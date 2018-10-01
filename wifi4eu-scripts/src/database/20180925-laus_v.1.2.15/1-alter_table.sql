ALTER TABLE laus ADD name_national nvarchar(255) NULL;
ALTER TABLE laus ADD name_latin nvarchar(255) NULL;
ALTER TABLE laus ADD abac_name nvarchar(255) NULL;
ALTER TABLE laus ADD display_name nvarchar(255) NULL;

ALTER TABLE laus ADD name1_backup nvarchar(255) NULL;
ALTER TABLE laus ADD name2_backup nvarchar(255) NULL;

update laus set name1_backup = name1;
update laus set name2_backup = name2;