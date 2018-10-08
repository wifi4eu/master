----------------------------------------------
-- how to check the space used by the tables
select COUNT(*) from registrations
SELECT 
    t.NAME AS TableName,
    s.Name AS SchemaName,
    p.rows AS RowCounts,
    SUM(a.total_pages) * 8 AS TotalSpaceKB, 
    CAST(ROUND(((SUM(a.total_pages) * 8) / 1024.00), 2) AS NUMERIC(36, 2)) AS TotalSpaceMB,
	CAST(ROUND((((SUM(a.total_pages) * 8) / 1024.00) / 1024.00), 2) AS NUMERIC(36, 2)) AS TotalSpaceGB,
    SUM(a.used_pages) * 8 AS UsedSpaceKB, 
    CAST(ROUND(((SUM(a.used_pages) * 8) / 1024.00), 2) AS NUMERIC(36, 2)) AS UsedSpaceMB, 
    (SUM(a.total_pages) - SUM(a.used_pages)) * 8 AS UnusedSpaceKB,
    CAST(ROUND(((SUM(a.total_pages) - SUM(a.used_pages)) * 8) / 1024.00, 2) AS NUMERIC(36, 2)) AS UnusedSpaceMB
FROM 
    sys.tables t
INNER JOIN      
    sys.indexes i ON t.OBJECT_ID = i.object_id
INNER JOIN 
    sys.partitions p ON i.object_id = p.OBJECT_ID AND i.index_id = p.index_id
INNER JOIN 
    sys.allocation_units a ON p.partition_id = a.container_id
LEFT OUTER JOIN 
    sys.schemas s ON t.schema_id = s.schema_id
WHERE 
    t.NAME NOT LIKE 'dt%' 
    AND t.is_ms_shipped = 0
    AND i.OBJECT_ID > 255 
GROUP BY 
    t.Name, s.Name, p.Rows
ORDER BY 
    TotalSpaceMB DESC, t.Name

    
----------------------------------------------
-- how to check the space used by the fields of a table (registrations)
SELECT 
      SUM(DATALENGTH(_user)) AS SizeInBytes_user
      ,SUM(DATALENGTH(municipality)) AS SizeInBytesmunicipality
      ,SUM(DATALENGTH(role)) AS SizeInBytesrole
      ,SUM(DATALENGTH(_status)) AS SizeInBytes_status
      ,SUM(DATALENGTH(ip_registration)) AS SizeInBytesip_registration
      ,SUM(DATALENGTH(organisation_id)) AS SizeInBytesorganisation_id
      ,SUM(DATALENGTH(association_name)) AS SizeInBytesassociation_name
      ,SUM(DATALENGTH(allFiles_flag)) AS SizeInBytesallFiles_flag
      ,SUM(DATALENGTH(mail_counter)) AS SizeInBytesmail_counter
      ,SUM(DATALENGTH(id_status_beneficiary)) AS SizeInBytesid_status_beneficiary
      ,SUM(DATALENGTH(id_pm)) AS SizeInBytesid_pm
      ,SUM(DATALENGTH(id_bpm)) AS SizeInBytesid_bpm
      ,SUM(DATALENGTH(compliance)) AS SizeInBytescompliance
      ,SUM(DATALENGTH(first_false_check)) AS SizeInBytesfirst_false_check
      ,SUM(DATALENGTH(conformity)) AS SizeInBytesconformity
      ,SUM(DATALENGTH(action_taken)) AS SizeInBytesaction_taken
      ,SUM(DATALENGTH(action_to_be_taken)) AS SizeInBytesaction_to_be_taken
      ,SUM(DATALENGTH(date_registered)) AS SizeInBytesdate_registered
      ,SUM(DATALENGTH(is_submission)) AS SizeInBytesis_submission
      ,SUM(DATALENGTH(is_rejection)) AS SizeInBytesis_rejection
      ,SUM(DATALENGTH(is_confirmation)) AS SizeInBytesis_confirmation
  FROM [dbo].[registrations]
GO


----------------------------------------------
-- how to check the queries in execution (summary)
select
    P.spid
,   right(convert(varchar, 
            dateadd(ms, datediff(ms, P.last_batch, getdate()), '1900-01-01'), 
            121), 12) as 'batch_duration'
,   P.program_name
,   P.hostname
,   P.loginame
from dbo.sysprocesses P
where P.spid > 50
and      P.status not in ('background', 'sleeping')
and      P.cmd not in ('AWAITING COMMAND'
                    ,'MIRROR HANDLER'
                    ,'LAZY WRITER'
                    ,'CHECKPOINT SLEEP'
                    ,'RA MANAGER')
order by batch_duration desc


----------------------------------------------
-- how to check the queries in execution (full details)
SELECT  *
FROM    sys.dm_exec_requests  
        CROSS APPLY sys.dm_exec_sql_text(sql_handle)  