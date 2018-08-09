--------------------------------------------------------
--  DDL for View WIF_ABAC_BC_STATUS_VIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "WIFI4EU_ABAC"."WIF_ABAC_BC_STATUS_VIEW" ("LOC_OBJ_FOREIGN_ID", "TITLE", "STATUS", "ERROR_MSG") AS
  select
bc.LOC_OBJ_FOREIGN_ID,
bc.title,
bc.PROCESSED as status,
listagg(err.msg_txt, chr(10)) within group (order by error_log_id) as ERROR_MSG
FROM V_LOC_COMMITMENT_HEADER@ABACBUDT_SHARED bc
LEFT JOIN V_O_LOG_ERRORS@ABACBUDT_SHARED err ON err.batch_id = bc.run_id and err.loc_sys_cd = bc.loc_sys_cd and err.msg_tp_cd <> 'I'
where bc.LOC_OBJ_FOREIGN_ID like 'WIF%'
group by bc.LOC_OBJ_FOREIGN_ID, bc.title, bc.PROCESSED;
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

  when lelinks.PROCESSED is not null and lelinks.OBJ_STATUS_CD = 'VALID'
  then 'ABAC_VALID'

   when lelinks.PROCESSED is not null and lelinks.OBJ_STATUS_CD = 'REJECTED'
  then 'ABAC_REJECTED'

  when le.PROCESSED = 'N'
  then 'WAITING_FOR_ABAC'

  when le.PROCESSED in ('OK','OK_W') and lekey.head_loc_obj_foreign_id is null
  then 'WAITING_APPROVAL'

  when le.PROCESSED = 'OK' and lekey.head_loc_obj_foreign_id is not null
  then 'ABAC_FINISH'

  when le.PROCESSED = 'NOK'
  then 'ABAC_ERROR'
  else 'UNMAPPED_STATUS'
end  as status,
lekey.head_loc_obj_foreign_id as LE_KEY,
err.msg_txt as ERROR_MSG,
err.error_log_id,
lelinks.REJECTION_REASON as REJECTION_MSG
FROM V_LOC_THP_LEGAL_ENTITIES@ABACBUDT_SHARED le
LEFT JOIN V_O_LOG_ERRORS@ABACBUDT_SHARED err ON err.batch_id = le.run_id and err.loc_sys_cd = le.loc_sys_cd and err.msg_tp_cd <> 'I'
LEFT JOIN V_O_THP_COMMON_LOCAL_LINKS@ABACBUDT_SHARED lekey ON lekey.loc_obj_foreign_id = le.loc_obj_foreign_id
LEFT JOIN V_LOC_THP_COMMON_LOCAL_LINKS@ABACBUDT_SHARED lelinks ON lelinks.loc_obj_foreign_id = le.loc_obj_foreign_id
where le.LOC_OBJ_FOREIGN_ID like 'WIF%')
group by LOC_OBJ_FOREIGN_ID, status, le_key;
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
	"REQUEST_TYPE" VARCHAR2(25 BYTE)
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."LE_ID" IS ' Municipality ID in AIRGAP';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."L_LOC_OBJ_FK" IS 'This is created by the application and is a unique identifier for the LE. The format should be "WIF.XXXXXX" where XXXXXX is the id in the application.';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."ERROR_MSG" IS 'The error message from ABAC';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."REJECTION_MSG" IS 'The rejection reason from ABAC';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS"."REQUEST_TYPE" IS 'Type of request sent to abac. E.g.: LEGAL_ENTITY';
--------------------------------------------------------
--  DDL for Table WIF_BUDGETARY_COMMITMENT
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT"
   (	"ID" NUMBER,
	"GLOBAL_COMMITMENT_L1_POS_KEY" VARCHAR2(100 BYTE),
	"COMMITMENT_L2_POSITION" NUMBER,
	"COMMITMENT_L2_AMOUNT" NUMBER,
	"WF_STATUS" VARCHAR2(20 BYTE),
	"LEGAL_ENTITY_ID" NUMBER,
	"DATE_CREATED" DATE,
	"DATE_UPDATED" DATE
   ) ;
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
   (	"CD" VARCHAR2(2 CHAR),
	"NAME" VARCHAR2(50 CHAR),
	"EU_MEMBER" VARCHAR2(1 CHAR) DEFAULT 'N',
	"ACTIVE" VARCHAR2(1 CHAR) DEFAULT 'Y',
	"CCM2_CODE" NUMBER,
	"NATIVE_DESCRIPTIONS" VARCHAR2(50 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table WIF_DOCUMENTS
--------------------------------------------------------

  CREATE TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS"
   (	"ID" NUMBER(18,0),
	"NAME" VARCHAR2(50 BYTE),
	"ARES_REFERENCE" VARCHAR2(50 BYTE),
	"ARES_DATE" DATE,
	"FILE_SIZE" NUMBER(18,0),
	"MIMETYPE" VARCHAR2(50 BYTE),
	"DATE_CREATED" DATE DEFAULT NULL,
	"DATE_UPDATED" DATE,
	"WF_STATUS" VARCHAR2(20 BYTE) DEFAULT 'READY_FOR_ABAC',
	"PORTAL_ID" NUMBER,
	"LEGAL_ENTITY_ID" NUMBER,
	"DOCUMENT_TYPE" VARCHAR2(50 BYTE),
	"FILE_NAME" VARCHAR2(255 BYTE),
	"PORTAL_DATE" DATE,
	"DATA" BLOB
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."ID" IS 'Incremental ID';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."ARES_REFERENCE" IS 'ARES document reference';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."ARES_DATE" IS 'ARES document date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."DATE_CREATED" IS 'Creation date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."DATE_UPDATED" IS 'Modification date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_DOCUMENTS"."WF_STATUS" IS 'Workflow status';
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
	"ID_LE" NUMBER(18,0),
	"ABAC_ID" NUMBER(18,0),
	"WF_STATUS" VARCHAR2(20 BYTE) DEFAULT 'READY_FOR_ABAC',
	"USER_IMPORTED" VARCHAR2(20 BYTE),
	"DATE_CREATED" VARCHAR2(20 BYTE) DEFAULT TO_CHAR(sysdate, 'MM/DD/YYYY HH:MM:SS'),
	"DATE_UPDATED" VARCHAR2(20 BYTE),
	"COUNTERSIGNATURE_DATE" VARCHAR2(20 BYTE),
	"ID_COUNTERSIGNATURE_FILE" NUMBER(18,0),
	"USER_COUNTERSIGNATURED" VARCHAR2(20 BYTE),
	"DATE_COUNTERSIGNATURED" VARCHAR2(20 BYTE)
   ) ;

   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."ID" IS 'Incremental ID';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."ID_LE" IS 'ID of the related LegalEntity';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."WF_STATUS" IS 'Workflow status';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."USER_IMPORTED" IS 'Username of the last user who exported it';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."DATE_CREATED" IS 'Creation date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."DATE_UPDATED" IS 'Modification date, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."COUNTERSIGNATURE_DATE" IS 'Date when the countersignature was applied, format MM/DD/YYYY HH:MM:SS';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."ID_COUNTERSIGNATURE_FILE" IS 'ID of the related file with the countersignature';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."USER_COUNTERSIGNATURED" IS 'Username who launched the countersignature';
   COMMENT ON COLUMN "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT"."DATE_COUNTERSIGNATURED" IS 'Date when was launched the countersignature, format MM/DD/YYYY HH:MM:SS';
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
	"ID_SIGNATURE_FILE" NUMBER(18,0)
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
--------------------------------------------------------
--  DDL for Sequence SEQ_ABAC_RUN_ID
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_ABAC_RUN_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1660 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_BANK_ACCOUNT
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_BANK_ACCOUNT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_BUDGETARY_COMMITMENT
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_BUDGETARY_COMMITMENT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_DOCUMENT
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_DOCUMENT"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_LEGAL_ENTITY
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_LEGAL_ENTITY"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 140 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SEQ_WIF_ABAC_STATUS
--------------------------------------------------------

   CREATE SEQUENCE  "WIFI4EU_ABAC"."SEQ_WIF_ABAC_STATUS"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 141 CACHE 20 NOORDER  NOCYCLE ;
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
--  DDL for Index UK_LANGUAGE_NAME
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."UK_LANGUAGE_NAME" ON "WIFI4EU_ABAC"."WIF_LANGUAGE" ("NAME")
  ;
--------------------------------------------------------
--  DDL for Index WIF_CONSTANTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."WIF_CONSTANTS_PK" ON "WIFI4EU_ABAC"."WIF_CONSTANTS" ("ID")
  ;
--------------------------------------------------------
--  DDL for Index PK_COUNTRY
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."PK_COUNTRY" ON "WIFI4EU_ABAC"."WIF_COUNTRY" ("CD")
  ;
--------------------------------------------------------
--  DDL for Index PK_LANGUAGE
--------------------------------------------------------

  CREATE UNIQUE INDEX "WIFI4EU_ABAC"."PK_LANGUAGE" ON "WIFI4EU_ABAC"."WIF_LANGUAGE" ("CD")
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
--  DDL for Procedure CREATE_BC_IN_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."CREATE_BC_IN_ABAC" (LEGALENTITYID IN NUMBER ) AS
  PRAGMA AUTONOMOUS_TRANSACTION;

  l_LE_ID NUMBER := LEGALENTITYID;
  l_run_id				          NUMBER;
	l_loc_sys_cd			        VARCHAR2(3);
	l_loc_obj_foreign_id	    VARCHAR2(56);
  l_que_id 				          NUMBER;
  ABAC_FEL_ID               number;
  header_title              varchar2(200);
  global_commitment_position varchar2(50);
  CONTR_REF_LOC_OBJ_FOREIGN_ID varchar2(100);
  request_type              varchar2(20);
BEGIN

  --global constants
  request_type := 'BUDGETARY_COMMITMENT';
  SELECT VALUE INTO l_loc_sys_cd from WIF_CONSTANTS WHERE NAME='ABAC_SYS_CD';
  l_run_id := SEQ_ABAC_RUN_ID.NEXTVAL;
  l_loc_obj_foreign_id:= l_loc_sys_cd || '.' || to_char(l_run_id);

  select
    le.ABAC_FEL_ID,
    'WIFI4EU ' || upper(le.OFFICIAL_NAME),
     l_loc_obj_foreign_id || '.SECONDARY.' || le.ABAC_FEL_ID
    into ABAC_FEL_ID, header_title, CONTR_REF_LOC_OBJ_FOREIGN_ID
  from WIF_LEGAL_ENTITY le where id = LEGALENTITYID;

  -- Logon into ABAC: activate security
  Insert into V_ABAC_BATCHINT_LOGIN@ABACBUDT_SHARED  Values ('X');

  --STEP 1 - Creation of the Commitment header
  /* to be provided by Wifi4EY : TITLE (in upperCase !!!) and  WKFLW_FDI_DT */
  Insert into V_LOC_COMMITMENT_HEADER@ABACBUDT_SHARED
    (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, COMMIT_CLASS_CD,
    CURRENCY_CD, DELETED_FLG, TITLE, CURRENT_TREE_CD, BUDGET_MGT_TP_CD, LEGAL_JUST_CD, PAYMENT_CLASS_CD, JUST_THP_MANDATORY, JUST_MULTIPLE_THP,
    COM_PF_GUA_TP_ID, RESP_ORG_STRUCT_KEY_CD, RESP_ORG_STRUCT_TP_CD, FIN_REGUL_GRP_CD, COM_PF_GUA_TP_FIN_REGUL_CD, IMPL_BY_TP_CD, EXP_CAT_TP_CD, WKFLW_FDI_DT)
  Values
    (l_run_id, 10, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE', 'COMMITMENT HEADER', l_loc_obj_foreign_id, 'N', 'RG',
    'EUR', 'N', header_title, 'B2018', 'DM', 'BF', 'SIN', 'VS', 'NA',
    '14', '\\EU\CE\INEA', 'EGY', 'FR2018', 'FR', 'EA', 'OPS', '23-FEB-2020');

  -- Create as many positions as needed
  FOR bugetaryCommitment in (
      SELECT le.OFFICIAL_NAME, le.ABAC_FEL_ID, le.COUNTRY_CODE,
      BC.GLOBAL_COMMITMENT_L1_POS_KEY, BC.COMMITMENT_L2_POSITION, BC.COMMITMENT_L2_AMOUNT
      FROM WIF_BUDGETARY_COMMITMENT BC
      JOIN WIF_LEGAL_ENTITY LE on bc.LEGAL_ENTITY_ID = LE.ID
      WHERE LE.ID=l_LE_ID
      ORDER BY COMMITMENT_L2_POSITION
  ) LOOP

      --STEP 2 - The creation of the Commitment position
      /* to be provided by Wifi4EY : WKFLW_POST_CUR_AMT and PRECOM_POS_l_loc_obj_foreign_id (amount and ID of the Global commitment position */
      Insert into V_LOC_COMMITMENT_POSITION@ABACBUDT_SHARED
        (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID,
        PROCESSED, COMMIT_APPROP_TP_CD, WKFLW_POST_CUR_AMT, CARRY_FRWRD_FLG, LOCKED_FLG, ON_ACCT_FLG, DELETED_FLG, COMMIT_POS_LINE_NO,
        COMMIT_HED_LOC_OBJ_FOREIGN_ID, PRECOM_POS_LOC_OBJ_FOREIGN_ID, EXPENS_TP_CD, DG_CD, POLICY_AREA_CD, PROGRAM_CD)
      Values
        (l_run_id, 20, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE', 'COMMITMENT POSITION',l_loc_obj_foreign_id,
        'N', 'P', bugetaryCommitment.COMMITMENT_L2_AMOUNT, 'Y', 'N', 'N', 'N', bugetaryCommitment.COMMITMENT_L2_POSITION,
        l_loc_obj_foreign_id, bugetaryCommitment.GLOBAL_COMMITMENT_L1_POS_KEY, 'SUP', '84', 'CNECT', 'CEF');

      --STEP 2.1 - The creation of the Commitment position CRITERIA
      Insert into V_LOC_GEN_ORE_CRT@ABACBUDT_SHARED
         (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD,
         TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, TRANS_POS_NR, CRIT_TP_CD, CRIT_CD)
       Values
         (l_run_id, 23, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE',
          'COMMITMENT CRITERIA', l_loc_obj_foreign_id, 'N', '1', 'B18IT', 'NO-IT');

      --STEP 2.2 - The creation of the Commitment position COUNTRY
      /* to be provided by Wifi4EY : CTY_ISO2_CD (country of the beneficiary) */
      Insert into V_LOC_GEN_ORE_CTY@ABACBUDT_SHARED
        (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD,
        TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, CTY_ISO2_CD, PCT, TRANS_POS_NR)
      Values
        (l_run_id, 26, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE',
        'COMMITMENT COUNTRY', l_loc_obj_foreign_id, 'N',  UPPER(bugetaryCommitment.COUNTRY_CODE), '100', '1');

  END LOOP;

    --STEP 4 - Finishing the creation (Responsible user)
    Insert into V_LOC_GEN_ORE_RSP_USERS@ABACBUDT_SHARED
      (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, PERSON_ID)
    Values
      (l_run_id, 40, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE', 'COMMITMENT RESP USER', l_loc_obj_foreign_id, 'N', 'VANDEJN');

    --STEP 4.1 - Finishing the creation (Contractor Ref)
    /* to be provided by Wifi4EY : CONTR_REF_LOC_OBJ_FOREIGN_ID and SUP_LOC_OBJ_FOREIGN_ID : Legal Entity ID of the municipality : 600... */
    Insert into V_LOC_COM_CONTRACTOR_REF@ABACBUDT_SHARED
      (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID,
       PROCESSED, CONTRACTOR_REF_TYPE_CD, STATUS_CD, CONTR_REF_LOC_OBJ_FOREIGN_ID, SUP_LOC_OBJ_FOREIGN_ID)
    Values
      (l_run_id, 50, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE', 'COMMITMENT CONTRACTOR REF', l_loc_obj_foreign_id,
      'N', 'SECONDARY', 'ACTIVE', CONTR_REF_LOC_OBJ_FOREIGN_ID, ABAC_FEL_ID);

    --STEP 5 - Attach a document to the LE
  Insert into V_LOC_GEN_DOCS_REFERENCES@ABACBUDT_SHARED
     (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED, DOC_REFERENCE, DOC_DESCRIPTION)
  Values
     (l_run_id, 60, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE', 'DOCUMENT REFERENCE', l_loc_obj_foreign_id, 'N', 'ARES(2018)456789', 'bla bla');

  --STEP 6 - Add a VISA to the LE
  /* to be provided by Wifi4EY : SIGNATURE, AGENT_ID and SUPPLIED_AGENT_NAME : these can be hard-coded, but should - I think - be a person from INEA that takes responsibility for WIFI4UP */
  Insert into V_LOC_VISA@ABACBUDT_SHARED
   (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD, TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
   ACTION_CD, SIGNATURE, COMMENT_TXT, AGENT_ID, WRKFLW_CENTER_CD, WRKFLW_ORG_NAME, SIGN_AS_AGENT_TYPE, SUPPLIED_AGENT_NAME)
  Values
    (l_run_id, 80, l_loc_sys_cd, 'ABACBUDT', 'COM', 'COM', 'CREATE', 'VISA', l_loc_obj_foreign_id, 'N',
    'AC', 'VANDERHAEGEN Johan', 'VISA GIVEN BY WIFI4EU','vandejn', 'WIFI4EU', 'CNECT', 'FA', 'vandejn');

  --STEP 7 - Call the stored procedure to process the data
  pck_abac_batchint_client.p_submit_batch@ABACBUDT_SHARED(l_run_id, l_loc_sys_cd, 'BATCH_QUE1', l_que_id);

  -- INSERT in STATUS Table
  Insert into WIF_ABAC_REQUEST_PROCESS (ID,LE_ID,L_LOC_OBJ_FK,L_QUE_ID, REQUEST_TYPE) values (SEQ_WIF_ABAC_STATUS.NEXTVAL,l_LE_ID,l_loc_obj_foreign_id,l_que_id, request_type);

  --UPDATE the BUDGETARY_COMMITMENT status
  update WIF_BUDGETARY_COMMITMENT set WF_STATUS='WAITING_FOR_ABAC' where LEGAL_ENTITY_ID=l_LE_ID;

  commit;

END CREATE_BC_IN_ABAC;

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
  l_visa_signature          VARCHAR2(200);
  l_visa_comment            VARCHAR2(200);
  l_visa_agent_id           VARCHAR2(200);
  l_visa_wlkflw_center_cd   VARCHAR2(200);
  l_visa_wlkflw_orgname     VARCHAR2(200);
  l_visa_agent_type         VARCHAR2(200);
  l_visa_agent_name         VARCHAR2(200);
  l_LE_ID                   NUMBER := LEGALENTITYID;
  l_language_cd             VARCHAR2(1);
  request_type              VARCHAR2(20);
  supporting_doc            WIF_DOCUMENTS%ROWTYPE;
  default_doc_type          VARCHAR2(20) := 'PDF';

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
 SELECT VALUE INTO l_visa_signature from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_SIGNATURE';
 SELECT VALUE INTO l_visa_comment from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_DEFAULT_COMMENT';
 SELECT VALUE INTO l_visa_agent_id from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_AGENT_ID';
 SELECT VALUE INTO l_visa_wlkflw_center_cd from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_WRKFLW_CENTER_CD';
 SELECT VALUE INTO l_visa_wlkflw_orgname from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_WRKFLW_ORG_NAME';
 SELECT VALUE INTO l_visa_agent_type from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_SIGN_AS_AGENT_TYPE';
 SELECT VALUE INTO l_visa_agent_name from WIF_CONSTANTS WHERE NAME='LEF_V_LOC_VISA_SUPPLIED_AGENT_NAME';

 SELECT * INTO supporting_doc FROM WIF_DOCUMENTS WHERE LEGAL_ENTITY_ID=l_LE_ID AND DOCUMENT_TYPE='IDENTIFICATION_FORM' AND ROWNUM=1 ORDER BY DATE_CREATED desc;

 l_loc_obj_foreign_id:= l_loc_sys_cd || '.' || to_char(l_run_id);


 FOR legatEntity in (SELECT * FROM WIF_LEGAL_ENTITY WHERE ID=l_LE_ID) LOOP
    dbms_output.put_line('OFFICIAL_NAME='||legatEntity.OFFICIAL_NAME);

    select LANGUAGE_CD into l_language_cd from V_O_GEN_LANGUAGES@ABACBUDT_SHARED
    where (UPPER(legatEntity.LANGUAGE_CODE) = UPPER(LANGUAGE_SIC_CD)
       or UPPER(legatEntity.LANGUAGE_CODE) = UPPER(LNG_ISO3_CD))
    and valid_flg ='Y';

    -- Logon into ABAC: activate security
    Insert into V_ABAC_BATCHINT_LOGIN@ABACBUDT_SHARED  Values ('X');


    Insert into V_LOC_THP_LEGAL_ENTITIES@ABACBUDT_SHARED
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
      UPPER(legatEntity.COUNTRY_CODE), l_language_cd, UPPER(legatEntity.OFFICIAL_NAME), 'SUP', UPPER(legatEntity.OFFICIAL_ADDRESS),
      UPPER(legatEntity.OFFICIAL_NAME), NULL, legatEntity.POSTAL_CODE, NULL, NULL,
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
          Insert into V_LOC_GEN_DOCS_REFERENCES@ABACBUDT_SHARED
           (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD,
            TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
            DOC_REFERENCE, DOC_DESCRIPTION, OFFICIAL_DOC_FLG)
         Values
           (l_run_id, 20, l_loc_sys_cd, l_destination, l_trans_area_cd,
            l_trans_tp_cd, l_trans_action_cd, l_doc_table_alias, l_loc_obj_foreign_id, 'N',
            supporting_doc.ARES_REFERENCE, 'NO COMMENTS', 'Y');
      ELSE
          -- insert document in abac database
          Insert into V_LOC_GEN_SCAN_DOC@ABACBUDT_SHARED
             (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD,
              TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
              SCANNED_DOC_LINE_NR, SCANNED_DOC_LIST_TP_CD, SCANNED_DOC_DESC, SCANNED_DOC_FORMAT_TYPE, OFFICIAL_DOC_FLG, SCANNED_DOC_BLOB)
          ---Values
          select
             l_run_id, 50, l_loc_sys_cd, l_destination, l_trans_area_cd,
              l_trans_tp_cd, l_trans_action_cd, l_doc_scan_table_alias, l_loc_obj_foreign_id, 'N',
              '1', 'AUT', supporting_doc.NAME, default_doc_type, 'Y', (select supporting_doc.DATA from dual) from dual;
      END IF;

      -- insert VISA details
      Insert into V_LOC_VISA@ABACBUDT_SHARED
       (RUN_ID, ROW_ID, LOC_SYS_CD, DESTINATION, TRANS_AREA_CD,
        TRANS_TP_CD, TRANS_ACTION_CD, TABLE_ALIAS, LOC_OBJ_FOREIGN_ID, PROCESSED,
        ACTION_CD, SIGNATURE, COMMENT_TXT, PERSON_ID, LOT_LOC_OBJ_FOREIGN_ID,
        LOC_SYS_VISA_DT, AGENT_ID, WRKFLW_CENTER_CD, WRKFLW_ORG_NAME, SIGN_AS_AGENT_TYPE,
        SUPPLIED_AGENT_NAME, SW_ORG_NAME)
     Values
       (l_run_id, 80, l_loc_sys_cd, l_destination, l_trans_area_cd,
        l_trans_tp_cd, l_trans_action_cd, l_visa_table_alias, l_loc_obj_foreign_id, 'N',
        l_visa_action_cd, l_visa_signature, l_visa_comment, NULL, NULL,
        NULL, l_visa_agent_id, l_visa_wlkflw_center_cd, l_visa_wlkflw_orgname, l_visa_agent_type,
        l_visa_agent_name, NULL);

      -- submit batch transmission in ABAC :
      pck_abac_batchint_client.p_submit_batch@ABACBUDT_SHARED(l_run_id, l_loc_sys_cd, 'BATCH_QUE1', l_que_id);

      -- INSERT in STATUS Table
      Insert into WIF_ABAC_REQUEST_PROCESS (ID,LE_ID,L_LOC_OBJ_FK,L_QUE_ID, REQUEST_TYPE) values (SEQ_WIF_ABAC_STATUS.NEXTVAL,l_LE_ID,l_loc_obj_foreign_id,l_que_id, request_type);

      --UPDATE the LEGAL_ENTITY status
      update WIF_LEGAL_ENTITY set WF_STATUS='WAITING_FOR_ABAC' where ID=l_LE_ID;

      -- commit operations
      commit;
 END LOOP;
END CREATE_LEF_IN_ABAC;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_BC_STATUS_FROM_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."UPDATE_BC_STATUS_FROM_ABAC" AS
  PRAGMA AUTONOMOUS_TRANSACTION;
  WAITING_FOR_ABAC varchar2(30);
  WAITING_APPROVAL varchar2(30);
  request_type varchar2(20);
  rows_affected number;
BEGIN
  --init constants
  WAITING_FOR_ABAC := 'WAITING_FOR_ABAC';
  request_type := 'BUDGETARY_COMMITMENT';

  rows_affected := 0;
  for request in (
                  select le_id, l_loc_obj_fk, bc.WF_STATUS as bc_status, status_vw.status as abac_status, status_vw.ERROR_MSG
                  from wif_abac_request_process request
                  inner join wif_budgetary_commitment bc on request.le_id = bc.legal_entity_id and bc.wf_status in (WAITING_FOR_ABAC)
                  left join wif_abac_bc_status_view status_vw on request.l_loc_obj_fk = loc_obj_foreign_id
                  where request.request_type = request_type
                  order by le_id, l_loc_obj_fk)
  loop

      if (request.bc_status <> request.abac_status) then
        update wif_budgetary_commitment set WF_STATUS = request.abac_status
        where wif_budgetary_commitment.legal_entity_id = request.le_id;

        update WIF_ABAC_REQUEST_PROCESS set ERROR_MSG=request.ERROR_MSG where l_loc_obj_fk=request.l_loc_obj_fk;

      end if;

      rows_affected := rows_affected + 1;
  END LOOP;
  commit;
END UPDATE_BC_STATUS_FROM_ABAC;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_LEF_STATUS_FROM_ABAC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "WIFI4EU_ABAC"."UPDATE_LEF_STATUS_FROM_ABAC" AS
  PRAGMA AUTONOMOUS_TRANSACTION;
  WAITING_FOR_ABAC varchar2(30);
  WAITING_APPROVAL varchar2(30);
  rows_affected number;
BEGIN
  --init constants
  WAITING_FOR_ABAC := 'WAITING_FOR_ABAC';
  WAITING_APPROVAL := 'WAITING_APPROVAL';

  rows_affected := 0;
  for request in (
                  select le_id, l_loc_obj_fk, le.WF_STATUS as legal_entity_status, status_vw.status as abac_status, status_vw.LE_KEY, status_vw.ERROR_MSG, status_vw.REJECTION_MSG
                  from wif_abac_request_process request
                  inner join wif_legal_entity le on request.le_id = le.id and le.wf_status in (WAITING_FOR_ABAC, WAITING_APPROVAL)
                  left join wif_abac_lef_status_view status_vw on request.l_loc_obj_fk = loc_obj_foreign_id
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
--  Constraints for Table WIF_BUDGETARY_COMMITMENT
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("LEGAL_ENTITY_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" ADD CONSTRAINT "WIF_BUDGETARY_COMMITMENT_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("WF_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("COMMITMENT_L2_AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("COMMITMENT_L2_POSITION" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("GLOBAL_COMMITMENT_L1_POS_KEY" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_BUDGETARY_COMMITMENT" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_ABAC_REQUEST_PROCESS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("SUBMIT_DATE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_BATCH_STATUS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("L_LOC_OBJ_FK" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("REQUEST_TYPE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_REQUEST_TYPE_CK" CHECK (REQUEST_TYPE in ('LEGAL_ENTITY', 'BUDGETARY_COMMITMENT', 'LEGAL_COMMITMENT')) ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("LE_ID" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_CONSTANTS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" ADD CONSTRAINT "WIF_CONSTANTS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" MODIFY ("VALUE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_CONSTANTS" MODIFY ("ID" NOT NULL ENABLE);
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
--  Constraints for Table WIF_DOCUMENTS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" ADD CONSTRAINT "WIF_DOCUMENTS_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("WF_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("MIMETYPE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("FILE_SIZE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_DOCUMENTS" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table WIF_LEGAL_COMMITMENT
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ADD CONSTRAINT "WIF_LC_PK" PRIMARY KEY ("ID")
  USING INDEX  ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("DATE_CREATED" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("WF_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("ID_LE" NOT NULL ENABLE);
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table WIF_ABAC_REQUEST_PROCESS
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_ABAC_REQUEST_PROCESS" ADD CONSTRAINT "WIF_ABAC_BATCH_LE_ID_FK" FOREIGN KEY ("LE_ID")
	  REFERENCES "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("ID") ENABLE;
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

  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ADD CONSTRAINT "WIF_LC_DOC_FK" FOREIGN KEY ("ID_COUNTERSIGNATURE_FILE")
	  REFERENCES "WIFI4EU_ABAC"."WIF_DOCUMENTS" ("ID") ENABLE;
  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_COMMITMENT" ADD CONSTRAINT "WIF_LC_LE_FK" FOREIGN KEY ("ID_LE")
	  REFERENCES "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table WIF_LEGAL_ENTITY
--------------------------------------------------------

  ALTER TABLE "WIFI4EU_ABAC"."WIF_LEGAL_ENTITY" ADD CONSTRAINT "WIF_LE_DOC_FK" FOREIGN KEY ("ID_SIGNATURE_FILE")
	  REFERENCES "WIFI4EU_ABAC"."WIF_DOCUMENTS" ("ID") ENABLE;
