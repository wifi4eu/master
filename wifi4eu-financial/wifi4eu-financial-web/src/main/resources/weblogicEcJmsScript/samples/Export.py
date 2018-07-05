connect('weblogic','Jaguar*82','t3://localhost:7001')
domainRuntime()
cd('/DomainServices/DomainRuntimeService/DomainConfiguration/base_domain2/SecurityConfiguration/base_domain2/DefaultRealm/myrealm/AuthenticationProviders/DefaultAuthenticator')
cmo.exportData('DefaultAtn','C:/Users/dcarrasg/Desktop/export.properties', Properties())