/*Autocommit mode false*/
SET AUTOCOMMIT=0;

DROP DATABASE IF EXISTS loginaccounts;
CREATE DATABASE loginaccounts;

/*DB選択*/
USE loginaccounts;

/*データベースの使用*/
USE loginaccounts;

/* Tavle structure for table yd_product_info*/
DROP TABLE IF EXISTS ACCOUNT;
CREATE TABLE ACCOUNT(
	USER_ID CHAR(10) PRIMARY KEY,
	PASS VARCHAR(10) NOT NULL,
	MAIL VARCHAR(100) NOT NULL,
	NAME VARCHAR(40) NOT NULL,
	AGE INT NOT NULL
)ENGINE = InnoDB;

/*テストデータ書き込み*/
INSERT INTO ACCOUNT(USER_ID,PASS,MAIL,NAME,AGE)
	VALUES('testname','1234','test@test.com','テストデータ',20);
	VALUES('testname2','12345','aaa@aaa.com','test',30);