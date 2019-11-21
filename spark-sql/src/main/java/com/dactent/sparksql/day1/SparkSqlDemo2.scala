package com.dactent.sparksql.day1

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqlDemo1
  * @Description: spark  读取本地文件
  *               查询年龄大于21 的客户
  *               以json 形式写入到本地
  * @Date 2019/11/20
  **/
object SparkSqlDemo2 {
  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder().appName("spark sql demmo").master("local[*]").getOrCreate()
    val rdd1 = spark.sparkContext.textFile("E:\\project\\bigdata\\data\\ml-latest\\cust.txt")
    import spark.implicits._
    val df1=rdd1.map(line=>{
      val arr = line.split(",")
      (arr(0).toInt,arr(1),arr(2).toInt)
    }).toDF("id","name","age")
    df1.show(10)
    df1.where("age>21").write.parquet("E:\\project\\bigdata\\data\\ml-latest\\json1")
  }

}
