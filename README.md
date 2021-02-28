# kafkaBinderDemo
This is sample program to demonstrate issues reported in https://github.com/spring-cloud/spring-cloud-sleuth/issues/1861, in particular warning log on 
application shutdown when kakfa binder is configured in application yml. This is a bare bone Kafka publishing Spring application, with one output channel called testOutput.

# To duplicate the issue
Start up a local kafka broker.  Then build the spring boot application, i.e., mvn package, run the local profile
```
java -Dspring.profiles.active=local -jar target/kafkaBinderDemo-0.0.1-SNAPSHOT.jar 
```
When application finishes start up, then stop the application. Notice this error printed on the console log followed by a stack trace:
```
Failed to stop bean 'outerContext'
```
Compare the shutdown log when running the default profile which shuts down cleanly.
```
java -Dspring.profiles.active=default -jar target/kafkaBinderDemo-0.0.1-SNAPSHOT.jar 
```
