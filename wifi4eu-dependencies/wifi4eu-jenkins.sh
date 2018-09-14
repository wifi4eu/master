#!/bin/bash
#echo "Install angular"
#npm install -g @angular/cli@latest
echo "Check angular version"
/usr/lib/node_modules/@angular/cli/bin/ng -v
#echo "Config EC Dev Ops repo"
npm config set "//ecdevops.eu/repository/npm-all/:_authToken=828d555c-441f-3ee2-8ec5-8fe715c389f2"
npm config set registry https://ecdevops.eu/repository/npm-all/
echo "NPM install on angular folders"
if [[ $2 = "" || $2 = *"wifi4eu-portal"* ]]; then
npm install --prefix ./wifi4eu-portal/wifi4eu-portal-web/src/main/angular/
fi
if [[ $2 = "" || $2 = *"wifi4eu-public-portal"* ]]; then
npm install --prefix ./wifi4eu-public-portal/wifi4eu-public-portal-web/src/main/angular/
fi
if [[ $2 = "" || $2 = *"wifi4eu-dgconn"* ]]; then
npm install --prefix ./wifi4eu-dgconn/wifi4eu-dgconn-web/src/main/angular/
fi
if [[ $2 = "" || $2 = *"wifi4eu-supplier"* ]]; then
npm install --prefix ./wifi4eu-supplier/wifi4eu-supplier-web/src/main/angular/
fi
if [[ $2 = "" || $2 = *"wifi4eu-financial"* ]]; then
npm install --prefix ./wifi4eu-financial/wifi4eu-financial-web/src/main/angular/
fi
#echo "Install ecas-tomcat-8.0 dependency"
/usr/local/lib/apache-maven/bin/mvn install:install-file -Dfile=wifi4eu-dependencies/ecas-tomcat-8.0-4.24.0-20180320.004350-3.jar  -DgroupId=eu.europa.ec.digit.iam.ecas.client -DartifactId=ecas-tomcat-8.0 -Dversion=4.24.0 -Dpackaging=jar
#echo "Install cns-client dependency"
/usr/local/lib/apache-maven/bin/mvn install:install-file -Dfile=wifi4eu-dependencies/cns-client-1.1.jar  -DgroupId=eu.europa.ec.digit.cns -DartifactId=cns-client -Dversion=1.1 -Dpackaging=jar
echo "Compile project"
echo "Environment: $1"
echo "Modules: $2"
/usr/local/lib/apache-maven/bin/mvn clean install -U -Png-build-jenkins,!full-build,$1,$2
