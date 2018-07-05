from eu.cec.digit.wlst.tools import Importer
from eu.cec.digit.wlst.utils import Utils

import sys


#connect(url='t3://localhost:7001')
connect(url='t3://wlts0275.cc.cec.eu.int:1041');
edit()
startEdit()
  
cd('/SystemResources/Wifi4euAbacDataSource')
#set('Targets',jarray.array([ObjectName('com.bea:Name=AdminServer,Type=Server')], ObjectName))	
set('Targets',jarray.array([ObjectName('com.bea:Name=WIFI4EU_TESTms11,Type=Server')], ObjectName))	
   
save()
activate()

