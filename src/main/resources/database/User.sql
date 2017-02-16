CREATE TABLE if not exists test.USER (
  ID          INT(8)      NOT NULL AUTO_INCREMENT,
  NAME        VARCHAR(25) NOT NULL,
  AGE         INT,
  ISADMIN     BIT         NOT NULL,
  CREATEDDATE TIMESTAMP   NOT NULL,
  PRIMARY KEY (ID))
  DEFAULT CHARACTER SET = utf8
);

INSERT INTO TEST.USER (ID, NAME, AGE, ISADMIN, CREATEDDATE) VALUES ('1', 'ANDREW', 35, 1, '2017.02.17');
INSERT INTO TEST.USER (ID, NAME, AGE, ISADMIN, CREATEDDATE) VALUES ('2', 'BOGDAN', 33, 0, '2017.01.17');
INSERT INTO TEST.USER (ID, NAME, AGE, ISADMIN, CREATEDDATE) VALUES ('3', 'CINTIA', 22, 0, '2017.02.10');
INSERT INTO TEST.USER (ID, NAME, AGE, ISADMIN, CREATEDDATE) VALUES ('4', 'DANA', 25, 0, '2016.02.10');