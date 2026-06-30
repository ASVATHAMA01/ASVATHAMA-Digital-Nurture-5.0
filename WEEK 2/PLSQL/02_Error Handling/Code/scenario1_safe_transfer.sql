-- transfers money from one account to another, rolls back on error
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
	p_from_account NUMBER,
	p_to_account NUMBER,
	p_amount NUMBER
) IS
	v_balance NUMBER;
BEGIN
	SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from_account;

	IF v_balance < p_amount THEN
		RAISE_APPLICATION_ERROR(-20001, 'insufficient funds');
	END IF;

	UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from_account;
	UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to_account;

	COMMIT;

EXCEPTION
	WHEN OTHERS THEN
		ROLLBACK;
		INSERT INTO ErrorLog (LogID, ProcedureName, ErrorMessage, LogDate)
		VALUES (errorlog_seq.NEXTVAL, 'SafeTransferFunds', SQLERRM, SYSDATE);
		COMMIT;
END;
/
