FROM maven:3.6.1-jdk-8

COPY . /code

WORKDIR /code

ARG envType

RUN mvn clean package -P$envType

COPY target/springboot.jar /springboot.jar

ENTRYPOINT ['java', '-jar', '/springboot.jar']