import java.util.concurrent.Executors
import org.apache.log4j.{Level, Logger}

import org.apache.spark.sql.{Encoders, SparkSession}

object Spark {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)
    streaming()

  }

  def streaming(): Unit = {

    val spark = SparkSession.builder()
      .config("spark.streaming.blockInterval", 100)
      .master("local")
      .appName("streaming").getOrCreate()

    val lines = spark.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load()
    import spark.implicits._
    val wordDataSet = lines.as[String].flatMap(_.split(" "))
    val wordCounts = wordDataSet.groupBy("value").count()

    val query = wordCounts.writeStream
      .outputMode("complete")
      .format("console")
      .start()

    query.awaitTermination()

  }

  def readText(): Unit = {
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

  def readJson(): Unit = {

    val spark = SparkSession.builder().master("local").appName("readJson").getOrCreate()
    val dataset = spark.read
      .option("multiline", "true")
      .json("/Users/leitian/Documents/spring-clould-about/grammar/spark/src/main/java/test.json")
      .cache()
    dataset.show()
    dataset.printSchema()

    dataset.createOrReplaceTempView("people")
    spark.sql("select * from people where age > 10").show()
    dataset.filter("age < 11").show()
    spark.close()
  }

  //  Error:(22, 31) Unable to find encoder for type stored in a Dataset.  Primitive types (Int, String, etc) and Product types (case classes) are supported by importing spark.implicits._  Support for serializing other types will be added in future releases.
  //  val wordDataSet = lines.as[String].flatMap(_.split(" "))

}


