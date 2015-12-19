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

Usage example
-------------

```kotlin
jdom("root-element-name") {
  attribute("attribute", "42")
  element("some-other-element")
  text("Hello World")
}
```
