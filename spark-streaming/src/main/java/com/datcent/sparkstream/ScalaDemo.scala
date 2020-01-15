package com.datcent.sparkstream

object ScalaDemo {

  private def getArray[String] ={
    ("hi","xiao","hu")
  }

  def main(args: Array[String]): Unit = {

    var strings=getArray
    print(strings)
  }
}
