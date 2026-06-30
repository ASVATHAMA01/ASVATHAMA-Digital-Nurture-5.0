-- mark customer as VIP if balance > 10000
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';

DECLARE
BEGIN
    FOR c IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = 'TRUE' WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/
