--------------------------------------------------------------------
--  Creation of applications from a list of registrations
--------------------------------------------------------------------
DECLARE  @call int;
DECLARE  @regs nvarchar(max);
DECLARE  @sql nvarchar(max);
SET @call = 1;
SET @regs = '1008,1009';

-- Show applications (there should be no results)
--SET @sql = 'select * from applications where registration in (' + @regs +')';
--exec sp_executesql @sql

-- Insert multiple registrations into applications
SET @sql = 'INSERT INTO applications (call_id, registration, supplier, voucher_awarded, date, _status, invalidate_reason, lef_export,
lef_import, lef_status, bc_export, bc_import, bc_status,lc_export, lc_import, lc_status)
SELECT TOP 10000 1, r.id, NULL, 0, 1535099405316 + FLOOR(10000 * RAND(convert(varbinary, newid()))), 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0 
FROM registrations r 
INNER JOIN municipalities m ON m.id = r.municipality 
WHERE m.lau in (select m.lau from registrations r inner join municipalities m ON m.id = r.municipality group by m.lau having COUNT(*) = 1)
	AND r.id in (' + @regs +')
ORDER BY r.id DESC';
--PRINT @sql;
exec sp_executesql @sql

-- Show applications (there should be results)
SET @sql = 'select * from applications where registration in (' + @regs +')';
exec sp_executesql @sql