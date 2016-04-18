### Run service:
```
mvn clean install && java -cp target/classes com.company.UserBatchProcessingApplication 
```
#### Description
The optimal solution for my point of view is a classical Producer-Consumer pattern. This allows us to be not dependent 
on the time required to retrieve data as well as on time to send email. Further improvement could be by introducing 
thread pool and executors.
Also in processing of large files one need keep in mind memory limit. It better to read file by lines. Further 
improvement could be by reading file by chunks.


