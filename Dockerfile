FROM openjdk:8-jdk-alpine

MAINTAINER tianmolunhui

ENV BASE_DIR  /home/www/forum/spring-monkey

ENV JAVA_OPTS="\
-Dspring.profiles.active=prod \
-Dserver.port=8888 \
-server -Xms1024m -Xmx1024m"

WORKDIR ${BASE_DIR}

ADD ./tmlh-forum-web/target/forum.jar  ${BASE_DIR}/forum.jar

EXPOSE  8888

ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar ./forum.jar