-- print reminder for loans due in 30 days
DECLARE
BEGIN
	FOR l IN (
		SELECT l.LoanID, l.EndDate, c.Name
		FROM Loans l, Customers c
		WHERE c.CustomerID = l.CustomerID
		AND l.EndDate BETWEEN SYSDATE AND SYSDATE+30
	) LOOP
		DBMS_OUTPUT.PUT_LINE('Reminder: loan ' || l.LoanID || ' for ' || l.Name || ' due ' || l.EndDate);
	END LOOP;
END;
/
