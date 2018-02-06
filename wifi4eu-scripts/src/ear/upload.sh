#!/usr/bin/env bash

PEM=~/.ssh/wifi4eu-test.pem
DIR=$(dirname "${BASH_SOURCE[0]}")
TARGET=${DIR}/../../../wifi4eu-ear/target
EAR=${TARGET}/wifi4eu.ear

if [ ! -f ${PEM} ]; then
  echo "[INFO] Copying wifi4eu-test.pem into ~/.ssh directory"
  cp ${DIR}/wifi4eu-test.pem ~/.ssh/
  echo "[INFO] Changing permissions to wifi4eu-test.pem"
  chmod 400 ~/.ssh//wifi4eu-test.pem
  echo "[INFO] Adding rules to ~/.ssh/config"
  echo -e "Host *wifi4eu.everisdigitalchannels.com\nIdentityFile ~/.ssh/wifi4eu-test.pem\nUser ec2-user" >> ~/.ssh/config
fi

scp ${EAR} ec2-user@wifi4eu.everisdigitalchannels.com:~/ears >> ${DIR}/upload.log.tmp & PID=$!
echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] Uploading EAR to server"
echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO] This may take a while, please be patient while is running"
printf "["
while kill -0 $PID 2> /dev/null; do
    printf  "▓"
    sleep 1
done
printf "]"
echo -e "\n"
OUT=$?
if [ $OUT = 0 ]; then
    echo "[INFO] Successfully uploaded wifi4eu.ear"
else
    echo "[ERROR] Failed uploaded wifi4eu.ear"
fi
rm -rf ${DIR}/upload.log.tmp