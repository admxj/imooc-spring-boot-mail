FROM maven:3.6.1-jdk-8

COPY . /code

WORKDIR /code

ARG envType=dev

RUN mvn clean package -P$envType

COPY --from=builder target/springboot.jar /springboot.jar

ENTRYPOINT ['java', '-jar', '/springboot.jar']