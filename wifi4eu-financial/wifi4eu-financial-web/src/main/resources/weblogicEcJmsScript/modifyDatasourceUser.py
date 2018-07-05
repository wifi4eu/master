from eu.cec.digit.wlst.tools import Importer
from eu.cec.digit.wlst.utils import Utils

#user="berghmc", pass=???
connect(url='t3://wlts0275.cc.cec.eu.int:1041');

edit()
startEdit()

cd('/JDBCSystemResources/Wifi4euAbacDataSource/JDBCResource/Wifi4euAbacDataSource/JDBCDriverParams/Wifi4euAbacDataSource')
set('PasswordEncrypted','wf3z+38d')
cd('/JDBCSystemResources/Wifi4euAbacDataSource/JDBCResource/Wifi4euAbacDataSource/JDBCDriverParams/Wifi4euAbacDataSource/Properties/Wifi4euAbacDataSource/Properties/user')
set('Value','WIFI4EU_ABAC')

save()
activate()
activate(block="true")              
