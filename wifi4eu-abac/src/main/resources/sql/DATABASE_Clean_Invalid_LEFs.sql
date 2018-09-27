delete from wif_abac_request_process where lc_id in
(select id from wif_legal_commitment where wf_status <> 'ABAC_VALID');

delete from wif_legal_commitment where legal_entity_id in
(select id from wif_legal_entity where wf_status <> 'ABAC_VALID');

delete from wif_abac_request_process where bc_id in
(select bc.id from WIF_BUDGETARY_COMMITMENT bc where wf_status <> 'ABAC_VALID');

delete from wif_bc_level2_position where BUDGETARY_COMMITMENT_ID in
(select id from WIF_BUDGETARY_COMMITMENT where wf_status <> 'ABAC_VALID');

delete from WIF_BUDGETARY_COMMITMENT where wf_status <> 'ABAC_VALID' or LEGAL_ENTITY_ID in
(select id from wif_legal_entity where wf_status <> 'ABAC_VALID');

delete from wif_abac_request_process where le_id in
(select id from wif_legal_entity where wf_status <> 'ABAC_VALID');

delete from wif_documents where legal_entity_id in
(select id from wif_legal_entity le where wf_status <> 'ABAC_VALID');

delete from wif_legal_entity where wf_status <> 'ABAC_VALID';