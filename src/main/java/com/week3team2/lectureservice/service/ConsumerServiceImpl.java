package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {
    private final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);
    private final LectureService lectureService;

    // 강의 신규생성 이벤트를 받으면 새로 생성된 강의에 디폴트 강사 배정 (강사아이디 : 999, 강사이름 : 신규강사)
    @KafkaListener(topics = "lecture-topic", groupId = "lecture-group", containerFactory = "pushEntityKafkaListenerContainerFactory")
    public void matchingDefaultTeacher(@Payload Lecture lecture, @Headers MessageHeaders messageHeaders) {

        logger.info(String.format("#### 카프카 소비자 데이터 ### : %s \n### 카프카 헤더 정보 ### : %s", lecture, messageHeaders));

        Mono<Lecture> lectureMono = Mono.just(lecture)
                .doOnNext(data-> data.setMemberId(999))
                .doOnNext(data-> data.setMemberName("신규강사"))
                .flatMap(lectureService::matchingLecture)
                ;
        lectureMono.subscribe();
    }

}