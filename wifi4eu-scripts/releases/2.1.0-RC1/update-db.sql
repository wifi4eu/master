alter table legal_files_correction_reason ADD request_correction_date DATETIME NULL;
alter table APPLICANTLISTITEM ADD SUPPORTINGDOCUMENTS BIT DEFAULT(0);
alter table legal_files ADD upload_time DATETIME NULL;
ALTER TABLE [applications] ADD authorized_person INT NULL;

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
inner join users as u on ru._user = u.id
