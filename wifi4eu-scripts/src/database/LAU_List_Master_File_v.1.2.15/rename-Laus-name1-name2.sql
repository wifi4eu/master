ALTER TABLE laus ADD name1_backup nvarchar(255) NULL;
ALTER TABLE laus ADD name2_backup nvarchar(255) NULL;

update laus set name1_backup = name1;
update laus set name2_backup = name2;

update laus set name1 = name_national;
update laus set name2 = display_name;