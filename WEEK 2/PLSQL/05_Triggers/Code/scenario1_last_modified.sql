-- stamps LastModified with current date whenever a customer row is updated
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
	:NEW.LastModified := SYSDATE;
END;
/
