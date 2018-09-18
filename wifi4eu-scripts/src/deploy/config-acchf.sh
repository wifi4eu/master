# Parameters
ENV=ACCHF
LOCAL_SOURCECODE=/Users/rgarcita/Proyectos/wifi4EU
REMOTE_COPYFOLDER=/home/client-acc-dev/deploy/auto
FO_WAR1_FOLDER=/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/target/*.war
FO_WAR2_FOLDER=/wifi4eu/wifi4eu-public-portal/wifi4eu-public-portal-web/target/*.war
FO_TOMCAT_1_CRED=client-acc-dev@202.3.1.11
FO_TOMCAT_2_CRED=client-acc-dev@202.3.1.12
FO_TOMCAT_3_CRED=client-acc-dev@202.3.1.13
FO_TOMCAT_4_CRED=client-acc-dev@202.3.1.14
FO_TOMCAT_LIST="$FO_TOMCAT_1_CRED $FO_TOMCAT_2_CRED $FO_TOMCAT_3_CRED $FO_TOMCAT_4_CRED"
FO_TOMCAT_PATH=/opt/tomcat
FO_TOMCAT_SERVICE=tomcat
BO_WAR1_FOLDER=/wifi4eu/wifi4eu-dgconn/wifi4eu-dgconn-web/target/*.war
BO_TOMCAT_1_CRED=client-acc-dev@202.3.3.8
BO_TOMCAT_PATH=/opt/tomcat-latest
BO_TOMCAT_SERVICE=tomcat
VARNISH_1_CRED=client-acc-dev@202.3.3.11
VARNISH_2_CRED=client-acc-dev@202.3.3.12

PEM_FO_CERT_PATH=/Users/rgarcita/security/wifi4eu-dev/client-acc-dev.pem
PEM_BO_CERT_PATH=/Users/rgarcita/security/wifi4eu-dev/client-acc-dev.pem
PEM_VARNISH_CERT_PATH=/Users/rgarcita/security/wifi4eu-dev/client-acc-dev.pem