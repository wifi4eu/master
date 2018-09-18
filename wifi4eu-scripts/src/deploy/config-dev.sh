# Parameters
ENV=DEV
LOCAL_SOURCECODE=/Users/rgarcita/Proyectos/wifi4EU
REMOTE_COPYFOLDER=/home/aperez/deploy/auto
FO_WAR1_FOLDER=/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/target/*.war
FO_WAR2_FOLDER=/wifi4eu/wifi4eu-public-portal/wifi4eu-public-portal-web/target/*.war
FO_TOMCAT_1_CRED=aperez@10.0.2.13
FO_TOMCAT_2_CRED=aperez@10.0.2.14
FO_TOMCAT_LIST="$FO_TOMCAT_1_CRED $FO_TOMCAT_2_CRED"
FO_TOMCAT_PATH=/opt/tomcat
FO_TOMCAT_SERVICE=tomcat
BO_WAR1_FOLDER=/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/target/*.war
BO_TOMCAT_1_CRED=aperez@10.0.4.244
BO_TOMCAT_PATH=/opt/tomcat-latest
BO_TOMCAT_SERVICE=tomcat
VARNISH_1_CRED=everis@10.0.2.4
VARNISH_2_CRED=everis@10.0.2.5

PEM_FO_CERT_PATH=/Users/rgarcita/security/wifi4eu-dev/aperez.pem
PEM_BO_CERT_PATH=/Users/rgarcita/security/wifi4eu-dev/client-acc-dev.pem
PEM_VARNISH_CERT_PATH=/Users/rgarcita/security/wifi4eu-dev/azurevm.pem