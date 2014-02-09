## Robot Vision

[![Build Status](https://travis-ci.org/frc-team-342/frc-team342-robot-vision.png?branch=master)](https://travis-ci.org/frc-team-342/frc-team342-robot-vision)

Robot Vision is a computer vision library based off of [WPIJavaCV](http://firstforge.wpi.edu/integration/viewcvs/viewcvs.cgi/trunk/WPIJavaCV/?root=smart_dashboard&system=exsy1002) and is meant for use with the [FIRST](http://www.usfirst.org) Robotics Competition.

### Disclaimer

This is NOT an official FIRST supported Library.  WPIJavaCV is built, maintained and tested by officially approved FIRST volunteers and personnel.  You should always default to WPIJavaCV for image processing in a FIRST Robotics Competition.

### Differences from WPIJavaCV

* Supports latest version of OpenCV (2.4.8).
* Supports latest version of FFMpeg (2.1.1).
* Configurable Debug logging.
* Simpler concurrency model.
* Cleaner resource management.

### Why use instead of WPIJavaCV

* You shouldn't (see Disclaimer).  This library is made available without any warranty or guarantee.  Use at your own risk.
* You want to use the latest versions of OpenCV and FFMpeg.
* You have a sense of adventure.

### Requires

* [JavaCV 0.7](https://code.google.com/p/javacv/)
* [OpenCV 2.4.8](http://sourceforge.net/projects/opencvlibrary/files/) - [Precompiled and prepackaged CPPJARs for Linux, Mac OS X, Windows, and Android](http://code.google.com/p/javacv/downloads/list)
* [FFMpeg 2.1.1](http://ffmpeg.org/download.html) - [Precompiled and prepackaged CPPJARs for Linux, Mac OS X, Windows, and Android](http://code.google.com/p/javacv/downloads/list)

### Compiling and Packaging

Robot Vision is a Maven project.  All dependencies for compilation are defined in the projects [pom.xml](pom.xml) file.

```
$> mvn package
```

### Installation

#### Windows

(Comming Soon)

#### Mac OS X

(Coming Soon)

#### Linux

(Coming Soon)

### Usage

(Coming Soon)
