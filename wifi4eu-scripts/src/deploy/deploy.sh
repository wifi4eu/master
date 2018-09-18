#!/bin/bash
# command line parameter
# get the script directory
mydir="${0%/*}"

# config load

echo $mydir
echo $1

# select environment to get the configuration
if [ $1 == "dev" ];
then
	echo "dev"
    source "$mydir"/config-dev.sh
elif [ $1 == "devnf" ];
then
	echo "devnf"
    source "$mydir"/config-devnf.sh
elif [ $1 == "acc" ];
then
    echo "acc"
    source "$mydir"/config-acc.sh
elif [ $1 == "acchf" ];
then
    echo "acchf";
    source "$mydir"/config-acchf.sh
else
    echo "please, provide valid environment name"
	exit 1
fi

echo $ENV

if [ $2 == "fo" ]
then

    echo "FrontOffice"
    echo $FO_TOMCAT_LIST

    # Copy files to remote Tomcat servers (Add all the FO servers)
    for FO_TOMCAT in $FO_TOMCAT_LIST
    do
        echo "SCP connection to Tomcat"
        echo $FO_TOMCAT
        scp -i  $PEM_FO_CERT_PATH -o StrictHostKeyChecking=no $LOCAL_SOURCECODE$FO_WAR1_FOLDER $FO_TOMCAT:$REMOTE_COPYFOLDER
        scp -i $PEM_FO_CERT_PATH -o StrictHostKeyChecking=no $LOCAL_SOURCECODE$FO_WAR2_FOLDER $FO_TOMCAT:$REMOTE_COPYFOLDER

        # Stop tomcat server
        # Copy files to webapps
        # Start tomcat server
        ssh -i $PEM_FO_CERT_PATH -o StrictHostKeyChecking=no $FO_TOMCAT "uname -a;
        sudo rm -R $FO_TOMCAT_PATH/webapps/*.war;
        sudo rm -fR $FO_TOMCAT_PATH/webapps/ROOT;
        sudo rm -fR $FO_TOMCAT_PATH/webapps/wifi4eu;
        sudo cp $REMOTE_COPYFOLDER/*.war $FO_TOMCAT_PATH/webapps"</dev/null

    done

elif [ $2 = "bo" ]
then

    echo "BackOffice"

    # Copy files to remote Tomcat servers (Add all the BO servers)
    for BO_TOMCAT in $BO_TOMCAT_1_CRED $BO_TOMCAT_2_CRED
    do
        echo "SCP connection to Tomcat"
        echo $BO_TOMCAT
        scp -i $PEM_BO_CERT_PATH -o StrictHostKeyChecking=no $LOCAL_SOURCECODE$BO_WAR1_FOLDER $BO_TOMCAT:$REMOTE_COPYFOLDER

        # Stop tomcat server
        # Copy files to webapps
        # Start tomcat server
        ssh -i $PEM_BO_CERT_PATH -o StrictHostKeyChecking=no $BO_TOMCAT "uname -a;
        sudo rm -R $BO_TOMCAT_PATH/webapps/wifi4eu.war;
        sudo cp $REMOTE_COPYFOLDER/*.war $BO_TOMCAT_PATH/webapps"</dev/null

    done

elif [ $2 = "varnish" ]
then

    echo "Varnish"

    # Restart varnish

    for VARNISH_CRED in $VARNISH_1_CRED $VARNISH_2_CRED
    do
        echo "SSH connection to Varnish"
        echo $VARNISH_CRED
        ssh -i $PEM_VARNISH_CERT_PATH -o StrictHostKeyChecking=no $VARNISH_CRED "uname -a;
        sudo service varnish restart" </dev/null
    done

elif [ $2 = "redis" ]
then 
    
    echo "Redis restart"

    # Redis restart

    for REDIS_CRED in $REDIS_LIST
    do
        echo "SSH connection to Redis"
        echo $REDIS_CRED
        ssh -i $PEM_REDIS_CERT_PATH -o StrictHostKeyChecking=no $REDIS_CRED "uname -a;
        sudo ./wifi4eu-gate-restart.sh"
    done


else
    echo "No action to do"
fi