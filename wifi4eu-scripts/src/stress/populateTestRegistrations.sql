-----------------------------------
-- populateTestRegistrations.sql
-----------------------------------
DELETE FROM representations
DELETE FROM municipalities
DELETE FROM supplied_regions
DELETE FROM supplier_users
DELETE FROM thread_messages
DELETE FROM user_threads
DELETE FROM application_comment
DELETE FROM voucher_simulations
DELETE FROM voucher_assignments
DELETE FROM registration_users
DELETE FROM rights
DELETE FROM conditions_agreement
DELETE FROM users
DELETE FROM legal_files
DELETE FROM registration_warnings
DELETE FROM registrations
DELETE FROM mayors
DELETE FROM application_invalidate_reason
DELETE FROM authorized_person_application
DELETE FROM applications
DELETE FROM temp_tokens
DELETE FROM suppliers
DELETE FROM helpdesk_issues
DELETE FROM timelines
DELETE FROM threads
DBCC CHECKIDENT ('municipalities', RESEED, 0);
DBCC CHECKIDENT ('users', RESEED, 0);
DBCC CHECKIDENT ('registrations', RESEED, 0);
DBCC CHECKIDENT ('mayors', RESEED, 0);
DBCC CHECKIDENT ('applications', RESEED, 0);
DBCC CHECKIDENT ('rights', RESEED, 0);
DBCC CHECKIDENT ('temp_tokens', RESEED, 0);
DBCC CHECKIDENT ('registration_users', RESEED, 0);
DBCC CHECKIDENT ('conditions_agreement', RESEED, 0);