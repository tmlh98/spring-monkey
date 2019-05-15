#!/bin/sh
F_PID=`ps -ef | grep forum.jar | grep -v grep | awk '{print $2}'`

if [ -z "$F_PID" ];then
 echo "[ not find forum.jar pid ]"
else
 echo "stop $F_PID success... "
 kill -9 $F_PID
fi
