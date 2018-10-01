# Readme: Scripts configuration for the GATE

## REDIS

### Update configuration

Copy the files in:
/wifi4eu-apply/src/main/scripts/redis/<ENV-NODE>/

to the following in the remote machine:
/home/<USER>/redis

### Start/Restart REDIS

```
[devel@AZ-W4EDEVLIAMQ03 ~]$ sh redis/wifi4eu-redis-restart.sh

Starting redis-server

Starting redis-sentinel
```

### Stop Go script

kill all related processes

### Check if REDIS is running

Processes should look like:
```
[devel@AZW4EDEVLIAMQ02 ~]$ ps aux | grep redis
devel     52521  0.0  0.0 156348  2944 pts/0    Sl   14:31   0:00 redis-server *:9000
devel     52526  0.2  0.0 153788  2868 pts/0    Sl   14:31   0:00 redis-server 10.0.2.32:5000 [sentinel]
devel     52534  0.0  0.0 112660   972 pts/0    S+   14:31   0:00 grep --color=auto redis
```


## HA PROXY

### Update configuration

Copy the files in:
/wifi4eu-apply/src/main/scripts/haproxy/<ENV>/

to the following in the remote machine:
/home/<USER>/haproxy

Then, copy the configuration itno HA PROXY
```
[devel@az-w4edevliamq01 ~]$ sudo cp haproxy/haproxy.cfg /etc/haproxy/
```

### Start HA Proxy

```
[devel@AZW4EDEVLIAMQ02 ~]$ sudo service haproxy start
Redirecting to /bin/systemctl start haproxy.service
```

### Stop HA Proxy

```
[devel@AZW4EDEVLIAMQ02 ~]$ sudo service haproxy stop
Redirecting to /bin/systemctl stop haproxy.service
```

### Check if HA Proxy is running

Processes should look like:
```
[devel@az-w4edevliamq01 ~]$ ps aux |grep proxy
root      80529  0.0  0.0  44676  1716 ?        Ss   Aug29   0:00 /usr/sbin/haproxy-systemd-wrapper -f /etc/haproxy/haproxy.cfg -p /run/haproxy.pid
haproxy   80530  0.0  0.0  83064  7008 ?        S    Aug29   0:00 /usr/sbin/haproxy -f /etc/haproxy/haproxy.cfg -p /run/haproxy.pid -Ds
haproxy   80531  0.0  0.9 147532 76012 ?        Ss   Aug29  18:03 /usr/sbin/haproxy -f /etc/haproxy/haproxy.cfg -p /run/haproxy.pid -Ds
```


## GO SCRIPT (GATE)

### Update configuration

Copy the files in:
/wifi4eu-apply/src/main/scripts/go/<ENV>/

to the following folder in the remote machine:
/home/<USER>

### Start/Restart Go script

```

[devel@AZ-W4EDEVLIAMQ03 ~]$ sudo sh wifi4eu-gate-restart.sh


```

### Stop Go script

kill all related processes

### Check if Go script is running

Processes should look like:
```
[devel@AZW4EDEVLIAMQ02 ~]$ ps aux | grep go
root      38503  0.0  0.0 456840  8044 ?        Sl   Sep18   0:04 go run /home/devel/wifi4eu-gate-redis-sync.go
root      38603  0.0  0.1 351152  8872 ?        Sl   Sep18   0:54 /tmp/go-build478238943/command-line-arguments/_obj/exe/wifi4eu-gate-redis-sync
```



