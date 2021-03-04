# kafkaBinderDemo
This is sample program to demonstrate issues reported in https://github.com/spring-cloud/spring-cloud-sleuth/issues/1861, in particular warning log on 
application shutdown when kakfa binder is configured in application yml. This is a bare bone Kafka publishing Spring application, with one output channel called testOutput.

# To duplicate the issue
Start up a local kafka broker.  Then build the spring boot application, i.e., mvn package, run the default profile
```
java -jar target/kafkaBinderDemo-0.0.1-SNAPSHOT.jar 
```
The application fails to startup shortly after creating the binder scl1:
```
2021-03-04 16:14:55.614  INFO [kafkaBinderDemo,,,] 24277 --- [           main] o.s.c.s.binder.DefaultBinderFactory      : Creating binder: scl1
2021-03-04 16:14:55.929 ERROR [kafkaBinderDemo,,,] 24277 --- [           main] o.s.boot.SpringApplication               : Application run failed
```
Compare ths behavior with another branch demo/nokafkaBinder, and it starts up successfully.