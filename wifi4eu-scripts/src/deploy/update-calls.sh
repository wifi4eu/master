#!/bin/bash

# Validate parameter's type
re='^[0-9]+$'
if ! [[ $3 =~ $re ]] ; then
   echo "error: Call_Id is not a number" >&2; exit 1
fi
if ! [[ $4 =~ $re ]] ; then
   echo "error: Start_Date is not a number" >&2; exit 1
fi
if ! [[ $5 =~ $re ]] ; then
   echo "error: End_Date is not a number" >&2; exit 1
fi

# Get credentials
DB_USER=${CREDENTIALS%:*}
DB_PASS=${CREDENTIALS#*:}

# Update calls
sqlcmd -S $1,$2 -U $DB_USER -d $DB_NAME -P '$DB_PASS' -Q "UPDATE calls SET start_date=$4, end_date=$5 where id=$3";

