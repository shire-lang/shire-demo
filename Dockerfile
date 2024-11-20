# Use a base image with JDK 17 for building
FROM adoptopenjdk:17-hotspot AS build

# Install Gradle
RUN apt-get update && apt-get install -y wget && rm -rf /var/lib/apt/lists/*
RUN wget -q https://services.gradle.org/distributions/gradle-7.5-all.zip -P /tmp
RUN unzip -q /tmp/gradle-7.5-all.zip -d /opt/gradle && rm /tmp/gradle-7.5-all.zip
ENV GRADLE_HOME=/opt/gradle/gradle-7.5
ENV PATH=$PATH:$GRADLE_HOME/bin

# Copy project and build it
COPY . /app
WORKDIR /app
RUN gradle assemble bootBuildImage

# Use a smaller base image for running the application
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 3000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
