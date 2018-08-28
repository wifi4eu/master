DECLARE @enable_constraints bit = 0
DECLARE @schema_name SYSNAME
DECLARE @table_name SYSNAME
DECLARE table_cursor CURSOR FOR
SELECT schemas.name, tables.name
FROM sys.tables INNER JOIN sys.schemas ON tables.schema_id = schemas.schema_id
OPEN table_cursor
FETCH NEXT FROM table_cursor INTO @schema_name, @table_name
DECLARE @cmd varchar(200)
WHILE @@FETCH_STATUS = 0
BEGIN
  SET @cmd = 'ALTER TABLE ' + QUOTENAME(@schema_name) + '.' + QUOTENAME(@table_name) + ' '
  SET @cmd = @cmd + (CASE WHEN @enable_constraints = 1 THEN 'CHECK' ELSE 'NOCHECK' END) + ' CONSTRAINT ALL'
  PRINT @cmd
  EXEC( @cmd )
  FETCH NEXT FROM table_cursor INTO @schema_name, @table_name
END
CLOSE table_cursor
DEALLOCATE table_cursor
DELETE FROM dbo.registrations;
DELETE FROM dbo.municipalities;
DELETE FROM dbo.mayors;
DELETE FROM dbo.users;
DELETE FROM dbo.rights;
DELETE FROM dbo.temp_tokens;
DELETE FROM dbo.suppliers;
DELETE FROM dbo.thread_messages;
DELETE FROM dbo.helpdesk_issues;
DELETE FROM dbo.timelines;
DELETE FROM dbo.user_threads;
DELETE FROM dbo.threads;
DELETE FROM dbo.applications;
DELETE FROM dbo.supplied_regions;
DELETE FROM dbo.representations;