alter table legal_files_correction_reason ADD request_correction_date DATETIME NULL;
alter table APPLICANTLISTITEM ADD SUPPORTINGDOCUMENTS BIT DEFAULT(0);
alter table legal_files ADD upload_time DATETIME NULL;
ALTER TABLE [applications] ADD authorized_person INT NULL;

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
          ([contact_email]
          ,[main]
          ,[registration]
          ,[status]
          ,[_user])
   SELECT u.ecas_email, 1, r.id, 1, u.id from registrations r inner join users u on r._user = u.id where u.ecas_email is not null;
ALTER TABLE [registrations] ALTER COLUMN _user INT null;

update [dbo].[legal_files]
set [upload_time] = (select dateadd(s, convert(bigint, r.upload_time) / 1000, convert(datetime, '1-1-1970 00:00:00')))
from [dbo].[legal_files]  inner join
[dbo].[registrations] r on r.id = registration;
