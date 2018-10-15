--select * from nuts where label like '%B_ORDER%'
update nuts set label = 'Border, Midland and Western' where code = 'IE01';
update nuts set label = 'Border' where code = 'IE011';
update nuts set label = 'Scottish Borders' where code= 'UKM24';


--select * from organizations where country='IE' and id=25
update organizations set name='Dún Laoghaire - Rathdown' where country='IE' and id=25;
--select * from organizations where country='UK' and id=89;
update organizations set name='Combined Authority' where country='UK' and id=89;
--select * from organizations where country='UK' and id=91
update organizations set name='County Council' where country='UK' and id=91



