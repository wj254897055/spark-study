package com.dactent.sparksql.day1

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqlDemo1
  * @Description: spark  访问csv
  * @Date 2019/11/20
  **/
object SparkSqlDemo1 {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("spark sql demmo").master("local[*]").getOrCreate()
//
//    val srcDF=spark.read.format("CSV").option("header","true").load("E:\\project\\bigdata\\data\\ml-latest\\tags.csv")
//
//    srcDF.show()

    val peopleDF=spark.read.format("json").load("E:\\project\\bigdata\\data")
    //peopleDF.show(10,false)
    import spark.implicits._
    //表结构
    peopleDF.printSchema()
    //peopleDF.select("name").show()
    //peopleDF.select($"name", $"age" + 1).show()
    //peopleDF.filter($"age">30).show()

    //Register the DataFrame as a SQL temporary view
    //创建一个类似于表的视图
    peopleDF.createOrReplaceTempView("people")
    peopleDF.createGlobalTempView("peolpe2")

    val dataFrame = spark.sql("select * from people")

    dataFrame.show()
  }

}
