CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER(10,2),
    LastModified DATE,
    IsVIP VARCHAR2(5) DEFAULT 'FALSE'
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER REFERENCES Customers(CustomerID),
    LoanAmount NUMBER(10,2),
    InterestRate NUMBER(5,2),
    StartDate DATE,
    EndDate DATE
);

INSERT INTO Customers VALUES (3, 'Ramesh Iyer', TO_DATE('1960-02-10', 'YYYY-MM-DD'), 15000, SYSDATE, 'FALSE');
INSERT INTO Customers VALUES (1, 'Amit Sharma', TO_DATE('1985-05-12', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

INSERT INTO Loans VALUES (2, 3, 20000, 6, SYSDATE, SYSDATE + 15);
INSERT INTO Loans VALUES (3, 1, 10000, 5, SYSDATE, SYSDATE + 60 * 12);

UPDATE Customers
SET IsVIP = 'TRUE'
WHERE Balance > 10000;

COMMIT;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Data inserted successfully.');

    DBMS_OUTPUT.PUT_LINE('VIP status updated:');
    FOR c IN (SELECT CustomerID, Name, Balance, IsVIP FROM Customers ORDER BY CustomerID) LOOP
        DBMS_OUTPUT.PUT_LINE('CustomerID=' || c.CustomerID || ', Name=' || c.Name || ', Balance=' || c.Balance || ', IsVIP=' || c.IsVIP);
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Loan details:');
    FOR l IN (
        SELECT l.LoanID, l.CustomerID, c.Name, l.LoanAmount, l.InterestRate, l.StartDate, l.EndDate
        FROM Loans l JOIN Customers c ON c.CustomerID = l.CustomerID
        ORDER BY l.LoanID
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('LoanID=' || l.LoanID || ', CustomerID=' || l.CustomerID || ', Name=' || l.Name || ', LoanAmount=' || l.LoanAmount || ', InterestRate=' || l.InterestRate || ', StartDate=' || TO_CHAR(l.StartDate, 'DD-MON-YYYY') || ', EndDate=' || TO_CHAR(l.EndDate, 'DD-MON-YYYY'));
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Loan due reminders:');
    FOR l IN (
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l JOIN Customers c ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.LoanID
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: loan ' || l.LoanID || ' for ' || l.Name || ' due ' || TO_CHAR(l.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/