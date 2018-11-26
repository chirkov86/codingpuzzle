FROM openjdk:8

MAINTAINER Andrey Chirkov <fyrkov86@gmail.com>

COPY build/libs .

WORKDIR .

RUN mkdir -p /savegames

VOLUME /savegames

CMD ["java", "-jar", "codingpuzzle-1.0-SNAPSHOT.jar"]

# Building an image:
# docker build -t fyrkov86/codingpuzzle .

# Running a container:
# winpty docker container run -it --rm --mount source=codingpuzzle-vol,target=//savegames fyrkov86/codingpuzzle
# Note winpty for MINGW with "the input device is not a TTY" error
# Note "//" for MINGW + Win confusing the path
# Note "-it" for starting the container interactively
# Note "-rm" for removing the container after exit
# Note "--mount" to create a volume and store savegames there, so they persist after exit

# Removing the Volume after exit:
# docker volume rm codingpuzzle-vol
