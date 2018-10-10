#!/bin/bash

# Get DB connection
DB_URL=$1
DB_PORT=$2
DB_NAME=$3

# Get credentials
DB_USER=$4
DB_PASS=$5

# Clean DB
sqlcmd -S $DB_URL,$DB_PORT -U $DB_USER -d $DB_NAME -P $DB_PASS -Q "SELECT 1 FROM calls";

