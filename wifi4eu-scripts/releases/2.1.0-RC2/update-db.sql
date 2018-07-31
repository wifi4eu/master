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
from [dbo].registration_users r inner join
[dbo].[legal_files] l on l.registration = r.registration
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
legal_file2_size, legal_file2_mime, legal_file3_size, legal_file3_mime, legal_file4_size, legal_file4_mime;