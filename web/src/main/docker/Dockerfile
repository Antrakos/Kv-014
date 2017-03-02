FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD web.jar server.jar
RUN sh -c 'touch /server.jar'
EXPOSE 8010
ENTRYPOINT ["java", "-Dserver.port=8010", "-Dspring.datasource.initialize=true", "-Ddb.prod.url=jdbc:postgresql://postgres:5432/zoo", "-jar", "/server.jar" ]