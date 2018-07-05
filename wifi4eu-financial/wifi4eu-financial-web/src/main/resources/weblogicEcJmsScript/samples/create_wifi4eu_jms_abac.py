import time
import getopt
import sys
import re


# Connect to the WIFI4EU_TESTserver.
connect('berghmc', 'Vulkaan03', 'http://wlts0275.cc.cec.eu.int:1041')
#connect('berghmc', 'Wifi4EU2018', 'http://wlts0275.cc.cec.eu.int:1041')


# Creating a JMS Server

edit()
startEdit()
cd('/')
print 'Creating JMS Server.'
cmo.createJMSServer('JMSServer')
cd('/JMSServers/JMSServer')
cmo.addTarget(getMBean('/Servers/WIFI4EU_TESTserver'))
activate()


#Creating a FileStores

startEdit()
cd('/')
cmo.createFileStore('WseeFileStore')
cd('/Deployments/WseeFileStore')
cmo.setDirectory('WseeFileStore')
set('Targets',jarray.array([ObjectName('com.bea:Name=WIFI4EU_TESTserver,Type=Server')], ObjectName))
activate()

startEdit()
cd('/')
cmo.createFileStore('WseeJaxwsFileStore')
cd('/Deployments/WseeJaxwsFileStore')
cmo.setDirectory('WseeJaxwsFileStore')
set('Targets',jarray.array([ObjectName('com.bea:Name=WIFI4EU_TESTserver,Type=Server')], ObjectName))
activate()

startEdit()
cd('/')
cmo.createFileStore('WseeSoapjmsFileStore')
cd('/Deployments/WseeSoapjmsFileStore')
cmo.setDirectory('WseeSoapjmsFileStore')
set('Targets',jarray.array([ObjectName('com.bea:Name=WIFI4EU_TESTserver,Type=Server')], ObjectName))
activate()


#Creating a SAF Agent

startEdit()
cd('/')
cmo.createSAFAgent('ReliableWseeSAFAgent')
cd('/SAFAgents/ReliableWseeSAFAgent')
cmo.setStore(getMBean('/Deployments/WseeFileStore'))
set('Targets',jarray.array([ObjectName('com.bea:Name=WIFI4EU_TESTserver,Type=Server')], ObjectName))
#cmo.setServiceType('Sending-only')
cmo.setServiceType('Both')
activate()


#Creating a Jaxws SAF Agent

startEdit()
cd('/')
cmo.createSAFAgent('ReliableWseeJaxwsSAFAgent')
cd('/SAFAgents/ReliableWseeJaxwsSAFAgent')
cmo.setStore(getMBean('/Deployments/WseeJaxwsFileStore'))
set('Targets',jarray.array([ObjectName('com.bea:Name=WIFI4EU_TESTserver,Type=Server')], ObjectName))
cmo.setServiceType('Both')
activate()


# Creating a Module

startEdit()
cd('/')
cmo.createJMSSystemResource('BudgSvcModule')
cd('/JMSSystemResources/BudgSvcModule')
cmo.addTarget(getMBean('/Servers/WIFI4EU_TESTserver'))
cmo.createSubDeployment('Budg')
activate()


# Creating Queue

startEdit()
print 'Creating Queue'
cd('/')
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule')
cmo.createQueue('BudgResponseQ')
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/Queues/BudgResponseQ')
set('JNDIName','jms/LSY_WIFI4EU_BudgSoaRemoteQueue')
set('SubDeploymentName','Budg')
cd('/JMSSystemResources/BudgSvcModule/SubDeployments/Budg')
cmo.addTarget(getMBean('/JMSServers/JMSServer'))
activate()


# Creating JMS Connection Factory XA

startEdit()
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule')
cmo.createConnectionFactory('localQCF')
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/ConnectionFactories/localQCF')
cmo.setJNDIName('jms/localQCF')
cmo.setDefaultTargetingEnabled(true)
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/ConnectionFactories/localQCF/SecurityParams/localQCF')
cmo.setAttachJMSXUserId(false)
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/ConnectionFactories/localQCF/TransactionParams/localQCF')
cmo.setTransactionTimeout(3600)
cmo.setXAConnectionFactoryEnabled(true)
activate()


#Remote SAF Context

startEdit()
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule')
cmo.createSAFRemoteContext('BudgSAFContext')
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/SAFRemoteContexts/BudgSAFContext/SAFLoginContext/BudgSAFContext')
#<----Specify remote server host, user,pwd ------>
cmo.setLoginURL('t3://localhost:7001')
cmo.setUsername('LSY_WIFI4EU')
cmo.setPassword('lsy_wifi4eu_2018')
activate()
 
 
#SAF Destination
 
startEdit()
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule')
cmo.createSAFImportedDestinations('SAFImportedBUDGDestination')
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/SAFImportedDestinations/SAFImportedBUDGDestination')
cmo.setSAFRemoteContext(getMBean('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/SAFRemoteContexts/BudgSAFContext'))
cmo.setSAFErrorHandling(None)
cmo.setTimeToLiveDefault(0)
cmo.setUseSAFTimeToLiveDefault(false)
cmo.setDefaultTargetingEnabled(true)
activate()
 
 
#SAF Queue

startEdit()
cmo.createSAFQueue('BudgRequestQ')
cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/SAFImportedDestinations/SAFImportedBUDGDestination/SAFQueues/BudgRequestQ')
#<---------Specify the remote queue name. Currently configured for EDN Queue------------>
cmo.setRemoteJNDIName('jms/LSY_WIFI4EU_REQ_OUT')
cmo.setNonPersistentQos('At-Least-Once')
cmo.setTimeToLiveDefault(0)
cmo.setUseSAFTimeToLiveDefault(false)
cmo.setUnitOfOrderRouting('Hash')
cmo.setLocalJNDIName('jms/budgRequestQ')
#cd('/JMSSystemResources/BudgSvcModule/JMSResource/BudgSvcModule/SAFImportedDestinations/SAFImportedBUDGDestination/MessageLoggingParams/SAFImportedDestinations')
#cmo.setMessageLoggingEnabled(false)
#cmo.setMessageLoggingEnabled(true)
#cmo.setMessageLoggingFormat('%header%,JMSCorrelationID,JMSDeliveryMode,JMSDestination,JMSExpiration,JMSMessageID,JMSPriority,JMSRedelivered,JMSReplyTo,JMSTimestamp,JMSType,%properties%')
activate()


#User

startEdit()
#startEdit(-1,-1,'false')
serverConfig()
cd('/SecurityConfiguration/WIFI4EU_TEST/Realms/myrealm/AuthenticationProviders/DefaultAuthenticator')
cmo.createUser('LSY_WIFI4EU', 'lsy_wifi4eu_2018', 'wifi4eu-financial user')
#cmo.groupExists('TestGroup')
cmo.createGroup('Administrators','')
cmo.addMemberToGroup('Administrators','LSY_WIFI4EU')
cd('/SecurityConfiguration/WIFI4EU_TEST/Realms/myrealm/RoleMappers/XACMLRoleMapper')
cmo.setRoleExpression('','Admin','Grp(Administrators)')
#cmo.setRoleExpression('','Admin','Grp(TestGroup)|Grp(Administrators)')
edit()
#undo(defaultAnswer='y', unactivatedChanges='true')
#stopEdit('y')

cd('/')

save()
activate()

disconnect()
exit()

#################################################################################################