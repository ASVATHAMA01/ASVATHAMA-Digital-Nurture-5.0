-- writes an audit record every time a transaction is inserted
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
	INSERT INTO AuditLog (AuditID, TransactionID, AccountID, Amount, LoggedAt)
	VALUES (auditlog_seq.NEXTVAL, :NEW.TransactionID, :NEW.AccountID, :NEW.Amount, SYSDATE);
END;
/
