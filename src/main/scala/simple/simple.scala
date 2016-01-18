

package simple

import org.apache.spark.{SparkConf, SparkContext}
import util.load_conf


/* SimpleApp.scala */

object simple {
  def main(args: Array[String]) {



    val prop = new java.util.Properties
    val conf = new SparkConf().setAppName("Federation Tool")
    val sc = new SparkContext(conf)

    val configuration= new load_conf(sc)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)


    /*val t1 = new sql_postgres(sqlContext,configuration)
    val t2 = new sql_teradata(sqlContext,configuration)*/


    val t1 = sqlContext.read.format("jdbc").options(
      Map(
        "url" -> configuration.url,
        "dbtable" -> "test_piani",
        "driver" -> "org.postgresql.Driver",
        "user" -> configuration.user)).load()

    val t2 = sqlContext.read.format("jdbc").options(
      Map(
        "url" -> configuration.url2,
        "driver" -> "com.teradata.jdbc.TeraDriver",
        "dbtable" -> configuration.table2,
        "user" -> configuration.user2)).load()
    t1.registerTempTable("t1")
    t2.registerTempTable("t2")

   // val query_text = configuration.query.toString()
    //print(query_text.getClass)
    val result_query = sqlContext.sql(configuration.query)

    val struct1= t1.rdd
    //struct1.saveAsTextFile("/Users/oventura/kk.txt")
    val struct2= t2.rdd
   // struct2.saveAsTextFile("/Users/oventura/kk2.txt")
    val struct3= result_query.rdd
    struct3.saveAsTextFile("/Users/oventura/kk3.txt")
 prop.setProperty("user",configuration.user)
 org.apache.spark.sql.execution.datasources.jdbc.JdbcUtils.saveTable(t1,configuration.url, "test1", prop)
  }
}

