# Stone Age Game Library

> A simple Swing-based game library that I wrote back in 2014

This is a rather limited library, but it is required by [Dark Forest Tower Defense](https://github.com/Rayzr522/Dark-Forest-Tower-Defense), so I figured I would post yet another piece of my coding-history online.

The entire library is Swing-based, using absolutely no external libraries. To a very limited degree, it handles the main game loop, graphics loading, sounds, input, and exceptionally limited UI.

## Installation

To use this library in your project (although I wouldn't suggest it), add the following to your `pom.xml`:

```xml
<repository>
    <id>rayzr-repo</id>
    <url>https://cdn.rawgit.com/Rayzr522/maven-repo/master/</url>
</repository>
```

```xml
<dependency>
    <groupId>me.rayzr522</groupId>
    <artifactId>sagl</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Or, to install the library into your local Maven repository, run the following commands:

```bash
$ git clone https://github.com/Rayzr522/SAGL.git
$ cd SAGL
$ mvn
# Stone Age Game Library will now be installed to your local Maven repository
```

This means you can now compile projects that require SAGL.
