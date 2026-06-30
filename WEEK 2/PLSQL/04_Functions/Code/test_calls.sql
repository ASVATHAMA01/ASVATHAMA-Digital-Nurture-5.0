SET SERVEROUTPUT ON;

-- Scenario 1: customer 3 is Ramesh Iyer, DOB 1960-02-10
SELECT CalculateAge(DOB) AS age FROM Customers WHERE CustomerID = 3;

-- Scenario 2: loan of 20000 at 6% annual interest over 1 year (matches loan 2 from earlier)
SELECT CalculateMonthlyInstallment(20000, 6, 1) AS emi FROM dual;

-- Scenario 3: boolean functions can't be selected directly, need a PL/SQL block
DECLARE
	v_result BOOLEAN;
BEGIN
	v_result := HasSufficientBalance(1, 500);
	IF v_result THEN
		DBMS_OUTPUT.PUT_LINE('account 1 has enough balance for 500');
	ELSE
		DBMS_OUTPUT.PUT_LINE('account 1 does not have enough balance for 500');
	END IF;

	v_result := HasSufficientBalance(1, 50000);
	IF v_result THEN
		DBMS_OUTPUT.PUT_LINE('account 1 has enough balance for 50000');
	ELSE
		DBMS_OUTPUT.PUT_LINE('account 1 does not have enough balance for 50000');
	END IF;
END;
/
