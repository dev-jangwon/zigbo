-- ��û�� "�����ϱ�"
DROP TABLE APPLY cascade constraint;
-- "��"
DROP TABLE INTEREST cascade constraint;
-- "��ǰ"����
DROP TABLE ITEM cascade constraint;
-- "ȸ��"����
DROP TABLE MEMBER cascade constraint;
-- "����"����
DROP TABLE PAYMENT cascade constraint;
-- "��û" : ����ּ���
DROP TABLE REQUEST cascade constraint;
-- "�Ǹ�" : �̰� �ȰŴ�
DROP TABLE SELLING cascade constraint;

DROP TABLE REQUEST_PAYMENT cascade constraint;

DROP SEQUENCE apply_code_seq;
DROP SEQUENCE interest_seq;
DROP SEQUENCE item_code_seq;
DROP SEQUENCE member_code_seq;
DROP SEQUENCE payment_code_seq;
DROP SEQUENCE request_code_seq;
DROP SEQUENCE selling_code_seq;
DROP SEQUENCE request_payment_code_seq;

CREATE SEQUENCE apply_code_seq;
ALTER SEQUENCE apply_code_seq nocache;
CREATE TABLE APPLY
(
	apply_code           NUMBER(3) PRIMARY KEY,
	request_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	detail               VARCHAR2(200) NULL 
);

CREATE SEQUENCE interest_seq;
ALTER SEQUENCE interest_seq nocache;
CREATE TABLE INTEREST
(
	member_code          NUMBER(3) NOT NULL,
	selling_code         NUMBER(3) NOT NULL,
	PRIMARY KEY(member_code, selling_code)
);

CREATE SEQUENCE item_code_seq;
ALTER SEQUENCE item_code_seq nocache;
CREATE TABLE ITEM
(
	item_code            NUMBER(3) NOT NULL PRIMARY KEY,
	title				 VARCHAR2(20) NULL ,
	price                VARCHAR2(20) NULL ,
	detail               VARCHAR2(200) NULL ,
	location             VARCHAR2(100) NULL ,
	picture              VARCHAR2(200) NULL
);

CREATE SEQUENCE member_code_seq;
ALTER SEQUENCE member_code_seq nocache;
CREATE TABLE MEMBER
(
	member_code          NUMBER(3) NOT NULL PRIMARY KEY,
	email                VARCHAR2(50) NOT NULL ,
	password             VARCHAR2(10) NOT NULL ,
	phone                VARCHAR2(20) NOT NULL ,
	address              VARCHAR2(100) NOT NULL ,
	account              VARCHAR2(20) NOT NULL 
);

CREATE SEQUENCE payment_code_seq;
ALTER SEQUENCE payment_code_seq nocache;
CREATE TABLE PAYMENT
(
	payment_code         NUMBER(3) NOT NULL PRIMARY KEY,
	selling_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	address              VARCHAR2(100) NOT NULL 
);

CREATE SEQUENCE request_payment_code_seq;
ALTER SEQUENCE request_payment_code_seq nocache;
CREATE TABLE REQUEST_PAYMENT
(
	payment_code         NUMBER(3) NOT NULL PRIMARY KEY,
	request_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	address              VARCHAR2(100) NOT NULL 
);

CREATE SEQUENCE request_code_seq;
ALTER SEQUENCE request_code_seq nocache;
CREATE TABLE REQUEST
(
	request_code         NUMBER(3) PRIMARY KEY,
	item_code            NUMBER(3) NOT NULL,
	member_code          NUMBER(3) NOT NULL,
	views                NUMBER(4) NULL,
	upload_date          DATE NULL,
	progress             VARCHAR2(1) NULL ,
	location             VARCHAR2(100) NOT NULL
);

CREATE SEQUENCE selling_code_seq;
ALTER SEQUENCE selling_code_seq nocache;
CREATE TABLE SELLING
(
	selling_code         NUMBER(3) NOT NULL PRIMARY KEY,
	member_code          NUMBER(3) NOT NULL ,
	item_code            NUMBER(3) NOT NULL ,
	views                NUMBER(4) NULL ,
	upload_date          DATE NULL ,
	progress             VARCHAR2(1) NULL ,
	location             VARCHAR2(100) NOT NULL 
);

ALTER TABLE APPLY ADD (CONSTRAINT R_1 FOREIGN KEY (request_code) REFERENCES REQUEST (request_code));
ALTER TABLE APPLY ADD (CONSTRAINT R_2 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE INTEREST ADD (CONSTRAINT R_6 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE INTEREST ADD (CONSTRAINT R_7 FOREIGN KEY (selling_code) REFERENCES SELLING (selling_code));
ALTER TABLE PAYMENT ADD (CONSTRAINT R_8 FOREIGN KEY (selling_code) REFERENCES SELLING (selling_code));
ALTER TABLE PAYMENT ADD (CONSTRAINT R_9 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE REQUEST ADD (CONSTRAINT R_10 FOREIGN KEY (item_code) REFERENCES ITEM (item_code));
ALTER TABLE REQUEST ADD (CONSTRAINT R_11 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE SELLING ADD (CONSTRAINT R_12 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));
ALTER TABLE SELLING ADD (CONSTRAINT R_13 FOREIGN KEY (item_code) REFERENCES ITEM (item_code));
ALTER TABLE REQUEST_PAYMENT ADD (CONSTRAINT R_14 FOREIGN KEY (request_code) REFERENCES REQUEST (request_code));
ALTER TABLE REQUEST_PAYMENT ADD (CONSTRAINT R_15 FOREIGN KEY (member_code) REFERENCES MEMBER (member_code));