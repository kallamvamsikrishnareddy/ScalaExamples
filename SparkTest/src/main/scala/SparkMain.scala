import org.apache.spark.sql.SparkSession
object SparkMain {
  def main(args:Array[String]): Unit ={
    val spark = SparkSession.builder
      .appName("Spark Test")
      .config("spark.master", "local")
      .getOrCreate()
    val wordCountData = spark.sparkContext.textFile("C:/Users/vamsi.kallam/Desktop/sparkdata.txt");
    val splitData = wordCountData.flatMap(line => line.split(" "));
    val mapData = splitData.map(word => (word,1));
    val reduceData = mapData.reduceByKey(_+_);
    //reduceData.saveAsTextFile("C:/Users/vamsi.kallam/Desktop/sparkdataOutput.txt");
    println(reduceData.count());

  }
}
