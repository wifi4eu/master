DROP TABLE IF EXISTS LOC_NUTS_T;
DROP TABLE IF EXISTS LOC_LAU_T;
DROP TABLE IF EXISTS SEC_USERS_T;
DROP TABLE IF EXISTS SEC_USER_ROLES_T;
DROP TABLE IF EXISTS SEC_ROLES_T;
DROP TABLE IF EXISTS SEC_ROLE_RIGHTS_T;
DROP TABLE IF EXISTS SEC_RIGHTS_T;
DROP TABLE IF EXISTS BEN_LGE_T;
DROP TABLE IF EXISTS BEN_MAY_T;
DROP TABLE IF EXISTS BEN_REP_T;
DROP TABLE IF EXISTS SEC_TEMPTOKEN_T;
DROP TABLE IF EXISTS SUPP_INSTALLATION_T;
DROP TABLE IF EXISTS SUPP_ACCESSPOINT_T;
DROP TABLE IF EXISTS SUPP_SUPPLIER_T;
DROP TABLE IF EXISTS SUPP_BENPUBSUP_T;
DROP TABLE IF EXISTS TIM_TIMELINE_T;
DROP TABLE IF EXISTS HEL_HELPDESK_T;
DROP TABLE IF EXISTS HEL_HELPDESK_COMMENTS_T;
DROP TABLE IF EXISTS CALL_T;
DROP TABLE IF EXISTS SEQUENCE;

CREATE TABLE LOC_NUTS_T (
  NUTS_ID      INTEGER      NOT NULL AUTO_INCREMENT,
  NUTS_CODE    VARCHAR(255) NOT NULL,
  NUTS_LABEL   VARCHAR(255) NOT NULL,
  NUTS_LEVEL   INTEGER      NOT NULL,
  COUNTRY_CODE VARCHAR(255) NOT NULL,
  _ORDER       INTEGER      NOT NULL,
  SORTING      INTEGER      NOT NULL,
  PRIMARY KEY (NUTS_ID)
);

CREATE TABLE LOC_LAU_T (
  LAU_ID       INTEGER      NOT NULL AUTO_INCREMENT,
  COUNTRY_CODE VARCHAR(255) NOT NULL,
  NUTS3        VARCHAR(255) NOT NULL,
  LAU1         VARCHAR(255) NOT NULL,
  LAU2         VARCHAR(255) NOT NULL,
  _CHANGE      VARCHAR(255) NOT NULL,
  NAME1        VARCHAR(255) NOT NULL,
  NAME2        VARCHAR(255) NOT NULL,
  POP          INTEGER      NOT NULL,
  AREA         INTEGER      NOT NULL,
  PRIMARY KEY (LAU_ID)
);

CREATE TABLE SEC_USERS_T (
  USER_ID      INTEGER NOT NULL,
  EMAIL        VARCHAR(255),
  PASSWORD     VARCHAR(255),
  CREATE_DATE  DATETIME,
  ACCESS_DATE  DATETIME,
  USER_TYPE    INTEGER NOT NULL,
  USER_TYPE_ID INTEGER NOT NULL,
  PRIMARY KEY (USER_ID)
);
INSERT INTO SEC_USERS_T (USER_ID, EMAIL, PASSWORD, CREATE_DATE, ACCESS_DATE, USER_TYPE, USER_TYPE_ID)
VALUES ('69', 'd1@example.com', '12345678', '2017-06-02', '2017-06-02', '5', '0');
/*INSERT INTO SEC_USERS_T (USER_ID, EMAIL, PASSWORD, CREATE_DATE, ACCESS_DATE, USER_TYPE, USER_TYPE_ID)
VALUES ('100', 'b1@example.com', '12345678', '2017-05-01', '2017-05-01', '2', '100'),
  ('101', 'b2@example.com', '12345678', '2017-05-01', '2017-05-01', '2', '101'),
  ('102', 'b3@example.com', '12345678', '2017-05-01', '2017-05-01', '2', '102'),
  ('103', 's1@example.com', '12345678', '2017-05-01', '2017-05-01', '1', '100'),
  ('104', 's2@example.com', '12345678', '2017-05-01', '2017-05-01', '1', '101'),
  ('105', 'd1@example.com', '12345678', '2017-05-01', '2017-05-01', '5', '0');*/

CREATE TABLE SEC_ROLES_T (
  ROLE_ID INTEGER NOT NULL,
  NAME    VARCHAR(255),
  PRIMARY KEY (ROLE_ID)
);
CREATE TABLE SEC_RIGHTS_T (
  RIGHT_ID INTEGER NOT NULL,
  NAME     VARCHAR(255),
  PRIMARY KEY (RIGHT_ID)
);
CREATE TABLE SEC_USER_ROLES_T (
  USER_ID INTEGER NOT NULL,
  ROLE_ID INTEGER NOT NULL
);
CREATE TABLE SEC_ROLE_RIGHTS_T (
  ROLE_ID  INTEGER NOT NULL,
  RIGHT_ID INTEGER NOT NULL
);
CREATE TABLE BEN_LGE_T (
  LEGAL_ENTITY_ID   INTEGER NOT NULL,
  COUNTRY_CODE      VARCHAR(255),
  MUNICIPALITY_CODE VARCHAR(255),
  ADDRESS           VARCHAR(255),
  ADDRESS_NUM       VARCHAR(255),
  POSTAL_CODE       VARCHAR(255),
  LEGAL_CHECKBOX_1  BOOLEAN,
  LEGAL_CHECKBOX_2  BOOLEAN,
  LEGAL_CHECKBOX_3  BOOLEAN,
  ABAC_STATUS       BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (LEGAL_ENTITY_ID)
);
/*
ALTER TABLE `BEN_LGE_T` ADD `ABAC_STATUS` BOOLEAN NOT NULL DEFAULT FALSE AFTER `LEGAL_CHECKBOX_3`;
*/

/*INSERT INTO BEN_LGE_T (LEGAL_ENTITY_ID, COUNTRY_CODE, MUNICIPALITY_CODE, ADDRESS, ADDRESS_NUM, POSTAL_CODE, LEGAL_CHECKBOX_1, LEGAL_CHECKBOX_2, LEGAL_CHECKBOX_3)
VALUES ('100', 'ES', 'ES511', 'Diagonal', '605', '08022', '1', '1', '1'),
  ('101', 'ES', 'ES511', 'Diagonal', '605', '08022', '1', '1', '1'),
  ('102', 'ES', 'ES512', 'Diagonal', '605', '08022', '1', '1', '1');*/

CREATE TABLE BEN_MAY_T (
  MAYOR_ID        INTEGER NOT NULL,
  TREATMENT       VARCHAR(255),
  NAME            VARCHAR(255),
  SURNAME         VARCHAR(255),
  EMAIL           VARCHAR(255),
  LEGAL_ENTITY_ID INTEGER NOT NULL,
  PRIMARY KEY (MAYOR_ID)
);
/*INSERT INTO BEN_MAY_T (MAYOR_ID, TREATMENT, NAME, SURNAME, EMAIL, LEGAL_ENTITY_ID)
VALUES ('100', 'mr', 'John', 'Doe', 'b1@example.com', '100'),
  ('101', 'mr', 'John', 'Doe', 'b2@example.com', '101'),
  ('102', 'mr', 'John', 'Doe', 'b3@example.com', '102');*/

CREATE TABLE BEN_REP_T (
  REPRESENTATIVE_ID INTEGER NOT NULL,
  TREATMENT         VARCHAR(255),
  NAME              VARCHAR(255),
  SURNAME           VARCHAR(255),
  MUNICIPALITY_ROLE VARCHAR(255),
  EMAIL             VARCHAR(255),
  MAYOR_ID          INTEGER,
  PRIMARY KEY (REPRESENTATIVE_ID)
);

CREATE TABLE SEC_TEMPTOKEN_T (
  ID          INTEGER NOT NULL,
  TOKEN       VARCHAR(255),
  EMAIL       VARCHAR(255),
  USER_ID     INTEGER NOT NULL,
  CREATE_DATE DATETIME,
  EXPIRY_DATE DATETIME,
  PRIMARY KEY (ID)
);

CREATE TABLE SUPP_SUPPLIER_T (
  SUPPLIER_ID          INTEGER NOT NULL,
  NAME                 VARCHAR(255),
  ADDRESS              VARCHAR(255),
  VAT                  VARCHAR(255),
  BIC                  VARCHAR(255),
  ACCOUNT_NUMBER       VARCHAR(255),
  WEBSITE              VARCHAR(255),
  CONTACT_NAME         VARCHAR(255),
  CONTACT_SURNAME      VARCHAR(255),
  CONTACT_PHONE_PREFIX VARCHAR(255),
  CONTACT_PHONE_NUMBER VARCHAR(255),
  CONTACT_EMAIL        VARCHAR(255),
  LEGAL_CHECK1         BOOLEAN,
  LEGAL_CHECK2         BOOLEAN,
  CREATE_DATE          DATETIME,
  NUTS_IDS             LONGTEXT,
  LOGO                 LONGTEXT,
  ABAC_STATUS          BOOLEAN NOT NULL DEFAULT FALSE,
  PRIMARY KEY (SUPPLIER_ID)
);
/*
ALTER TABLE `SUPP_SUPPLIER_T` ADD `ABAC_STATUS` BOOLEAN NOT NULL DEFAULT FALSE AFTER `LOGO`;
*/

/*INSERT INTO SUPP_SUPPLIER_T (SUPPLIER_ID, NAME, ADDRESS, VAT, BIC, ACCOUNT_NUMBER, WEBSITE, CONTACT_NAME, CONTACT_SURNAME, CONTACT_PHONE_PREFIX, CONTACT_PHONE_NUMBER, CONTACT_EMAIL, LEGAL_CHECK1, LEGAL_CHECK2, CREATE_DATE, NUTS_IDS, LOGO)
VALUES
  ('100', 'Everis', 'Diagonal, 605', '0', '0', '0', 'http://everis.com', 'Everis', 'Diagonal, 605', '+34', '666666666',
   's1@example.com', '1', '1', '2017-05-01', 'ES,ES511', NULL),
  ('101', 'Everis', 'Diagonal, 605', '0', '0', '0', 'http://everis.com', 'Everis', 'Diagonal, 605', '+34', '666666666',
   's2@example.com', '1', '1', '2017-05-01', 'ES,ES511', NULL);*/

CREATE TABLE SUPP_INSTALLATION_T (
  INSTALLATION_ID INTEGER NOT NULL,
  NIP             VARCHAR(255),
  PRIMARY KEY (INSTALLATION_ID)
);
/*INSERT INTO SUPP_INSTALLATION_T (INSTALLATION_ID, NIP)
VALUES ('111', '0');*/

CREATE TABLE SUPP_ACCESSPOINT_T (
  ACCESSPOINT_ID  INTEGER NOT NULL,
  NAME            VARCHAR(255),
  SERIAL_NUMBER   VARCHAR(255),
  PRODUCT_NAME    VARCHAR(255),
  MODEL_NUMBER    VARCHAR(255),
  INSTALLATION_ID INTEGER NOT NULL,
  INDOOR          TINYINT,
  PRIMARY KEY (ACCESSPOINT_ID)
);
/*INSERT INTO SUPP_ACCESSPOINT_T (ACCESSPOINT_ID, NAME, SERIAL_NUMBER, PRODUCT_NAME, MODEL_NUMBER, INSTALLATION_ID)
VALUES ('112', 'AP-01', '0', 'Makita 1-1/4 HP Compact Router', 'RT0701C', '111'),
  ('113', 'AP-02', '0', 'Makita 1-1/4 HP Compact Router', 'RT0701C', '111'),
  ('114', 'AP-03', '0', 'Makita 1-1/4 HP Compact Router', 'RT0701C', '111');*/

CREATE TABLE TIM_TIMELINE_T (
  TIMELINE_ID INTEGER NOT NULL,
  START_DATE  VARCHAR(255),
  END_DATE    VARCHAR(255),
  EVENT       VARCHAR(255),
  PRIMARY KEY (TIMELINE_ID)
);
/*INSERT INTO TIM_TIMELINE_T (TIMELINE_ID, START_DATE, END_DATE, EVENT)
VALUES ('108', '1494055200000', '1493968800000', 'Opening competition'),
  ('109', '1494055200000', '1493968800000', 'Voucher assignation'),
  ('110', '1494055200000', '1493968800000', 'Closing competition');*/

CREATE TABLE HEL_HELPDESK_T (
  ISSUE_ID              INTEGER NOT NULL,
  ASSIGNED_TO           VARCHAR(255),
  CREATE_DATE           DATETIME,
  DG_CONNECT_COMMENTS   VARCHAR(255),
  FROM_EMAIL            VARCHAR(255),
  ISSUE_SUMMARY         VARCHAR(255),
  MEMBER_STATE          VARCHAR(255),
  MEMBER_STATE_COMMENTS VARCHAR(255),
  PORTAL                VARCHAR(255),
  STATUS                VARCHAR(255),
  TOPIC                 VARCHAR(255),
  PRIMARY KEY (ISSUE_ID)
);

CREATE TABLE HEL_HELPDESK_COMMENTS_T (
  COMMENT_ID    INTEGER NOT NULL,
  TYPE          VARCHAR(255),
  COMMENT       TEXT,
  COMMENT_DATE  DATETIME,
  ISSUE_ID      INTEGER,
  PRIMARY KEY (COMMENT_ID)
);

/*INSERT INTO HEL_HELPDESK_T (ISSUE_ID, ASSIGNED_TO, CREATE_DATE, DG_CONNECT_COMMENTS, FROM_EMAIL, ISSUE_SUMMARY, MEMBER_STATE, MEMBER_STATE_COMMENTS, PORTAL, STATUS, TOPIC)
VALUES ('115', 'Member State', '2017-05-01', NULL, 'b1@example.com', 'Test', NULL, NULL, NULL, 'Pending', 'Test'),
  ('116', 'Member State', '2017-05-01', NULL, 'b2@example.com', 'Test 2', NULL, NULL, NULL, 'Pending', 'Test');*/

CREATE TABLE CALL_T (
  CALL_ID    INTEGER,
  END_DATE   VARCHAR(255),
  EVENT      VARCHAR(255),
  START_DATE VARCHAR(255),
  PRIMARY KEY (CALL_ID)

);
/*INSERT INTO CALL_T (CALL_ID, END_DATE, EVENT, START_DATE)
VALUES ('201', '1494055200000', 'Wifi for Europeans 2017', '1493968800000');*/

CREATE TABLE SUPP_BENPUBSUP_T (
  `BENPUBSUP_ID` int(11) NOT NULL,
  `BENEFICIARY_ID` int(11) NOT NULL,
  `PUBLICATION_ID` int(11) NOT NULL,
  `AWARDED` tinyint(1) NOT NULL DEFAULT '0',
  `SUPPLIER_ID` int(11) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  `LEF_EXPORT` bigint(20) NOT NULL DEFAULT '0',
  `LEF_IMPORT` bigint(20) NOT NULL DEFAULT '0',
  `LEF_STATUS` int(11) NOT NULL DEFAULT '0',
  `BC_EXPORT` bigint(20) NOT NULL DEFAULT '0',
  `BC_IMPORT` bigint(20) NOT NULL DEFAULT '0',
  `BC_STATUS` int(11) NOT NULL DEFAULT '0',
  `LC_EXPORT` bigint(20) NOT NULL DEFAULT '0',
  `LC_IMPORT` bigint(20) NOT NULL DEFAULT '0',
  `LC_STATUS` int(11) NOT NULL DEFAULT '0',
  `LAST_ABAC_MESSAGE` text COLLATE utf8_bin,
  PRIMARY KEY (BENPUBSUP_ID)
);
/*
ALTER TABLE `SUPP_BENPUBSUP_T` ADD `ABAC_STATUS` BOOLEAN NOT NULL DEFAULT FALSE AFTER `DATE`;
*/
/*INSERT INTO SUPP_BENPUBSUP_T (BENPUBSUP_ID, BENEFICIARY_ID, PUBLICATION_ID, AWARDED, SUPPLIER_ID)
VALUES ('111', '100', '201', '1', '100'), ('101', '102', '201', '1', '101');*/

CREATE TABLE SEQUENCE (
  SEQ_NAME  VARCHAR(50) NOT NULL,
  SEQ_COUNT NUMERIC(38),
  PRIMARY KEY (SEQ_NAME)
);
INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) VALUES ('SEQ_GEN', 50);
