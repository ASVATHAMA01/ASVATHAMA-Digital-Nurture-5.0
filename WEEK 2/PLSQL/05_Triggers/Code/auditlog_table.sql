-- new table for transaction auditing, not in original schema
CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    Amount NUMBER,
    LoggedAt DATE
);

CREATE SEQUENCE auditlog_seq START WITH 1 INCREMENT BY 1;
