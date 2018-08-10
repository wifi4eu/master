alter table [dbo].[applications] ADD date_signature datetime NULL;
alter table [dbo].[applications] ADD date_counter_signature datetime NULL;
alter table [dbo].[applications] ADD cancel_reason VARCHAR(255) NULL;
CREATE TABLE authorized_person_application (id INT IDENTITY NOT NULL, authorized_person INT, application_id INT, PRIMARY KEY (id)) ;
ALTER TABLE users ADD contact_phone_prefix NVARCHAR(255);
ALTER TABLE users ADD contact_phone_number NVARCHAR(255);
update users set users.contact_phone_number = (SELECT s.contact_phone_number from suppliers s inner join users u on s._user = u.id where users.id = u.id);
update users set users.contact_phone_prefix = (SELECT s.contact_phone_prefix from suppliers s inner join users u on s._user = u.id where users.id = u.id);
ALTER TABLE suppliers DROP COLUMN contact_phone_prefix;
ALTER TABLE suppliers DROP COLUMN contact_phone_number;
ALTER TABLE suppliers DROP COLUMN contact_name;
ALTER TABLE suppliers DROP COLUMN contact_surname;

UPDATE ru set creation_date  = dateadd(s, convert(bigint, u.create_date) / 1000, convert(datetime, '1-1-1970 00:00:00'))
FROM dbo.[registration_users] as ru
inner join users as u on ru._user = u.id;
create table grant_agreement(
   [id]    INT    NOT NULL IDENTITY,
   [application_id] INT NOT NULL,
   [signature_id] nvarchar(MAX),
   [counter_signature_id] nvarchar(MAX),
   [document_location_countersigned] nvarchar(MAX),
   [signature_proof] nvarchar(MAX),
   [document_location] nvarchar(MAX),
   [date_signature] datetime,
   [date_counter_signature] datetime,
   [document_language] nvarchar(2) DEFAULT ('en'),
   PRIMARY KEY ([id]),
   CONSTRAINT [fk_grant_agreement_application]
   FOREIGN KEY ([application_id])
   REFERENCES dbo.applications ([id])
       ON DELETE CASCADE
       ON UPDATE CASCADE
); 

ALTER TABLE log_emails ALTER COLUMN body NTEXT;
ALTER TABLE log_emails ALTER COLUMN subject NTEXT;

-- 27/07/2018 -  populate table supplier_users with supplier table values. ONLY on db where supplier_users is empty and you have supplier's table with information.
INSERT INTO [dbo].[supplier_users]
         ([creation_date]
          ,[email]
         ,[main]
         ,[status]
          ,[supplier_id]
         ,[user_id])
  SELECT dateadd(s, convert(bigint, u.create_date) / 1000, convert(datetime2, '1970-1-1 00:00:00.0000000')), u.ecas_email, 1, 1, s.id, u.id from [dbo].[suppliers] s inner join [dbo].[users] u on s._user = u.id where u.ecas_email is not null;

--WIFI4EU-2556 changes in legal files / registration / legal files correction reason
--FOREIGN KEYS
ALTER TABLE legal_files_correction_reason
    ADD id_legal_file BIGINT,
    FOREIGN KEY (id_legal_file) REFERENCES legal_files(id)
    ON DELETE CASCADE
   ON UPDATE CASCADE;

ALTER TABLE legal_files
    ADD id_user INTEGER,
    FOREIGN KEY (id_user) REFERENCES users(id)
    ON DELETE CASCADE
   ON UPDATE CASCADE;


--NEW CAMPS
ALTER TABLE legal_files
	ADD file_size BIGINT,
	file_mime nvarchar(256),
	file_name nvarchar(256);

--DATA REASSIGN
--add users to legal_file
update [dbo].[legal_files]
set id_user = r._user
from [dbo].registration_users r
inner join [dbo].[legal_files] l on l.registration = r.registration
inner join users u on u.id = r._user
where main = 1

--add legal file to correction
update [dbo].legal_files_correction_reason
set id_legal_file = l.id
from [dbo].legal_files l inner join
[dbo].legal_files_correction_reason c on c.registration = l.registration and c.type = l.type

--add legal files type 1 mime and size
update [dbo].[legal_files]
set file_size = r.legal_file1_size,
file_mime = r.legal_file1_mime
from [dbo].registrations r inner join
[dbo].[legal_files] l on l.registration = r.id where l.type = 1

--add legal files type 2 mime and size
update [dbo].[legal_files]
set file_size = r.legal_file1_size,
file_mime = r.legal_file1_mime
from [dbo].registrations r inner join
[dbo].[legal_files] l on l.registration = r.id where l.type = 2

--add legal files type 3 mime and size
update [dbo].[legal_files]
set file_size = r.legal_file1_size,
file_mime = r.legal_file1_mime
from [dbo].registrations r inner join
[dbo].[legal_files] l on l.registration = r.id where l.type = 3

--add legal files type 4 mime and size
update [dbo].[legal_files]
set file_size = r.legal_file1_size,
file_mime = r.legal_file1_mime
from [dbo].registrations r inner join
[dbo].[legal_files] l on l.registration = r.id where l.type = 4

--delete columns from registrations
ALTER TABLE dbo.registrations DROP COLUMN upload_time, legal_file1_size, legal_file1_mime,
legal_file2_size, legal_file2_mime, legal_file3_size, legal_file3_mime, legal_file4_size, legal_file4_mime, legal_file1, legal_file2, legal_file3, legal_file4;

-- DB INDEXES CREATION - feature/WIFIFOREU-2884
-- The following sql lines are used to create indexes to optimize the use of queries to the database
CREATE NONCLUSTERED INDEX IX_municipality_name ON municipalities (name)
CREATE NONCLUSTERED INDEX IX_users_ecasName_token ON users (ecas_username,csrf_token)
CREATE NONCLUSTERED INDEX IX_calls_dates ON calls (start_date,end_date)
CREATE NONCLUSTERED INDEX IX_registration_files_status ON registrations (allFiles_flag,_status)
CREATE NONCLUSTERED INDEX IX_registrationusers_date_main ON registration_users (creation_date,main)
CREATE NONCLUSTERED INDEX IX_rights_rightdesc ON rights (rightdesc)
CREATE NONCLUSTERED INDEX IX_applications_status ON applications (_status)

-- feature/WIFIFOREU-2568 log_emails registered when sending a message to all applicants of a call
ALTER TABLE applications ADD sent_email smallint DEFAULT 0;
UPDATE applications SET sent_email = 0 WHERE sent_email is null;

-- feature/WIFIFOREU-2914 Add column issues to voucher_simulations
ALTER TABLE voucher_simulations ADD issues INT;