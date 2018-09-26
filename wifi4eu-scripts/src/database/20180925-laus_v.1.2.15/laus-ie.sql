--MUNICIPALITIES WITH NO REGISTRATION (can delete lau and rename)
delete from municipalities where id in(1888, 7006, 7014, 7007);

--MUNICIPALITIES WITH REGISTRATION and same user
--Rearranging laus from municipalities that we are keeping (Waterford)
UPDATE municipalities SET lau = 69128 where id=22760 and lau = 69130; --Waterford City and County C -> Waterford City and County A
UPDATE municipalities SET lau = 69129 where id=22762 and lau = 69131; --Waterford City and County D -> Waterford City and County B
UPDATE municipalities SET lau = 69130 where id=22761 and lau = 69134; --Waterford County C -> Waterford City and County C
UPDATE municipalities SET lau = 69131 where id=22763 and lau = 69135; --Waterford County D -> Waterford City and County D

--Delete registrations / municipalities

--creamos una tabla temporal con los datos a tratar
DECLARE @tempTableRegistrations table (ID int);
INSERT INTO @tempTableRegistrations values (4674), (4675), (8422), (8423), (8424), (8425);

--declaramos variables temporales de los datos
DECLARE  @registrationId int;

--creamos cursor que recorrerá la tabla 
DECLARE cursorDeleteRegistration CURSOR FOR SELECT * FROM @tempTableRegistrations;
OPEN cursorDeleteRegistration 
FETCH NEXT FROM cursorDeleteRegistration 
INTO @registrationId;
WHILE @@FETCH_STATUS = 0
BEGIN
	PRINT concat('DELETING REGISTRATION ', @registrationId);
	DECLARE  @mayor int, @municipality int, @user int;
	set @mayor = (select id from mayors where municipality= (select municipality from registrations where id = 4674));
	--PRINT concat('Mayor ', @mayor);
	set @municipality = (select municipality from registrations where id = @registrationId);
	--PRINT concat('Municipality ', @municipality);
	set @user = (select _user from registrations where id = @registrationId);
	--PRINT concat('User ', @user);

	--delete municipality
	delete from mayors where id= @mayor;
	delete from invitation_contacts where id_registration = @registrationId;
	delete from registration_users where registration = @registrationId;
	delete from registration_warnings where registration_id = @registrationId;
	delete from applications where registration = @registrationId;
	delete from municipalities where id = @municipality;
	delete from registrations where id= @registrationId;
	--user threads
	delete from user_threads where _user = @user;
	--temp token
	delete from temp_tokens where _user = @user;
	--rights BEFORE ADD CONTACT TODO REMOVE RIGHTS OF OTHER USERS
	delete from rights where userId = @user;
	--conditions Agreement
	delete from conditions_agreement where user_id = @user;
	--invitation contacts by user
	delete from invitation_contacts where id_user_request = @user;
	--update user type
	update users set type=0 where id= @user;

  FETCH NEXT FROM cursorDeleteRegistration 
  INTO @registrationId;
END; 
CLOSE cursorDeleteRegistration ;
DEALLOCATE cursorDeleteRegistration;

--Drop threads of deleted laus
DELETE FROM THREADS WHERE ID = 466;
DELETE FROM THREADS WHERE ID = 1708;

--LAUS WITH NO MUNICIPALITIES
DELETE FROM laus WHERE id =69081;--Limerick County B
DELETE FROM laus WHERE id =69082;--Limerick County C
DELETE FROM laus WHERE id =69083;--Limerick County D

--Delete lau after deleting municipalities
DELETE FROM laus WHERE id =69080;--Limerick County
DELETE FROM laus WHERE id =69133;--Waterford County B

--Delete lau
DELETE FROM laus WHERE id =69124; --South Tipperary
DELETE FROM laus WHERE id =69125; --South Tipperary B
DELETE FROM laus WHERE id =69126; --South Tipperary C
DELETE FROM laus WHERE id =69127; --South Tipperary D
DELETE FROM laus WHERE id =69132; --Waterford County
DELETE FROM laus WHERE id =69134; --Waterford County C
DELETE FROM laus WHERE id =69135; --Waterford County D


--Rename
UPDATE laus SET name_national=N'Carlow A', name_latin=N'Carlow A', abac_name=N'Carlow A', display_name=N'Carlow A' WHERE id=69012;
UPDATE laus SET name_national=N'Carlow B', name_latin=N'Carlow B', abac_name=N'Carlow B', display_name=N'Carlow B' WHERE id=69013;
UPDATE laus SET name_national=N'Carlow C', name_latin=N'Carlow C', abac_name=N'Carlow C', display_name=N'Carlow C' WHERE id=69014;
UPDATE laus SET name_national=N'Carlow D', name_latin=N'Carlow D', abac_name=N'Carlow D', display_name=N'Carlow D' WHERE id=69015;
UPDATE laus SET name_national=N'Cavan A', name_latin=N'Cavan A', abac_name=N'Cavan A', display_name=N'Cavan A' WHERE id=69016;
UPDATE laus SET name_national=N'Cavan B', name_latin=N'Cavan B', abac_name=N'Cavan B', display_name=N'Cavan B' WHERE id=69017;
UPDATE laus SET name_national=N'Cavan C', name_latin=N'Cavan C', abac_name=N'Cavan C', display_name=N'Cavan C' WHERE id=69018;
UPDATE laus SET name_national=N'Cavan D', name_latin=N'Cavan D', abac_name=N'Cavan D', display_name=N'Cavan D' WHERE id=69019;
UPDATE laus SET name_national=N'Clare A', name_latin=N'Clare A', abac_name=N'Clare A', display_name=N'Clare A' WHERE id=69020;
UPDATE laus SET name_national=N'Clare B', name_latin=N'Clare B', abac_name=N'Clare B', display_name=N'Clare B' WHERE id=69021;
UPDATE laus SET name_national=N'Clare C', name_latin=N'Clare C', abac_name=N'Clare C', display_name=N'Clare C' WHERE id=69022;
UPDATE laus SET name_national=N'Clare D', name_latin=N'Clare D', abac_name=N'Clare D', display_name=N'Clare D' WHERE id=69023;
UPDATE laus SET name_national=N'Cork City A', name_latin=N'Cork City A', abac_name=N'Cork City A', display_name=N'Cork City A' WHERE id=69024;
UPDATE laus SET name_national=N'Cork City B', name_latin=N'Cork City B', abac_name=N'Cork City B', display_name=N'Cork City B' WHERE id=69025;
UPDATE laus SET name_national=N'Cork City C', name_latin=N'Cork City C', abac_name=N'Cork City C', display_name=N'Cork City C' WHERE id=69026;
UPDATE laus SET name_national=N'Cork City D', name_latin=N'Cork City D', abac_name=N'Cork City D', display_name=N'Cork City D' WHERE id=69027;
UPDATE laus SET name_national=N'Cork County A', name_latin=N'Cork County A', abac_name=N'Cork County A', display_name=N'Cork County A' WHERE id=69028;
UPDATE laus SET name_national=N'Cork County B', name_latin=N'Cork County B', abac_name=N'Cork County B', display_name=N'Cork County B' WHERE id=69029;
UPDATE laus SET name_national=N'Cork County C', name_latin=N'Cork County C', abac_name=N'Cork County C', display_name=N'Cork County C' WHERE id=69030;
UPDATE laus SET name_national=N'Cork County D', name_latin=N'Cork County D', abac_name=N'Cork County D', display_name=N'Cork County D' WHERE id=69031;
UPDATE laus SET name_national=N'Donegal A', name_latin=N'Donegal A', abac_name=N'Donegal A', display_name=N'Donegal A' WHERE id=69032;
UPDATE laus SET name_national=N'Donegal B', name_latin=N'Donegal B', abac_name=N'Donegal B', display_name=N'Donegal B' WHERE id=69033;
UPDATE laus SET name_national=N'Donegal C', name_latin=N'Donegal C', abac_name=N'Donegal C', display_name=N'Donegal C' WHERE id=69034;
UPDATE laus SET name_national=N'Donegal D', name_latin=N'Donegal D', abac_name=N'Donegal D', display_name=N'Donegal D' WHERE id=69035;
UPDATE laus SET name_national=N'Dublin City A', name_latin=N'Dublin City A', abac_name=N'Dublin City A', display_name=N'Dublin City A' WHERE id=69036;
UPDATE laus SET name_national=N'Dublin City B', name_latin=N'Dublin City B', abac_name=N'Dublin City B', display_name=N'Dublin City B' WHERE id=69037;
UPDATE laus SET name_national=N'Dublin City C', name_latin=N'Dublin City C', abac_name=N'Dublin City C', display_name=N'Dublin City C' WHERE id=69038;
UPDATE laus SET name_national=N'Dublin City D', name_latin=N'Dublin City D', abac_name=N'Dublin City D', display_name=N'Dublin City D' WHERE id=69039;
UPDATE laus SET name_national=N'Dún Laoghaire - Rathdown A', name_latin=N'Dún Laoghaire - Rathdown A', abac_name=N'Dún Laoghaire - Rathdown A', display_name=N'Dún Laoghaire - Rathdown A' WHERE id=69040;
UPDATE laus SET name_national=N'Dún Laoghaire - Rathdown B', name_latin=N'Dún Laoghaire - Rathdown B', abac_name=N'Dún Laoghaire - Rathdown B', display_name=N'Dún Laoghaire - Rathdown B' WHERE id=69041;
UPDATE laus SET name_national=N'Dún Laoghaire - Rathdown C', name_latin=N'Dún Laoghaire - Rathdown C', abac_name=N'Dún Laoghaire - Rathdown C', display_name=N'Dún Laoghaire - Rathdown C' WHERE id=69042;
UPDATE laus SET name_national=N'Dún Laoghaire - Rathdown D', name_latin=N'Dún Laoghaire - Rathdown D', abac_name=N'Dún Laoghaire - Rathdown D', display_name=N'Dún Laoghaire - Rathdown D' WHERE id=69043;
UPDATE laus SET name_national=N'Fingal A', name_latin=N'Fingal A', abac_name=N'Fingal A', display_name=N'Fingal A' WHERE id=69044;
UPDATE laus SET name_national=N'Fingal B', name_latin=N'Fingal B', abac_name=N'Fingal B', display_name=N'Fingal B' WHERE id=69045;
UPDATE laus SET name_national=N'Fingal C', name_latin=N'Fingal C', abac_name=N'Fingal C', display_name=N'Fingal C' WHERE id=69046;
UPDATE laus SET name_national=N'Fingal D', name_latin=N'Fingal D', abac_name=N'Fingal D', display_name=N'Fingal D' WHERE id=69047;
UPDATE laus SET name_national=N'Galway City A', name_latin=N'Galway City A', abac_name=N'Galway City A', display_name=N'Galway City A' WHERE id=69048;
UPDATE laus SET name_national=N'Galway City B', name_latin=N'Galway City B', abac_name=N'Galway City B', display_name=N'Galway City B' WHERE id=69049;
UPDATE laus SET name_national=N'Galway City C', name_latin=N'Galway City C', abac_name=N'Galway City C', display_name=N'Galway City C' WHERE id=69050;
UPDATE laus SET name_national=N'Galway City D', name_latin=N'Galway City D', abac_name=N'Galway City D', display_name=N'Galway City D' WHERE id=69051;
UPDATE laus SET name_national=N'Galway County A', name_latin=N'Galway County A', abac_name=N'Galway County A', display_name=N'Galway County A' WHERE id=69052;
UPDATE laus SET name_national=N'Galway County B', name_latin=N'Galway County B', abac_name=N'Galway County B', display_name=N'Galway County B' WHERE id=69053;
UPDATE laus SET name_national=N'Galway County C', name_latin=N'Galway County C', abac_name=N'Galway County C', display_name=N'Galway County C' WHERE id=69054;
UPDATE laus SET name_national=N'Galway County D', name_latin=N'Galway County D', abac_name=N'Galway County D', display_name=N'Galway County D' WHERE id=69055;
UPDATE laus SET name_national=N'Kerry A', name_latin=N'Kerry A', abac_name=N'Kerry A', display_name=N'Kerry A' WHERE id=69056;
UPDATE laus SET name_national=N'Kerry B', name_latin=N'Kerry B', abac_name=N'Kerry B', display_name=N'Kerry B' WHERE id=69057;
UPDATE laus SET name_national=N'Kerry C', name_latin=N'Kerry C', abac_name=N'Kerry C', display_name=N'Kerry C' WHERE id=69058;
UPDATE laus SET name_national=N'Kerry D', name_latin=N'Kerry D', abac_name=N'Kerry D', display_name=N'Kerry D' WHERE id=69059;
UPDATE laus SET name_national=N'Kildare A', name_latin=N'Kildare A', abac_name=N'Kildare A', display_name=N'Kildare A' WHERE id=69060;
UPDATE laus SET name_national=N'Kildare B', name_latin=N'Kildare B', abac_name=N'Kildare B', display_name=N'Kildare B' WHERE id=69061;
UPDATE laus SET name_national=N'Kildare C', name_latin=N'Kildare C', abac_name=N'Kildare C', display_name=N'Kildare C' WHERE id=69062;
UPDATE laus SET name_national=N'Kildare D', name_latin=N'Kildare D', abac_name=N'Kildare D', display_name=N'Kildare D' WHERE id=69063;
UPDATE laus SET name_national=N'Kilkenny A', name_latin=N'Kilkenny A', abac_name=N'Kilkenny A', display_name=N'Kilkenny A' WHERE id=69064;
UPDATE laus SET name_national=N'Kilkenny B', name_latin=N'Kilkenny B', abac_name=N'Kilkenny B', display_name=N'Kilkenny B' WHERE id=69065;
UPDATE laus SET name_national=N'Kilkenny C', name_latin=N'Kilkenny C', abac_name=N'Kilkenny C', display_name=N'Kilkenny C' WHERE id=69066;
UPDATE laus SET name_national=N'Kilkenny D', name_latin=N'Kilkenny D', abac_name=N'Kilkenny D', display_name=N'Kilkenny D' WHERE id=69067;
UPDATE laus SET name_national=N'Laois A', name_latin=N'Laois A', abac_name=N'Laois A', display_name=N'Laois A' WHERE id=69068;
UPDATE laus SET name_national=N'Laois B', name_latin=N'Laois B', abac_name=N'Laois B', display_name=N'Laois B' WHERE id=69069;
UPDATE laus SET name_national=N'Laois C', name_latin=N'Laois C', abac_name=N'Laois C', display_name=N'Laois C' WHERE id=69070;
UPDATE laus SET name_national=N'Laois D', name_latin=N'Laois D', abac_name=N'Laois D', display_name=N'Laois D' WHERE id=69071;
UPDATE laus SET name_national=N'Leitrim A', name_latin=N'Leitrim A', abac_name=N'Leitrim A', display_name=N'Leitrim A' WHERE id=69072;
UPDATE laus SET name_national=N'Leitrim B', name_latin=N'Leitrim B', abac_name=N'Leitrim B', display_name=N'Leitrim B' WHERE id=69073;
UPDATE laus SET name_national=N'Leitrim C', name_latin=N'Leitrim C', abac_name=N'Leitrim C', display_name=N'Leitrim C' WHERE id=69074;
UPDATE laus SET name_national=N'Leitrim D', name_latin=N'Leitrim D', abac_name=N'Leitrim D', display_name=N'Leitrim D' WHERE id=69075;
UPDATE laus SET name_national=N'Limerick City and County A', name_latin=N'Limerick City and County A', abac_name=N'Limerick City and County A', display_name=N'Limerick City and County A' WHERE id=69076;
UPDATE laus SET name_national=N'Limerick City and County B', name_latin=N'Limerick City and County B', abac_name=N'Limerick City and County B', display_name=N'Limerick City and County B' WHERE id=69077;
UPDATE laus SET name_national=N'Limerick City and County C', name_latin=N'Limerick City and County C', abac_name=N'Limerick City and County C', display_name=N'Limerick City and County C' WHERE id=69078;
UPDATE laus SET name_national=N'Limerick City and County D', name_latin=N'Limerick City and County D', abac_name=N'Limerick City and County D', display_name=N'Limerick City and County D' WHERE id=69079;
UPDATE laus SET name_national=N'Longford A', name_latin=N'Longford A', abac_name=N'Longford A', display_name=N'Longford A' WHERE id=69084;
UPDATE laus SET name_national=N'Longford B', name_latin=N'Longford B', abac_name=N'Longford B', display_name=N'Longford B' WHERE id=69085;
UPDATE laus SET name_national=N'Longford C', name_latin=N'Longford C', abac_name=N'Longford C', display_name=N'Longford C' WHERE id=69086;
UPDATE laus SET name_national=N'Longford D', name_latin=N'Longford D', abac_name=N'Longford D', display_name=N'Longford D' WHERE id=69087;
UPDATE laus SET name_national=N'Louth A', name_latin=N'Louth A', abac_name=N'Louth A', display_name=N'Louth A' WHERE id=69088;
UPDATE laus SET name_national=N'Louth B', name_latin=N'Louth B', abac_name=N'Louth B', display_name=N'Louth B' WHERE id=69089;
UPDATE laus SET name_national=N'Louth C', name_latin=N'Louth C', abac_name=N'Louth C', display_name=N'Louth C' WHERE id=69090;
UPDATE laus SET name_national=N'Louth D', name_latin=N'Louth D', abac_name=N'Louth D', display_name=N'Louth D' WHERE id=69091;
UPDATE laus SET name_national=N'Mayo A', name_latin=N'Mayo A', abac_name=N'Mayo A', display_name=N'Mayo A' WHERE id=69092;
UPDATE laus SET name_national=N'Mayo B', name_latin=N'Mayo B', abac_name=N'Mayo B', display_name=N'Mayo B' WHERE id=69093;
UPDATE laus SET name_national=N'Mayo C', name_latin=N'Mayo C', abac_name=N'Mayo C', display_name=N'Mayo C' WHERE id=69094;
UPDATE laus SET name_national=N'Mayo D', name_latin=N'Mayo D', abac_name=N'Mayo D', display_name=N'Mayo D' WHERE id=69095;
UPDATE laus SET name_national=N'Meath A', name_latin=N'Meath A', abac_name=N'Meath A', display_name=N'Meath A' WHERE id=69096;
UPDATE laus SET name_national=N'Meath B', name_latin=N'Meath B', abac_name=N'Meath B', display_name=N'Meath B' WHERE id=69097;
UPDATE laus SET name_national=N'Meath C', name_latin=N'Meath C', abac_name=N'Meath C', display_name=N'Meath C' WHERE id=69098;
UPDATE laus SET name_national=N'Meath D', name_latin=N'Meath D', abac_name=N'Meath D', display_name=N'Meath D' WHERE id=69099;
UPDATE laus SET name_national=N'Monaghan A', name_latin=N'Monaghan A', abac_name=N'Monaghan A', display_name=N'Monaghan A' WHERE id=69100;
UPDATE laus SET name_national=N'Monaghan B', name_latin=N'Monaghan B', abac_name=N'Monaghan B', display_name=N'Monaghan B' WHERE id=69101;
UPDATE laus SET name_national=N'Monaghan C', name_latin=N'Monaghan C', abac_name=N'Monaghan C', display_name=N'Monaghan C' WHERE id=69102;
UPDATE laus SET name_national=N'Monaghan D', name_latin=N'Monaghan D', abac_name=N'Monaghan D', display_name=N'Monaghan D' WHERE id=69103;
UPDATE laus SET name_national=N'Offaly A', name_latin=N'Offaly A', abac_name=N'Offaly A', display_name=N'Offaly A' WHERE id=69108;
UPDATE laus SET name_national=N'Offaly B', name_latin=N'Offaly B', abac_name=N'Offaly B', display_name=N'Offaly B' WHERE id=69109;
UPDATE laus SET name_national=N'Offaly C', name_latin=N'Offaly C', abac_name=N'Offaly C', display_name=N'Offaly C' WHERE id=69110;
UPDATE laus SET name_national=N'Offaly D', name_latin=N'Offaly D', abac_name=N'Offaly D', display_name=N'Offaly D' WHERE id=69111;
UPDATE laus SET name_national=N'Roscommon A', name_latin=N'Roscommon A', abac_name=N'Roscommon A', display_name=N'Roscommon A' WHERE id=69112;
UPDATE laus SET name_national=N'Roscommon B', name_latin=N'Roscommon B', abac_name=N'Roscommon B', display_name=N'Roscommon B' WHERE id=69113;
UPDATE laus SET name_national=N'Roscommon C', name_latin=N'Roscommon C', abac_name=N'Roscommon C', display_name=N'Roscommon C' WHERE id=69114;
UPDATE laus SET name_national=N'Roscommon D', name_latin=N'Roscommon D', abac_name=N'Roscommon D', display_name=N'Roscommon D' WHERE id=69115;
UPDATE laus SET name_national=N'Sligo A', name_latin=N'Sligo A', abac_name=N'Sligo A', display_name=N'Sligo A' WHERE id=69116;
UPDATE laus SET name_national=N'Sligo B', name_latin=N'Sligo B', abac_name=N'Sligo B', display_name=N'Sligo B' WHERE id=69117;
UPDATE laus SET name_national=N'Sligo C', name_latin=N'Sligo C', abac_name=N'Sligo C', display_name=N'Sligo C' WHERE id=69118;
UPDATE laus SET name_national=N'Sligo D', name_latin=N'Sligo D', abac_name=N'Sligo D', display_name=N'Sligo D' WHERE id=69119;
UPDATE laus SET name_national=N'South Dublin A', name_latin=N'South Dublin A', abac_name=N'South Dublin A', display_name=N'South Dublin A' WHERE id=69120;
UPDATE laus SET name_national=N'South Dublin B', name_latin=N'South Dublin B', abac_name=N'South Dublin B', display_name=N'South Dublin B' WHERE id=69121;
UPDATE laus SET name_national=N'South Dublin C', name_latin=N'South Dublin C', abac_name=N'South Dublin C', display_name=N'South Dublin C' WHERE id=69122;
UPDATE laus SET name_national=N'South Dublin D', name_latin=N'South Dublin D', abac_name=N'South Dublin D', display_name=N'South Dublin D' WHERE id=69123;
UPDATE laus SET name_national=N'Tipperary A', name_latin=N'Tipperary A', abac_name=N'Tipperary A', display_name=N'Tipperary A' WHERE id=69104;
UPDATE laus SET name_national=N'Tipperary B', name_latin=N'Tipperary B', abac_name=N'Tipperary B', display_name=N'Tipperary B' WHERE id=69105;
UPDATE laus SET name_national=N'Tipperary C', name_latin=N'Tipperary C', abac_name=N'Tipperary C', display_name=N'Tipperary C' WHERE id=69106;
UPDATE laus SET name_national=N'Tipperary D', name_latin=N'Tipperary D', abac_name=N'Tipperary D', display_name=N'Tipperary D' WHERE id=69107;
UPDATE laus SET name_national=N'Waterford City and County A', name_latin=N'Waterford City and County A', abac_name=N'Waterford City and County A', display_name=N'Waterford City and County A' WHERE id=69128;
UPDATE laus SET name_national=N'Waterford City and County B', name_latin=N'Waterford City and County B', abac_name=N'Waterford City and County B', display_name=N'Waterford City and County B' WHERE id=69129;
UPDATE laus SET name_national=N'Waterford City and County C', name_latin=N'Waterford City and County C', abac_name=N'Waterford City and County C', display_name=N'Waterford City and County C' WHERE id=69130;
UPDATE laus SET name_national=N'Waterford City and County D', name_latin=N'Waterford City and County D', abac_name=N'Waterford City and County D', display_name=N'Waterford City and County D' WHERE id=69131;
UPDATE laus SET name_national=N'Westmeath A', name_latin=N'Westmeath A', abac_name=N'Westmeath A', display_name=N'Westmeath A' WHERE id=69136;
UPDATE laus SET name_national=N'Westmeath B', name_latin=N'Westmeath B', abac_name=N'Westmeath B', display_name=N'Westmeath B' WHERE id=69137;
UPDATE laus SET name_national=N'Westmeath C', name_latin=N'Westmeath C', abac_name=N'Westmeath C', display_name=N'Westmeath C' WHERE id=69138;
UPDATE laus SET name_national=N'Westmeath D', name_latin=N'Westmeath D', abac_name=N'Westmeath D', display_name=N'Westmeath D' WHERE id=69139;
UPDATE laus SET name_national=N'Wexford A', name_latin=N'Wexford A', abac_name=N'Wexford A', display_name=N'Wexford A' WHERE id=69140;
UPDATE laus SET name_national=N'Wexford B', name_latin=N'Wexford B', abac_name=N'Wexford B', display_name=N'Wexford B' WHERE id=69141;
UPDATE laus SET name_national=N'Wexford C', name_latin=N'Wexford C', abac_name=N'Wexford C', display_name=N'Wexford C' WHERE id=69142;
UPDATE laus SET name_national=N'Wexford D', name_latin=N'Wexford D', abac_name=N'Wexford D', display_name=N'Wexford D' WHERE id=69143;
UPDATE laus SET name_national=N'Wicklow A', name_latin=N'Wicklow A', abac_name=N'Wicklow A', display_name=N'Wicklow A' WHERE id=69144;
UPDATE laus SET name_national=N'Wicklow B', name_latin=N'Wicklow B', abac_name=N'Wicklow B', display_name=N'Wicklow B' WHERE id=69145;
UPDATE laus SET name_national=N'Wicklow C', name_latin=N'Wicklow C', abac_name=N'Wicklow C', display_name=N'Wicklow C' WHERE id=69146;
UPDATE laus SET name_national=N'Wicklow D', name_latin=N'Wicklow D', abac_name=N'Wicklow D', display_name=N'Wicklow D' WHERE id=69147;

--142
-- +6 regstrations

--select nuts3, lau1, name_national, name_latin, abac_name, display_name, id 
--from laus where country_code = 'IE' order by name1 asc