import org.apache.spark.sql.{Encoders, SparkSession}

object Spark {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local").appName("name").getOrCreate()

    implicit val matchError = org.apache.spark.sql.Encoders.tuple(Encoders.STRING, Encoders.STRING, Encoders.STRING, Encoders.STRING, Encoders.STRING)

    val fileDateSet = spark
      .read
      .option("multiline", "true")
      .textFile("/Users/leitian/Documents/spring-clould-about/grammar/spark/src/main/resources/test.txt")

    val count = fileDateSet.rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _)
    count.foreach(print)
    spark.close()


  }

}


//Error:(11, 160) Unable to find encoder for type stored in a Dataset.  Primitive types (Int, String, etc) and Product types (case classes) are supported by importing spark.implicits._  Support for serializing other types will be added in future releases.
//val fileDateSet = spark.read.option("encode","utf-8").textFile("/Users/leitian/Documents/spring-clould-about/grammar/spark/src/main/resources/test.txt").as[String]

