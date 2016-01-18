
# README file

## Compile process using sbt
~~~
/usr/local/Cellar/sbt/0.13.9/bin/sbt package
~~~
## The way to run the process

~~~
/opt/spark/spark-1.6.0-bin-hadoop2.3/bin/spark-submit --class simple.simple --driver-class-path /Users/oventura/Downloads/GP_PIVOTAL_SW/postgresql-9.4-1204.jdbc4.jar:/Users/oventura/Downloads/TeraJDBC__indep_indep.15.10.00.09/tdgssconfig.jar:/Users/oventura/Downloads/TeraJDBC__indep_indep.15.10.00.09/terajdbc4.jar --master local[2] --properties-file  ./configuration.conf /Users/oventura/spark_projects/simple2/target/scala-2.10/simple_2.10-0.0.1.jar 
~~~

## Tips

dbtable can be substituted by a query like (select product, count(1) as total from test_piani group by product)

## Conf Values

~~~
//Conf 1 usually Greenplum will be used as write conf too

spark.db1.user           gpadmin
spark.db1.host           192.168.177.145
spark.db1.port           5432
spark.db1.db             public
spark.db1.table          test_piani

// Conf 2 prepared for Teradata will be extended
spark.db2.user           dbc
spark.db2.host           192.168.0.16
spark.db2.port           1025
spark.db2.password       dbc
spark.db2.db             dbc
spark.db2.table          tables

// t1 is first table and t2 second one change the projection and join parts
spark.query              select {B.*} from t1  A {inner} join t2  B on {1=1}
~~~

## Additional Documentation
* [Conf file](configuration.conf)
