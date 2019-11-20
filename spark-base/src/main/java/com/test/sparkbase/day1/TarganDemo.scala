package com.test.sparkbase.day1

import com.alibaba.fastjson.JSON
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer


/**
  * @ClassName TarganDemo
  * @Description: 标签生成
  * @Date 2019/10/20 
  **/
object TarganDemo {

  /**
    * 解析json串，抽取评论，形成集合
    * @param str
    * @return
    */
  def parseJson(str:String) : ArrayBuffer[String] = {
    val result : ArrayBuffer[String] = ArrayBuffer()
    //解析成JSONObject
    val jo1 = JSON.parseObject(str) ;
    //得到extInfoList数组
    val jarr = jo1.getJSONArray("extInfoList")
    if(jarr != null && jarr.size() > 0){
      //得到第一个对象
      val firstObj = jarr.getJSONObject(0)
      val tagArr = firstObj.getJSONArray("values")
      if(tagArr != null && tagArr.size() > 0){
        val arr = tagArr.toArray()
        for(e <- arr){
          result.+=(e.asInstanceOf[String])
        }
      }
    }
    return result ;
  }

  def main(args: Array[String]): Unit = {


    val conf = new SparkConf()
    conf.setAppName("TarganDemo")
    conf.setMaster("local")

    //加载文件
    val sc = new SparkContext(conf)
    val rdd1 = sc.textFile("file:///D:/wujing/data/temptags.txt")

    val rdd2=rdd1.map(line=>{
      val arr = line.split("\t")
      val busid = arr(0)
      val json = arr(1)

      val tagbuf = parseJson(json)
      (busid,tagbuf)
    })

    //过滤空集合
    val rdd3 = rdd2.filter(tup=>{tup._2 !=null && tup._2.length>0})

    //压扁值
    val rdd4 = rdd3.flatMapValues(list=>list)

    //标一成对
    val rdd5 = rdd4.map(e=>(e,1))
    //聚合
    val rdd6 = rdd5.reduceByKey(_+_)
    //再转换
    val rdd7 = rdd6.map(e=>(e._1._1,(e._1._2,e._2)))

    //分组
    val rdd8 = rdd7.groupByKey()

    //商家内排序
    val rdd9 = rdd8.mapValues(e=> e.toList.sortBy(- _._2))

    //对商家排序
    val rdd10 = rdd9.sortBy(t=> -t._2(0)._2)
    rdd10.collect().foreach(println)


  }


}
