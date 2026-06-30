-- table to log errors from the procedures below, doesn't exist in original schema

CREATE TABLE ErrorLog (
	LogID NUMBER PRIMARY KEY,
	ProcedureName VARCHAR2(50),
	ErrorMessage VARCHAR2(500),
	LogDate DATE
);

CREATE SEQUENCE errorlog_seq START WITH 1 INCREMENT BY 1;
