

package simple
import org.apache.spark.{SparkConf, SparkContext}
import util.load_conf


/* SimpleApp.scala */

object simple {
  def main(args: Array[String]) {



    val conf = new SparkConf().setAppName("Federation Tool")
    val sc = new SparkContext(conf)

    val configuration= new load_conf(sc)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)

    val t1 = sqlContext.read.format("jdbc").options(
      Map(
        "url" -> configuration.url,
        "dbtable" -> "test_piani",
        "driver" -> "org.postgresql.Driver",
        "user" -> configuration.user)).load()

    val t2 = sqlContext.read.format("jdbc").options(
      Map(
        "url" -> "jdbc:teradata://192.168.0.16/TMODE=ANSI,DATABASE=dbc,USER=dbc,PASSWORD=dbc",
        "driver" -> "com.teradata.jdbc.TeraDriver",
        "dbtable" -> "diskspace",
        "user" -> configuration.user2)).load()

    val struct1= t1.rdd
    struct1.saveAsTextFile("/Users/oventura/kk.txt")
    val struct2= t2.rdd
    struct2.saveAsTextFile("/Users/oventura/kk2.txt")
  }
}

