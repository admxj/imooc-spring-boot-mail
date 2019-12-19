FROM maven:3.6.1-jdk-8 as builder

COPY . /code

WORKDIR /code

ARG envType=dev

RUN mvn clean package -P$envType

FROM java:openjdk-8u40-jdk

COPY --from=builder /code/target/springboot.jar /springboot.jar

ENTRYPOINT ["java", "-jar", "/springboot.jar"]