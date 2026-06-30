-- adds a new customer, blocks insert and logs if id already used
CREATE OR REPLACE PROCEDURE AddNewCustomer(
	p_id NUMBER,
	p_name VARCHAR2,
	p_dob DATE,
	p_balance NUMBER
) IS
BEGIN
	INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
	VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);

	COMMIT;

EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
		INSERT INTO ErrorLog (LogID, ProcedureName, ErrorMessage, LogDate)
		VALUES (errorlog_seq.NEXTVAL, 'AddNewCustomer', 'customer id already exists: ' || p_id, SYSDATE);
		COMMIT;
END;
/
