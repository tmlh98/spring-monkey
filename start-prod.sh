#!/bin/sh
echo 'staring forum'

nohup java -jar -Dspring.profiles.active=prod /root/java-app/spring-monkey/tmlh-forum-web/target &
echo 'Start Success!'
