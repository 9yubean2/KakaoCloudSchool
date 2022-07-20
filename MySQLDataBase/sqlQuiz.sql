-- 1. 30번 부서의 직무 별 급여의 평균을 파악하고자 합니다.
--    출력 컬럼 명: "직무", "급여 평균"    
--    연봉의 평균은 백 단위 까지만 나타냅니다.
USE sqldb;
SELECT JOB, TRUNCATE(AVG(SAL),-2)
FROM EMP
WHERE DEPTNO = 30
GROUP BY JOB;

-- 2. 근무 중인 직원이 4명 이상인 부서의 정보를 출력합니다.
--  출력 컬럼 명: "부서명", "직원 수"
SELECT JOB AS '부서 명', COUNT(EMPNO) AS '직원 수'
FROM EMP
GROUP BY JOB
HAVING COUNT(EMPNO) >= 4;


-- 3. 직무 별(job) 급여의 합을 출력하고 마지막에 누적 집계도 출력합니다. 
-- 누적 집계를 출력하는 행의 급여의 합은 총합계를 출력합니다.
--    또한 금액에는 천단위마다 콤마(,)를 출력합니다.
--    출력 컬럼 명: "직무명", "급여의 합"
SELECT JOB, SUM(SAL) AS '급여의 합'
FROM EMP
GROUP BY JOB
;


-- 4. 이 회사에서 월급을 제일 많이 받는 사람의 이름과 월급 그리고 급여 등급을 출력하세요.
--    출력 컬럼 명:  "직원명", "급여", "급여 등급"
SELECT ENAME, SAL
FROM EMP
WHERE SAL >= (
	SELECT LOSAL
	FROM SALGRADE
) AND SAL <= (
	SELECT HISAL
	FROM SALGRADE
);

-- 5. 1981년에 입사한 직원들의 이름을 월급을 많이 받는 순으로 출력합니다. 
-- 급여는 sal + comm으로 계산하는데 comm 이 null인 경우에는 0으로 계산합니다. 또한 천 단위마다 ,를 붙이고 뒤에 '원' 을 붙여서  출력합니다. 
-- 출력 컬럼 명: "직원명", "급여"
SELECT ENAME, SAL+IFNULL(COMM,0)
FROM EMP
WHERE YEAR(HIREDATE)=1981
ORDER BY SAL+IFNULL(COMM,0) DESC;

-- 6. 입사한 년도가 1980년이면 'A'를 1981년이면 'B'를 1982년이면 'C'를 1983년이면 'D'로 그룹을 출력합니다.
--     출력 컬럼 명: "직원명", "입사년월일", "그룹"
--     입사년월일은 'XXXX년 XX월 XX일'로 표현합니다.
SELECT ENAME, CONCAT(YEAR(HIREDATE),'년',MONTH(HIREDATE),'월',DAY(HIREDATE),'일') AS '입사년월일',
(CASE WHEN YEAR(HIREDATE) = 1981 THEN 'A'
        WHEN YEAR(HIREDATE) = 1982 THEN 'B'
        WHEN YEAR(HIREDATE) = 1983 THEN 'C'
    END) AS '그룹'
FROM EMP;



-- 7. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 각각의 컬럼명을 "사원 사번",
--    "사원 이름", "관리자 사번", "관리자 이름"으로 출력하는데 관리자가 없는 직원은 제외합니다.
SELECT E.EMPNO, E.ENAME, E.MGR, E2.ENAME
FROM EMP E
	INNER JOIN EMP E2
    ON E.MGR = E2.EMPNO;


-- 8. 'CHICAGO' 라는 도시에서 근무중인 직원의 사번, 성명 그리고 부서번호를 출력합니다.(JOIN 구문으로 해결)
SELECT E.EMPNO, E.ENAME, E.DEPTNO
FROM EMP E
	INNER JOIN DEPT D
	ON E.DEPTNO = D.DEPTNO
	INNER JOIN LOCATIONS L
	ON D.LOC_CODE = L.LOC_CODE
WHERE L.CITY = 'CHICAGO';

-- 9. 30번 부서의 직원들의 급여보다 많은 급여를 받는 직원들의 이름을 출력
SELECT ENAME,SAL
FROM EMP
WHERE SAL > ALL(
	SELECT SAL
	FROM EMP
	WHERE DEPTNO = 30
)
ORDER BY SAL DESC;




