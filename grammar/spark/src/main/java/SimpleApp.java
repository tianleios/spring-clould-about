import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

import java.util.stream.Collectors;

public class SimpleApp {

    public static void main(String[] args) {

        sparkSql();

    }

    //spark sql
    public static void sparkSql() {
        StructType structType = new StructType()
                .add("name", DataTypes.StringType)
                .add("age", DataTypes.IntegerType);

        SparkSession spark = SparkSession.builder().appName("test").getOrCreate();
        Dataset<Row> dataset = spark.read()
                .option("multiline", "true")
                .schema(structType)
                .json("/Users/leitian/Documents/spring-clould-about/grammar/spark/src/main/java/test.json")
                .cache();
        dataset.show();
        dataset.printSchema();
        dataset.filter("age > 10").show();
//        dataset.reduce((Function2<Row, Row, Row>) (x, y) -> {return x.getLong(1) + y;});

        dataset.createOrReplaceTempView("people");
        spark.sql("select * from people where age < 11").show();
        spark.stop();



    }
}
