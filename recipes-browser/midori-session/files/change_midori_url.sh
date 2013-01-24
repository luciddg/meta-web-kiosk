#!/bin/sh

KICKFILE="/home/root/.config/midori/kick-new-midori-config"
CONFIGFILE="/home/root/.config/midori/config"

usage()
{
  echo "Usage: $0 <new url>"
  exit 1
}

if [ $# -lt 1 ]
then
  usage
fi

URL=$1

sed -i "s|^homepage=.*$|homepage=${URL}|g" ${CONFIGFILE}
touch ${KICKFILE}
