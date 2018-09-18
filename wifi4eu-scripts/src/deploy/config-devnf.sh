# Parameters
ENV=DEVNF
LOCAL_SOURCECODE=.
REMOTE_COPYFOLDER=/home/everis/deploy/auto
FO_WAR1_FOLDER=/wifi4eu-portal/wifi4eu-portal-web/target/*.war
FO_WAR2_FOLDER=/wifi4eu-public-portal/wifi4eu-public-portal-web/target/*.war
FO_TOMCAT_1_CRED=everis@202.1.1.4
FO_TOMCAT_2_CRED=everis@202.1.1.4
FO_TOMCAT_LIST="$FO_TOMCAT_1_CRED $FO_TOMCAT_2_CRED"
FO_TOMCAT_PATH=/opt/tomcat-latest
BO_WAR1_FOLDER=/wifi4eu-portal/wifi4eu-portal-web/target/*.war
BO_TOMCAT_1_CRED=everis@202.1.1.4
BO_TOMCAT_PATH=/opt/tomcat-latest
VARNISH_1_CRED=everis@202.1.1.4
VARNISH_2_CRED=everis@202.1.1.4

PEM_FO_CERT_PATH=/usr/local/lib/security/jenkins-pems/azurevm.pem
PEM_BO_CERT_PATH=/usr/local/lib/security/jenkins-pems/azurevm.pem
PEM_VARNISH_CERT_PATH=/usr/local/lib/security/jenkins-pems/azurevm.pem