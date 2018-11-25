[![Build Status](https://travis-ci.org/chirkov86/codingpuzzle.svg?branch=master)](https://travis-ci.org/chirkov86/codingpuzzle)
[![Coverage Status](https://codecov.io/gh/chirkov86/codingpuzzle/branch/master/graph/badge.svg)](https://codecov.io/gh/chirkov86/codingpuzzle)
[![Sonar Status](https://sonarcloud.io/api/project_badges/measure?project=chirkov86_codingpuzzle&metric=alert_status)](https://sonarcloud.io/api/project_badges/measure?project=chirkov86_codingpuzzle&metric=alert_status)

## Command line based role playing game.

### About
This is a command line based role playing game.
The game has following features:
- A player can create a character :heavy_check_mark:
- A player can explore the world :heavy_check_mark:
- A player can gain experience through fighting :heavy_check_mark:
- A player can save and resume a game :heavy_check_mark:

See examples below.

### Constraints
- Only plain Java except for tools for testing and building CI/CD pipelines
- CLI interface

### Features
- This project is MVP (Minimum Viable Product). Therefore it is not rich with features and not perfect in details
- Project is covered with unit tests. Code coverage plugin is included (see on the top of the page)
- Project is supplied with instructions (this readme) 
- Project is build with respect to agile engineering practices

### How-to run
`$ git clone https://github.com/chirkov86/codingpuzzle.git`\
`$ cd codingpuzzle`\
`$ ./gradlew build`\
`$ java -jar ./build/libs/codingpuzzle-1.0-SNAPSHOT.jar`

### Game process examples 
1. Creation:\
![Creation](images/Creation.png)\
2. Exploration:\
![Creation](images/Exploration.png)\
3. Fighting and gaining exp:\
![Creation](images/Fighting.png)\

