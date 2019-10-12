FROM openjdk:11.0.4-jre
MAINTAINER lx
COPY classes/artifacts/campephilus_jar /usr/campephilus_jar
# PORT
EXPOSE 8081
ENTRYPOINT ["java", "-Dserver.port=8081","-jar", "/usr/campephilus_jar/campephilus.jar"]
