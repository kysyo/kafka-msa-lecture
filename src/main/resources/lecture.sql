create table IF NOT EXISTS lecture
(
    lectureId INT NOT NULL AUTO_INCREMENT,
    lectureName VARCHAR(255),
    memberId INT,
    memberName VARCHAR(255),
    lectureShowYn BOOLEAN(10) DEFAULT FALSE,
    lectureTotalScore BIGINT,
    insertDt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateDt DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (lectureId)

    );

create table IF NOT EXISTS lectureInfo
(
    lectureInfoId INT NOT NULL AUTO_INCREMENT,
    lectureId INT,
    memberId INT,
    testScore INTEGER DEFAULT 0,
    lectureState VARCHAR(255),
    lectureScore  INTEGER DEFAULT 0,
    insertDt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateDt DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (lectureInfoId)
    );

INSERT INTO lecture VALUES (1, 'testName', 1, 'teacherName1', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (2, 'testName', 1, 'teacherName2', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (3, 'testName', 1, 'teacherName3', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (4, 'testName', 2, 'teacherName4', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (5, 'testName', 3, 'teacherName5', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureInfo VALUES (0, 1, 4, 0, 'Enrolment', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureInfo VALUES (1, 2, 3, 0, 'Enrolment', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureInfo VALUES (2, 3, 2, 0, 'TAKING', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureInfo VALUES (3, 4, 1, 0, 'TAKING', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

