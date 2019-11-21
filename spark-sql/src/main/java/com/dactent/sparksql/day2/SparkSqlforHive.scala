package com.dactent.sparksql.day2

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqlforHive
  * @Description: TODO 
  * @Date 2019/11/21 
  **/
object SparkSqlforHive {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local[*]").appName("SparkSqlforHive")
      .enableHiveSupport()
      .getOrCreate()

    spark.sql("select current_timestamp()").show(1000,false)
  }

}
