SET SERVEROUTPUT ON;

EXEC CustomerManagement.AddCustomer(5, 'Sneha Patel', TO_DATE('1992-03-12','YYYY-MM-DD'), 2000);
SELECT CustomerManagement.GetCustomerBalance(5) AS balance FROM dual;

EXEC EmployeeManagement.HireEmployee(3, 'Vikram Rao', 'Sales', 50000);
SELECT EmployeeManagement.CalculateAnnualSalary(3) AS annual_salary FROM dual;

EXEC AccountOperations.OpenAccount(3, 5, 2000);
SELECT AccountOperations.GetTotalBalance(1) AS total FROM dual;
