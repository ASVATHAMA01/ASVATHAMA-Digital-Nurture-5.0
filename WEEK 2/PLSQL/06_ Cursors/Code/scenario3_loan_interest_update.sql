-- new policy: every loan gets interest rate reduced by 0.5 points
DECLARE
	v_reduction CONSTANT NUMBER := 0.5;

	CURSOR c_loans IS
		SELECT LoanID, InterestRate FROM Loans;

	v_loan_id NUMBER;
	v_rate NUMBER;
BEGIN
	OPEN c_loans;
	LOOP
		FETCH c_loans INTO v_loan_id, v_rate;
		EXIT WHEN c_loans%NOTFOUND;

		UPDATE Loans SET InterestRate = v_rate - v_reduction WHERE LoanID = v_loan_id;
		DBMS_OUTPUT.PUT_LINE('loan ' || v_loan_id || ' rate updated from ' || v_rate || ' to ' || (v_rate - v_reduction));
	END LOOP;
	CLOSE c_loans;

	COMMIT;
END;
/
