USE sqldb;
CREATE TABLE testtbl1 (
	id INT,
    userName CHAR(3), -- varchar보다 insert delete 연산 빠름
    age INT
);
SELECT * FROM testtbl1;
-- 일반적인 INSERT 구문
INSERT INTO testtbl1 VALUES (1,'홍길동',25);
-- 필요한 것만 선택해서 데이터 입력
INSERT INTO testtbl1(id,userName) VALUES (2,'이순신');
-- 순서 무관
INSERT INTO testtbl1(userName,id) VALUES ('강감찬',3);

-- AUTO_INCREMENT : 숫자 형식만 가능, PRIMARY KEY이거나 UNIQUE 값이어야함
CREATE TABLE testtbl2 (
	id INT AUTO_INCREMENT PRIMARY KEY,
    userName CHAR(3), -- varchar보다 insert delete 연산 빠름
    age INT
);
SELECT * FROM testtbl2;

INSERT INTO testtbl2 VALUES (NULL,'홍길동',25);
INSERT INTO testtbl2 VALUES (NULL,'김길동',30);

ALTER TABLE testtbl2 auto_increment = 100; -- 시작값 변경 가능
INSERT INTO testtbl2 VALUES (NULL,'최길동',50);

SET @@auto_increment_increment = 5; -- 증가폭 default값 1을 5로 변경
INSERT INTO testtbl2 VALUES (NULL,'박길동',60);





