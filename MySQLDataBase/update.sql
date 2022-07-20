CREATE TABLE testtbl3 (
	id INT,
    fname VARCHAR(50),
    lname VARCHAR(50)
);
INSERT INTO testtbl3 (
	SELECT emp_no, first_name, last_name
    FROM employees.employees
    
);

SELECT * FROM testtbl3;

START TRANSACTION;

-- UPDATE
UPDATE testtbl3
SET lname = '없음'
WHERE fname= 'kyoichi';

SELECT * FROM testtbl3 WHERE fname= 'kyoichi';

ROLLBACK;
SELECT * FROM testtbl3 WHERE fname= 'kyoichi';