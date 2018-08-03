create or replace PROCEDURE                "CREATE_LEF_IN_ABAC"
(LEGALENTITYID IN NUMBER ) AS
  PRAGMA AUTONOMOUS_TRANSACTION;
  l_LE_ID NUMBER := LEGALENTITYID;
  l_run_id				          NUMBER;  
  l_loc_sys_cd			        VARCHAR2(3);
  l_loc_obj_foreign_id	    VARCHAR2(56);
  l_que_id 				          NUMBER;
  
BEGIN
  --init constants
  l_run_id := SEQ_LEF_RUN_ID.NEXTVAL;
  SELECT VALUE INTO l_loc_sys_cd from WIF_CONSTANTS WHERE NAME='ABAC_SYS_CD';
  l_loc_obj_foreign_id:= l_loc_sys_cd || '.' || to_char(l_run_id);

  FOR legatEntity in (SELECT * FROM WIF_LEGAL_ENTITY WHERE ID=l_LE_ID) LOOP
    dbms_output.put_line('OFFICIAL_NAME='||legatEntity.OFFICIAL_NAME);
      -- INSERT in STATUS Table
      Insert into WIF_ABAC_REQUEST_PROCESS (ID,LE_ID,L_RUN_ID,L_LOC_SYS_CD,L_LOC_OBJ_FK,L_QUE_ID) 
        values (SEQ_WIF_ABAC_STATUS.NEXTVAL,l_LE_ID,l_run_id,l_loc_sys_cd,l_loc_obj_foreign_id,l_que_id);

      --UPDATE the LEGAL_ENTITY status
      update WIF_LEGAL_ENTITY set WF_STATUS='WAITING_FOR_ABAC' where ID=l_LE_ID;

      -- commit operations
      commit;
 END LOOP;

END CREATE_LEF_IN_ABAC;

/

create or replace PROCEDURE  UPDATE_LEF_STATUS_FROM_ABAC AS
  PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
  --init constants
  commit;
END UPDATE_LEF_STATUS_FROM_ABAC;

/