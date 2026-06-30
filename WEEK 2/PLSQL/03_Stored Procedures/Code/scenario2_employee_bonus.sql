-- Department column not in original Employees table, adding it here
ALTER TABLE Employees ADD Department VARCHAR2(50);

UPDATE Employees SET Department = 'Operations' WHERE EmployeeID = 1;
UPDATE Employees SET Department = 'Sales' WHERE EmployeeID = 2;
COMMIT;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department VARCHAR2,
    p_bonus_percent NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percent / 100)
    WHERE Department = p_department;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('bonus applied to department: ' || p_department);
END;
/
