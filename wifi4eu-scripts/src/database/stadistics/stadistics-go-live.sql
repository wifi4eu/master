-- number of registered users today of every type
SELECT COUNT(*) FROM users WHERE create_date BETWEEN 1539216000000 AND 1539302399000 

-- number of registered suppliers today
SELECT COUNT(*) FROM users WHERE type = 1 AND create_date BETWEEN 1539216000000 AND 1539302399000 

-- number of registered beneficiaries today
SELECT COUNT(*) FROM users WHERE type = 3 AND create_date BETWEEN 1539216000000 AND 1539302399000 

-- number of registered WITHOUT TYPE today
SELECT COUNT(*) FROM users WHERE type = 0 AND create_date BETWEEN 1539216000000 AND 1539302399000

-- number of legal_files uploaded today
SELECT COUNT(*) FROM legal_files WHERE upload_time BETWEEN 1539216000000 AND 1539302399000 

-- number of tickets of helpdesk
SELECT COUNT(*) FROM helpdesk_issues WHERE create_date BETWEEN 1539216000000 AND 1539302399000 

-- count nut duplicates on uk
SELECT label, COUNT(*) AS countOf FROM nuts WHERE country_code = 'uk' group by label having count(*) > 1

SELECT n.id, n.code, n.label FROM nuts n INNER JOIN (SELECT label, COUNT(*) AS CountOf FROM nuts GROUP BY label HAVING COUNT(*)>1 ) dt ON n.label=dt.label WHERE n.country_code = 'uk'

-- count how many suppliers are in duplicate nuts
SELECT n.id, n.code, n.label, n.country_code, (SELECT count(1) from supplied_regions where supplied_regions.region=n.id) as numberOfSuppliers FROM nuts n 
INNER JOIN (
       SELECT label, COUNT(*) AS CountOf 
       FROM nuts 
       where level = 3
       GROUP BY label 
       HAVING COUNT(*)>1 ) dt 
ON n.label=dt.label 
WHERE level = 3
order by label





