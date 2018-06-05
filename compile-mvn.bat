@ECHO ***** Preparing to build the projects...
@C:
@SET "base_folder=C:\DEV\WIFI4EU\workspace\app";
@ECHO ***** Using base folder of the project: %base_folder%

@ECHO rm %base_folder%\wifi4eu-portal\wifi4eu-portal-web\target\wifi4eu.war
@ECHO rm %base_folder%\wifi4eu-public-portal\wifi4eu-public-portal-web\target\wifi4eu.war
@ECHO rm %base_folder%\wifi4eu-public-portal\wifi4eu-public-portal-web\target\ROOT.war

@ECHO ***** Compiling java [app]
cd %base_folder%
CALL mvn clean install -P ng-build-win
@ECHO ***** Finished [app]

cp %base_folder%\wifi4eu-public-portal\wifi4eu-public-portal-web\target\wifi4eu-public.war %base_folder%\wifi4eu-public-portal\wifi4eu-public-portal-web\target\ROOT.war

PAUSE
