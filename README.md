
* The way to run the process

 /opt/spark/spark-1.6.0-bin-hadoop2.3/bin/spark-submit --class simple.simple --driver-class-path /Users/oventura/Downloads/GP_PIVOTAL_SW/postgresql-9.4-1204.jdbc4.jar:/Users/oventura/Downloads/TeraJDBC__indep_indep.15.10.00.09/tdgssconfig.jar:/Users/oventura/Downloads/TeraJDBC__indep_indep.15.10.00.09/terajdbc4.jar --master local[2] --properties-file  ./configuration.conf /Users/oventura/spark_projects/simple2/target/scala-2.10/simple_2.10-0.0.1.jar 
