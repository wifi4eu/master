# wifi4eu-abac

To run the code, first compile angular dependencies:

$ cd <base-dir>\app\wifi4eu-abac\src\main\angular
$ npm install

Secondly, compile the java with maven:

$ cd <base-dir>\app\wifi4eu-abac
$ mvn clean install -e -Png-build-win

The generated war will be in:


The datasource jndi name configured in WLS should be:
jdbc/Wifi4euAbacDataSource

