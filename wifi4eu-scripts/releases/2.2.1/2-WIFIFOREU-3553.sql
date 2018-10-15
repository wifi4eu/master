
-- 2018-09-27 bugfix/WIFIFOREU-3553 - Column data to store reference of exported file on applications list
ALTER TABLE dbo.admin_actions ADD data nvarchar(255);