START TRANSACTION;

SELECT * FROM testtbl3 WHERE fname = 'Kyoichi';

ROLLBACK;

-- DELETE
DELETE
FROM testtbl3
WHERE fname = 'Kyoichi'
LIMIT 100;