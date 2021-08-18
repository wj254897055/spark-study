package com.dactent.sparksql.day1

import java.util.Properties

import org.apache.spark.sql.SparkSession

/**
  * @ClassName SparkSqltoMySql
  * @Description: 读取json文件到mysql
  * @Date 2019/11/21 
  **/
object SparkSqlReadMySql {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder()
      .appName("SparkSqltoMySql")
      .master("local[*]").getOrCreate()

    val aaa="dadada";

    aaa.startsWith("da");
    aaa.map(a => {
      print(a)
    })

    //创建myqsl lianjie
    val url="jdbc:mysql://192.168.1.121:3306/qsdi_ivdg"
    val table="t_important_person"
    val prop = new Properties()
    prop.setProperty("driver","com.mysql.jdbc.Driver")
    prop.setProperty("user","root")
    prop.setProperty("password","qsdi")
    //读取json 文件
    val df = spark.read.jdbc(url,table,prop)
    val unit = df.show(100)
  }

}
