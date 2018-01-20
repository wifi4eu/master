#!/usr/bin/env bash

rm ../../../../wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/assets/i18n/*.json
rm ../../../../wifi4eu-public-portal/wifi4eu-public-portal-web/src/main/angular/src/assets/i18n/*.json
rm ../../../../wifi4eu-scripts/src/i18n/en.json

cp ./*.json ../../../../wifi4eu-portal/wifi4eu-portal-web/src/main/angular/src/assets/i18n
cp ./*.json ../../../../wifi4eu-public-portal/wifi4eu-public-portal-web/src/main/angular/src/assets/i18n
cp ./en.json ../../../../wifi4eu-scripts/src/i18n/en.json