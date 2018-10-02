#!/bin/bash

# Get DB connection
DB_URL=$1
DB_PORT=$2
DB_NAME=$3

# Get credentials
DB_USER=$4
DB_PASS=$5

echo $6;
echo $7;
echo $8;

# Get query parameters
CALL_ID=$6
START_DATE=$7
END_DATE=$8

# Validate parameter's type
re='^[0-9]+$'
if ! [[ $CALL_ID =~ $re ]] ; then
   echo "error: Call_Id is not a number" >&2; exit 1
fi
if ! [[ $START_DATE =~ $re ]] ; then
   echo "error: Start_Date is not a number" >&2; exit 1
fi
if ! [[ $END_DATE =~ $re ]] ; then
   echo "error: End_Date is not a number" >&2; exit 1
fi

# Update calls
sqlcmd -S $DB_URL,$DB_PORT -U $DB_USER -d $DB_NAME -P $DB_PASS -Q "UPDATE calls SET start_date=$START_DATE, end_date=$END_DATE where id=$CALL_ID";

