package simple

import org.apache.spark.sql.DataFrame
import util.load_conf

/**
 *  Created by oventura on 1/15/16.
 */
class sql_postgres (sqlContext: org.apache.spark.sql.SQLContext,configuration: load_conf){

  def t1 :DataFrame= sqlContext.read.format("jdbc").options(
    Map(
      "url" -> configuration.url,
      "dbtable" -> "test_piani",
      "driver" -> "org.postgresql.Driver",
      "user" -> configuration.user)).load():org.apache.spark.sql.DataFrame
}
