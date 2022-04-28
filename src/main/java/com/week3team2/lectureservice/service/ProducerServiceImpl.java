package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);
    private static final String TOPIC = "lecture-topic";

    private final KafkaTemplate<String, Lecture> kafkaTemplate;

    @Autowired
    public ProducerServiceImpl(KafkaTemplate<String, Lecture> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

        public void sendLectureData(Lecture lecture) {
            logger.info(String.format("**** 카프카 생산자 데이터 **** : %s ", lecture));
        this.kafkaTemplate.send(TOPIC, lecture);
    }
}
