#!/bin/bash
echo "Install angular"
npm install -g @angular/cli@latest
echo "Check angular version"
ng -v
echo "Config EC Dev Ops repo"
npm config set "//ecdevops.eu/repository/npm-all/:_authToken=828d555c-441f-3ee2-8ec5-8fe715c389f2"
npm config set registry https://ecdevops.eu/repository/npm-all/
echo "NPM install on angular folders"
npm install --prefix ./wifi4eu-portal/wifi4eu-portal-web/src/main/angular/
npm install --prefix ./wifi4eu-public-portal/wifi4eu-public-portal-web/src/main/angular/
echo "Install ECAS dependency"
mvn install:install-file -Dfile=wifi4eu-dependencies/ecas-tomcat-8.0-4.17.1.jar  -DgroupId=eu.europa.ec.digit.iam.ecas.client -DartifactId=ecas-tomcat-8.0 -Dversion=4.17.1 -Dpackaging=jar
echo "Compile project"
mvn clean install -Png-build-mac -PTEST
