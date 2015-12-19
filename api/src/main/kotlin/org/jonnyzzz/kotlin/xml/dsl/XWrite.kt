package org.jonnyzzz.kotlin.xml.dsl

public interface XWriter {
  fun attribute(name : String, value : String)
  fun element(name: String, builder: XWriter.() -> Unit = {})
  fun text(text: String)
  fun cdata(text: String)
}

