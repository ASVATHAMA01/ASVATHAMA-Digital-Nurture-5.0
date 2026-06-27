-- run errorlog_table.sql and all 3 scenario procedures first, then this

SET SERVEROUTPUT ON;

-- 1a. transfer fails: account 1 only has 1000, asking for 5000
EXEC SafeTransferFunds(1, 2, 5000);

-- 1b. transfer succeeds: account 2 has 1500, asking for 300
EXEC SafeTransferFunds(2, 1, 300);

-- 2a. fails: employee 99 doesn't exist
EXEC UpdateSalary(99, 10);

-- 2b. succeeds: employee 1 exists
EXEC UpdateSalary(1, 10);

-- 3a. fails: customer 1 already exists
EXEC AddNewCustomer(1, 'Duplicate Test', SYSDATE, 500);

-- 3b. succeeds: customer 4 is new
EXEC AddNewCustomer(4, 'New Customer', SYSDATE, 500);

-- check what got logged
SELECT ProcedureName, ErrorMessage FROM ErrorLog ORDER BY LogID;
