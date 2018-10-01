# Parameters
ENV=PROD
LOCAL_SOURCECODE=/Users/rgarcita/Proyectos/wifi4EU
REMOTE_COPYFOLDER=/home/devel/deploy/auto
FO_WAR1_FOLDER=/wifi4eu/wifi4eu-portal/wifi4eu-portal-web/target/*.war
FO_WAR2_FOLDER=/wifi4eu/wifi4eu-public-portal/wifi4eu-public-portal-web/target/*.war
FO_WAR3_FOLDER=/wifi4eu-supplier/wifi4eu-supplier-web/target/*.war
FO_TOMCAT_1_CRED=devel@10.0.2.15
FO_TOMCAT_2_CRED=
FO_TOMCAT_LIST="$FO_TOMCAT_1_CRED"
FO_TOMCAT_PATH=/opt/tomcat-latest
BO_WAR1_FOLDER=/wifi4eu/wifi4eu-dgconn/wifi4eu-dgconn-web/target/*.war
BO_TOMCAT_1_CRED=
BO_TOMCAT_PATH=/opt/tomcat-latest
VARNISH_1_CRED=devel@10.0.2.6
VARNISH_2_CRED=devel@10.0.2.6
REDIS_1_CRED=client-acc-dev@202.3.2.11
REDIS_2_CRED=client-acc-dev@202.3.2.12
REDIS_3_CRED=client-acc-dev@202.3.2.13
REDIS_LIST=""

PEM_REDIS_CERT_PATH=/Users/rgarcita/security/wifi4eu-prod/devel.pem
PEM_FO_CERT_PATH=/Users/rgarcita/security/wifi4eu-prod/devel.pem
PEM_BO_CERT_PATH=/Users/rgarcita/security/wifi4eu-prod/devel.pem
PEM_VARNISH_CERT_PATH=/Users/rgarcita/security/wifi4eu-prod/devel.pem