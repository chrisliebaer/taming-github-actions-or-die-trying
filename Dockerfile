FROM openjdk:15-jdk AS build
RUN mkdir /build
COPY . /build
WORKDIR /build
RUN ./gradlew build --no-daemon

FROM openjdk:15-slim
LABEL org.opencontainers.image.source https://github.com/chrisliebaer/taming-github-actions-or-die-trying
COPY --from=build /build/build/libs/* /hello-world
WORKDIR /hello-world
ENTRYPOINT ["java", "-jar", "hello-world.jar"]