--select * from nuts where label like '%B_ORDER%'
update nuts set label = 'Border, Midland and Western' where code = 'IE01';
update nuts set label = 'Border' where code = 'IE011';
update nuts set label = 'Scottish Borders' where code= 'UKM24';


--THIS SCRIPT WAS RUN ON ACC on 02/10
--select * from organizations where country='IE' and id=25
update organizations set name='Dún Laoghaire – Rathdown' where country='IE' and id=25;


