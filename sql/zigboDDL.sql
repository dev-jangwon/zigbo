-- 요청에 "지원하기"
DROP TABLE APPLY cascade constraint;
-- "찜"
DROP TABLE INTEREST cascade constraint;
-- "상품"정보
DROP TABLE ITEM cascade constraint;
-- "회원"정보
DROP TABLE MEMBER cascade constraint;
-- "결제"정보
DROP TABLE PAYMENT cascade constraint;
-- "요청" : 사다주세요
DROP TABLE REQUEST cascade constraint;
-- "판매" : 이거 팔거다
DROP TABLE SELLING cascade constraint;

DROP SEQUENCE apply_code_seq;
DROP SEQUENCE interest_seq;
DROP SEQUENCE item_code_seq;
DROP SEQUENCE member_code_seq;
DROP SEQUENCE payment_code_seq;
DROP SEQUENCE request_code_seq;
DROP SEQUENCE selling_code_seq;

CREATE SEQUENCE apply_code_seq;
CREATE TABLE APPLY
(
	apply_code           NUMBER(3) PRIMARY KEY,
	request_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	detail               VARCHAR2(200) NULL 
);

CREATE SEQUENCE interest_seq;
CREATE TABLE INTEREST
(
	member_code          NUMBER(3) NOT NULL,
	selling_code         NUMBER(3) NOT NULL,
	PRIMARY KEY(member_code, selling_code)
);

CREATE SEQUENCE item_code_seq;
CREATE TABLE ITEM
(
	item_code            NUMBER(3) NOT NULL PRIMARY KEY,
	price                VARCHAR2(20) NULL ,
	detail               VARCHAR2(200) NULL ,
	location             VARCHAR2(100) NULL ,
	picture1             BLOB NULL ,
	picture2             BLOB NULL 
);

CREATE SEQUENCE member_code_seq;
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
CREATE TABLE PAYMENT
(
	payment_code         NUMBER(3) NOT NULL PRIMARY KEY,
	selling_code         NUMBER(3) NOT NULL ,
	member_code          NUMBER(3) NOT NULL ,
	address              VARCHAR2(100) NOT NULL 
);

CREATE SEQUENCE request_code_seq;
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