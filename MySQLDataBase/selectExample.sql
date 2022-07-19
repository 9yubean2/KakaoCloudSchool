  USE sqldb;
  SELECT * FROM  usertbl;
  SELECT * FROM  buytbl;
  
  -- 이름이 김경호인 사람을 usertbl에서 추출
  SELECT * FROM usertbl WHERE name = '김경호';
  
  -- 1970년 이후에 출생하고 신장이 182 이상인 사람의 아이디와 이름을 조회
  SELECT userID, name FROM usertbl WHERE birthYear >= 1970 AND height >=182;
  
  -- 1970년 이후에 출생하거나 신장이 182 이상인 사람의 아이디와 이름을 조회
  SELECT userID, name FROM usertbl WHERE birthYear >= 1970 OR height >=182;
  
  -- 키가 180~183인 사람의 이름과 키를 조회
  SELECT height, name FROM usertbl WHERE height BETWEEN 180 AND 183;
  
  -- 지역이 경남, 전남, 경북인 사람을 조회
  -- SELECT name, addr FROM usertbl WHERE addr='경남' OR addr ='전남' OR addr ='경북';
  SELECT name, addr FROM usertbl WHERE addr in ('경남','전남','경북');
  
  -- 성이 김씨인 사람들의 이름과 키를 조사하세요 pattern matching 연산량이 많아서 남발하면 곤란행
  -- SELECT name, height FROM usertbl WHERE name LIKE '김_'; underscore는 한글자
  SELECT name, height FROM usertbl WHERE name LIKE '김%'; -- %는 0개 이상의 글자
  
-- 김경호보다 키가 크거나 같은 사람의 이름과 키를 조회하세요
SELECT height,name 
FROM usertbl 
WHERE height >= (
	SELECT height
	FROM usertbl 
	WHERE name='김경호'
);

-- 지역이 '경남'인 사람의 키보다 키가 크거나 같은 사람 조회
SELECT name, height
FROM usertbl 
WHERE height >= ANY(
	SELECT height
	FROM usertbl 
	WHERE addr='경남'
);

-- 먼저 가입한 순으로 출력
SELECT name, mDate
FROM usertbl
ORDER BY mDate ASC ; -- DESC는 내림차순

-- usertbl에서 회원들의 거주지역이 어디인지를 출력
SELECT DISTINCT addr -- DISTINCT 중복 제거
FROM usertbl;

-- 먼저 가입한 순으로 4명만
SELECT name, mDate
FROM usertbl
ORDER BY mDate ASC 
LIMIT 4;
-- '윤종신','2005-05-05'
-- '김경호','2007-07-07'
-- '이승기','2008-08-08'
-- '조용필','2009-04-04'

SELECT name, mDate
FROM usertbl
ORDER BY mDate ASC 
LIMIT 1,2; -- 인덱스 범위 지정해서 중간에 있는 값 추출 가능
-- '김경호','2007-07-07'
-- '이승기','2008-08-08'

-- table 복사
-- data만 복사되기 때문에 PK, FK같은 Constraints는 복사되지 않아요
CREATE TABLe buytbl2(
	SELECT * FROM buytbl
);

-- 구매 테이블에서 사용자가 구매한 물품의 개수를 조회
SELECT userID, SUM(amount)
FROM buytbl
GROUP BY userID;

-- 구매 테이블에서 각 사용자별 구매액의 총합을 출력하세요
SELECT userID, SUM(amount*price)
FROM buytbl
GROUP BY userID;
  