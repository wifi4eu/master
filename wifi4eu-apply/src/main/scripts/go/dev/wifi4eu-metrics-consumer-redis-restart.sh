#!/bin/bash

PIDGO=`pidof wifi4eu-metrics-consumer-redis`;
echo $PIDGO

if [ ! x$PIDGO = "x" ] ; then
	echo "Restarting METRICS" ; 
	kill $PIDGO;
fi

nohup go run /home/devel/wifi4eu-metrics-consumer-redis.go &> logging/go-metrics.out&

