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
