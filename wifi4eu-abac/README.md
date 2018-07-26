# Readme

## Angular requirements

Check npm version:
```
<projecFolder>\app\wifi4eu-abac\src\main\eui> node -v
v4.6.1
```

If you need to update it:
```
<projecFolder>\app\wifi4eu-abac\src\main\eui> npm install -g npm@4.6.1
```

Make sure you have eUI registry set to your NPM configuration
npm set registry = "https://ecdevops.eu/repository/npm-all/"

Check node version:
```
<projecFolder>\app\wifi4eu-abac\src\main\eui> node -v
v8.9.4
```

Check ng version:
```
<projecFolder>\app\wifi4eu-abac\src\main\eui> ng -v
Your global Angular CLI version (1.5.3) is greater than your local
version (1.2.0). The local Angular CLI version is used.

To disable this warning use "ng set --global warnings.versionMismatch=false".
    _                      _                 ____ _     ___
   / \   _ __   __ _ _   _| | __ _ _ __     / ___| |   |_ _|
  / △ \ | '_ \ / _` | | | | |/ _` | '__|   | |   | |    | |
 / ___ \| | | | (_| | |_| | | (_| | |      | |___| |___ | |
/_/   \_\_| |_|\__, |\__,_|_|\__,_|_|       \____|_____|___|
               |___/
@angular/cli: 1.2.0
node: 8.9.4
os: win32 x64
@angular/common: 4.2.6
@angular/compiler: 4.2.6
@angular/core: 4.2.6
@angular/forms: 4.2.6
@angular/http: 4.2.6
@angular/platform-browser: 4.2.6
@angular/platform-browser-dynamic: 4.2.6
@angular/router: 4.2.6
@angular/cli: 1.2.0
@angular/compiler-cli: 4.2.6
```

Install dependencies:
```
<projecFolder>\app\wifi4eu-abac\src\main\eui> npm install
```

## Build WAR for weblogic

To execute a full build (angular and java), run:
```
<projecFolder>\app\wifi4eu-abac> mvn clean package -Pnpm-build,weblogic
```

To execute a build of the java code (weblogic profile is enabled by default), run:
```
<projecFolder>\app\wifi4eu-abac> mvn clean package
```

## Deploy WAR in weblogic

Access to Weblogic Console, then to deployments. Click "Install" and select the WAR file (should be in "<projecFolder>\app\wifi4eu-abac\target\wifi4eu-financial.war").
Select the option "Install this deployment as an application" and "Finish".

You should be able to access the application using the following URL (default values):
http://localhost:7001/wifi4eu/


