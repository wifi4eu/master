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
