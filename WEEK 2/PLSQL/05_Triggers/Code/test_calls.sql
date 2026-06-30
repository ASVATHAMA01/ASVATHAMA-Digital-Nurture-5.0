-- run auditlog_table.sql and all 3 triggers first, then this

SET SERVEROUTPUT ON;

-- Scenario 1: update customer 1, check LastModified changes
UPDATE Customers SET Balance = 900 WHERE CustomerID = 1;
SELECT CustomerID, LastModified FROM Customers WHERE CustomerID = 1;

-- Scenario 2 + 3: insert a valid withdrawal (account 1 has 813)
INSERT INTO Transactions (TransactionID, AccountID, TransactionType, Amount, TransactionDate)
VALUES (10, 1, 'Withdrawal', 200, SYSDATE);

-- check it got logged
SELECT * FROM AuditLog WHERE TransactionID = 10;

-- this should fail: withdrawal bigger than balance
INSERT INTO Transactions (TransactionID, AccountID, TransactionType, Amount, TransactionDate)
VALUES (11, 1, 'Withdrawal', 99999, SYSDATE);

-- this should also fail: negative deposit
INSERT INTO Transactions (TransactionID, AccountID, TransactionType, Amount, TransactionDate)
VALUES (12, 1, 'Deposit', -50, SYSDATE);
