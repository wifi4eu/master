@echo off
where /q npm
if ERRORLEVEL 1 (
    echo ***************************************
    echo * NPM is not installed!               *
    echo * Please download and install Node.js *
    echo ***************************************
    goto end
)

where /q ng
if ERRORLEVEL 1 (
    echo *******************************************
    echo * Please hold on.                         *
    echo * Installing Angular CLI takes a while... *
    echo *******************************************
    @echo on
    cmd /c npm install -g angular-cli
    @echo off
)

where /q yarn
if ERRORLEVEL 1 (
    echo *******************************************
    echo * Please hold on.                         *
    echo * Installing Yarn...                      *
    echo *******************************************
    @echo on
    cmd /c npm install -g yarn
    @echo off
)

echo ****************************************************************
echo * Please hold on.                                              *
echo * Installing an Angular CLI-based application takes a while... *
echo ****************************************************************
pushd src\main\angular
@echo on
cmd /c yarn
@echo off
popd

echo *******************************************************
echo * The Angular CLI-based application is now installed. *
echo *******************************************************

:end