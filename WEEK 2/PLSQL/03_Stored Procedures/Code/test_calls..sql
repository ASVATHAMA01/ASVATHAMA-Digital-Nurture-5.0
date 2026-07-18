-- run after the 3 procedures above are created

SET SERVEROUTPUT ON;

EXEC ProcessMonthlyInterest;

EXEC UpdateEmployeeBonus('Operations', 5);

-- account 1 has 1313 after interest, try transferring 500 (should succeed)
EXEC TransferFunds(1, 2, 500);

-- try transferring more than account 1 has left (should fail)
EXEC TransferFunds(1, 2, 10000);
