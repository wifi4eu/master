#!/bin/bash

PIDGO=`pidof wifi4eu-gate-redis-sync`;
echo $PIDGO

if [ ! x$PIDGO = "x" ] ; then
	echo "Restarting GATE"; 
	kill $PIDGO;
fi

nohup go run /home/devel/wifi4eu-gate-redis-sync.go &> logging/go.out&

