-- Add new columns on legal files
ALTER TABLE legal_files ADD status int;
ALTER TABLE legal_files ADD new int;

-- Update existing files with information on the new columns
UPDATE legal_files SET status = 0
UPDATE l SET l.status = 2 FROM legal_files l INNER JOIN applications a ON l.registration = a.registration WHERE a._status = 2;
UPDATE l SET l.status = 1 FROM legal_files l INNER JOIN applications a ON l.registration = a.registration WHERE a._status = 1;
UPDATE legal_files SET new = 0;
UPDATE r SET r.new = 1 FROM legal_files r inner join (select l1.* from legal_files l1 inner join (select registration, max(upload_time) as ut from legal_files l2 inner join (select type from legal_files group by type)l3 on l3.type = l2.type group by registration) l2 on l2.registration = l1.registration and l1.upload_time = l2.ut) l4 on l4.id = r.id  where r.status = 0
UPDATE r SET r.new = 2 FROM legal_files r inner join (select l1.* from legal_files l1 inner join (select registration, max(upload_time) as ut from legal_files l2 inner join (select type from legal_files group by type)l3 on l3.type = l2.type group by registration) l2 on l2.registration = l1.registration and l1.upload_time = l2.ut) l4 on l4.id = r.id where r.status != 0;
