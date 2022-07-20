CREATE DATABASE moviedb;

USE moviedb;

CREATE TABLE movietbl (
	movie_id INT,
    movie_title VARCHAR(30),
    movie_script LONGTEXT,
    movie_film LONGBLOB
) DEFAULT CHARSET=utf8mb4;

-- 데이터를 입력
INSERT INTO movietbl VALUES(1,'쉰들러 리스트',
	LOAD_FILE('/Users/Dia/Desktop/sql/Schindler.txt'),
    LOAD_FILE('/Users/Dia/Desktop/sql/Schindler.mp4')
);
DELETE FROM movietbl;

SELECT * FROM movietbl;

-- 환경설정이 안되어있기 때문에 정상적으로 동작하지 않아요!
-- 설정 시작~~~