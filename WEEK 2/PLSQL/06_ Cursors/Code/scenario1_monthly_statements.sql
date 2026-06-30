-- prints a statement line for every transaction made this month
DECLARE
	CURSOR c_statements IS
		SELECT t.TransactionID, t.AccountID, t.Amount, t.TransactionDate, c.Name
		FROM Transactions t, Accounts a, Customers c
		WHERE t.AccountID = a.AccountID
		AND a.CustomerID = c.CustomerID
		AND EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
		AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

	v_txn c_statements%ROWTYPE;
BEGIN
	OPEN c_statements;
	LOOP
		FETCH c_statements INTO v_txn;
		EXIT WHEN c_statements%NOTFOUND;

		DBMS_OUTPUT.PUT_LINE(v_txn.Name || ' - txn ' || v_txn.TransactionID ||
			' - amount ' || v_txn.Amount || ' on ' || v_txn.TransactionDate);
	END LOOP;
	CLOSE c_statements;
END;
/
