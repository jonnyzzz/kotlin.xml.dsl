package org.jonnyzzz.kotlin.xml.dsl.jdom

import org.jdom2.CDATA
import org.jdom2.Content
import org.jdom2.Element
import org.jdom2.Text
import org.jonnyzzz.kotlin.xml.dsl.XWriter

object JDOM {
  public fun write(name: String, builder: XWriter.() -> Unit = {}): Element {
    val element = Element(name)
    object : XWriter {
      override fun attribute(name: String, value: String) {
        element.setAttribute(name, value)
      }

      override fun element(name: String, builder: XWriter.() -> Unit) {
        element.addContent(JDOM.write(name, builder) as Content)
      }

      override fun text(text: String) {
        element.addContent(Text(text))
      }

      override fun cdata(text: String) {
        element.addContent(CDATA(text))
      }
    }.builder()
    return element
  }
}

