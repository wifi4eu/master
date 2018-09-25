--CZ DELETE
DELETE FROM laus WHERE id = 5042;
DELETE FROM laus WHERE id = 5041;
DELETE FROM laus WHERE id = 5127;
DELETE FROM laus WHERE id = 5659;

--CZ INSERT
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ020', '531359', 'no', N'Horky (Kutná Hora)', N'Horky (Kutná Hora)' , N'Horky (Kutná Hora)', N'Horky (Kutná Hora)', N'Horky (Kutna Hora)', N'Horky (Kutná Hora)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ053', '578053', 'no', N'Horky (Svitavy)', N'Horky (Svitavy)' , N'Horky (Svitavy)', N'Horky (Svitavy)', N'Horky (Svitavy)', N'Horky (Svitavy)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ071', '569542', 'no', N'Horní Újezd (Přerov)', N'Horní Újezd (Přerov)' , N'Horní Újezd (Přerov)', N'Horní Újezd (Přerov)', N'Horni Ujezd (Prerov)', N'Horní Újezd (Přerov)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ064', '581739', 'no', N'Knínice u Boskovic', N'Knínice u Boskovic' , N'Knínice u Boskovic', N'Knínice u Boskovic', N'Kninice u Boskovic', N'Knínice u Boskovic');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ063', '514055', 'no', N'Kojetín (Přerov)', N'Kojetín (Přerov)' , N'Kojetín (Přerov)', N'Kojetín (Přerov)', N'Kojetín (Prerov)', N'Kojetín (Přerov)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ020', '532533', 'no', N'Ledce (Kladno)', N'Ledce (Kladno)' , N'Ledce (Kladno)', N'Ledce (Kladno)', N'Ledce (Kladno)', N'Ledce (Kladno)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ064', '594393', 'no', N'Lukov (Znojmo)', N'Lukov (Znojmo)' , N'Lukov (Znojmo)', N'Lukov (Znojmo)', N'Lukov (Znojmo)', N'Lukov (Znojmo)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ051', '546593', 'no', N'Nová Ves (Liberec)', N'Nová Ves (Liberec)' , N'Nová Ves (Liberec)', N'Nová Ves (Liberec)', N'Nová Ves (Liberec)', N'Nová Ves (Liberec)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ080', '589870', 'no', N'Pěnčín (Prostějov)', N'Pěnčín (Prostějov)' , N'Pěnčín (Prostějov)', N'Pěnčín (Prostějov)', N'Pencín (Prostejov)', N'Pěnčín (Prostějov)');
INSERT INTO laus (country_code, nuts3, lau1, _change, name1, name2, name_national, name_latin, abac_name, display_name) values ('CZ', 'CZ063', '596922', 'no', N'Újezd (Žďár nad Sázavou)', N'Újezd (Žďár nad Sázavou)' , N'Újezd (Žďár nad Sázavou)', N'Újezd (Žďár nad Sázavou)', N'Ujezd (Zdar nad Sazavou)', N'Újezd (Žďár nad Sázavou)');

--EE NUTS3 --we leave as it's in v14

--EL CHANGE NAMES
UPDATE laus SET name_national=N'ΔΗΜΟΣ ΚΑΜΕΝΩΝ ΒΟΥΡΛΩΝ', name_latin=N'Municipality of Kamena Vourla', abac_name=N'DEMOS KAMENA VOURLA', display_name=N'ΔΗΜΟΣ ΚΑΜΕΝΩΝ ΒΟΥΡΛΩΝ-Municipality of Kamena Vourla' WHERE id=21178;
UPDATE laus SET name_national=N'ΔΗΜΟΣ ΜΕΤΕΩΡΩΝ', name_latin=N'Municipality of Meteora', abac_name=N'DEMOS METEORA', display_name=N'ΔΗΜΟΣ ΜΕΤΕΩΡΩΝ-Municipality of Meteora' WHERE id=21170;

--FR DELETE
delete from municipalities where id in(20059,20953);
delete laus where id in (48941, 45040, 60642, 60647, 45908, 39936, 56831, 38451, 35547, 44328, 58293, 29948, 53042, 47303, 39501, 64677, 47304, 48147, 44228, 46582, 47597, 39618, 39823, 37307, 31579, 57067, 57068, 57069, 57070, 57071, 57072, 57073, 57074, 57075, 34275, 34276, 34277, 34278, 34279, 34280, 34281, 34266, 34267, 34268, 34269, 34270, 34271, 34272, 34273, 34274, 45979, 40097, 53127, 53139, 53149, 48273, 45188, 59122, 59123, 59124, 59125, 59126, 59127, 59128, 59129, 59130, 59131, 59113, 59132, 59114, 59115, 59116, 59117, 59118, 59119, 59120, 59121, 34649, 41316, 45218, 35336, 45223, 43606, 35347, 60817, 31669, 39746, 56988, 35791, 46695, 47375, 35828, 46073, 53271, 39830, 39835, 44668, 38863, 52897, 48500, 46101, 56420);

--FR DUPLICATES
UPDATE laus SET name_national=N'Le Breuil (Allier)', name_latin=N'Le Breuil (Allier)', abac_name=N'Le Breuil (Allier)', display_name=N'Le Breuil (Allier)' WHERE id=31071;
UPDATE laus SET name_national=N'Le Breuil (Marne)', name_latin=N'Le Breuil (Marne)', abac_name=N'Le Breuil (Marne)', display_name=N'Le Breuil (Marne)' WHERE id=47973;
UPDATE laus SET name_national=N'Le Breuil (Rhône)', name_latin=N'Le Breuil (Rhône)', abac_name=N'Le Breuil (Rhône)', display_name=N'Le Breuil (Rhône)' WHERE id=56810;
UPDATE laus SET name_national=N'Le Breuil (Saône-et-Loire)', name_latin=N'Le Breuil (Saône-et-Loire)', abac_name=N'Le Breuil (Saône-et-Loire)', display_name=N'Le Breuil (Saône-et-Loire)' WHERE id=57674;

--RO OK
--SK-duplicates leave it as it is 

--122