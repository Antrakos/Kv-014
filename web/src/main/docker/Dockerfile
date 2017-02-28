FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD web.jar server.jar
RUN sh -c 'touch /server.jar'
ENTRYPOINT ["java", "-jar", "/server.jar" ]