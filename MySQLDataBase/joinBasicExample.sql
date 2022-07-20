USE sqldb;

-- 구매 테이블에서 JYP라는 아이디를 가진 사람이 구매한 물건을
-- 발송하기 위해서 이름과 주소가 필요하고 이 정보는 usetbl에 존재
-- 두 테이블을 결합해서 결과를 알아내야 해요

SELECT *
FROM buytbl
	INNER JOIN usertbl
	ON buytbl.userID = usertbl.userID -- 여기까지 해서 새로운 테이블 생성된 것
WHERE buytbl.userID = 'JYP';

-- 표준 방식
SELECT B.userID, name, addr
FROM buytbl B
	INNER JOIN usertbl U
	ON B.userID = U.userID 
WHERE B.userID = 'JYP';