FROM openjdk:8

MAINTAINER Andrey Chirkov <chirkov86@gmail.com>

COPY build/libs .

WORKDIR .

CMD ["java", "-jar", "codingpuzzle-1.0-SNAPSHOT.jar"]

# docker build -t achirkov/codingpuzzle .
# docker container run -it achirkov/codingpuzzle