/* *********************
 * Anonymize emails
 ********************* */
/*
update users
set email = 'INEA-W4EU-TEST@ec.europa.eu', ecas_email = 'INEA-W4EU-TEST@ec.europa.eu';

update helpdesk_issues
set from_email = 'INEA-W4EU-TEST@ec.europa.eu';

update mayors
set email = 'INEA-W4EU-TEST@ec.europa.eu';

update suppliers
set contact_email = 'INEA-W4EU-TEST@ec.europa.eu';

update registration_users
set contact_email = 'INEA-W4EU-TEST@ec.europa.eu';

update supplier_users
set email = 'INEA-W4EU-TEST@ec.europa.eu';

update temp_tokens
set email = 'INEA-W4EU-TEST@ec.europa.eu';
*/


//-- Legal files
ALTER TABLE legal_files_correction_reason ADD request_correction_date DATETIME NULL;
ALTER TABLE legal_files ADD upload_time DATETIME NULL;
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

ALTER TABLE legal_files
  ADD file_size BIGINT,
  file_mime nvarchar(256),
  file_name nvarchar(256);

update [dbo].[legal_files]
  set [upload_time] = (select dateadd(s, convert(bigint, r.upload_time) / 1000, convert(datetime, '1-1-1970 00:00:00')))
  from [dbo].[legal_files] inner join [dbo].[registrations] r on r.id = registration;

--WIFIFOREU-2939 because of time zones problems we are changing date field to long
--New temporary columns
ALTER TABLE legal_files ADD upload_time2 bigint NULL;
ALTER TABLE legal_files_correction_reason ADD request_correction_date2 bigint NULL;

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


//-- Applicant List Item
ALTER TABLE APPLICANTLISTITEM ADD SUPPORTINGDOCUMENTS BIT DEFAULT(0);


//-- Applications
ALTER TABLE applications ADD authorized_person INT NULL;
ALTER TABLE applications ADD date_signature datetime NULL;
ALTER TABLE applications ADD date_counter_signature datetime NULL;
ALTER TABLE applications ADD cancel_reason VARCHAR(255) NULL;
ALTER TABLE applications ADD pre_selected_flag BIT DEFAULT(0) NOT NULL;
ALTER TABLE applications ADD rejected BIT DEFAULT(0) NOT NULL;


//-- Registration users
CREATE TABLE [dbo].[registration_users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[contact_email] [varchar](255) NULL,
	[creation_date] [datetime2](7) NULL,
	[main] [int] NULL,
	[registration] [int] NULL,
	[status] [int] NULL,
	[_user] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]


INSERT INTO [dbo].[registration_users]
  ([contact_email], [main], [registration], [status], [_user])
  SELECT u.ecas_email, 1, r.id, 1, u.id 
    from registrations r inner join users u on r._user = u.id where u.ecas_email is not null;

UPDATE ru set creation_date = dateadd(s, convert(bigint, u.create_date) / 1000, convert(datetime, '1-1-1970 00:00:00'))
  FROM dbo.[registration_users] as ru
  inner join users as u on ru._user = u.id;

  
//-- Registrations
ALTER TABLE [registrations] ALTER COLUMN _user INT null;
ALTER TABLE [registrations] ADD [id_status_beneficiary] BIGINT;
ALTER TABLE [registrations] ADD [id_pm] BIGINT NULL;
ALTER TABLE [registrations] ADD [id_bpm] BIGINT NULL;
ALTER TABLE [registrations] ADD [compliance] INT NULL;
ALTER TABLE [registrations] ADD [first_false_check] DATETIME DEFAULT NULL;
ALTER TABLE [registrations] ADD [conformity] BIT NULL;
ALTER TABLE [registrations] ADD [action_taken] INT NULL;
ALTER TABLE [registrations] ADD [action_to_be_taken] INT NULL;
ALTER TABLE [registrations] ADD [date_registered] DATETIME NULL;
ALTER TABLE [registrations] ADD [is_submission] DATETIME NULL;
ALTER TABLE [registrations] ADD [is_rejection] DATETIME NULL;
ALTER TABLE [registrations] ADD [is_confirmation] DATETIME NULL;


//-- Authorized person application
CREATE TABLE authorized_person_application (id INT IDENTITY NOT NULL, authorized_person INT, application_id INT, PRIMARY KEY (id)) ;


//-- Users
ALTER TABLE users ADD contact_phone_prefix NVARCHAR(255);
ALTER TABLE users ADD contact_phone_number NVARCHAR(255);

UPDATE users SET users.contact_phone_number = SUP.contact_phone_number FROM users US INNER JOIN suppliers SUP ON US.id = SUP._user;
UPDATE users SET users.contact_phone_prefix = SUP.contact_phone_prefix FROM users US INNER JOIN suppliers SUP ON US.id = SUP._user;


//-- Suppliers
ALTER TABLE suppliers DROP COLUMN contact_phone_prefix;
ALTER TABLE suppliers DROP COLUMN contact_phone_number;
ALTER TABLE suppliers DROP COLUMN contact_name;
ALTER TABLE suppliers DROP COLUMN contact_surname;


//-- Grant Agreement
create table grant_agreement(
  [id] INT NOT NULL IDENTITY,
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


//-- LOG EMAILS
CREATE TABLE dbo.log_emails(
  [id] INT NOT NULL IDENTITY,
  [municipalityId] INT NOT NULL,
  [sent_date] BIGINT NOT NULL,
  [action] NVARCHAR(255) NOT NULL,
  [fromAddress] NVARCHAR(255) NULL,
  [toAddress] NVARCHAR(255) NOT NULL,
  [subject] NTEXT NULL,
  [body] NTEXT NULL,
  PRIMARY KEY ([id]),
  CONSTRAINT [fk_registrations_municipalities]
  FOREIGN KEY ([municipalityId])
  REFERENCES dbo.municipalities ([id])
  ON DELETE CASCADE
  ON UPDATE CASCADE
);


//-- Supplier users
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

INSERT INTO [dbo].[supplier_users]
  ([creation_date], [email], [main], [status], [supplier_id], [user_id])
  SELECT dateadd(s, convert(bigint, u.create_date) / 1000, convert(datetime2, '1970-1-1 00:00:00.0000000')), u.ecas_email, 1, 1, s.id, u.id 
    from [dbo].[suppliers] s inner join [dbo].[users] u on s._user = u.id where u.ecas_email is not null;

//-- Data reassign
update [dbo].[legal_files]
  set id_user = r._user
  from [dbo].registration_users r
  inner join [dbo].[legal_files] l on l.registration = r.registration
  inner join users u on u.id = r._user
  where main = 1;

update [dbo].legal_files_correction_reason
  set id_legal_file = l.id
  from [dbo].legal_files l inner join
  [dbo].legal_files_correction_reason c on c.registration = l.registration and c.type = l.type;

update [dbo].[legal_files]
  set file_size = r.legal_file1_size,
  file_mime = r.legal_file1_mime
  from [dbo].registrations r inner join
  [dbo].[legal_files] l on l.registration = r.id where l.type = 1;

update [dbo].[legal_files]
  set file_size = r.legal_file2_size,
  file_mime = r.legal_file2_mime
  from [dbo].registrations r inner join
  [dbo].[legal_files] l on l.registration = r.id where l.type = 2;

update [dbo].[legal_files]
  set file_size = r.legal_file3_size,
  file_mime = r.legal_file3_mime
  from [dbo].registrations r inner join
  [dbo].[legal_files] l on l.registration = r.id where l.type = 3;


update [dbo].[legal_files]
  set file_size = r.legal_file4_size,
  file_mime = r.legal_file4_mime
  from [dbo].registrations r inner join
  [dbo].[legal_files] l on l.registration = r.id where l.type = 4;

  
//-- PENDING TO BE DONE. CHECK SARA -->
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__4321E620];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__44160A59];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__450A2E92];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__45FE52CB];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__46F27704];
ALTER TABLE [dbo].[registrations] DROP CONSTRAINT [DF__registrat__legal__47E69B3D];
ALTER TABLE [dbo].[registrations] DROP COLUMN upload_time;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file1_size;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file1_mime;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file2_size;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file2_mime;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file3_size;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file3_mime;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file4_size;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file4_mime;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file1;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file2;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file3;
ALTER TABLE [dbo].[registrations] DROP COLUMN legal_file4;


//-- INDEXES
CREATE NONCLUSTERED INDEX IX_municipality_name ON municipalities (name)
CREATE NONCLUSTERED INDEX IX_users_ecasName_token ON users (ecas_username,csrf_token)
CREATE NONCLUSTERED INDEX IX_calls_dates ON calls (start_date,end_date)
CREATE NONCLUSTERED INDEX IX_registration_files_status ON registrations (allFiles_flag,_status)
CREATE NONCLUSTERED INDEX IX_registrationusers_date_main ON registration_users (creation_date,main)
CREATE NONCLUSTERED INDEX IX_rights_rightdesc ON rights (rightdesc)
CREATE NONCLUSTERED INDEX IX_applications_status ON applications (_status)

CREATE INDEX IX_fk_mayors_municipalities ON mayors(municipality);
CREATE INDEX IX_fk_temp_tokens_users ON temp_tokens(_user);
CREATE INDEX IX_fk_suppliers_users ON suppliers(_user);
CREATE INDEX IX_fk_registrations_users ON registrations(_user);
CREATE INDEX IX_fk_registrations_municipalities ON registrations(municipality);


-- feature/WIFIFOREU-2568 log_emails registered when sending a message to all applicants of a call
ALTER TABLE applications ADD sent_email smallint DEFAULT 0;
UPDATE applications SET sent_email = 0 WHERE sent_email is null;
ALTER TABLE applications ADD sent_email_date datetime DEFAULT null;


-- feature/WIFIFOREU-2914 Add column issues to voucher_simulations
ALTER TABLE voucher_simulations ADD issues INT;


//-- ADD Contacts
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


//-- Application Comments
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
  REFERENCES [dbo].[applications] ([id]);

ALTER TABLE [dbo].[application_comment] CHECK CONSTRAINT [pplctncommentpplctonid];

ALTER TABLE [dbo].[application_comment]  WITH CHECK ADD  CONSTRAINT [pplicationcommentserid] FOREIGN KEY([user_id])
  REFERENCES [dbo].[users] ([id]);

ALTER TABLE [dbo].[application_comment] CHECK CONSTRAINT [pplicationcommentserid];

ALTER TABLE application_comment ALTER COLUMN [comment] NVARCHAR(256) NOT NULL;


-- addContact - to follow the good way to create new contact emails, need to create two extra fields on users table
ALTER TABLE users ADD country nvarchar(256) NULL;
ALTER TABLE users ADD city nvarchar(256) NULL;


//-- Installation site
if exists (select * from sysobjects where name='installation_site' and xtype='U')
  DROP table installation_site;

if not exists (select * from sysobjects where name='installation_site' and xtype='U')
  CREATE TABLE installation_site (
    [id] bigint NOT NULL IDENTITY,
    [id_municipality] int NOT NULL,
    [number] int NOT NULL,
    [id_status] bigint NOT NULL,
    [id_network_snippet] varchar(75) NOT NULL,
    [name] varchar(75) NOT NULL,
    [date_registered] datetime NOT NULL,
    [domain_name] varchar(255) NOT NULL,
    [url] varchar(255) NOT NULL,
    [first_false_check] datetime NULL
  PRIMARY KEY CLUSTERED
  (
    [id] ASC
  )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
  ) ON [PRIMARY];

ALTER TABLE installation_site WITH CHECK ADD CONSTRAINT [fk_installationSite_municipality] FOREIGN KEY ([id_municipality])
  REFERENCES  municipalities ([id])
  ON DELETE CASCADE
  ON UPDATE CASCADE;

  
//-- Installation site whitelist
DROP table installation_site_whitelist;

if not exists (select * from sysobjects where name='installation_site_whitelist' and xtype='U')
  CREATE TABLE installation_site_whitelist (
    [id] bigint NOT NULL IDENTITY ,
    [origin] varchar(75) NOT NULL,
    [active] int NOT NULL
  PRIMARY KEY CLUSTERED
  (
    [id] ASC
  )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
  ) ON [PRIMARY];


//-- Access point
DROP table access_points;

CREATE TABLE access_points (
  [id] int NOT NULL IDENTITY ,
  [model_number] varchar(255) NOT NULL,
  [serial_number] varchar(255) NOT NULL,
  [id_installation_site] bigint NOT NULL,
  [isIndoor] BIT NOT NULL,
  [device_brand] varchar(255) NOT NULL,
  [location] varchar(75) NOT NULL,
  [location_type] varchar(75) NOT NULL,
  [latitude] decimal(8,6) NOT NULL,
  [longitude] decimal(8,6) NOT NULL,
  [mac_address] varchar(17) NOT NULL,
  [number] int NOT NULL
  PRIMARY KEY CLUSTERED
(
  [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY];

ALTER TABLE access_points WITH CHECK ADD CONSTRAINT [fk_accessPoints_installationSites] FOREIGN KEY ([id_installation_site])
REFERENCES installation_site ([id])
ON DELETE CASCADE
ON UPDATE CASCADE;

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


-- Creation of FKs - Part II
-- Table:   conditions_agreement
-- Column:  registration_id,user_id
ALTER TABLE [dbo].[conditions_agreement] WITH CHECK ADD CONSTRAINT [fk_conditions_agreement_with_registrations] FOREIGN KEY([registration_id])
REFERENCES [dbo].[registrations] ([id]);
ALTER TABLE [dbo].[conditions_agreement] WITH CHECK ADD CONSTRAINT [fk_conditions_agreement_with_users] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id]);

-- Table:   correction_requests_emails
-- Column:  call
ALTER TABLE [dbo].[correction_requests_emails] WITH CHECK ADD CONSTRAINT [fk_correction_requests_emails_with_calls] FOREIGN KEY([call])
REFERENCES [dbo].[calls] ([id]);

-- Table:   global_commitment
-- Column:  call
ALTER TABLE [dbo].[global_commitment] WITH CHECK ADD CONSTRAINT [fk_global_commitment_with_calls] FOREIGN KEY([call])
REFERENCES [dbo].[calls] ([id]);

-- Table:   grant_agreement
-- Column:  application_id
ALTER TABLE [dbo].[grant_agreement] WITH CHECK ADD CONSTRAINT [fk_grant_agreement_with_applications] FOREIGN KEY([application_id])
REFERENCES [dbo].[applications] ([id]);

-- Table:   municipalities_abac
-- Column:  municipality
ALTER TABLE [dbo].[municipalities_abac] WITH CHECK ADD CONSTRAINT [fk_municipalities_abac_with_municipalities] FOREIGN KEY([municipality])
REFERENCES [dbo].[municipalities] ([id]);

-- Table:   user_threads
-- Column:  _user,thread
ALTER TABLE [dbo].[user_threads] WITH CHECK ADD CONSTRAINT [fk_user_threads_with_threads] FOREIGN KEY([thread])
REFERENCES [dbo].[threads] ([id]);

-- Table:   voucher_management
-- Column:  call_id
ALTER TABLE [dbo].[voucher_management] WITH CHECK ADD CONSTRAINT [fk_voucher_management_with_calls] FOREIGN KEY([call_id])
REFERENCES [dbo].[calls] ([id]);

-- Table:   voucher_simulations
-- Column:  municipality
ALTER TABLE [dbo].[voucher_simulations] WITH CHECK ADD CONSTRAINT [fk_voucher_simulations_with_municipalities] FOREIGN KEY([municipality])
REFERENCES [dbo].[municipalities] ([id]);

-- Creation of FKs - Part II
-- The following tables provoke conflicts for the creation of the FKs because they hold reference to registers that are not present in the source tables.
-- The missing registers can be checked with a query similar to the following (user_threads is the table where the FKs should be created and users is the source table):
-- SELECT [_user] from [user_threads] WHERE [_user] NOT IN (SELECT [id] from [users])

-- Table:   log_emails
-- Column:  municipalityId
ALTER TABLE [dbo].[log_emails] WITH CHECK ADD CONSTRAINT [fk_log_emails_with_municipalities] FOREIGN KEY([municipalityId])
REFERENCES [dbo].[municipalities] ([id]);


select * from rights where userId NOT IN (select id from users) -- list of rights where userId doesn't exists
-- delete from rights where userId NOT IN (select id from users)
-- Table:   rights
-- Column:  userId
ALTER TABLE [dbo].[rights] WITH CHECK ADD CONSTRAINT [fk_rights_with_users] FOREIGN KEY([userId])
REFERENCES [dbo].[users] ([id]);

-- Table:   user_threads
-- Column:  _user,thread
ALTER TABLE [dbo].[user_threads] WITH CHECK ADD CONSTRAINT [fk_user_threads_with_users] FOREIGN KEY([_user])
REFERENCES [dbo].[users] ([id]);


-- Update NUTS/Laus
delete from supplied_regions
where region in (select id from nuts where label like 'EXTRA%');
delete from nuts where label like 'EXTRA%';

-- 2018-09-03 Convert the date of the applications from nanos to millis (10 digits)
UPDATE applications set date = LEFT(date, 13) where LEN(date) > 13;

-- 2018-09-13 Azure Blob storage for legal files, this new column stores the URI in Azure
alter table legal_files add azure_uri varchar(2048);


