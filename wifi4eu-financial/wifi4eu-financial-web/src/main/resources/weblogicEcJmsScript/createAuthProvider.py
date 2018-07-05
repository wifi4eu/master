from eu.cec.digit.wlst.tools import Importer
from eu.cec.digit.wlst.utils import Utils

#user="berghmc", pass=???
connect(url='t3://wlts0275.cc.cec.eu.int:1041');

edit()
startEdit()

cd('/SecurityConfiguration/WIFI4EU_TEST/Realms/myrealm')
cmo.createAuthenticationProvider('EcasIdentityAsserterV2', 'eu.cec.digit.ecas.client.j2ee.weblogic.EcasIdentityAsserterV2')

cd('/SecurityConfiguration/WIFI4EU_TEST/Realms/myrealm/AuthenticationProviders/EcasIdentityAsserterV2')
cmo.setControlFlag('OPCIONAL')

save()
activate()
activate(block="true")
