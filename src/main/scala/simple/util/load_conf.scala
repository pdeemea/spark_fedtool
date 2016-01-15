package simple.util
import org.apache.spark.SparkContext

/**
 * Created by oventura on 1/15/16.
 */
class load_conf (sc: SparkContext){
  def user = sc.getConf.get(ConfigHelper.USER1)
        def host =sc.getConf.get(ConfigHelper.DB1_HOST)
        def port =sc.getConf.get(ConfigHelper.DB1_PORT)
        def user2 = sc.getConf.get(ConfigHelper.USER2)
        def host2 =sc.getConf.get(ConfigHelper.DB2_HOST)
        def port2 =sc.getConf.get(ConfigHelper.DB2_PORT)
        def password2 =sc.getConf.get(ConfigHelper.PASSWORD2)
        def url = "jdbc:postgresql://" + host + ":" + port + "/gpadmin"
        def url2 = "jdbc:teradata://" + host2 + "/TMODE=ANSI,DATABASE=dbc,USER=" + user2 + ",PASSWORD=" + password2

}


