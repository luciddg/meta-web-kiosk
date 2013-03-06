#!/bin/sh

default_client=kiosk-client
changescript=/usr/bin/change_midori_url.sh

if [ $# == 1 ]
then
  client=$default_client
  url=$1
elif [ $# == 2 ]
then
  client=$1
  url=$2
else
  echo "Usage: $0 [client] <url>"
  exit
fi

ssh -x root@${client} ${changescript} ${url}
