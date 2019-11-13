FROM openjdk:8-jdk-alpine

ENV dir  /home/www/spring-monkey

WORKDIR ${dir}


MAINTAINER tianmolunhui

ADD ./tmlh-forum-web/target/forum.jar  ${dir}/jar/forum.jar

EXPOSE  8888

ENTRYPOINT ["java" ,"-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod" , "-Dserver.port=8888", "-jar","./jar/forum.jar"]
