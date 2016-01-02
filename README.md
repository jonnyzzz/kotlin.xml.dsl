Kotlin XML DLS
==============

This is a tiny library that allows one to generate
XML files via Kotlin DSLs.

Project consists of API module with no dependencies
from any XML implementations.
There is an implementation module that implements
API via JDOM

License
-------

MIT

You can freely use this library or sources
in the way you like

Binaries
========

You may download binaries from maven artifacts repository from here
http://dl.bintray.com/jonnyzzz/maven

In Gradle build script it may be done like this
```gradle
repositories {
  maven { url "http://dl.bintray.com/jonnyzzz/maven" }
}

dependencies {
  compile "org.jonnyzzz.kotlin.xml.dsl:jdom:<VERSION>"
}
```

Usage example
-------------

```kotlin
jdom("root-element-name") {
  attribute("attribute", "42")
  element("some-other-element")
  text("Hello World")
}
```
