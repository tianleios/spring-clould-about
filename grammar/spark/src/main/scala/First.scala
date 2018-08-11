import org.apache.spark.sql.SparkSession

class First {

  def main(args: Array[String]): Unit = {
    val sparkSession = SparkSession.builder().appName("test").getOrCreate()
    val dataSet = sparkSession.read.textFile("").cache()
    val count = dataSet.filter(s => s.contains("name")).count()
    print(s"name count $count")
    sparkSession.stop()

  }

}
