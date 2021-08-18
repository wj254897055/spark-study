package com.datcent.sparkstream

object ScalaDemo {

  private def getArray[String] ={
    ("hi","xiao","hu")
  }

  def main(args: Array[String]): Unit = {
    val array = getArray
    println(array)
  }
}
