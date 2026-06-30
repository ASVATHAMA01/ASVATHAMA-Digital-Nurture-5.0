-- deducts a flat annual fee from every account using an explicit cursor
DECLARE
    v_fee CONSTANT NUMBER := 50;

    CURSOR c_accounts IS
        SELECT AccountID FROM Accounts;

    v_acc_id NUMBER;
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_acc_id;
        EXIT WHEN c_accounts%NOTFOUND;

        UPDATE Accounts SET Balance = Balance - v_fee WHERE AccountID = v_acc_id;
        DBMS_OUTPUT.PUT_LINE('fee deducted from account ' || v_acc_id);
    END LOOP;
    CLOSE c_accounts;

    COMMIT;
END;
/
