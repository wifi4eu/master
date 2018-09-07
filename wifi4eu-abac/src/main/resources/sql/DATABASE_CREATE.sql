--------------------------------------------------------
--  DDL for View WIF_ABAC_BC_STATUS_VIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "WIFI4EU_ABAC"."WIF_ABAC_BC_STATUS_VIEW" ("BC_ID", "REQUEST_ID", "SUBMIT_DATE", "REQUEST_TYPE", "L_LOC_OBJ_FK", "OBJ_STATUS_CD", "WKFLW_STAT_CD", "STATUS", "ERROR_MSG") AS
  select bc_id, request_id, submit_date, request_type, L_LOC_OBJ_FK, obj_status_cd, wkflw_stat_cd, status, listagg(error_message, chr(10)) within group(order by error_log_id) as ERROR_MSG
from (
select request.bc_id, request.submit_date, request.request_type, error_log_id, request.id as request_id, request.L_LOC_OBJ_FK, oj.obj_status_cd, oj.wkflw_stat_cd, err.msg_txt as error_message,
case
  when bc.PROCESSED = 'N'
  then 'WAITING_FOR_ABAC'

  when oj.obj_status_cd = 'VALID' and oj.wkflw_stat_cd = 'FIN'
  then 'ABAC_VALID'

  when oj.obj_status_cd = 'VALID' and oj.wkflw_stat_cd in ('INIT','PEND')
  then 'WAITING_APPROVAL'

  when oj.obj_status_cd = 'INVALID' or err.msg_txt is not null
  then 'ABAC_ERROR'
  else 'UNMAPPED_STATUS'
end  as status
from wif_abac_request_process request
left join V_LOC_COMMITMENT_HEADER@ABAC_SHARED bc on request.L_LOC_OBJ_FK = (bc.loc_sys_cd || '.' || bc.run_id)
left join v_o_gen_object_References@ABAC_SHARED oj on oj.loc_sys_cd = 'WIF' and ('WIF.' || substr(oj.loc_obj_Foreign_id, 5, instr(oj.loc_obj_Foreign_id, '.')+1)) = request.L_LOC_OBJ_FK
left join V_O_LOG_ERRORS@ABAC_SHARED err ON err.loc_sys_cd = 'WIF' and request.L_LOC_OBJ_FK = (err.loc_sys_cd || '.' || err.batch_id) and err.msg_tp_cd <> 'I'
where request.request_type = 'BUDGETARY_COMMITMENT'
) group by bc_id, request_id, submit_date, request_type, L_LOC_OBJ_FK, obj_status_cd, wkflw_stat_cd, status;
--------------------------------------------------------
--  DDL for View WIF_ABAC_LC_STATUS_VIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "WIFI4EU_ABAC"."WIF_ABAC_LC_STATUS_VIEW" ("LC_ID", "REQUEST_ID", "SUBMIT_DATE", "REQUEST_TYPE", "L_LOC_OBJ_FK", "OBJ_STATUS_CD", "WKFLW_STAT_CD", "STATUS", "ERROR_MSG") AS
  select lc_id, request_id, submit_date, request_type, L_LOC_OBJ_FK, obj_status_cd, wkflw_stat_cd, status, listagg(error_message, chr(10)) within group(order by error_log_id) as ERROR_MSG
from (
select request.lc_id, request.submit_date, request.request_type, error_log_id, request.id as request_id, request.L_LOC_OBJ_FK, oj.obj_status_cd, oj.wkflw_stat_cd, err.msg_txt as error_message,
case
  when lc.PROCESSED = 'N'
  then 'WAITING_FOR_ABAC'

  when oj.obj_status_cd = 'VALID' and oj.wkflw_stat_cd = 'FIN'
  then 'ABAC_VALID'

  when oj.obj_status_cd = 'INVALID' or err.msg_txt is not null
  then 'ABAC_ERROR'
  else 'UNMAPPED_STATUS'
end  as status
from wif_abac_request_process request
left join V_LOC_LCM_HEADER@ABAC_SHARED lc on request.L_LOC_OBJ_FK = (lc.loc_sys_cd || '.' || lc.run_id)
left join v_o_gen_object_References@ABAC_SHARED oj on oj.loc_obj_Foreign_id = request.L_LOC_OBJ_FK
left join V_O_LOG_ERRORS@ABAC_SHARED err ON err.loc_sys_cd = 'WIF' and request.L_LOC_OBJ_FK = (err.loc_sys_cd || '.' || err.batch_id) and err.msg_tp_cd <> 'I'
where request.request_type = 'LEGAL_COMMITMENT'
) group by lc_id, request_id, submit_date, request_type, L_LOC_OBJ_FK, obj_status_cd, wkflw_stat_cd, status;
--------------------------------------------------------
--  DDL for View WIF_ABAC_LEF_STATUS_VIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "WIFI4EU_ABAC"."WIF_ABAC_LEF_STATUS_VIEW" ("LOC_OBJ_FOREIGN_ID", "STATUS", "LE_KEY", "ERROR_MSG", "REJECTION_MSG") AS
  select LOC_OBJ_FOREIGN_ID, status, le_key,
listagg(error_msg, chr(10)) within group(order by error_log_id) as ERROR_MSG,
listagg(REJECTION_MSG, chr(10)) within group(order by error_log_id) as REJECTION_MSG
from (
select
le.LOC_OBJ_FOREIGN_ID,
case

  when le.PROCESSED = 'OK' and lekey.head_loc_obj_foreign_id is not null
  then 'ABAC_VALID'

   when lelinks.PROCESSED is not null and lelinks.OBJ_STATUS_CD = 'REJECTED'
  then 'ABAC_REJECTED'

  when le.PROCESSED = 'N'
  then 'WAITING_FOR_ABAC'

  when le.PROCESSED in ('OK','OK_W') and lekey.head_loc_obj_foreign_id is null
  then 'WAITING_APPROVAL'

  when le.PROCESSED = 'NOK'
  then 'ABAC_ERROR'
  else 'UNMAPPED_STATUS'
end  as status,
lekey.head_loc_obj_foreign_id as LE_KEY,
err.msg_txt as ERROR_MSG,
err.error_log_id,
lelinks.REJECTION_REASON as REJECTION_MSG
FROM V_LOC_THP_LEGAL_ENTITIES@ABAC_SHARED le
LEFT JOIN V_O_LOG_ERRORS@ABAC_SHARED err ON err.batch_id = le.run_id and err.loc_sys_cd = le.loc_sys_cd and err.msg_tp_cd <> 'I'
LEFT JOIN V_O_THP_COMMON_LOCAL_LINKS@ABAC_SHARED lekey ON lekey.loc_obj_foreign_id = le.loc_obj_foreign_id
LEFT JOIN V_LOC_THP_COMMON_LOCAL_LINKS@ABAC_SHARED lelinks ON lelinks.loc_obj_foreign_id = le.loc_obj_foreign_id
where le.LOC_OBJ_FOREIGN_ID like 'WIF%')
group by LOC_OBJ_FOREIGN_ID, status, le_key;
--------------------------------------------------------
--  DDL for DB Link ABAC.CC.CEC.EU.INT
--------------------------------------------------------

  CREATE DATABASE LINK "ABAC.CC.CEC.EU.INT"
   CONNECT TO "WIFI4EU$" IDENTIFIED BY VALUES ':1'
   USING 'ABACBUDT';
--------------------------------------------------------
--  DDL for DB Link ABAC_SHARED.CC.CEC.EU.INT
--------------------------------------------------------

  CREATE SHARED DATABASE LINK "ABAC_SHARED.CC.CEC.EU.INT"
   CONNECT TO "WIFI4EU$" IDENTIFIED BY VALUES ':1'
   AUTHENTICATED BY "WIFI4EU$" IDENTIFIED BY VALUES ':2'
   USING 'ABACBUDT';
--------------------------------------------------------
--  DDL for Table WIF_ABAC_REQUEST_PROCESS
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"
   (	"ID" NUMBER(18,0),
	"LE_ID" NUMBER(18,0),
	"L_LOC_OBJ_FK" VARCHAR2(56 BYTE),
	"L_QUE_ID" NUMBER(18,0),
	"SUBMIT_DATE" DATE DEFAULT SYSDATE,
	"ERROR_MSG" VARCHAR2(2000 BYTE),
	"REJECTION_MSG" VARCHAR2(2000 BYTE),
	"REQUEST_TYPE" VARCHAR2(25 BYTE),
	"BC_ID" NUMBER,
	"LC_ID" NUMBER
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."LE_ID" IS ' Municipality ID in AIRGAP';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."L_LOC_OBJ_FK" IS 'This is created by the application and is a unique identifier for the LE. The format should be "WIF.XXXXXX" where XXXXXX is the id in the application.';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."ERROR_MSG" IS 'The error message from ABAC';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."REJECTION_MSG" IS 'The rejection reason from ABAC';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."REQUEST_TYPE" IS 'Type of request sent to abac. E.g.: LEGAL_ENTITY';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."BC_ID" IS 'Budgetary Commitment Id in Airgap';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."LC_ID" IS 'Legal Commitment Id in Airgap';
--------------------------------------------------------
--  DDL for Table WIF_AUTH_ROLES
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_AUTH_ROLES"
   (	"ID" NUMBER(18,0),
	"NAME" VARCHAR2(100 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_AUTH_USERS
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS"
   (	"ID" NUMBER(18,0),
	"USERNAME" VARCHAR2(50 BYTE),
	"EMAIL" VARCHAR2(100 BYTE),
	"FIRST_NAME" VARCHAR2(100 BYTE),
	"LAST_NAME" VARCHAR2(100 BYTE),
	"ENABLED" VARCHAR2(1 BYTE) DEFAULT 'Y',
	"TOKEN_EXPIRED" VARCHAR2(1 BYTE) DEFAULT 'Y'
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_AUTH_USERS_ROLES
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS_ROLES"
   (	"ROLE_ID" NUMBER(18,0),
	"USER_ID" NUMBER(18,0)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_BC_LEVEL2_POSITION
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION"
   (	"ID" NUMBER,
	"COMMITMENT_L2_POSITION" NUMBER,
	"COMMITMENT_L2_AMOUNT" NUMBER,
	"BUDGETARY_COMMITMENT_ID" NUMBER,
	"GLOBAL_COMMITMENT_L1_POS_KEY" VARCHAR2(50 BYTE),
	"COMMITMENT_L2_KEY" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_BUDGETARY_COMMITMENT
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT"
   (	"ID" NUMBER,
	"WF_STATUS" VARCHAR2(20 BYTE),
	"LEGAL_ENTITY_ID" NUMBER,
	"DATE_CREATED" DATE,
	"DATE_UPDATED" DATE,
	"COMMITMENT_L2_KEY" VARCHAR2(50 BYTE),
	"BATCH_REF" VARCHAR2(50 BYTE)
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT"."BATCH_REF" IS 'The batch process unique reference used for notifications';
--------------------------------------------------------
--  DDL for Table WIF_CONSTANTS
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS"
   (	"ID" NUMBER(18,0),
	"NAME" VARCHAR2(200 BYTE),
	"VALUE" VARCHAR2(200 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_COUNTRY
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_COUNTRY"
   (	"ISO2_CODE" VARCHAR2(2 CHAR),
	"NAME" VARCHAR2(50 CHAR),
	"EU_MEMBER" VARCHAR2(1 CHAR) DEFAULT 'N',
	"ACTIVE" VARCHAR2(1 CHAR) DEFAULT 'Y',
	"CCM2_CODE" NUMBER,
	"NATIVE_DESCRIPTIONS" VARCHAR2(50 BYTE),
	"ISO3_CODE" VARCHAR2(3 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_DOCTYPE_METADATA_TYPE
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE"
   (	"ID" NUMBER(18,0),
	"CCM2_DOCTYPE_ID" NUMBER(18,0),
	"CCM2_DOCTYPE_ABBREV" VARCHAR2(100 BYTE),
	"CCM2_METADATA_ID" NUMBER(18,0),
	"CCM2_METADATA_ABBREV" VARCHAR2(100 BYTE),
	"METADATA_KEY" VARCHAR2(100 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_DOCUMENTS
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS"
   (	"ID" NUMBER(18,0),
	"NAME" VARCHAR2(50 BYTE),
	"ARES_REFERENCE" VARCHAR2(50 BYTE),
	"ARES_DATE" DATE,
	"MIMETYPE" VARCHAR2(50 BYTE),
	"DATE_CREATED" DATE DEFAULT NULL,
	"DATE_UPDATED" DATE,
	"WF_STATUS" VARCHAR2(50 BYTE) DEFAULT 'READY_FOR_ABAC',
	"PORTAL_ID" NUMBER,
	"LEGAL_ENTITY_ID" NUMBER,
	"DOCUMENT_TYPE" VARCHAR2(50 BYTE),
	"FILE_NAME" VARCHAR2(255 BYTE),
	"PORTAL_DATE" DATE,
	"DATA" BLOB,
	"HERMES_REF" VARCHAR2(100 BYTE),
	"ORIGINAL" VARCHAR2(1 BYTE),
	"HERMES_ATT_ID" VARCHAR2(100 BYTE),
	"HERMES_SAVE_NUMBER" VARCHAR2(200 BYTE),
	"HERMES_REG_NUMBER" VARCHAR2(200 BYTE),
	"DOCUMENTTYPE_CCM2CODE" VARCHAR2(100 BYTE),
	"HERMES_FILE_ID" VARCHAR2(200 BYTE),
	"HERMES_DOC_ID" VARCHAR2(200 BYTE)
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."ID" IS 'Incremental ID';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."ARES_REFERENCE" IS 'ARES document reference';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."ARES_DATE" IS 'ARES document date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."DATE_CREATED" IS 'Creation date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."DATE_UPDATED" IS 'Modification date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."WF_STATUS" IS 'Workflow status';
--------------------------------------------------------
--  DDL for Table WIF_DOCUMENT_TYPE
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_DOCUMENT_TYPE"
   (	"ID" NUMBER(18,0),
	"DOCT_TYPE_NAME" VARCHAR2(200 BYTE),
	"DESCRIPTION" VARCHAR2(200 BYTE),
	"CCM2_DOCTYPE_ID" NUMBER(18,0),
	"CCM2_DOCTYPE_ABBREV" VARCHAR2(50 BYTE),
	"CCM2_DOCTYPE_PARENT_ID" NUMBER,
	"CCM2_DOCTYPE_PARENT_ABBREV" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_IMPORT_LOG
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_IMPORT_LOG"
   (	"ID" NUMBER(18,0),
	"FILENAME" VARCHAR2(200 BYTE),
	"IMPORT_DATE" DATE,
	"USER_ID" VARCHAR2(20 BYTE),
	"BATCH_REF" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_LANGUAGE
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_LANGUAGE"
   (	"CD" VARCHAR2(2 CHAR),
	"NAME" VARCHAR2(200 CHAR),
	"ACTIVE" VARCHAR2(1 CHAR) DEFAULT 'Y',
	"CCM2_CODE" NUMBER,
	"NATIVE_DESCRIPTIONS" VARCHAR2(200 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_LEGAL_COMMITMENT
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"
   (	"ID" NUMBER(18,0),
	"LEGAL_ENTITY_ID" NUMBER(18,0),
	"ABAC_KEY" VARCHAR2(30 BYTE),
	"WF_STATUS" VARCHAR2(30 BYTE) DEFAULT 'READY_FOR_ABAC',
	"DATE_CREATED" DATE DEFAULT NULL,
	"DATE_UPDATED" DATE,
	"GRANT_AGREEMENT_DOC_ID" NUMBER,
	"COUNTERSIGNED_GRANT_AGR_DOC_ID" NUMBER,
	"GRANT_AGREEMENT_SIGNATURE_DATE" DATE,
	"GRANT_AGREEMENT_CNTRSIGN_DATE" DATE,
	"BATCH_REF" VARCHAR2(50 BYTE),
	"GRANT_AGREEMENT_CNTRSIGN_USER" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."ID" IS 'Incremental ID';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."LEGAL_ENTITY_ID" IS 'ID of the related LegalEntity';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."WF_STATUS" IS 'Workflow status';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."DATE_CREATED" IS 'Creation date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."DATE_UPDATED" IS 'Modification date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."GRANT_AGREEMENT_DOC_ID" IS 'Grant Agreement Document';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."COUNTERSIGNED_GRANT_AGR_DOC_ID" IS 'Counter-signed Grant Agreement Document';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."GRANT_AGREEMENT_SIGNATURE_DATE" IS 'Grant Agreement Signature Date';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."GRANT_AGREEMENT_CNTRSIGN_DATE" IS 'Grant Agreement CoutnerSignature Date';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."BATCH_REF" IS 'The batch process unique reference used for notifications';
--------------------------------------------------------
--  DDL for Table WIF_LEGAL_ENTITY
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"
   (	"ID" NUMBER(18,0),
	"MID" NUMBER(18,0),
	"OFFICIAL_NAME" VARCHAR2(400 BYTE),
	"LANGUAGE_CODE" VARCHAR2(3 BYTE) DEFAULT 'fr',
	"COUNTRY_CODE" VARCHAR2(2 BYTE),
	"OFFICIAL_ADDRESS" VARCHAR2(400 BYTE),
	"POSTAL_CODE" VARCHAR2(50 BYTE),
	"ABAC_FEL_ID" VARCHAR2(50 BYTE),
	"WF_STATUS" VARCHAR2(20 BYTE) DEFAULT 'IMPORTED',
	"DATE_CREATED" DATE DEFAULT SYSDATE,
	"CITY" VARCHAR2(400 BYTE),
	"DATE_UPDATED" DATE,
	"REGISTRATION_NUMBER" NUMBER(18,0),
	"SIGNATURE_DATE" DATE,
	"USER_IMPORTED" VARCHAR2(20 BYTE),
	"ID_SIGNATURE_FILE" NUMBER(18,0),
	"HERMES_FILE_ID" VARCHAR2(200 BYTE),
	"BATCH_REF" VARCHAR2(50 BYTE),
	"CALL_NUMBER" NUMBER(18,0),
	"ABAC_LATIN_NAME" VARCHAR2(35 BYTE),
	"ABAC_LATIN_ADDRESS" VARCHAR2(400 BYTE)
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."ID" IS 'AIGAP incremental id';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."MID" IS 'MUNICIPALITY registration ID from Portal';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."OFFICIAL_NAME" IS 'Offical name of the municipality';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."LANGUAGE_CODE" IS 'Language ISO code';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."COUNTRY_CODE" IS 'Country ISO2 code';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."OFFICIAL_ADDRESS" IS 'The offical address of the municipality';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."POSTAL_CODE" IS 'Postal code';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."ABAC_FEL_ID" IS 'A reference in format 6000XXXXXX with a reference validly pointing at a LEF in ABAC';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."WF_STATUS" IS 'Workflow status : IMPORTED, READY_FOR_ABAC, WAITING_FOR_ABAC, ABAC_FINISH, ABAC_ERROR';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."DATE_CREATED" IS 'Date when the entry was created in the system';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."CITY" IS 'Name of the city';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."USER_IMPORTED" IS 'Username of the last user who exported it';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."ID_SIGNATURE_FILE" IS 'ID of the related file with the signature';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."BATCH_REF" IS 'The batch process unique reference used for notifications';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY"."CALL_NUMBER" IS 'The call number of the grant';
--------------------------------------------------------
--  DDL for Table WIF_NOTIFICATION
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_NOTIFICATION"
   (	"ID" NUMBER(18,0),
	"NOTIFICATION_TYPE" VARCHAR2(100 BYTE),
	"SEND_TO" VARCHAR2(200 BYTE),
	"BATCH_REF" VARCHAR2(50 BYTE),
	"STATUS" VARCHAR2(100 BYTE) DEFAULT 'PENDING'
   ) ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ABAC_RUN_ID
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_ABAC_RUN_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 22120 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_BANK_ACCOUNT
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_BANK_ACCOUNT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_BC_LEVEL2_POSITION
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_BC_LEVEL2_POSITION"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_BUDGETARY_COMMITMENT
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_BUDGETARY_COMMITMENT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_DOCUMENT
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_DOCUMENT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 341 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_IMPORT_LOG
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_IMPORT_LOG"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 121 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_LEGAL_COMMITMENT
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_LEGAL_COMMITMENT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_LEGAL_ENTITY
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_LEGAL_ENTITY"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 557 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_NOTIFICATION
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_NOTIFICATION"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 121 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_WIF_ABAC_STATUS
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_WIF_ABAC_STATUS"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 461 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Index WIF_DOCUMENT_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_DOCUMENT_TYPE_PK" ON "WIFI4EU_ABAC"."WIF_DOCUMENT_TYPE" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_DOCTYPE_METADATA_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE_PK" ON "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_ABAC_BATCH_STATUS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_ABAC_BATCH_STATUS_PK" ON "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_BUDGETARY_COMMITMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT_PK" ON "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_LEGAL_ENTITY_MID_UNQ
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY_MID_UNQ" ON "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("OFFICIAL_NAME")
  ;
--------------------------------------------------------
--  DDL for Index WIF_IMPORT_LOG_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_IMPORT_LOG_PK" ON "WIFI4EU_ABAC"."WIF_IMPORT_LOG" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_CONSTANTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_CONSTANTS_PK" ON "WIFI4EU_ABAC"."WIF_CONSTANTS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_AUTH_TOLES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_AUTH_TOLES_PK" ON "WIFI4EU_ABAC"."WIF_AUTH_ROLES" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_NOTIFICATION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_NOTIFICATION_PK" ON "WIFI4EU_ABAC"."WIF_NOTIFICATION" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_BC_LEVEL2_POSITION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION_PK" ON "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index PK_LANGUAGE
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."PK_LANGUAGE" ON "WIFI4EU_ABAC"."WIF_LANGUAGE" ("CD")
  ;
--------------------------------------------------------
--  DDL for Index WIF_DOCUMENTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_DOCUMENTS_PK" ON "WIFI4EU_ABAC"."WIF_DOCUMENTS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index WIF_LC_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_LC_PK" ON "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index UK_LANGUAGE_NAME
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."UK_LANGUAGE_NAME" ON "WIFI4EU_ABAC"."WIF_LANGUAGE" ("NAME")
  ;
--------------------------------------------------------
--  DDL for Index WIF_AUTH_USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_AUTH_USERS_PK" ON "WIFI4EU_ABAC"."WIF_AUTH_USERS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index PK_COUNTRY
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."PK_COUNTRY" ON "WIFI4EU_ABAC"."WIF_COUNTRY" ("ISO2_CODE")
  ;
--------------------------------------------------------
--  DDL for Index IDX_TB_COUNTRYCCM2_CODE
--------------------------------------------------------

  CREATE INDEX "WIFI4EU_ABAC"."IDX_TB_COUNTRYCCM2_CODE" ON "WIFI4EU_ABAC"."WIF_COUNTRY" ("CCM2_CODE")
  ;
--------------------------------------------------------
--  DDL for Index WIF_MUNICIPALITY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_MUNICIPALITY_PK" ON "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("ID")
  ;
--------------------------------------------------------
--  DDL for Procedure CREATE_BC_IN_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."CREATE_BC_IN_ABAC" (LEGALENTITYID IN NUMBER ) AS
  PRAGMA AUTONOMOUS_TRANSACTION;

  l_BC_ID                   NUMBER;
  l_run_id				          NUMBER;
	l_loc_sys_cd			        VARCHAR2(3);
	l_loc_obj_foreign_id	    VARCHAR2(56);
  l_que_id 				          NUMBER;
  l_destination             VARCHAR2(200);
  ABAC_FEL_ID               number;
  header_title              varchar2(200);
  global_commitment_position varchar2(50);
  CONTR_REF_LOC_OBJ_FOREIGN_ID varchar2(100);
  request_type              varchar2(20);
  fdi_date                  date;
  fdi_delay_months          number;
  user_imported_login       varchar2(20);
  user_imported_name        varchar2(100);
  supporting_doc_ares_ref   varchar2(100);
BEGIN

  --global constants
  request_type := 'BUDGETARY_COMMITMENT';
  SELECT VALUE INTO l_loc_sys_cd from WIF_CONSTANTS WHERE NAME='ABAC_SYS_CD';
  SELECT VALUE INTO l_destination from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_DEST';
  l_run_id := SEQ_ABAC_RUN_ID.NEXTVAL;
  l_loc_obj_foreign_id:= l_loc_sys_cd || '.' || to_char(l_run_id);

  select
    le.ABAC_FEL_ID, 'WIFI4EU ' || upper(le.OFFICIAL_NAME), l_loc_obj_foreign_id || '.SECONDARY.' || le.ABAC_FEL_ID,
    le.user_imported as user_imported_login, (upper(u.last_name) || ' ' || u.first_name) as user_imported_name,
    doc.ares_reference as supporting_doc_ares_ref
    into ABAC_FEL_ID, header_title, CONTR_REF_LOC_OBJ_FOREIGN_ID, user_imported_login, user_imported_name, supporting_doc_ares_ref
  from WIF_LEGAL_ENTITY le
  join WIF_AUTH_USERS u on le.user_imported = u.USERNAME
  join WIF_DOCUMENTS doc on doc.legal_entity_id = le.id and doc.document_type = 'IDENTIFICATION_FORM'
  where le.id = LEGALENTITYID;

    fdi_delay_months := 18+6;

  --Don't move on unless the Legal Entity has a FEL ID
  if (ABAC_FEL_ID is null) then
    rollback;
    return;
  end if;

  -- Logon into ABAC: activate security
  Insert into V_ABAC_BATCHINT_LOGIN@ABAC_SHARED  Values ('X');

  --Calcualte FDI date
   select add_months((select last_day(trunc(sysdate))+ 1 from dual), fdi_delay_months) - 1 into fdi_date from dual;

  --STEP 1 - Creation of the Commitment header
  /* to be provided by Wifi4EY : TITLE (in upperCase !!!) and  WKFLW_FDI_DT */
  Insert into V_LOC_COMMITMENT_HEADER@ABAC_SHARED
    (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, COMMIT_CLASS_CD,
    CURRENCY_CD, DELETED_FLG, TITLE, CURRENT_TREE_CD, BUDGET_MGT_TP_CD, LEGAL_JUST_CD, PAYMENT_CLASS_CD, JUST_THP_MANDATORY, JUST_MULTIPLE_THP,
    COM_PF_GUA_TP_ID, RESP_ORG_STRUCT_KEY_CD, RESP_ORG_STRUCT_TP_CD, FIN_REGUL_GRP_CD, COM_PF_GUA_TP_FIN_REGUL_CD, IMPL_BY_TP_CD, EXP_CAT_TP_CD, WKFLW_FDI_DT)
  Values
    (l_run_id, 10, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE', 'COMMITMENT HEADER', l_loc_obj_foreign_id, 'N', 'RG',
    'EUR', 'N', header_title, 'B2018', 'DM', 'BF', 'SIN', 'VS', 'NA',
    '14', '\\EU\CE\INEA', 'EGY', 'FR2018', 'FR', 'EA', 'OPS', to_char(fdi_date, 'DD-MON-YYYY'));

  -- Create as many positions as needed
  FOR budgetaryCommitment in (
      SELECT BC.ID as BC_ID, le.OFFICIAL_NAME, le.ABAC_FEL_ID, le.COUNTRY_CODE,
      BC_POSITION.GLOBAL_COMMITMENT_L1_POS_KEY, BC_POSITION.COMMITMENT_L2_POSITION, BC_POSITION.COMMITMENT_L2_AMOUNT
      FROM WIF_BC_LEVEL2_POSITION BC_POSITION
      join WIF_BUDGETARY_COMMITMENT BC on BC.ID = BC_POSITION.BUDGETARY_COMMITMENT_ID
      JOIN WIF_LEGAL_ENTITY LE on bc.LEGAL_ENTITY_ID = LE.ID
      WHERE LE.ID=LEGALENTITYID
      ORDER BY BC_POSITION.COMMITMENT_L2_POSITION
  ) LOOP

      l_BC_ID := budgetaryCommitment.BC_ID;

      --STEP 2 - The creation of the Commitment position
      /* to be provided by Wifi4EY : WKFLW_POST_CUR_AMT and PRECOM_POS_l_loc_obj_foreign_id (amount and ID of the Global commitment position */
      Insert into V_LOC_COMMITMENT_POSITION@ABAC_SHARED
        (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID,
        PROCESSED, COMMIT_APPROP_TP_CD, WKFLW_POST_CUR_AMT, CARRY_FRWRD_FLG, LOCKED_FLG, ON_ACCT_FLG, DELETED_FLG, COMMIT_POS_LINE_NO,
        COMMIT_HED_LOC_OBJ_FOREIGN_ID, PRECOM_POS_LOC_OBJ_FOREIGN_ID, EXPENS_TP_CD, DG_CD, POLICY_AREA_CD, PROGRAM_CD)
      Values
        (l_run_id, 20, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE', 'COMMITMENT POSITION',l_loc_obj_foreign_id,
        'N', 'P', budgetaryCommitment.COMMITMENT_L2_AMOUNT, 'Y', 'N', 'N', 'N', budgetaryCommitment.COMMITMENT_L2_POSITION,
        l_loc_obj_foreign_id, budgetaryCommitment.GLOBAL_COMMITMENT_L1_POS_KEY, 'SUP', '84', 'CNECT', 'CEF');

      --STEP 2.1 - The creation of the Commitment position CRITERIA
      Insert into V_LOC_GEN_ORE_CRT@ABAC_SHARED
         (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD,
         TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, TRANS_POS_NR, CRIT_TP_CD, CRIT_CD)
       Values
         (l_run_id, 23, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE',
          'COMMITMENT CRITERIA', l_loc_obj_foreign_id, 'N', '1', 'B18IT', 'NO-IT');

      --STEP 2.2 - The creation of the Commitment position COUNTRY
      /* to be provided by Wifi4EY : CTY_ISO2_CD (country of the beneficiary) */
      Insert into V_LOC_GEN_ORE_CTY@ABAC_SHARED
        (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD,
        TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, CTY_ISO2_CD, PCT, TRANS_POS_NR)
      Values
        (l_run_id, 26, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE',
        'COMMITMENT COUNTRY', l_loc_obj_foreign_id, 'N',  UPPER(budgetaryCommitment.COUNTRY_CODE), '100', '1');

  END LOOP;

    --STEP 4 - Finishing the creation (Responsible user)
    Insert into V_LOC_GEN_ORE_RSP_USERS@ABAC_SHARED
      (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, PERSON_ID)
    Values
      (l_run_id, 40, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE', 'COMMITMENT RESP USER', l_loc_obj_foreign_id, 'N', 'VANDEJN');

    --STEP 4.1 - Finishing the creation (Contractor Ref)
    /* to be provided by Wifi4EY : CONTR_REF_LOC_OBJ_FOREIGN_ID and SUP_LOC_OBJ_FOREIGN_ID : Legal Entity ID of the municipality : 600... */
    Insert into V_LOC_COM_CONTRACTOR_REF@ABAC_SHARED
      (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID,
       PROCESSED, CONTRACTOR_REF_TYPE_CD, STATUS_CD, CONTR_REF_LOC_OBJ_FOREIGN_ID, SUP_LOC_OBJ_FOREIGN_ID)
    Values
      (l_run_id, 50, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE', 'COMMITMENT CONTRACTOR REF', l_loc_obj_foreign_id,
      'N', 'SECONDARY', 'ACTIVE', CONTR_REF_LOC_OBJ_FOREIGN_ID, ABAC_FEL_ID);

    --STEP 5 - Attach a document to the LE

  Insert into V_LOC_GEN_DOCS_REFERENCES@ABAC_SHARED
     (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, DOC_REFERENCE, DOC_DESCRIPTION)
  Values
     (l_run_id, 60, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE', 'DOCUMENT REFERENCE', l_loc_obj_foreign_id, 'N', supporting_doc_ares_ref, 'IDENTIFICATION FORM');

  --STEP 6 - Add a VISA to the LE
  /* to be provided by Wifi4EY : SIGNATURE, AGENT_ID and SUPPLIED_AGENT_NAME : these can be hard-coded, but should - I think - be a person from INEA that takes responsibility for WIFI4UP */
  Insert into V_LOC_VISA@ABAC_SHARED
   (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
   ACTION_CD, SIGNATURE, COMMENT_TXT, AGENT_ID, WRKFLW_CENTER_CD, WRKFLW_ORG_NAME, SIGN_AS_AGENT_TYPE, SUPPLIED_AGENT_NAME)
  Values
    (l_run_id, 80, l_loc_sys_cd, l_destination, 'COM', 'COM', 'CREATE', 'VISA', l_loc_obj_foreign_id, 'N',
    'AC', user_imported_name, 'VISA GIVEN BY WIFI4EU', user_imported_name, 'WIFI4EU', 'INEA', 'FA', user_imported_name);

  --STEP 7 - Call the stored procedure to process the data
  pck_abac_batchint_client.p_submit_batch@ABAC_SHARED(l_run_id, l_loc_sys_cd, 'BATCH_QUE1', l_que_id);

  -- INSERT in STATUS Table
  Insert into WIF_ABAC_REQUEST_PROCESS (ID,BC_ID,L_LOC_OBJ_FK,L_QUE_ID, REQUEST_TYPE) values (SEQ_WIF_ABAC_STATUS.NEXTVAL,l_BC_ID,l_loc_obj_foreign_id,l_que_id, request_type);

  --UPDATE the BUDGETARY_COMMITMENT status
  update WIF_BUDGETARY_COMMITMENT set WF_STATUS='WAITING_FOR_ABAC' where ID=l_BC_ID;

  commit;

END CREATE_BC_IN_ABAC;

/
--------------------------------------------------------
--  DDL for Procedure CREATE_LC_IN_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."CREATE_LC_IN_ABAC" (LEGAL_COMMITMENT_ID IN NUMBER) AS
  PRAGMA AUTONOMOUS_TRANSACTION;

  l_run_id				          NUMBER;
	l_loc_sys_cd			        VARCHAR2(3);
	l_loc_obj_foreign_id	    VARCHAR2(56);
  l_que_id 				          NUMBER;
  l_destination             VARCHAR2(200);
  request_type              varchar2(50);
  duration_in_months        NUMBER;
  payment_time_limit        NUMBER;

BEGIN

  --global constants
  request_type := 'LEGAL_COMMITMENT';
  duration_in_months := 18;
  payment_time_limit := 60;
  SELECT VALUE INTO l_loc_sys_cd from WIF_CONSTANTS WHERE NAME='ABAC_SYS_CD';
  SELECT VALUE INTO l_destination from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_DEST';
  l_run_id := SEQ_ABAC_RUN_ID.NEXTVAL;
  l_loc_obj_foreign_id:= l_loc_sys_cd || '.' || to_char(l_run_id);

  -- Logon into ABAC: activate security
  Insert into V_ABAC_BATCHINT_LOGIN@ABAC_SHARED  Values ('X');

  FOR legalCommitment in (
    select le.abac_fel_id as le_fel_id, lc.id as lc_id, bc.COMMITMENT_L2_KEY, bc_l2.COMMITMENT_L2_AMOUNT, lc.GRANT_AGREEMENT_CNTRSIGN_DATE, le.OFFICIAL_NAME,
    le.user_imported as user_imported_login, (upper(u.last_name) || ' ' || u.first_name) as user_imported_name
    from wif_legal_commitment lc
    join wif_legal_entity le on le.id = lc.legal_entity_id
    join WIF_AUTH_USERS u on le.user_imported = u.USERNAME
    join wif_budgetary_commitment bc on lc.LEGAL_ENTITY_ID = bc.legal_entity_id
    join wif_bc_level2_position bc_l2 on bc_l2.budgetary_commitment_id = bc.id
    where lc.WF_STATUS = 'COUNTERSIGNED'
  ) loop

      -- STEP 1 - Creation of the Commitment header
      Insert into V_LOC_LCM_HEADER@ABAC_SHARED
       (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD,
        TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
        LCH_TP_CD, SUBJECT_TXT,
        FTS_RESTRICTION_CD, RESP_ORG_STRUCT_KEY_CD,
        RESP_ORG_STRUCT_TP_CD, FIRST_PRE_FIN_REQ_DUE_CSD_FLG,
        FIN_REGUL_GRP_CD, LCH_TP_FIN_REGUL_CD, CONTRACT_SIGN_DT,
        LATE_INTRST_INDICATOR_CD, LI_FIN_REGUL_CD, LCV_CHNG_RQST_TP_CD,
        CONTRACT_CUR_AMT, CONTRACT_CURRENCY_ISO3_CD,
        LCM_AMT_DIST_MODE_CD, LOCAL_IDENTIFIER, LC_CAT_CD,
        USER_REFERENCE, IN_FORCE_FROM_DT, CONTRACT_AMT_FOLLOWS_BC_FLG, TASK_START_DT,
        TASK_DURATION_UNIT_VALUE, TASK_DURATION_UNIT_CD,
        IS_SPECIFIC_FPA_GRANT_FLG, FIN_FORM_GRP_CD)
     Values
       (l_run_id, 10, l_loc_sys_cd, l_destination, 'LCM',
        'LCH', 'CREATE', 'LEGAL COMMITMENT HEADER', l_loc_obj_foreign_id, 'N',
        'GRT', 'BRUSSELS WIFI 4EU - NULL - SIMULATION',
        'NR', '\\EU\CE\INEA',
        'EGY', 'Y',
        'FR2018', 'FR2018', to_char(legalCommitment.GRANT_AGREEMENT_CNTRSIGN_DATE, 'DD-MON-YYYY'),
        'EX_MEMBER', 'FR', 'BSC',
        legalCommitment.COMMITMENT_L2_AMOUNT, 'EUR',
        'AMT', 'BRUSSELS WIFI 4EU ' || legalCommitment.OFFICIAL_NAME || ' ' || l_run_id, 'ACTGRANT',
        upper('BRUSSELS WIFI 4EU -' || legalCommitment.OFFICIAL_NAME || ' ' || l_run_id), to_char(legalCommitment.GRANT_AGREEMENT_CNTRSIGN_DATE, 'DD-MON-YYYY'), 'N', to_char(legalCommitment.GRANT_AGREEMENT_CNTRSIGN_DATE, 'DD-MON-YYYY'),
        duration_in_months, 'MONTH',
        'Y', 'GO');

      -- STEP 2 - Registration of the contract
      Insert into V_LOC_LCM_CONTRACT_MGMT@ABAC_SHARED
       (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, LE_LOC_OBJ_FOREIGN_ID, CM_ROLE_TP_CD, CM_DISTRIBUTION_AMT)
      Values
       (l_run_id, 20, l_loc_sys_cd, l_destination, 'LCM', 'LCH', 'CREATE', 'LEGAL COMMITMENT CONTRACT MGMT', l_loc_obj_foreign_id, 'N', legalCommitment.LE_FEL_ID, 'BC', legalCommitment.COMMITMENT_L2_AMOUNT);

      -- STEP 3 - Registration of responsible person
      Insert into V_LOC_GEN_ORE_RSP_USERS@ABAC_SHARED
        (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, PERSON_ID)
      Values
        (l_run_id, 40, l_loc_sys_cd, l_destination, 'LCM', 'LCH', 'CREATE', 'LEGAL COMMITMENT RESP USER', l_loc_obj_foreign_id, 'N', 'BILLEWO');


      -- STEP 4 - Registration of the related Budget Commitment
      Insert into V_LOC_LCM_HEADER_COM_LINK@ABAC_SHARED
         (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, COM_HED_LOC_OBJ_FOREIGN_ID)
      Values
         (l_run_id, 110, l_loc_sys_cd, l_destination, 'LCM', 'LCH', 'CREATE', 'LEGAL COMMITMENT HEADER LINK', l_loc_obj_foreign_id, 'N', legalCommitment.COMMITMENT_L2_KEY);

      -- STEP 5 - Registration of the VISA
      Insert into V_LOC_VISA@ABAC_SHARED
       (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID,
       PROCESSED, ACTION_CD, SIGNATURE, COMMENT_TXT, AGENT_ID, WRKFLW_CENTER_CD, WRKFLW_ORG_NAME, SIGN_AS_AGENT_TYPE, SUPPLIED_AGENT_NAME)
      Values
       (l_run_id, 120, l_loc_sys_cd, l_destination, 'LCM', 'LCH', 'CREATE', 'VISA', l_loc_obj_foreign_id,
       'N', 'AC', legalCommitment.user_imported_name, 'VISA GIVEN BY WIFI4EU', legalCommitment.user_imported_login, 'LEGAL_COMMITMENT', 'INEA', 'FA', legalCommitment.user_imported_login);

     -- STEP 7 - Set the payment time limit
     insert into V_LOC_LCM_PAY_DELAY_CLASS@ABAC_SHARED
     (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS,
     LOC_OBJ_FOREIGN_ID, PAYMENT_TYPE_CD, MAX_PAY_DELAY_CLASS, PDL_FIN_REGUL_CD)
     values
     (l_run_id, 130, l_loc_sys_cd, l_destination, 'LCM', 'LCH', 'CREATE', 'LEGAL COMMITMENT PTL',
     l_loc_obj_foreign_id, 'FNP', payment_time_limit, 'FR2018');

      -- STEP 8 - Call the stored procedure to process the data
      pck_abac_batchint_client.p_submit_batch@ABAC_SHARED(l_run_id, l_loc_sys_cd, 'BATCH_QUE1', l_que_id);

      -- INSERT in STATUS Table
      Insert into WIF_ABAC_REQUEST_PROCESS (ID,LC_ID,L_LOC_OBJ_FK,L_QUE_ID, REQUEST_TYPE) values (SEQ_WIF_ABAC_STATUS.NEXTVAL, legalCommitment.lc_id, l_loc_obj_foreign_id,l_que_id, request_type);

      --UPDATE the LEGAL_COMMITMENT status
      update WIF_LEGAL_COMMITMENT set WF_STATUS='WAITING_FOR_ABAC' where ID=legalCommitment.lc_id;
  end loop;
  commit;
END CREATE_LC_IN_ABAC;

/
--------------------------------------------------------
--  DDL for Procedure CREATE_LEF_IN_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."CREATE_LEF_IN_ABAC"
(LEGALENTITYID IN NUMBER ) AS
  PRAGMA AUTONOMOUS_TRANSACTION;

  l_run_id				          NUMBER;
	l_loc_sys_cd			        VARCHAR2(3);
	l_loc_obj_foreign_id	    VARCHAR2(56);
	l_que_id 				          NUMBER;
  l_destination             VARCHAR2(200);
  l_trans_area_cd           VARCHAR2(200);
  l_trans_tp_cd             VARCHAR2(200);
  l_trans_action_cd         VARCHAR2(200);
  l_table_alias             VARCHAR2(200);
  l_debtor_cat_id           VARCHAR2(200);
  l_legal_type_cd           VARCHAR2(200);
  l_resp_org_struct_key_cd  VARCHAR2(200);
  l_resp_org_struct_tp_cd   VARCHAR2(200);
  l_doc_table_alias         VARCHAR2(200);
  l_doc_scan_table_alias    VARCHAR2(200);
  l_visa_table_alias        VARCHAR2(200);
  l_visa_action_cd          VARCHAR2(200);
  --l_visa_signature          VARCHAR2(200);
  l_visa_comment            VARCHAR2(200);
  --l_visa_agent_id           VARCHAR2(200);
  l_visa_wlkflw_center_cd   VARCHAR2(200);
  l_visa_wlkflw_orgname     VARCHAR2(200);
  l_visa_agent_type         VARCHAR2(200);
  --l_visa_agent_name         VARCHAR2(200);
  l_LE_ID                   NUMBER := LEGALENTITYID;
  l_language_cd             VARCHAR2(1);
  request_type              VARCHAR2(20);
  supporting_doc            WIF_DOCUMENTS%ROWTYPE;
  default_doc_type          VARCHAR2(20) := 'pdf';

BEGIN
 --init constants
 request_type := 'LEGAL_ENTITY';
 l_run_id := SEQ_ABAC_RUN_ID.NEXTVAL;
 SELECT VALUE INTO l_loc_sys_cd from WIF_CONSTANTS WHERE NAME='ABAC_SYS_CD';
 SELECT VALUE INTO l_destination from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_DEST';
 SELECT VALUE INTO l_trans_area_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_TRANS_AREA_CD';
 SELECT VALUE INTO l_trans_tp_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_TRANS_TP_CD';
 SELECT VALUE INTO l_trans_action_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_TRANS_ACTION_CD';
 SELECT VALUE INTO l_table_alias from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_TABLE_ALIAS';
 SELECT VALUE INTO l_debtor_cat_id from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_DEBTOR_CAT_ID';
 SELECT VALUE INTO l_legal_type_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_LEGAL_TYPE_CD';
 SELECT VALUE INTO l_resp_org_struct_key_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_RESP_ORG_STRUCT_KEY_CD';
 SELECT VALUE INTO l_resp_org_struct_tp_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_RESP_ORG_STRUCT_TP_CD';

 SELECT VALUE INTO l_doc_table_alias from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_DOC_TABLE_ALIAS';
 SELECT VALUE INTO l_doc_scan_table_alias from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_DOC_SCAN_TABLE_ALIAS';

 SELECT VALUE INTO l_visa_table_alias from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_TABLE_ALIAS';
 SELECT VALUE INTO l_visa_action_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_ACTION_CD';
 --SELECT VALUE INTO l_visa_signature from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_SIGNATURE';
 SELECT VALUE INTO l_visa_comment from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_DEFAULT_COMMENT';
 --SELECT VALUE INTO l_visa_agent_id from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_AGENT_ID';
 SELECT VALUE INTO l_visa_wlkflw_center_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_WRKFLW_CENTER_CD';
 SELECT VALUE INTO l_visa_wlkflw_orgname from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_WRKFLW_ORG_NAME';
 SELECT VALUE INTO l_visa_agent_type from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_SIGN_AS_AGENT_TYPE';
 --SELECT VALUE INTO l_visa_agent_name from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_SUPPLIED_AGENT_NAME';

 l_loc_obj_foreign_id:= l_loc_sys_cd || '.' || to_char(l_run_id);


  FOR legalEntity in (
      SELECT le.*, (upper(u.last_name) || ' ' || u.first_name) as user_import_name
      FROM WIF_LEGAL_ENTITY le join WIF_AUTH_USERS u on le.user_imported = u.username WHERE le.ID=l_LE_ID
  ) LOOP

    begin
      SELECT * INTO supporting_doc FROM WIF_DOCUMENTS WHERE LEGAL_ENTITY_ID=legalEntity.ID AND DOCUMENT_TYPE='IDENTIFICATION_FORM' AND ROWNUM=1 ORDER BY DATE_CREATED desc;
    exception when NO_DATA_FOUND then
      NULL;
    end;

    select LANGUAGE_CD into l_language_cd from V_O_GEN_LANGUAGES@ABAC_SHARED
    where (UPPER(legalEntity.LANGUAGE_CODE) = UPPER(LANGUAGE_SIC_CD)
       or UPPER(legalEntity.LANGUAGE_CODE) = UPPER(LNG_ISO3_CD))
    and valid_flg ='Y';

    -- Logon into ABAC: activate security
    Insert into V_ABAC_BATCHINT_LOGIN@ABAC_SHARED  Values ('X');


    Insert into V_LOC_THP_LEGAL_ENTITIES@ABAC_SHARED
     (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD,
      TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
      CTY_ISO2_CD, LANGUAGE_CD, NAME, VEND_CUST_SWITCH_CD, STREET,
      CITY, POST_BOX, POST_CD, COUNTY, VAT,
      REMARKS, BIRTH_CITY, BIRTH_CTY_ISO2_CD, BIRTH_DT, CUST_ONLY_FLG,
      DEBTOR_CAT_ID, FIRST_NAME, IDENTIFICATION_NUM, LEGAL_FORM_ID, LEGAL_TYPE_CD,
      MATRICULE_NUM, REG_AUTH, REG_DT, REG_NUM, STREET_2,
      STREET_3, SUPP_ACRONYM, SUP_OFFICIAL_NAME_2, SUP_OFFICIAL_NAME_3, SUP_OFFICIAL_NAME_4,
      ID_DOC_TYPE_ID, TITLE_ID, MAIL_ADR_OPT, PER_ID, RESP_ORG_STRUCT_ID,
      LEGAL_FORM_FPO_TP_ID, ORIG_LOC_OBJ_FOREIGN_ID, IS_NGO_FLG, RESP_ORG_STRUCT_KEY_CD, RESP_ORG_STRUCT_TP_CD,
      NAT_ID_NUM, NAT_ID_CTY_ISO2_CD, PASSP_NUM, PASSP_CTY_ISO2_CD, DRIVL_NUM,
      DRIVL_CTY_ISO2_CD, OTH_DOC_NUM, OTH_DOC_CTY_ISO2_CD, ID_CARD_NUM, ID_CARD_CTY_ISO2_CD,
      REGISTR_CTY_ISO2_CD, BUSS_NAME, CMPY_NUM, LIGHT_VALIDATION_FLG, DUPLICATE_BYPASS_FLG,
      CONTEXT_CD, SELF_EMPLOYED_FLG)
   Values
     (l_run_id, 10, l_loc_sys_cd, l_destination, l_trans_area_cd,
      l_trans_tp_cd, l_trans_action_cd, l_table_alias, l_loc_obj_foreign_id, 'N',
      UPPER(legalEntity.COUNTRY_CODE), l_language_cd, UPPER(legalEntity.ABAC_LATIN_NAME), 'SUP', UPPER(legalEntity.ABAC_LATIN_ADDRESS),
      UPPER(legalEntity.ABAC_LATIN_NAME), NULL, legalEntity.POSTAL_CODE, NULL, NULL,
      NULL, NULL, NULL, NULL, NULL,
      l_debtor_cat_id, NULL, NULL, NULL, l_legal_type_cd,
      NULL, NULL, NULL, NULL, NULL,
      NULL, NULL, NULL, NULL, NULL,
      NULL, NULL, NULL, NULL, NULL,
      NULL, NULL, NULL, l_resp_org_struct_key_cd, l_resp_org_struct_tp_cd,
      NULL, NULL, NULL, NULL, NULL,
      NULL, NULL, NULL, NULL, NULL,
      NULL, NULL, NULL, NULL, NULL,
      NULL, NULL);

      --if we have an ARES reference then use the ares ref, otherwhise load the binary
      IF(supporting_doc.ARES_REFERENCE IS NOT NULL) THEN
          -- insert document rerefences
          Insert into V_LOC_GEN_DOCS_REFERENCES@ABAC_SHARED
           (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD,
            TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
            DOC_REFERENCE, DOC_DESCRIPTION, OFFICIAL_DOC_FLG)
         Values
           (l_run_id, 20, l_loc_sys_cd, l_destination, l_trans_area_cd,
            l_trans_tp_cd, l_trans_action_cd, l_doc_table_alias, l_loc_obj_foreign_id, 'N',
            supporting_doc.ARES_REFERENCE, 'NO COMMENTS', 'Y');
      END IF;

      -- insert VISA details
      Insert into V_LOC_VISA@ABAC_SHARED
       (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD,
        TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
        ACTION_CD, SIGNATURE, COMMENT_TXT, PERSON_ID, LOT_LOC_OBJ_FOREIGN_ID,
        LOC_SYS_VISA_DT, AGENT_ID, WRKFLW_CENTER_CD, WRKFLW_ORG_NAME, SIGN_AS_AGENT_TYPE,
        SUPPLIED_AGENT_NAME, SW_ORG_NAME)
     Values
       (l_run_id, 80, l_loc_sys_cd, l_destination, l_trans_area_cd,
        l_trans_tp_cd, l_trans_action_cd, l_visa_table_alias, l_loc_obj_foreign_id, 'N',
        l_visa_action_cd, legalEntity.user_import_name, l_visa_comment, NULL, NULL,
        NULL, legalEntity.user_imported, l_visa_wlkflw_center_cd, l_visa_wlkflw_orgname, l_visa_agent_type,
        legalEntity.user_imported, NULL);

      -- submit batch transmission in ABAC :
      pck_abac_batchint_client.p_submit_batch@ABAC_SHARED(l_run_id, l_loc_sys_cd, 'BATCH_QUE1', l_que_id);

      -- INSERT in STATUS Table
      Insert into WIF_ABAC_REQUEST_PROCESS (ID,LE_ID,L_LOC_OBJ_FK,L_QUE_ID, REQUEST_TYPE) values (SEQ_WIF_ABAC_STATUS.NEXTVAL,l_LE_ID,l_loc_obj_foreign_id,l_que_id, request_type);

      --UPDATE the LEGAL_ENTITY status
      update WIF_LEGAL_ENTITY set WF_STATUS='WAITING_FOR_ABAC' where ID=l_LE_ID;
 END LOOP;
 -- commit operations
 commit;
END CREATE_LEF_IN_ABAC;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_BC_STATUS_FROM_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."UPDATE_BC_STATUS_FROM_ABAC" AS
  PRAGMA AUTONOMOUS_TRANSACTION;
  ABAC_VALID varchar2(30);
  WAITING_APPROVAL varchar2(30);
  LC_IMPORTED varchar2(30);
  LC_READY_TO_BE_COUNTERSIGNED varchar2(30);
  rows_affected number;
BEGIN
  --init constants
  ABAC_VALID := 'ABAC_VALID';
  WAITING_APPROVAL := 'WAITING_APPROVAL';
  LC_IMPORTED := 'IMPORTED';
  LC_READY_TO_BE_COUNTERSIGNED := 'READY_TO_BE_COUNTERSIGNED';

  rows_affected := 0;
  for request in (
                  select bc.legal_entity_id as le_id, bc.id as bc_id, l_loc_obj_fk, bc.WF_STATUS as bc_status, status_vw.status as abac_status, status_vw.ERROR_MSG
                  from wif_budgetary_commitment bc
                  left join wif_abac_bc_status_view status_vw on bc.id = status_vw.bc_id and bc.WF_STATUS <> ABAC_VALID
                  where status_vw.submit_date = (select max(all_requests.submit_date)
                                                from wif_abac_request_process all_requests
                                                where all_requests.bc_id = bc.id
                                                and all_requests.request_type = status_vw.request_type)
                  order by bc_id, l_loc_obj_fk)
  loop

      if (request.bc_status <> request.abac_status) then

        --Update the status
        update wif_budgetary_commitment set WF_STATUS = request.abac_status
        where wif_budgetary_commitment.id = request.bc_id;

        --Update the ABAC Commitment Level 2 Key of the Budgetary Commitment
        if request.abac_status in (WAITING_APPROVAL, ABAC_VALID) then
          update wif_budgetary_commitment set commitment_l2_key = request.l_loc_obj_fk
          where wif_budgetary_commitment.id = request.bc_id;
        end if;

        --Take the commitment key of every position
        for position in (
                        select wif_pos.id, abac_pos.precom_pos_loc_obj_foreign_id
                        from wif_bc_level2_position wif_pos
                        join V_LOC_COMMITMENT_POSITION@ABAC_SHARED abac_pos on wif_pos.commitment_l2_position = abac_pos.commit_pos_line_no and abac_pos.loc_obj_foreign_id = request.l_loc_obj_fk
                        where wif_pos.budgetary_commitment_id = request.bc_id)
        loop

          --TODO Find out where to get the Level 2 position key from
          --update wif_bc_level2_position set commitment_l2_key = position.precom_pos_loc_obj_foreign_id where id = position.id;
          null;

        end loop;

        --Make a copy of the error message, if it's the case
        update WIF_ABAC_REQUEST_PROCESS set ERROR_MSG=request.ERROR_MSG where l_loc_obj_fk=request.l_loc_obj_fk;

        --If there's already a legal commitment, update it's status
        if (request.abac_status = ABAC_VALID) then
          update wif_legal_commitment lc set wf_status = LC_READY_TO_BE_COUNTERSIGNED
          where lc.legal_entity_id = request.le_id and lc.wf_status = LC_IMPORTED;
        end if;

      end if;

      rows_affected := rows_affected + 1;
  END LOOP;
  commit;
END UPDATE_BC_STATUS_FROM_ABAC;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_LC_STATUS_FROM_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."UPDATE_LC_STATUS_FROM_ABAC" AS
  PRAGMA AUTONOMOUS_TRANSACTION;
  ABAC_VALID varchar2(30);
  rows_affected number;
BEGIN
  --init constants
  ABAC_VALID := 'ABAC_VALID';

  rows_affected := 0;
  for request in (
                  select lc.id as lc_id, l_loc_obj_fk, lc.WF_STATUS as lc_status, status_vw.status as abac_status, status_vw.ERROR_MSG
                  from wif_legal_commitment lc
                  left join wif_abac_lc_status_view status_vw on status_vw.lc_id = lc.id and lc.WF_STATUS <> 'ABAC_VALID'
                  where status_vw.submit_date = (select max(all_requests.submit_date)
                                                from wif_abac_request_process all_requests
                                                where all_requests.lc_id = lc.id
                                                and all_requests.request_type = status_vw.request_type)
                  order by lc_id, l_loc_obj_fk)
  loop

      if (request.lc_status <> request.abac_status) then

        --Update the status of the legal Commitment
        update wif_legal_commitment set WF_STATUS = request.abac_status
        where wif_legal_commitment.id = request.lc_id;

        --Update the ABAC Legal Commitment Key
        if request.abac_status = ABAC_VALID then
          update wif_legal_commitment set abac_key = request.l_loc_obj_fk
          where wif_legal_commitment.id = request.lc_id;
        end if;

        update WIF_ABAC_REQUEST_PROCESS set ERROR_MSG=request.ERROR_MSG where l_loc_obj_fk=request.l_loc_obj_fk;

      end if;

      rows_affected := rows_affected + 1;
  END LOOP;
  commit;
END UPDATE_LC_STATUS_FROM_ABAC;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_LEF_STATUS_FROM_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."UPDATE_LEF_STATUS_FROM_ABAC" AS
  PRAGMA AUTONOMOUS_TRANSACTION;
  req_type varchar2(20);
  rows_affected number;
BEGIN
  --init constants
  req_type := 'LEGAL_ENTITY';

  rows_affected := 0;
  for request in (
                  select le_id, l_loc_obj_fk, le.WF_STATUS as legal_entity_status, status_vw.status as abac_status, status_vw.LE_KEY, status_vw.ERROR_MSG, status_vw.REJECTION_MSG
                  from wif_abac_request_process req
                  inner join wif_legal_entity le on req.le_id = le.id
                  left join wif_abac_lef_status_view status_vw on req.l_loc_obj_fk = loc_obj_foreign_id
                  where req.request_type = req_type
                  and req.submit_date = (select max(all_requests.submit_date)
                                                      from wif_abac_request_process all_requests
                                                      where all_requests.le_id = le.id
                                                      and all_requests.request_type = req_type)
                  order by le_id, l_loc_obj_fk)
  loop
      dbms_output.put_line('LEGAL_ENTITY_ID='||request.le_id);

      if (request.legal_entity_status <> request.abac_status) then
        update wif_legal_entity set WF_STATUS = request.abac_status, abac_fel_id = request.LE_KEY
        where wif_legal_entity.id = request.le_id;

        update WIF_ABAC_REQUEST_PROCESS set ERROR_MSG=request.ERROR_MSG, REJECTION_MSG=request.REJECTION_MSG where l_loc_obj_fk=request.l_loc_obj_fk;

      end if;

      rows_affected := rows_affected + 1;
  END LOOP;
  commit;
END UPDATE_LEF_STATUS_FROM_ABAC;

/
--------------------------------------------------------
--  DDL for Package ABAC_FN
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "WIFI4EU_ABAC"."ABAC_FN" as function FN_UPDATE_LEF_STATUS_FROM_ABAC return number is
BEGIN
  --init constants
  var WAITING_FOR_ABAC := 'WAITING_FOR_ABAC';
  var WAITING_APPROVAL := 'WAITING_APPROVAL';

  var counter := 0;

  for request in (
                  select le_id, l_loc_obj_fk, le.WF_STATUS as legal_entity_status, status_vw.status as abac_status, status_vw.LE_KEY
                  from wif_abac_request_process request
                  inner join wif_legal_entity le on request.le_id = le.id and le.wf_status in (WAITING_FOR_ABAC, WAITING_APPROVAL)
                  left join wif_abac_lef_status_view status_vw on request.l_loc_obj_fk = loc_obj_foreign_id
                  order by le_id, l_loc_obj_fk)
  loop
      dbms_output.put_line('LEGAL_ENTITY_ID='||request.le_id);

      update wif_legal_entity set WF_STATUS = request.abac_status, abac_fel_id = request.LE_KEY
      where wif_legal_entity.id = request.le_id;

      counter := counter+1;
  END LOOP;

  return counter;
END UPDATE_LEF_STATUS_FROM_ABAC;

/
--------------------------------------------------------
--  Constraints for Table WIF_ABAC_REQUEST_PROCESS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("SUBMIT_DATE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_BATCH_STATUS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("L_LOC_OBJ_FK" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("REQUEST_TYPE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_REQUEST_TYPE_CK" CHECK (REQUEST_TYPE in ('LEGAL_ENTITY', 'BUDGETARY_COMMITMENT', 'LEGAL_COMMITMENT')) ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_DOCUMENT_TYPE
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENT_TYPE" ADD CONSTRAINT "WIF_DOCUMENT_TYPE_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENT_TYPE" MODIFY ("DOCT_TYPE_NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENT_TYPE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_COUNTRY
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_COUNTRY" MODIFY ("ISO3_CODE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_COUNTRY" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_COUNTRY" ADD CONSTRAINT "WIF_COUNTRY_PK" PRIMARY KEY ("ISO2_CODE")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_COUNTRY" MODIFY ("ISO2_CODE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_LEGAL_ENTITY
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ADD CONSTRAINT "WIF_LEGAL_ENTITY_MID_UNQ" UNIQUE ("OFFICIAL_NAME")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ADD CONSTRAINT "WIF_MUNICIPALITY_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("WF_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("POSTAL_CODE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("OFFICIAL_ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("COUNTRY_CODE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("OFFICIAL_NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("MID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_AUTH_USERS_ROLES
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS_ROLES" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS_ROLES" MODIFY ("ROLE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_DOCTYPE_METADATA_TYPE
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE" ADD CONSTRAINT "WIF_DOCTYPE_METADATA_TYPE_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE" MODIFY ("METADATA_KEY" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE" MODIFY ("CCM2_METADATA_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE" MODIFY ("CCM2_DOCTYPE_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCTYPE_METADATA_TYPE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_LEGAL_COMMITMENT
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ADD CONSTRAINT "WIF_LC_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("WF_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("LEGAL_ENTITY_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_BUDGETARY_COMMITMENT
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("LEGAL_ENTITY_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" ADD CONSTRAINT "WIF_BUDGETARY_COMMITMENT_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("WF_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_NOTIFICATION
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_NOTIFICATION" ADD CONSTRAINT "WIF_NOTIFICATION_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_NOTIFICATION" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_NOTIFICATION" MODIFY ("SEND_TO" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_NOTIFICATION" MODIFY ("NOTIFICATION_TYPE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_NOTIFICATION" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_AUTH_USERS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" ADD CONSTRAINT "WIF_AUTH_USERS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" MODIFY ("TOKEN_EXPIRED" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" MODIFY ("ENABLED" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" MODIFY ("FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_USERS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_IMPORT_LOG
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_IMPORT_LOG" MODIFY ("BATCH_REF" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_IMPORT_LOG" ADD CONSTRAINT "WIF_IMPORT_LOG_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_IMPORT_LOG" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_IMPORT_LOG" MODIFY ("IMPORT_DATE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_IMPORT_LOG" MODIFY ("FILENAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_IMPORT_LOG" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_CONSTANTS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" ADD CONSTRAINT "WIF_CONSTANTS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" MODIFY ("VALUE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_AUTH_ROLES
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_ROLES" ADD CONSTRAINT "WIF_AUTH_TOLES_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_ROLES" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_AUTH_ROLES" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_BC_LEVEL2_POSITION
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" MODIFY ("GLOBAL_COMMITMENT_L1_POS_KEY" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" ADD CONSTRAINT "WIF_BC_LEVEL2_POSITION_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" MODIFY ("BUDGETARY_COMMITMENT_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" MODIFY ("COMMITMENT_L2_AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" MODIFY ("COMMITMENT_L2_POSITION" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_DOCUMENTS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" ADD CONSTRAINT "WIF_DOCUMENTS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("WF_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("MIMETYPE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table WIF_ABAC_REQUEST_PROCESS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_BATCH_BC_ID_FK" FOREIGN KEY ("BC_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" ("ID") ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_BATCH_LC_ID_FK" FOREIGN KEY ("LC_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ("ID") ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_BATCH_LE_ID_FK" FOREIGN KEY ("LE_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WIF_BC_LEVEL2_POSITION
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_BC_LEVEL2_POSITION" ADD CONSTRAINT "WIF_BC_POSITION_BC_FK" FOREIGN KEY ("BUDGETARY_COMMITMENT_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WIF_BUDGETARY_COMMITMENT
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" ADD CONSTRAINT "WIF_BC_LE_FK" FOREIGN KEY ("LEGAL_ENTITY_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WIF_DOCUMENTS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" ADD CONSTRAINT "WIF_DOC_LE_FK" FOREIGN KEY ("LEGAL_ENTITY_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WIF_LEGAL_COMMITMENT
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ADD CONSTRAINT "WIF_LC_LE_FK" FOREIGN KEY ("LEGAL_ENTITY_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("ID") ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ADD CONSTRAINT "WIF_LEGAL_COMMITMENT_GA_DOC_FK" FOREIGN KEY ("GRANT_AGREEMENT_DOC_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_DOCUMENTS" ("ID") ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ADD CONSTRAINT "WIF_LEGAL_COMMIT_CSGA_DOC_FK" FOREIGN KEY ("COUNTERSIGNED_GRANT_AGR_DOC_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_DOCUMENTS" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WIF_LEGAL_ENTITY
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ADD CONSTRAINT "WIF_LEGAL_ENTITY_COUNTRY_FK" FOREIGN KEY ("COUNTRY_CODE")
	  REFERENCES "WIFI4EU_ABAC"."WIF_COUNTRY" ("ISO2_CODE") ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ADD CONSTRAINT "WIF_LE_DOC_FK" FOREIGN KEY ("ID_SIGNATURE_FILE")
	  REFERENCES "WIFI4EU_ABAC"."WIF_DOCUMENTS" ("ID") ENABLE;
