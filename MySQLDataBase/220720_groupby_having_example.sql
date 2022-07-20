-- 220720
-- 집계함수
-- SUM(), COUNT()(count all), COUNT(DISTINCT)(중복 제외 count), MAX(), MIN(), AVG()

-- 전체 구매자가 구매한 물품 개수의 평균은 얼마인가요?
SELECT AVG(amount)
FROM buytbl;

-- 각 사용자 별로 한 번 구매시 물건을 평균 몇개 구매했는지 조회하세용
SELECT userID, AVG(amount) AS '평균 구매 개수'
FROM buytbl
GROUP BY userID;

-- 가장 큰 키와 가장 작은 키의 회원 이름과 키를 출력하세요
SELECT name, MAX(height), MIN(height)
FROM usertbl;
-- subQuery로 생각 전환하면?
SELECT name, height
FROM usertbl
WHERE height = ( 
	SELECT MAX(height) FROM usertbl
) OR height = (
	SELECT MIN(height) FROM usertbl
);

-- 사용자별 총 구매금액이 1,000이상인 사용자만 출력하세요
SELECT userID, SUM(amount*price)
FROM buytbl
-- WHERE SUM(amount*price) >= 1000 -- WHERE절에는 집계함수가 직접적으로 올 수 없음
GROUP BY userID
HAVING SUM(amount*price) >= 1000;
