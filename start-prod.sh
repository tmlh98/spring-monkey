#!/bin/sh
echo 'staring forum'

nohup java -jar -Dspring.profiles.active=prod /home/www/tmlh.xyz/spring-monkey/tmlh-forum-web/target/forum.jar &
echo 'Start Success!'
