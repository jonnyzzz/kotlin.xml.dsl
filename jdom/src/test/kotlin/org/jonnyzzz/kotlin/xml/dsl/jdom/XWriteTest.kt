package org.jonnyzzz.kotlin.xml.dsl.jdom

import org.junit.Assert
import org.junit.Test

public class XWriteTest {
  private val XML = JDOM

  @Test
  public fun testWriteXML() {

    val x = XML.write("test") {
      attribute("a", "b")
      element("c") {
        attribute("d", "e")
      }
    }

    Assert.assertEquals(x.name, "test")
    Assert.assertEquals(x.getAttributeValue("a"), "b")
    Assert.assertEquals(x.attributes!!.size, 1)
    Assert.assertEquals(x.children!!.size, 1)
    Assert.assertNotNull(x.getChild("c"))
    Assert.assertEquals(x.getChild("c")!!.getAttributeValue("d"), "e")
  }

  @Test
  public fun testWriteXML_TEXT() {

    val x = XML.write("test") {
      text("aaaa")
    }

    Assert.assertEquals(x.name, "test")
    Assert.assertEquals(x.textTrim, "aaaa")
  }

  @Test
  public fun testWriteXML_text_and_element() {

    val x = XML.write("test") {
      element("zzz")
      text("aaaa")
    }

    Assert.assertEquals(x.name, "test")
    Assert.assertEquals(x.textTrim, "aaaa")
    Assert.assertNotNull(x.getChild("zzz"))
  }

  @Test
  public fun testWriteXML_CDATA_and_element() {

    val x = XML.write("test") {
      element("zzz")
      cdata("aaaa")
    }

    Assert.assertEquals(x.name, "test")
    Assert.assertEquals(x.textTrim, "aaaa")
    Assert.assertNotNull(x.getChild("zzz"))
  }

  @Test
  public fun testWriteXML_CDATA() {

    val x = XML.write("test") {
      cdata("aaaa")
    }

    Assert.assertEquals(x.name, "test")
    Assert.assertEquals(x.textTrim, "aaaa")
  }
}
