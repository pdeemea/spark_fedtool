

package simple
import org.apache.spark.{SparkConf, SparkContext}
import util.ConfigHelper

/* SimpleApp.scala */

object simple {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val user = sc.getConf.get(ConfigHelper.USER1)
    val host =sc.getConf.get(ConfigHelper.DB1_HOST)
    val port =sc.getConf.get(ConfigHelper.DB1_PORT)
    //val host ="192.168.177.145"
    //val port = "5432"
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    val url = "jdbc:postgresql://" + host + ":" + port + "/gpadmin"
    val t1 = sqlContext.read.format("jdbc").options(
      Map(
        "url" -> url,
        "dbtable" -> "test_piani",
        "driver" -> "org.postgresql.Driver",
        "user" -> user)).load()
    val struct1= t1.rdd
    struct1.saveAsTextFile("/Users/oventura/kk.txt")
  }
}

