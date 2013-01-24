#!/bin/sh
KICKFILE="/home/root/.config/midori/kick-new-midori-config"
CONFIGFILE="/home/root/.config/midori/config"
CONFIGDIR="/home/root/.config/midori"
LOGFILE="/home/root/.config/midori/midori_log"
PIDFILE="/home/root/.config/midori/midori_log"
MIDORICOMMAND="/usr/bin/midori -e Fullscreen -c ${CONFIGDIR} -l ${LOGFILE}"
CHECKDELAY=1

while true
do
  if [ ! -f ${KICKFILE} ]
  then
    sleep ${CHECKDELAY}
  else
    killall -9 midori
    sleep 1
    newhomepage="`cat ${CONFIGFILE} | grep ^homepage= | sed 's/^homepage=//'`"
    echo starting midori with new homepage: ${newhomepage}
    ${MIDORICOMMAND} &
    echo started new midori
    rm -f ${KICKFILE}
  fi
done
