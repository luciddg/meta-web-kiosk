#!/bin/sh

KICKFILE="/var/run/midori/kick-new-midori-config"
CONFIGFILE="/var/run/midori/config"

# We need to change cwd to somewhere writeable for sed -i
cd /var/run/midori/

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
