package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;

public interface ProducerService {

    //강의 신규생성시 이벤트 카프카에 전송
    void sendLectureData(Lecture lecture);
}
