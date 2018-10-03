--1 Le touquet
UPDATE municipalities set lau ='54112', country='FRANCE' where id = '1320';
DELETE LAUS WHERE ID ='88120';

--2 Wildungen
UPDATE municipalities set lau ='10411', country='DEUTSCHLAND' where id = '1415';
DELETE LAUS WHERE ID ='88121';

--3 Olevano sul Tusciano
UPDATE municipalities set lau ='73888', country='ITALIA' where id = '5501';
DELETE LAUS WHERE ID ='88125';
insert into threads (title, reason, type) values ((select display_name from laus where id=73888), 73888, 1);
  --USER THREADS
    --creamos una tabla temporal con los datos a tratar
    DECLARE @tempTable3 table (ID int);
    INSERT INTO @tempTable3 select distinct r._user from municipalities m join registrations r on r.municipality = m.id where lau = 73888;
    
    --declaramos variables temporales de los datos
    DECLARE  @userId int;

    DECLARE cursor3 CURSOR FOR SELECT * FROM @tempTable3; 
    OPEN cursor3 FETCH NEXT FROM cursor3 INTO @userId; WHILE @@FETCH_STATUS = 0
    BEGIN
      insert into user_threads (_user, thread) values (@userId, (select id from threads where reason = 73888));
      FETCH NEXT FROM cursor3 INTO @userId;
    END; 
    CLOSE cursor3 ;
    DEALLOCATE cursor3;

--4 Kuppenheim
UPDATE municipalities set lau ='15201', country='DEUTSCHLAND' where id = '7775';
DELETE LAUS WHERE ID ='88128';

--5&6 Lunano
UPDATE municipalities set lau ='72872', country='ITALIA' where id = '8312';
UPDATE municipalities set lau ='72872', country='ITALIA' where id = '19121';
DELETE LAUS WHERE ID ='88140';
DELETE LAUS WHERE ID ='88129';

--7 Pr√©-en-saint-samson
UPDATE municipalities set lau ='49108', country='FRANCE' where id = '8631';
DELETE LAUS WHERE ID ='88130';
insert into threads (title, reason, type) values ((select display_name from laus where id=49108), 49108, 1);
  --USER THREADS
    --creamos una tabla temporal con los datos a tratar
    DECLARE @tempTable7 table (ID int);
    INSERT INTO @tempTable7 select distinct r._user from municipalities m join registrations r on r.municipality = m.id where lau = 49108;

    --declaramos variables temporales de los datos
    --DECLARE  @userId int;

    DECLARE cursor7 CURSOR FOR SELECT * FROM @tempTable7;
    OPEN cursor7 FETCH NEXT FROM cursor7 INTO @userId; WHILE @@FETCH_STATUS = 0
    BEGIN 
      insert into user_threads (_user, thread) values (@userId, (select id from threads where reason = 49108));
      FETCH NEXT FROM cursor7 
      INTO @userId;
    END; 
    CLOSE cursor7 ;
    DEALLOCATE cursor7;

--8 Valdefuentes
UPDATE municipalities set lau ='23124', country=N'ESPA—A' where id = '8850';
DELETE LAUS WHERE ID ='88131';

--9 Hontanares
UPDATE municipalities set lau ='27327', country=N'ESPA—A' where id = '11966';
DELETE LAUS WHERE ID ='88133';

--10 Comitini
UPDATE municipalities set lau ='71487', country='ITALIA' where id = '12206';
DELETE LAUS WHERE ID ='88134';

--11 Vilches
UPDATE municipalities set lau ='24973', country=N'ESPA—A' where id = '13644';
DELETE LAUS WHERE ID ='88137';
insert into threads (title, reason, type) values ((select display_name from laus where id=24973), 24973, 1);
  --USER THREADS
    --creamos una tabla temporal con los datos a tratar
    DECLARE @tempTable11 table (ID int);
    INSERT INTO @tempTable11 select distinct r._user from municipalities m join registrations r on r.municipality = m.id where lau = 24973;
    
    --declaramos variables temporales de los datos
    --DECLARE  @userId int;

    DECLARE cursor11 CURSOR FOR SELECT * FROM @tempTable11;
    OPEN cursor11 FETCH NEXT FROM cursor11 INTO @userId; WHILE @@FETCH_STATUS = 0
    BEGIN 
      insert into user_threads (_user, thread) values (@userId, (select id from threads where reason = 24973));
      FETCH NEXT FROM cursor11 
      INTO @userId;
    END; 
    CLOSE cursor11 ;
    DEALLOCATE cursor11;


--12 San Giorgio di Mantova
UPDATE municipalities set lau ='75336', country='ITALIA' where id = '16411';
DELETE LAUS WHERE ID ='88138';

insert into threads (title, reason, type) values ((select display_name from laus where id=75336), 75336, 1);
  --USER THREADS
    --creamos una tabla temporal con los datos a tratar
    DECLARE @tempTable12 table (ID int);
    INSERT INTO @tempTable12 select distinct r._user from municipalities m join registrations r on r.municipality = m.id where lau = 75336;
    
    --declaramos variables temporales de los datos
    --DECLARE  @userId int;

    DECLARE cursor12 CURSOR FOR SELECT * FROM @tempTable12;
    OPEN cursor12 FETCH NEXT FROM cursor12 INTO @userId; WHILE @@FETCH_STATUS = 0
    BEGIN 
      insert into user_threads (_user, thread) values (@userId, (select id from threads where reason = 75336));
      FETCH NEXT FROM cursor12 
      INTO @userId;
    END; 
    CLOSE cursor12 ;
    DEALLOCATE cursor12;

--13 Vohburg
UPDATE municipalities set lau ='19883', country='DEUTSCHLAND' where id = '17119';
DELETE LAUS WHERE ID ='88139';

--14 M√ºhlingen
UPDATE municipalities set lau ='16320', country='DEUTSCHLAND' where id = '20741';
DELETE LAUS WHERE ID ='88141';

--15 Zwiesel
UPDATE municipalities set lau ='20877', country='DEUTSCHLAND' where id = '21119';
DELETE LAUS WHERE ID ='88143';

--16 Grazalema
UPDATE municipalities set lau ='23169', country=N'ESPA—A' where id = '21290';
DELETE LAUS WHERE ID ='88144';

--17 Merbes-le-Ch√¢teau
UPDATE municipalities set lau ='2461', country=N'BELGIQUE-BELGIÀ' where id = '23248';
DELETE LAUS WHERE ID ='88460';

--18 Sueglio
UPDATE municipalities set lau ='76216', country='ITALIA' where id = '27172';
DELETE LAUS WHERE ID ='88461';

--19 apiro
UPDATE municipalities set lau ='69496', country='ITALIA' where id = '27775';
DELETE LAUS WHERE ID ='88462';

--20 Sennecey-l√®s-Dijon
DELETE municipalities where id = 2408;
DELETE municipalities where id = 2430;
DELETE municipalities where id = 2328;
DELETE municipalities where id = 2384;
DELETE municipalities where id = 2304;
UPDATE municipalities set lau ='37087', country='FRANCE' where id = '28231';
DELETE LAUS WHERE ID ='88463';
DELETE LAUS WHERE ID='88122';
DELETE LAUS WHERE ID='88123';
DELETE LAUS WHERE ID='88124';


--21 Barxeta
UPDATE municipalities set lau ='28405', country=N'ESPA—A' where id = '28357';
DELETE LAUS WHERE ID ='88464';


--22 laus without registrations
DELETE FROM MUNICIPALITIES WHERE ID='6620';
DELETE FROM MUNICIPALITIES WHERE ID='6652';
DELETE FROM MUNICIPALITIES WHERE ID='12353';
DELETE FROM MUNICIPALITIES WHERE ID='12360';
DELETE FROM MUNICIPALITIES WHERE ID='20790';


DELETE LAUS WHERE ID='88132';
DELETE LAUS WHERE ID='88459';
DELETE LAUS WHERE ID='88126';
DELETE LAUS WHERE ID='88127';
DELETE LAUS WHERE ID='88135';
DELETE LAUS WHERE ID='88136';
DELETE LAUS WHERE ID='88142';


--update municipalities name
UPDATE municipalities set name = (select display_name from laus where id = municipalities.lau) 
where id  in (1320, 1415, 5501, 7775, 8312, 8631, 8850, 11966, 12206, 13644, 16411, 17119, 19121, 20741, 21119, 21290, 23248, 27172, 27775, 28231, 28357);

