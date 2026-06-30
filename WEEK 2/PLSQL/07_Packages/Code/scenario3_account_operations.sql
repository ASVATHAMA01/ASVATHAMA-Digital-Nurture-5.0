CREATE OR REPLACE PACKAGE AccountOperations IS
	PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_balance NUMBER);
	PROCEDURE CloseAccount(p_acc_id NUMBER);
	FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations IS

	PROCEDURE OpenAccount(p_acc_id NUMBER, p_cust_id NUMBER, p_balance NUMBER) IS
	BEGIN
		INSERT INTO Accounts (AccountID, CustomerID, Balance)
		VALUES (p_acc_id, p_cust_id, p_balance);
		COMMIT;
	END;

	PROCEDURE CloseAccount(p_acc_id NUMBER) IS
	BEGIN
		DELETE FROM Accounts WHERE AccountID = p_acc_id;
		COMMIT;
	END;

	FUNCTION GetTotalBalance(p_cust_id NUMBER) RETURN NUMBER IS
		v_total NUMBER;
	BEGIN
		SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_cust_id;
		RETURN v_total;
	END;

END AccountOperations;
/
