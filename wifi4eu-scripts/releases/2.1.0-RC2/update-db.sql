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
    [signature_proof] nvarchar(MAX),
    [document_location] nvarchar(MAX),
    [document_location_countersigned] nvarchar(MAX),
    [date_signature] datetime,
    [date_counter_signature] datetime,
    PRIMARY KEY ([id]),
    CONSTRAINT [fk_grant_agreement_application]
    FOREIGN KEY ([application_id])
    REFERENCES dbo.applications ([id])
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
