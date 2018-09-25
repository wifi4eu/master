alter table [dbo].[applications] ADD date_signature datetime NULL;
alter table [dbo].[applications] ADD date_counter_signature datetime NULL;
alter table [dbo].[applications] ADD cancel_reason VARCHAR(255) NULL;
CREATE TABLE authorized_person_application (id INT IDENTITY NOT NULL, authorized_person INT, application_id INT, PRIMARY KEY (id)) ;
ALTER TABLE users ADD contact_phone_prefix NVARCHAR(255);
ALTER TABLE users ADD contact_phone_number NVARCHAR(255);
UPDATE users SET users.contact_phone_number = SUP.contact_phone_number FROM users US INNER JOIN suppliers SUP ON US.id = SUP._user;
UPDATE users SET users.contact_phone_prefix = SUP.contact_phone_prefix FROM users US INNER JOIN suppliers SUP ON US.id = SUP._user;
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

--ALTER TABLE log_emails ALTER COLUMN body NTEXT;
--ALTER TABLE log_emails ALTER COLUMN subject NTEXT;
CREATE TABLE dbo.log_emails(
	[id]               	INT           NOT NULL IDENTITY,
	[municipalityId]   	INT          NOT NULL,
	[sent_date]  		BIGINT       NOT NULL,
	[action]  			NVARCHAR(255)       NOT NULL,
	[fromAddress]   	NVARCHAR(255) NULL,
	[toAddress]   		NVARCHAR(255) NOT NULL,
	[subject]   		NTEXT NULL,
	[body]   			NTEXT NULL,
	PRIMARY KEY ([id]),
	CONSTRAINT [fk_registrations_municipalities]
  	FOREIGN KEY ([municipalityId])
  	REFERENCES dbo.municipalities ([id])
    	ON DELETE CASCADE
    	ON UPDATE CASCADE
);

CREATE TABLE [dbo].[supplier_users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[creation_date] [datetime2](7) NULL,
	[email] [varchar](255) NULL,
	[main] [int] NULL,
	[status] [int] NULL,
	[supplier_id] [int] NULL,
	[user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

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
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__4321E620];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__44160A59];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__450A2E92];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__45FE52CB];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__46F27704];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__47E69B3D];
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
ALTER TABLE applications ADD sent_email_date datetime DEFAULT null;

-- feature/WIFIFOREU-2914 Add column issues to voucher_simulations
ALTER TABLE voucher_simulations ADD issues INT;

-- addContacts beneficiary / supplier table
create table invitation_contacts(
   [id] INT NOT NULL IDENTITY,
   [type] INT NOT NULL,
   [id_registration] INT NULL,
   [id_supplier] INT NULL,
   [id_user_request] INT NOT NULL,
   [email_invited] VARCHAR(255),
   [status] INT NOT NULL,
   [create_date] datetime,
   [last_modified] datetime,
   PRIMARY KEY ([id]),
   CONSTRAINT [fk_invitationContacts_users]
   FOREIGN KEY ([id_user_request])
   REFERENCES dbo.users ([id])
       ON DELETE CASCADE
       ON UPDATE CASCADE
);

CREATE TABLE [dbo].[application_comment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[COMMENT] [nvarchar](256) NOT NULL,
	[date_posted] [numeric](19, 0) NULL,
	[application_id] [int] NULL,
	[user_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

ALTER TABLE [dbo].[application_comment]  WITH CHECK ADD  CONSTRAINT [pplctncommentpplctonid] FOREIGN KEY([application_id])
REFERENCES [dbo].[applications] ([id])

ALTER TABLE [dbo].[application_comment] CHECK CONSTRAINT [pplctncommentpplctonid]

ALTER TABLE [dbo].[application_comment]  WITH CHECK ADD  CONSTRAINT [pplicationcommentserid] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])

ALTER TABLE [dbo].[application_comment] CHECK CONSTRAINT [pplicationcommentserid]

ALTER TABLE application_comment ALTER COLUMN [comment] NVARCHAR(256) NOT NULL;

-- addContact - to follow the good way to create new contact emails, need to create two extra fields on users table
ALTER TABLE users ADD country nvarchar(256) NULL;
ALTER TABLE users ADD city nvarchar(256) NULL;

--WIFIFOREU-2939 because of time zones problems we are changing date field to long
 --New temporary columns
alter table legal_files ADD upload_time2 bigint NULL;
alter table legal_files_correction_reason ADD request_correction_date2 bigint NULL;

--updating dates to long
update legal_files set upload_time2 = DATEDIFF(second, '1970-01-01 00:00:00', upload_time)
update legal_files_correction_reason set request_correction_date2 = DATEDIFF(second, '1970-01-01 00:00:00', request_correction_date)

update legal_files set upload_time2 = upload_time2 * 1000
update legal_files_correction_reason set request_correction_date2 = request_correction_date2 * 1000

 --drop old columns with the wrong type
ALTER TABLE legal_files DROP COLUMN upload_time;
ALTER TABLE legal_files_correction_reason DROP COLUMN request_correction_date;

--renaming temp column to the old ones
 EXEC sp_RENAME 'legal_files.upload_time2' , 'upload_time', 'COLUMN'
 EXEC sp_RENAME 'legal_files_correction_reason.request_correction_date2' , 'request_correction_date', 'COLUMN'

create table admin_actions(
   [id]	INT	NOT NULL IDENTITY,
   [action] varchar(MAX) NOT NULL,
   [is_running] bit,
   [start_date] datetime,
   [end_date] datetime,
   [_user] int NOT NULL,
   PRIMARY KEY ([id]),
   CONSTRAINT [fk_user_action]
   FOREIGN KEY ([_user])
   REFERENCES dbo.users ([id])
       ON DELETE CASCADE
       ON UPDATE CASCADE
);

alter table voucher_assignments ADD notified_date bigint NULL;

-- NUTS modifications
delete from supplied_regions
where region in
(select id from nuts where label like 'EXTRA%')

delete from nuts where label like 'EXTRA%'

-- 2018-09-03 Convert the date of the applications from nanos to millis (10 digits)
UPDATE applications set date = LEFT(date, 13) where LEN(date) > 13 

-- 2018-09-13 Azure Blob storage for legal files, this new column stores the URI in Azure
alter table legal_files add azure_uri varchar(2048);

-- Add new column for laus
ALTER TABLE laus ADD name_national nvarchar(255) NULL;
ALTER TABLE laus ADD name_latin nvarchar(255) NULL;
ALTER TABLE laus ADD abac_name nvarchar(255) NULL;
ALTER TABLE laus ADD display_name nvarchar(255) NULL;

-- Place name1 and name2 to name_latin,name_national,abac_name,display_name for testing
UPDATE laus
    SET name_latin=l2.name2, name_national=l2.name1, abac_name=l2.name2, display_name=l2.name2
    FROM laus l2 WHERE id = l2.id


-- Add new columns on legal files
ALTER TABLE legal_files ADD status int;
ALTER TABLE legal_files ADD new int;

-- Update existing files with information on the new columns
UPDATE legal_files SET status = 0
UPDATE l SET l.status = 2 FROM legal_files l INNER JOIN applications a ON l.registration = a.registration WHERE a._status = 2;
UPDATE l SET l.status = 1 FROM legal_files l INNER JOIN applications a ON l.registration = a.registration WHERE a._status = 1;
UPDATE legal_files SET new = 0;
UPDATE r SET r.new = 1 FROM legal_files r inner join (select l1.* from legal_files l1 inner join (select registration, max(upload_time) as ut from legal_files l2 inner join (select type from legal_files group by type)l3 on l3.type = l2.type group by registration) l2 on l2.registration = l1.registration and l1.upload_time = l2.ut) l4 on l4.id = r.id  where r.status = 0
UPDATE r SET r.new = 2 FROM legal_files r inner join (select l1.* from legal_files l1 inner join (select registration, max(upload_time) as ut from legal_files l2 inner join (select type from legal_files group by type)l3 on l3.type = l2.type group by registration) l2 on l2.registration = l1.registration and l1.upload_time = l2.ut) l4 on l4.id = r.id where r.status != 0;



