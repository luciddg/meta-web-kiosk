#!/bin/sh

client=192.168.1.101

changescript=/usr/bin/change_midori_url.sh


REMOTE_ADS="
100;http://alteredqualia.com/canvasmol/#Penicillin
120;http://peterned.home.xs4all.nl/3d/
120;http://andrew-hoyer.com/experiments/walking/
120;http://ie.microsoft.com/testdrive/performance/fishbowl/
120;http://fff.cmiscm.com
"

LOCAL_VIDEOS="
134;file:///var/local/ads/html5video/video-yp1.html
134;file:///var/local/ads/html5video/multi-video.html
170;file:///var/local/ads/html5video/video-yp2.html
140;file:///var/local/ads/html5video/video-seagaul.html
63;file:///var/local/ads/html5video/video-bunny.html
193;file:///var/local/ads/html5video/video-linux1.html
62;file:///var/local/ads/www.shinydemos.com/hipster-dog/index.html
"

LOCAL_INTERACTIVE_ADS="
62;file:///var/local/ads/www.shinydemos.com/beach/index.html
32;file:///var/local/ads/www.shinydemos.com/inbox-attack/index.html
32;file:///var/local/ads/www.shinydemos.com/rock-piano/index.html
"

ADS=${REMOTE_ADS}
ADS=${LOCAL_VIDEOS}
#ADS=${LOCAL_INTERACTIVE_ADS}

for ad in ${ADS}
do
  duration=`echo ${ad} | cut -d\; -f1 `
  url=`echo ${ad} | sed "s/^[0-9]*;//"`
  echo ${client} ${duration}Seconds ${url}
  ssh -x root@${client} ${changescript} ${url}
  sleep ${duration}
done
