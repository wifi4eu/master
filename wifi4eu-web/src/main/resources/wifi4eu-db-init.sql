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
DROP TABLE IF EXISTS SUPP_SUPPLIER_T;
DROP TABLE IF EXISTS TIM_TIMELINE_T;
DROP TABLE IF EXISTS HEL_HELPDESK_T;
DROP TABLE IF EXISTS SEQUENCE;

CREATE TABLE LOC_NUTS_T (
  NUTS_ID      INTEGER      NOT NULL AUTO_INCREMENT,
  NUTS_CODE    VARCHAR(255) NOT NULL,
  NUTS_LABEL   VARCHAR(255) NOT NULL,
  NUTS_LEVEL   INTEGER      NOT NULL,
  COUNTRY_CODE VARCHAR(255) NOT NULL,
  `_ORDER`     INTEGER      NOT NULL,
  SORTING      INTEGER      NOT NULL,
  PRIMARY KEY (NUTS_ID)
);
CREATE TABLE LOC_LAU_T (
  LAU_ID       INTEGER      NOT NULL AUTO_INCREMENT,
  COUNTRY_CODE VARCHAR(255) NOT NULL,
  NUTS3        VARCHAR(255) NOT NULL,
  LAU1         VARCHAR(255) NOT NULL,
  LAU2         VARCHAR(255) NOT NULL,
  `_CHANGE`    VARCHAR(255) NOT NULL,
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
  PRIMARY KEY (LEGAL_ENTITY_ID)
);
CREATE TABLE BEN_MAY_T (
  MAYOR_ID        INTEGER NOT NULL,
  TREATMENT       VARCHAR(255),
  NAME            VARCHAR(255),
  SURNAME         VARCHAR(255),
  EMAIL           VARCHAR(255),
  LEGAL_ENTITY_ID INTEGER NOT NULL,
  PRIMARY KEY (MAYOR_ID)
);
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
    SUPPLIER_ID     INTEGER NOT NULL,
    NAME            VARCHAR(255),
    ADDRESS                 VARCHAR(255),
    VAT                     VARCHAR(255),
    BIC                     VARCHAR(255),
    ACCOUNT_NUMBER          VARCHAR(255),
    WEBSITE                 VARCHAR(255),
    CONTACT_NAME            VARCHAR(255),
    CONTACT_SURNAME         VARCHAR(255),
    CONTACT_PHONE_PREFIX    VARCHAR(255),
    CONTACT_PHONE_NUMBER    VARCHAR(255),
    CONTACT_EMAIL           VARCHAR(255),
    LEGAL_CHECK1            BOOLEAN,
    LEGAL_CHECK2            BOOLEAN,
    CREATE_DATE             DATETIME,
    NUTS_IDS                VARCHAR(255),
    PRIMARY KEY (SUPPLIER_ID)
);

CREATE TABLE SUPP_INSTALLATION_T (
    INSTALLATION_ID     INTEGER NOT NULL,
    NIP                 VARCHAR(255),
    OUTDOOR_PRICE           DOUBLE,
    INDOOR_PRICE            DOUBLE,
    PRIMARY KEY (INSTALLATION_ID)
);

CREATE TABLE SUPP_ACCESSPOINT_T (
    ACCESSPOINT_ID    INTEGER NOT NULL,
    NAME              VARCHAR(255),
    SERIAL_NUMBER     VARCHAR(255),
    PRODUCT_NAME      VARCHAR(255),
    MODEL_NUMBER      VARCHAR(255),
    INSTALLATION_ID   INTEGER NOT NULL,
    PRIMARY KEY (ACCESSPOINT_ID)
);

CREATE TABLE TIM_TIMELINE_T (
    TIMELINE_ID         INTEGER NOT NULL,
    START_DATE          VARCHAR(255),
    END_DATE            VARCHAR(255),
    EVENT               VARCHAR(255),
    PRIMARY KEY (TIMELINE_ID)
);

CREATE TABLE HEL_HELPDESK_T (
    ISSUE_ID                INTEGER NOT NULL,
    ASSIGNED_TO             VARCHAR(255),
    CREATE_DATE             DATETIME,
    DG_CONNECT_COMMENTS     VARCHAR(255),
    FROM_EMAIL              VARCHAR(255),
    ISSUE_SUMMARY           VARCHAR(255),
    MEMBER_STATE            VARCHAR(255),
    MEMBER_STATE_COMMENTS   VARCHAR(255),
    PORTAL                  VARCHAR(255),
    STATUS                  VARCHAR(255),
    TOPIC                   VARCHAR(255),
    PRIMARY KEY (ISSUE_ID)
);

CREATE TABLE CALL_T (
    CALL_ID         INTEGER,
    END_DATE        VARCHAR(255),
    EVENT           VARCHAR(255),
    START_DATE      VARCHAR(255),
    PRIMARY KEY(CALL_ID)

);

CREATE TABLE SEQUENCE (
  SEQ_NAME  VARCHAR(50) NOT NULL,
  SEQ_COUNT NUMERIC(38),
  PRIMARY KEY (SEQ_NAME)
);
INSERT INTO SEQUENCE (SEQ_NAME, SEQ_COUNT) VALUES ('SEQ_GEN', 50);

/*
INSERT INTO SEC_USERS_T VALUES (152488, 'test@wifi4eu.eu', 'test', '2017-02-01', '2017-02-01');
INSERT INTO SEC_ROLES_T VALUES (1, 'ADMIN');
INSERT INTO SEC_RIGHTS_T VALUES (1, 'right.connect');
INSERT INTO SEC_ROLE_RIGHTS_T VALUES (1, 1);
INSERT INTO SEC_USER_ROLES_T VALUES (152488, 1);
*/

/*
DROP TABLE LOC_NUTS_T;
DROP TABLE LOC_LAU_T;
DROP TABLE SEC_USERS_T;
DROP TABLE SEC_USER_ROLES_T;
DROP TABLE SEC_ROLES_T;
DROP TABLE SEC_ROLE_RIGHTS_T;
DROP TABLE SEC_RIGHTS_T;
DROP TABLE BEN_LGE_T;
DROP TABLE BEN_MAY_T;
DROP TABLE BEN_REP_T;

CREATE TABLE LOC_NUTS_T (NUTS_ID INTEGER NOT NULL,CODE VARCHAR(255) NOT NULL ,NAME VARCHAR(255) NOT NULL , COL_LEVEL INTEGER NOT NULL , CONTRY_CODE VARCHAR(255) NOT NULL , COL_ORDER INTEGER NOT NULL , SORTING INTEGER NOT NULL , PRIMARY KEY (NUTS_ID));
CREATE TABLE LOC_LAU_T (LAU_ID INTEGER NOT NULL,COUNTRY_CODE VARCHAR(255) NOT NULL , NUTS3 VARCHAR(255) NOT NULL , LAU1 VARCHAR(255) NOT NULL , LAU2 VARCHAR(255) NOT NULL , COL_CHANGE VARCHAR(255) NOT NULL , NAME1 VARCHAR(255) NOT NULL , NAME2 VARCHAR(255) NOT NULL , POP INTEGER NOT NULL , AREA INTEGER NOT NULL , PRIMARY KEY (LAU_ID));

CREATE TABLE SEC_USERS_T (USER_ID INTEGER NOT NULL, EMAIL VARCHAR(255), PASSWORD VARCHAR(255), CREATE_DATE DATE, ACCESS_DATE DATE, PRIMARY KEY (USER_ID));
CREATE TABLE SEC_ROLES_T (ROLE_ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (ROLE_ID));
CREATE TABLE SEC_RIGHTS_T (RIGHT_ID INTEGER NOT NULL, NAME VARCHAR(255), PRIMARY KEY (RIGHT_ID));
CREATE TABLE SEC_USER_ROLES_T (USER_ID INTEGER NOT NULL, ROLE_ID INTEGER NOT NULL);
CREATE TABLE SEC_ROLE_RIGHTS_T (ROLE_ID INTEGER NOT NULL, RIGHT_ID INTEGER NOT NULL);
CREATE TABLE BEN_LGE_T (LEGAL_ENTITY_ID INTEGER NOT NULL, COUNTRY_CODE VARCHAR(255),MUNICIPALITY_CODE VARCHAR(255), ADDRESS VARCHAR(255), ADDRESS_NUM VARCHAR(255), POSTAL_CODE VARCHAR(255),LEGAL_CHECKBOX_1 CHAR(1), LEGAL_CHECKBOX_2 CHAR(1), LEGAL_CHECKBOX_3 CHAR(1), PRIMARY KEY (LEGAL_ENTITY_ID));
CREATE TABLE BEN_MAY_T (MAYOR_ID INTEGER NOT NULL, TREATMENT VARCHAR(255), NAME VARCHAR(255), SURNAME VARCHAR(255), EMAIL VARCHAR(255), PRIMARY KEY (MAYOR_ID));
CREATE TABLE BEN_REP_T (REPRESENTATIVE_ID INTEGER NOT NULL,TREATMENT VARCHAR(255), NAME VARCHAR(255),SURNAME VARCHAR(255),MUNICIPALITY_ROLE VARCHAR(255),EMAIL VARCHAR(255), MAYOR_ID INTEGER, PRIMARY KEY (REPRESENTATIVE_ID));


INSERT INTO SEC_USERS_T VALUES ('152488', 'test@wifi4eu.eu', 'test', '2017-02-01', '2017-02-01');

*/