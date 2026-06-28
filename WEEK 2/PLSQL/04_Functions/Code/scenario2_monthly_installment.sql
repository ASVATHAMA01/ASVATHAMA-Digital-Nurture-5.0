-- standard EMI formula: P * r * (1+r)^n / ((1+r)^n - 1)
-- rate passed in as annual percent (e.g. 6 for 6%), years converted to months
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_annual_rate NUMBER,
    p_years NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_rate := (p_annual_rate / 100) / 12;
    v_months := p_years * 12;

    v_emi := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months)
             / (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/
