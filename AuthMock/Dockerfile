FROM maven:3.8.5-openjdk-18
ARG PROJECT_NAME=AuthMock
ARG ACTIVE_PROFILE=docker
ENV PROJECT_NAME=$PROJECT_NAME
ENV ACTIVE_PROFILE=$ACTIVE_PROFILE
ENV JAVA_TOOL_OPTIONS "-Dcom.sun.management.jmxremote.ssl=false \
 -Dcom.sun.management.jmxremote.authenticate=false \
 -Dcom.sun.management.jmxremote.port=1091 \
 -Dcom.sun.management.jmxremote.rmi.port=1091 \
 -Dcom.sun.management.jmxremote.host=0.0.0.0 \
 -Djava.rmi.server.hostname=0.0.0.0"
COPY ./$PROJECT_NAME/out/artifacts/AuthMock_jar/$PROJECT_NAME.jar /$PROJECT_NAME/$PROJECT_NAME.jar
WORKDIR /$PROJECT_NAME
ENTRYPOINT java -jar -Dspring.profiles.active=$ACTIVE_PROFILE -Xms128m -Xmx300m $PROJECT_NAME.jar