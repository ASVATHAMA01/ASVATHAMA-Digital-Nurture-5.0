-- raises employee's salary by given percent, logs error if employee not found
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id NUMBER,
    p_percent NUMBER
) IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count FROM Employees WHERE EmployeeID = p_emp_id;

    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'employee id not found: ' || p_emp_id);
    END IF;

    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_emp_id;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        INSERT INTO ErrorLog (LogID, ProcedureName, ErrorMessage, LogDate)
        VALUES (errorlog_seq.NEXTVAL, 'UpdateSalary', SQLERRM, SYSDATE);
        COMMIT;
END;
/
