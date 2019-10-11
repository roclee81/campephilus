FROM openjdk:11
MAINTAINER lx
COPY ./classes/artifacts/campephilus_jar /usr/campephilus_jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar --spring.profiles.active=local", "/usr/campephilus_jar/ca  mpephilus.jar"]