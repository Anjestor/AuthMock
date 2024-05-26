FROM maven:3.8.5-openjdk-18
#EXPOSE 8080
#EXPOSE 8778 8778
ARG PROJECT_NAME=AuthMock
ARG ACTIVE_PROFILE=docker
ENV PROJECT_NAME=$PROJECT_NAME
ENV ACTIVE_PROFILE=$ACTIVE_PROFILE

COPY ./target/AuthMock-1.0-SNAPSHOT.jar /$PROJECT_NAME/$PROJECT_NAME.jar
COPY ./target/classes/jolokia.jar /$PROJECT_NAME/jolokia.jar
COPY ./target/classes/application.yml /$PROJECT_NAME/application.yml

WORKDIR /$PROJECT_NAME
ENV JAVA_TOOL_OPTIONS="-javaagent:jolokia.jar"
ENTRYPOINT java -Dspring.profiles.active=$ACTIVE_PROFILE -Xms128m -Xmx300m -Dspring.config.location=/$PROJECT_NAME/application.yml -jar $PROJECT_NAME.jar