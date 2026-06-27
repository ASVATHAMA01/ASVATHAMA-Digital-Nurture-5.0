-- moves money between two accounts, checks balance first
CREATE OR REPLACE PROCEDURE TransferFunds(
	p_from_account NUMBER,
	p_to_account NUMBER,
	p_amount NUMBER
) IS
	v_balance NUMBER;
BEGIN
	SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

	IF v_balance >= p_amount THEN
		UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
		UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;
		COMMIT;
		DBMS_OUTPUT.PUT_LINE('transferred ' || p_amount || ' from ' || p_from_account || ' to ' || p_to_account);
	ELSE
		DBMS_OUTPUT.PUT_LINE('not enough balance in account ' || p_from_account);
	END IF;
END;
/
