-----------------------------------
-- populateUpdated.sql
-----------------------------------
DELETE FROM representations
DELETE FROM municipalities
DELETE FROM supplied_regions
DELETE FROM supplier_users
DELETE FROM thread_messages
DELETE FROM user_threads
DELETE FROM application_comment
DELETE FROM voucher_simulations
DELETE FROM voucher_assignments
DELETE FROM registration_users
DELETE FROM rights
DELETE FROM conditions_agreement
DELETE FROM users
DELETE FROM legal_files
DELETE FROM registration_warnings
DELETE FROM registrations
DELETE FROM mayors
DELETE FROM application_invalidate_reason
DELETE FROM authorized_person_application
DELETE FROM applications
DELETE FROM temp_tokens
DELETE FROM suppliers
DELETE FROM helpdesk_issues
DELETE FROM timelines
DELETE FROM threads

DELETE FROM municipalities_abac;
DELETE FROM budgetary_commitment;
DELETE FROM global_commitment;
DELETE FROM grant_agreement;

DBCC CHECKIDENT ('municipalities', RESEED, 0);
DBCC CHECKIDENT ('users', RESEED, 0);
DBCC CHECKIDENT ('registrations', RESEED, 0);
DBCC CHECKIDENT ('mayors', RESEED, 0);
DBCC CHECKIDENT ('applications', RESEED, 0);
DBCC CHECKIDENT ('rights', RESEED, 0);
DBCC CHECKIDENT ('temp_tokens', RESEED, 0);
DBCC CHECKIDENT ('registration_users', RESEED, 0);
DBCC CHECKIDENT ('conditions_agreement', RESEED, 0);
DECLARE @i INT = 0
DECLARE @u VARCHAR(255) = ''
DECLARE @m_id VARCHAR(255) = ''
DECLARE @u_id VARCHAR(255) = ''
DECLARE @r_id VARCHAR(255) = ''
DECLARE @t_id VARCHAR(255) = ''
DECLARE @f_id1 VARCHAR(255) = ''
DECLARE @f_id3 VARCHAR(255) = ''

-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aagaach', 'aagaach', 'Berlin str', '605', '08028', 'Christian.AAGAARD@ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Christian.AAGAARD@ec.europa.eu', 'aagaach', 5, 0, 'se')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Österåker', 'Akersberga', '1', '123', 'Sverige', 104140)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aagaach', 'aagaach', 'Christian.AAGAARD@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM registrations ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Christian.AAGAARD@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aagaape', 'aagaape', 'Черешка', '605', '08028', 'Peter.Aagaard@ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Peter.Aagaard@ec.europa.eu', 'aagaape', 5, 0, 'bg')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Черешка', 'Черешка', '1', '22000', 'България', 7813)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aagaape', 'aagaape', 'Peter.Aagaard@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Peter.Aagaard@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aalankr', 'aalankr', 'Κοινότητα ητα', '605', '121221', 'Kristine.AALAND@ec.europa.eu', '08028', 1523537782500, 1523537782500, 'Kristine.AALAND@ec.europa.eu', 'aalankr', 5, 0, 'gr')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Κοκκινογείων', 'Τοπική Κοινότητα Κοκκινογείων', '605', '08028', 'Greece', 28646)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aalankr', 'aalankr', 'Kristine.AALAND@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM registrations ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Kristine.AALAND@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)



-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aallima', 'aallima', 'Diagonal', '2', '08028', 'Malene.AALLING@ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Malene.AALLING@ec.europa.eu', 'aallima', 5, 0, 'es')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Barcelona', 'Diagonal', '605', '08028', 'ESPAÑA', 35511)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aallima', 'aallima', 'Malene.AALLING@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Malene.AALLING@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aaltope', 'aaltope', 'Trifterner str.', '605', '08028', 'Pekka.AALTO@ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Pekka.AALTO@ec.europa.eu', 'aaltope', 5, 0, 'de')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Kößlarn', 'Trifterner str.', '12', '2344', 'Deutschland', 21810)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aaltope', 'aaltope', 'Pekka.AALTO@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Pekka.AALTO@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aaltosi', 'aaltosi', 'Obern str.', '605', '08028', 'Sirpa.AALTONEN@ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Sirpa.AALTONEN@ec.europa.eu', 'aaltosi', 5, 0, 'de')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Haarbach', 'Obern str.', '98', '078', 'Deutschland', 21805)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aaltosi', 'aaltosi', 'Sirpa.AALTONEN@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Sirpa.AALTONEN@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aarabmo', 'aarabmo', 'Fløng Sogn', '605', '08028', 'Mounir.AARAB@ext.ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Mounir.AARAB@ext.ec.europa.eu', 'aarabmo', 5, 0, 'dk')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Høje-Taastrup', 'Fløng Sogn', '5', '08028', 'Danmark', 26096)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aarabmo', 'aarabmo', 'Mounir.AARAB@ext.ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Mounir.AARAB@ext.ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aarabnn', 'aarabnn', 'Gevninge Sogn', '605', '08028', 'Nesrin.TRIBAK@ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Nesrin.TRIBAK@ec.europa.eu', 'aarabnn', 5, 0, 'dk')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Lejre', 'Gevninge Sogn', '605', '08021', 'Danmark', 26098)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aarabnn', 'aarabnn', 'Nesrin.TRIBAK@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Nesrin.TRIBAK@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'Franklin', 'Kaswiner', 'Avenue de Dre', '3', '1045', 'fkaswine@everis.com', '123123', 1523537782500, 1523537782500, 'fkaswine@everis.com', 'frkaswi', 5, 0, 'en')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Molenbeek-Saint-Jean', 'Rue de Geneve', '1', '1000', 'Belgique', 82)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aardean', 'aardean', 'Ann.VAN-AARDEN@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Ann.VAN-AARDEN@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'aardepe', 'aardepe', 'Rue de Quelquechose', '605', '08028', 'Peter.Aardema@ec.europa.eu', '123123', 1523537782500, 1523537782500, 'Peter.Aardema@ec.europa.eu', 'aardepe', 5, 0, 'nl')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Namur ', 'Rue de Quelquechose', '1', '1098', 'Belgique', 574)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aardepe', 'aardepe', 'Peter.Aardema@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Peter.Aardema@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'Michael', 'Manalis', 'Avenue du Prince d''Orange', '1', '1180', 'michael.manalis@ext.ec.europa.eu', '1234567', 1523537782500, 1523537782500, 'michael.manalis@ext.ec.europa.eu', 'manalmi', 5, 0, 'fr')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Uccle', 'Avenue du Prince d''Orange', '100', '1180', 'Belgique', 86)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aardepe', 'aardepe', 'Peter.Aardema@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Peter.Aardema@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'Siarhei', 'Tsitou', 'Avenue Eugène Plasky', '1', '1030', 'siarhei.tsitou@ext.ec.europa.eu', '1234567', 1523537782500, 1523537782500, 'siarhei.tsitou@ext.ec.europa.eu', 'tsitosi', 5, 0, 'nl')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Schaerbeek', 'Avenue Eugène Plasky', '100', '1030', 'Belgique', 85)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aardepe', 'aardepe', 'Peter.Aardema@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Peter.Aardema@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'Alex', 'Perez', 'Avenue de Faraway', '6', '10310', 'alex.perez@everis.com', '1234567', 1523537782500, 1523537782500, 'alex.perez@everis.com', 'alperez', 5, 0, 'es')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Яковци', 'Яковци иковци', '10', '123', 'Bulgaria', 7907)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aardepe', 'aardepe', 'Peter.Aardema@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Peter.Aardema@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'Ruben', 'Garcia Tamayo', 'Попови ливади', '1', '1030', 'ruben.garcia@everis.com', '1234567', 1523537782500, 1523537782500, 'ruben.garcia@everis.com', 'rugarci', 5, 0, 'es')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Попови ливади', 'Попови ливади', '75', '1233', 'Bulgaria', 7947)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aardepe', 'aardepe', 'Peter.Aardema@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Peter.Aardema@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)


-- Add user
INSERT INTO users
    (treatment, name, surname, address, address_num, postal_code, email, password, create_date, access_date, ecas_email, ecas_username, type, verified, lang)
VALUES
       ('', 'Sara', 'Connor', 'Next Door Blvd.', '11', '1230', 'sara.connor@everis.com', '1234567', 1523537782500, 1523537782500, 'sara.connor@everis.com', 'saconno', 3, 0, 'en')
-- Add municipality
INSERT INTO municipalities
    (name,address,address_num,postal_code,country,lau)
VALUES
       ('Mhère', 'Next Door Blvd.', '75', '234343', 'France', 65057)
-- Add user and municipality link
SET @u_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
SET @m_id = (SELECT TOP 1 id FROM municipalities ORDER BY ID DESC)
-- Add mayor
INSERT INTO mayors
    (treatment, name, surname, email, municipality)
VALUES
       (NULL, 'aardepe', 'aardepe', 'Peter.Aardema@ec.europa.eu', @m_id)
-- Add registration
INSERT INTO registrations
    (_user, municipality, role, _status, ip_registration, organisation_id, association_name, allFiles_flag, mail_counter)
VALUES(@u_id, @m_id, 'Representative', 0, '127.0.0.1', 0, '', 1, 0)
-- Add registration link
SET @r_id = (SELECT TOP 1 id FROM users ORDER BY ID DESC)
-- Add legal file #1
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile1', 0, 1, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #1 link
SET @f_id1 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add legal file #3
INSERT INTO legal_files
    (registration, id_user, data, file_size, file_mime, file_name, upload_time, type, azure_uri)
VALUES(@r_id, @u_id, 'data:application/pdf;base64,JVBERi0xLjQNJeLjz9', 18, 'application/pdf', 'sampleFile3', 0, 3, 'https://w4eudevlfstore.blob.core.windows.net/wifi4eu/1_5B8300077FF823619271C54CB470754CB7B9EAF9_1538049938872')
-- Add legal file #3 link
SET @f_id3 = (SELECT TOP 1 id FROM legal_files ORDER BY ID DESC)
-- Add temp_tokens
INSERT INTO temp_tokens
    (token, email, create_date, expiry_date, _user)
VALUES
       (54379073478005177501523550744865+@i+1, 'Peter.Aardema@ec.europa.eu', 1523550744865, 1523557944865, @u_id)
-- Add temp_token link
SET @t_id = (SELECT TOP 1 id FROM temp_tokens ORDER BY ID DESC)
-- Add right
INSERT INTO rights
    (userId,rightdesc, type)
VALUES
       (@u_id, 'users_'+@u_id, 0),
       (@u_id, 'municipalities_'+@m_id, 3),
       (@u_id, 'registrations_'+@r_id, 3),
       (@u_id, 'temp_tokens_'+@t_id, 3),
       (@u_id, 'mayors_'+@t_id, 3)
INSERT INTO registration_users
    (registration, _user)
VALUES
    (@r_id, @u_id)



-- Global Commitments
INSERT INTO global_commitment
    (id, ammount, call, globalCommitment, priority)
VALUES
       (1, 300000, 1, 'SI2.773329.1.B2018', 1)

INSERT INTO global_commitment
    (id, ammount, call, globalCommitment, priority)
VALUES
       (2, 300000, 1, 'SI2.773329.2.B2018', 2)
