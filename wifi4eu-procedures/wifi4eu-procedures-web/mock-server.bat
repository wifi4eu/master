@echo off
start node %~dp0src/mock/mock-server.js
start /d %~dp0src\main\angular ng serve --proxy-config proxy.conf.json

echo Press any key to quit the mock server...
pause >nul

wmic process where (CommandLine like 'node %%src/mock/mock-server.js') get ProcessId | findstr /rc:[0-9] > mock-server-pid.txt
set /p pid= < mock-server-pid.txt
taskkill /F /PID %pid% >nul
del mock-server-pid.txt

wmic process where (CommandLine like 'node%%\\ng%%serve%%--proxy-config%%proxy.conf.json%%') get ProcessId | findstr /rc:[0-9] > mock-server-pid.txt
set /p pid= < mock-server-pid.txt
taskkill /F /PID %pid% >nul
del mock-server-pid.txt

wmic process where (Caption='cmd.exe' AND CommandLine like '%%/K ng %%serve%%') get ProcessId | findstr /rc:[0-9] > mock-server-pid.txt
set /p pid= < mock-server-pid.txt
taskkill /F /PID %pid% >nul
del mock-server-pid.txt

echo Mock server has been shut down.