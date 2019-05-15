#!/bin/sh
echo 'staring forum'

nohup java -jar -Dspring.profiles.active=prod /root/java-app/spring-monkey/tmlh-forum-web/target/forum.jar &
echo 'Start Success!'
