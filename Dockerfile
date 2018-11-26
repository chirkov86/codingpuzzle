FROM openjdk:8

MAINTAINER Andrey Chirkov <fyrkov86@gmail.com>

COPY build/libs .

WORKDIR .

CMD ["java", "-jar", "codingpuzzle-1.0-SNAPSHOT.jar"]

# Building an image:
# docker build -t fyrkov86/codingpuzzle .
# Running a container:
# docker container run -it fyrkov86/codingpuzzle
