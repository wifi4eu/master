-- Get the municipalities by country
select n.label, l.name1 from laus l
inner join nuts n on l.country_code = n.country_code
where n.level = 0
order by n.label, l.name1 asc


-- Show the foreign keys
SELECT
   OBJECT_NAME(f.parent_object_id) TableName,
   COL_NAME(fc.parent_object_id,fc.parent_column_id) ColName
FROM
   sys.foreign_keys AS f
INNER JOIN
   sys.foreign_key_columns AS fc
      ON f.OBJECT_ID = fc.constraint_object_id
INNER JOIN
   sys.tables t
      ON t.OBJECT_ID = fc.referenced_object_id
WHERE
   OBJECT_NAME (f.referenced_object_id) = 'TABLE_NAME';


-- (REDIS) Information to to be sent to redis for pub/sub sync for a given userId
SELECT
     u.id AS userId,
     u.csrf_token AS csrfToken,
	CASE WHEN ca.status IS NULL THEN CAST(0 As Bit) ELSE CAST(ca.status As Bit) END AS acceptStatus,
     reg.id AS regId,
     mun.id AS munId,
     CAST(reg.allFiles_flag AS Bit) as docStatus
 FROM users u
 INNER JOIN registration_users ru ON u.id = ru._user
 INNER JOIN registrations reg ON reg.id = ru.registration

 OUTER APPLY
     (SELECT TOP 1 * FROM conditions_agreement WHERE user_id=u.id AND registration_id = reg.id ORDER BY change_status_date DESC) ca
 INNER JOIN  municipalities mun ON mun.id = reg.municipality
 WHERE
      u.id = 28165

-- When deleteing applications, delete the following tables

-- delete from voucher_assignments
-- delete from vouchers_simulations
-- delete from grant_agreement
-- delete from application_comment
-- delete from authorized_person_application
-- delete from application_invalidate_reason
-- delete from applications



-- Return all the applications -Preparation to be sent as a CSV (with municipality, laus, apply date, etc...)
select m.country, m.name as municipality, l.name1 as lau_name,
    dateadd(HOUR, 2, dateadd(s, convert(bigint, a.date) / 1000, convert(datetime, '1-1-1970 00:00:00'))) as apply_date,
    CASE a._status WHEN 0 THEN 'Applied' WHEN 1 THEN 'Invalid' WHEN 2 THEN 'Valid' WHEN 3 THEN 'Pending followup' END AS status,
    r.id as reg_id, m.id as mun_id, a.id as application_id
from applications a
inner join registrations r ON a.registration = r.id
inner join municipalities m ON r.municipality = m.id
inner join laus l ON m.lau = l.id
WHERE m.name is not null
ORDER BY m.country;



-- DELETE AND CREATE NEW APPLICATIONS
--------------------------------------
    -- Clean the applications
    DELETE FROM voucher_simulations
    DELETE FROM voucher_assignments
    DELETE FROM grant_agreement
    DELETE FROM application_comment
    DELETE FROM authorized_person_application
    DELETE FROM application_invalidate_reason
    DELETE FROM applications


    -- Create call from Thursday, 13 September 2018 15:30:00 to Thursday, 13 September 2018 16:00:00
    UPDATE calls SET start_date = 1536845400000, end_date = 1536847200000 where id = 1


    -- Create 10k application from current registrations

    INSERT INTO applications (call_id, registration, supplier, voucher_awarded, date, _status, invalidate_reason, lef_export,
    lef_import, lef_status, bc_export, bc_import, bc_status,lc_export, lc_import, lc_status)
    select top 10000 1, r.id, NULL, 0, 1536845400000 + FLOOR(1000000 * RAND(convert(varbinary, newid()))), 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0
    from registrations r
    inner join municipalities m
        ON m.id = r.municipality
    where m.lau in (select m.lau from registrations r
    inner join municipalities m
        ON m.id = r.municipality
         group by m.lau having COUNT(*) = 1)
    order by r.id desc;

