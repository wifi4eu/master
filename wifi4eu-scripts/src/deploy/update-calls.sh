#!/bin/bash

# Get DB connection
DB_URL=$1
DB_PORT=$2
DB_NAME=$3

# Get credentials
DB_USER=${4%:*}
DB_PASS=${4#*:}

# Get query parameters
P_CALL_ID=$5
P_START_DATE=$6
P_END_DATE=$7

# Validate parameter's type
re='^[0-9]+$'
echo P_CALL_ID;
if ! [[ $P_CALL_ID =~ $re ]] ; then
   echo "error: Call_Id is not a number" >&2; exit 1
fi
if ! [[ $P_START_DATE =~ $re ]] ; then
   echo "error: Start_Date is not a number" >&2; exit 1
fi
if ! [[ $P_END_DATE =~ $re ]] ; then
   echo "error: End_Date is not a number" >&2; exit 1
fi

# Update calls
sqlcmd -S $DB_URL,$DB_PORT -U $DB_USER -d $DB_NAME -P '$DB_PASS' -Q "UPDATE calls SET start_date=$P_START_DATE, end_date=$P_END_DATE where id=$P_CALL_ID";

