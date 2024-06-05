FROM maven:3.8.5-openjdk-18
EXPOSE 8084 8085

WORKDIR /app

RUN git clone https://github.com/Anjestor/AuthMock .

WORKDIR /app/AuthMock/
RUN mvn clean install

WORKDIR /app/AuthMock/target/
ENTRYPOINT ["java", "-jar", "-javaagent:../jolokia.jar=port=8085,host=0.0.0.0", "AuthMock-1.jar", "--Dspring.config.location=application.yml"]