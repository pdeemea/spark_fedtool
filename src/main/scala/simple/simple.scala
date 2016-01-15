

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
    val user2 = sc.getConf.get(ConfigHelper.USER2)
    val host2 =sc.getConf.get(ConfigHelper.DB2_HOST)
    val port2 =sc.getConf.get(ConfigHelper.DB2_PORT)
    val password2 =sc.getConf.get(ConfigHelper.PASSWORD2)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    val url = "jdbc:postgresql://" + host + ":" + port + "/gpadmin"
    val url2 = "jdbc:teradata://" + host2 + "/TMODE=ANSI,DATABASE=dbc,USER=" + user2 + ",PASSWORD=" + password2
    val t1 = sqlContext.read.format("jdbc").options(
      Map(
        "url" -> url,
        "dbtable" -> "test_piani",
        "driver" -> "org.postgresql.Driver",
        "user" -> user)).load()
    val t2 = sqlContext.read.format("jdbc").options(
      Map(
        "url" -> "jdbc:teradata://192.168.0.16/TMODE=ANSI,DATABASE=dbc,USER=dbc,PASSWORD=dbc",
        "driver" -> "com.teradata.jdbc.TeraDriver",
        "dbtable" -> "diskspace",
        "user" -> user2)).load()

    val struct1= t1.rdd
    struct1.saveAsTextFile("/Users/oventura/kk.txt")
    val struct2= t2.rdd
    struct2.saveAsTextFile("/Users/oventura/kk2.txt")
  }
}

