-- transaction
SELECT distinct userid
FROM buytbl;

START TRANSACTION;

DELETE
FROM buytbl;

ROLLBACK; -- 무효화