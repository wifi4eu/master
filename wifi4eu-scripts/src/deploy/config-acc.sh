# Parameters
ENV=ACC
LOCAL_SOURCECODE=/Users/rgarcita/Proyectos/wifi4EU
REMOTE_COPYFOLDER=/home/client-acc-dev/deploy/auto
FO_WAR1_FOLDER=/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/target/*.war
FO_WAR2_FOLDER=/wifi4eu/wifi4eu-public-portal/wifi4eu-public-portal-web/target/*.war
FO_TOMCAT_1_CRED=client-acc-dev@202.3.1.4
FO_TOMCAT_2_CRED=client-acc-dev@202.3.1.5
FO_TOMCAT_LIST="$FO_TOMCAT_1_CRED $FO_TOMCAT_2_CRED"
FO_TOMCAT_PATH=/opt/tomcat
FO_TOMCAT_SERVICE=tomcat
BO_WAR1_FOLDER=/wifi4eu/wifi4eu-dgconn/wifi4eu-dgconn-web/target/*.war
BO_TOMCAT_1_CRED=client-acc-dev@202.3.3.7
BO_TOMCAT_PATH=/opt/tomcat-latest
BO_TOMCAT_SERVICE=tomcat
VARNISH_1_CRED=client-acc-dev@202.3.3.4
VARNISH_2_CRED=client-acc-dev@202.3.3.5
REDIS_1_CRED=client-acc-dev@202.3.2.11
REDIS_2_CRED=client-acc-dev@202.3.2.12
REDIS_3_CRED=client-acc-dev@202.3.2.13
REDIS_LIST="$REDIS_1_CRED $REDIS_2_CRED $REDIS_3_CRED"

PEM_REDIS_CERT_PATH=/home/cliente/security/jenkins-pems/client-acc-dev.pem
PEM_FO_CERT_PATH=/home/cliente/security/jenkins-pems/client-acc-dev.pem
PEM_BO_CERT_PATH=/home/cliente/security/jenkins-pems/client-acc-dev.pem
PEM_VARNISH_CERT_PATH=/home/cliente/security/jenkins-pems/client-acc-dev.pem