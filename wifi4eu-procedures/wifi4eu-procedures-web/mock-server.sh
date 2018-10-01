#!/bin/bash
sh -c 'node src/mock/mock-server.js & cd src/main/angular; ng serve --proxy-config proxy.conf.json & wait'