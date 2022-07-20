USE sqldb;
-- 학생테이블
CREATE TABLE stdtbl (
	std_name VARCHAR(10) NOT NULL PRIMARY KEY,
    std_addr VARCHAR(4) NOT NULL
);

-- 동아리 테이블
CREATE TABLE clubtbl (
	club_name VARCHAR(10) NOT NULL PRIMARY KEY,
    club_room VARCHAR(4) NOT NULL
);

-- 학생 동아리 테이블
CREATE TABLE stdclubtbl(
	num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    std_name VARCHAR(10) NOT NULL,
    club_name VARCHAR(10) NOT NULL,
    FOREIGN KEY(std_name) REFERENCES stdtbl(std_name),
    FOREIGN KEY(club_name) REFERENCES clubtbl(club_name)
);

INSERT INTO stdtbl VALUES('김범수','경남');
INSERT INTO stdtbl VALUES('성시경','서울');
INSERT INTO stdtbl VALUES('조용필','경기');
INSERT INTO stdtbl VALUES('은지원','경북');
INSERT INTO stdtbl VALUES('바비킴','서울');

INSERT INTO clubtbl VALUES('수영','101호');
INSERT INTO clubtbl VALUES('바둑','102호');
INSERT INTO clubtbl VALUES('축구','103호');
INSERT INTO clubtbl VALUES('봉사','104호');

INSERT INTO stdclubtbl VALUES(NULL,'김범수','바둑');
INSERT INTO stdclubtbl VALUES(NULL,'김범수','축구');
INSERT INTO stdclubtbl VALUES(NULL,'조용필','축구');
INSERT INTO stdclubtbl VALUES(NULL,'은지원','축구');
INSERT INTO stdclubtbl VALUES(NULL,'은지원','봉사');
INSERT INTO stdclubtbl VALUES(NULL,'바비킴','봉사');


-- 학생을 기준으로 학생이름, 지역, 가입 동아리, 동아리 방번호를 출력
SELECT S.std_name, S.std_addr, SC.club_name, C.club_room
FROM stdtbl S
	INNER JOIN stdclubtbl SC
    ON S.std_name = SC.std_name
    INNER JOIN clubtbl C
    ON SC.club_name = C.club_name
ORDER BY S.std_name;


-- usertbl과 buytbl을 이용
-- 전체 회원의 구매기록을 조회 단, 구매 기록이 없는 회원도 조회
SELECT U.userId, U.name, B.prodName, U.addr 
FROM usertbl U -- LEFT
	LEFT OUTER JOIN buytbl B -- RIGHT -- 어느 쪽 테이블 정보를 더할건지 명시해주기
    ON U.userId = B.userId
ORDER BY U.userId;


