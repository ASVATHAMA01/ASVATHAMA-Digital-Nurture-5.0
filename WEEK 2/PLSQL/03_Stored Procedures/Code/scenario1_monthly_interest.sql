-- adds 1% interest to every account's balance
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
	UPDATE Accounts
	SET Balance = Balance + (Balance * 0.01);

	COMMIT;
	DBMS_OUTPUT.PUT_LINE('interest applied to all accounts');
END;
/
