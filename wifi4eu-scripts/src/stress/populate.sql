DELETE FROM municipalities
DELETE FROM users
DELETE FROM registrations
DELETE FROM mayors
DELETE FROM applications
DELETE FROM rights
DELETE FROM temp_tokens
DECLARE @i INT = 0
DECLARE @u VARCHAR(255) = ''
DECLARE @m_id VARCHAR(255) = ''
DECLARE @u_id VARCHAR(255) = ''
DECLARE @r_id VARCHAR(255) = ''
DECLARE @t_id VARCHAR(255) = ''
WHILE @i < 10
BEGIN
  SET @i = @i + 1
  set @u = 'uid'+RIGHT(CONCAT('00000', CONVERT(VARCHAR, @i)), 5)
  -- Add user
  INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
  VALUES
    (NULL, @u, @u, 'Diagonal', '605', '08028', @u+'.loadtest@ec.europa.eu', '', 1523537782500, 1523537782500, @u+'.loadtest@ec.europa.eu', @u, 3, 0, 'en')
  -- Add municipality
  INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
  VALUES
    ('Barcelona', 'Diagonal', '605', '08028', 'ESPAÑA', 35511)
  -- Add user and municipality link
  SET @u_id = (SELECT TOP 1
    id
  FROM users
  ORDER BY ID DESC)
  SET @m_id = (SELECT TOP 1
    id
  FROM municipalities
  ORDER BY ID DESC)
  -- Add mayor
  INSERT INTO mayors
    (treatment, name, surname, email, municipality)
  VALUES
    (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
  -- Add registration
  INSERT INTO registrations
    (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
  VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
  -- Add registration link
  SET @r_id = (SELECT TOP 1
    id
  FROM users
  ORDER BY ID DESC)
  -- Add temp_tokens
  INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
  VALUES
    (54379073478005177501523550744865+@i, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
  -- Add temp_token link
  SET @t_id = (SELECT TOP 1
    id
  FROM temp_tokens
  ORDER BY ID DESC)
  -- Add right
  INSERT INTO rights
    (userId,rightdesc, type)
  VALUES
    (@u_id, 'users_'+@u_id, 0),
    (@u_id, 'municipalities_'+@m_id, 3),
    (@u_id, 'registrations_'+@r_id, 3),
    (@u_id, 'temp_tokens_'+@t_id, 3),
    (@u_id, 'mayors_'+@t_id, 3)
END
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aagaach', 'aagaach', 'Diagonal', 'Diagonal', '605', '08028', 'aagaach.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aagaach.loadtest@ec.europa.eu', 'aagaach', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aagaape', 'aagaape', 'Diagonal', 'Diagonal', '605', '08028', 'aagaape.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aagaape.loadtest@ec.europa.eu', 'aagaape', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aalankr', 'aalankr', 'Diagonal', 'Diagonal', '605', '08028', 'aalankr.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aalankr.loadtest@ec.europa.eu', 'aalankr', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aallima', 'aallima', 'Diagonal', 'Diagonal', '605', '08028', 'aallima.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aallima.loadtest@ec.europa.eu', 'aallima', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aaltope', 'aaltope', 'Diagonal', 'Diagonal', '605', '08028', 'aaltope.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aaltope.loadtest@ec.europa.eu', 'aaltope', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aaltosi', 'aaltosi', 'Diagonal', 'Diagonal', '605', '08028', 'aaltosi.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aaltosi.loadtest@ec.europa.eu', 'aaltosi', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aarabmo', 'aarabmo', 'Diagonal', 'Diagonal', '605', '08028', 'aarabmo.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aarabmo.loadtest@ec.europa.eu', 'aarabmo', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aarabnn', 'aarabnn', 'Diagonal', 'Diagonal', '605', '08028', 'aarabnn.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aarabnn.loadtest@ec.europa.eu', 'aarabnn', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aardean', 'aardean', 'Diagonal', 'Diagonal', '605', '08028', 'aardean.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aardean.loadtest@ec.europa.eu', 'aardean', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO users
  (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
  ('', 'aardepe', 'aardepe', 'Diagonal', 'Diagonal', '605', '08028', 'aardepe.loadtest@ec.europa.eu', 1523537782500, 1523537782500, 'aardepe.loadtest@ec.europa.eu', 'aardepe', 3, 0, 'en')
-- Add user and municipality link
SET @u_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1
  id
FROM municipalities
ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
  (treatment, name, surname, email, municipality)
VALUES
  (NULL, @u, @u, @u+'.loadtest@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
  (_user, municipality, role, _status, legal_file1, legal_file2, legal_file3, legal_file4, ip_registration, organisation_id, association_name, upload_time, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', '', '127.0.0.1', 0, ' ', 0, 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1
  id
FROM users
ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
  (token, email, create_date, expiry_date, _user)
VALUES
  (54379073478005177501523550744865+@i+1, @u+'.loadtest@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1
  id
FROM temp_tokens
ORDER BY ID DESC)
-- Add right
INSERT INTO rights
  (userId,rightdesc, type)
VALUES
  (@u_id, 'users_'+@u_id, 0),
  (@u_id, 'municipalities_'+@m_id, 3),
  (@u_id, 'registrations_'+@r_id, 3),
  (@u_id, 'temp_tokens_'+@t_id, 3),
  (@u_id, 'mayors_'+@t_id, 3)
-- select count(*)
-- from users
-- select top 5
--   *
-- from users
-- select top 5
--   *
-- from registrations
-- select top 5
--   *
-- from municipalities
-- select top 5
--   *
-- from mayors
-- select top 5
--   *
-- from rights
-- select top 5
--   *
-- from temp_tokens