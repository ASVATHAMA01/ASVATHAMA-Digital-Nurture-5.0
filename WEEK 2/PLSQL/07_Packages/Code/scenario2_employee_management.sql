CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_dept VARCHAR2, p_salary NUMBER);
    PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_dept VARCHAR2);
    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS

    PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_dept VARCHAR2, p_salary NUMBER) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Department, Salary)
        VALUES (p_id, p_name, p_dept, p_salary);
        COMMIT;
    END;

    PROCEDURE UpdateEmployeeDetails(p_id NUMBER, p_dept VARCHAR2) IS
    BEGIN
        UPDATE Employees SET Department = p_dept WHERE EmployeeID = p_id;
        COMMIT;
    END;

    FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
        v_sal NUMBER;
    BEGIN
        SELECT Salary INTO v_sal FROM Employees WHERE EmployeeID = p_id;
        RETURN v_sal * 12;
    END;

END EmployeeManagement;
/
