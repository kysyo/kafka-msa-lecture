# Kafka 
## 신규 강의 생성시 디폴트 강사 매칭  

### 강의 생성 -> (Producer) 강의생성 이벤트 전달 -> Kafka -> (Consumer) 이벤트내의 신규강의정보 받아 디폴트 강사정보 입력</br></br></br>





- Consumer에 전달된 이벤트 데이터

![image](https://user-images.githubusercontent.com/53042885/165819986-4659e479-72bb-4e1c-a8f2-ee271cde20ef.png)

- 신규생성된 강의에 디폴트 강사(memberId : 999, memberName : 신규강사 )매칭

![image](https://user-images.githubusercontent.com/53042885/165821448-66404632-6dd4-4922-bd67-e1fe863fa80f.png)


