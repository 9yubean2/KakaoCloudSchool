SELECT CHAR_LENGTH('abcde'), -- 5
	   CHAR_LENGTH('홍길동'), -- 3 
       LENGTH('abcde'), -- 5
       LENGTH('홍길동'); -- 9 byte수 계산
       
SELECT CONCAT('소리없는','아우성');
SELECT CONCAT_WS('-','2022','02','20');

SELECT FORMAT(1234567.1415234,3); -- 1,234,567.142

SELECT TRIM('        소리없는 아우성         ');

SELECT REPLACE('이것은 소리없는 아우성','소리','양심');
SELECT SUBSTRING('이것은 소리없는 아우성',3,5);

-- 날짜에 관련된 내장함수
SELECT CURDATE(); -- 2022-07-20
SELECT NOW(); -- 2022-07-20 12:19:27
SELECT YEAR(CURDATE()); -- 2022

