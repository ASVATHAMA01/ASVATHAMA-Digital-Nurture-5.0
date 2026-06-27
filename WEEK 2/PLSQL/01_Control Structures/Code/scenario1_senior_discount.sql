-- apply 1% discount on loan interest for customers over 60

DECLARE
	v_age NUMBER;
BEGIN
	FOR c IN (SELECT CustomerID, DOB FROM Customers) LOOP
		v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12);

		IF v_age > 60 THEN
			UPDATE Loans SET InterestRate = InterestRate - (InterestRate * 0.01) WHERE CustomerID = c.CustomerID;
			DBMS_OUTPUT.PUT_LINE('discount given to customer ' || c.CustomerID);
		END IF;
	END LOOP;

	COMMIT;
END;
/
