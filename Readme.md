## Assessment

* This implementation approach utilizes Spring Batch's built-in capabilities for reading CSV files, processing items, and writing to a database. It provides a scalable and maintainable solution for handling large volumes of data while taking advantage of Spring's robust ecosystem.

Note: This implementation is using Spring 3.0

####Implementation Approach

To implement the requirements using Java Spring Batch, I have followed below-mentioned steps:

* Set up a Spring Boot project: Created a new Spring Boot project and configured the necessary dependencies, including Spring Batch.

* Create a CSV reader(OrderReader): Implemented a CSV reader component that reads the data from the CSV file. I Have used Spring Batch's built-in FlatFileItemReader.

* Implement item processors(OrderProcessor): Created a order processor that process each order item read from the CSV file. In the order processor, I have used regular expressions to determine the country based on the phone number. Apply the appropriate regular expression to each phone number to identify the country and update the order accordingly.

* Set up a database: Configured a database to store the processed orders. I have used a relational database supported by Spring Data JPA, such as MySQL.
    * Include Spring JPA Dependency
    * Include MySQL Connector Dependency
    * Provide DataSource properties in Application.properties file

* Create a JPA entity(Order): Defined a JPA entity representing an order, including attributes such as order ID, email, phone number, country and parcel weight. Map the entity to the corresponding database table.

* Implement item writers(OrderWriter): Created a item writer that persist the processed order to the database. I have used Spring Batch's ItemWriter using Spring Data JPA.

* Configure the Spring Batch job(SpringBatchConfig): Set up a Spring Batch job that orchestrates the CSV reading, item processing, and item writing. Configured the job with the necessary steps, reader, processor, and writer.

* Create Scheduler(JobScheduler): Implemented a Scheduler which is responsible to run batch on specified cron time. This scheduler is enabled only when spring profile is SCHEDULER.

* Create Controller(JobController): Implemented a RestController with PostMapping. This Endpoint is responsible for explicitly running a batch Job. This controller is enabled only when spring profile is REST.

####Run Configuration:
```text
MainClass : com.interview.assessment.AssessmentApplication
VM args : -Dspring.profiles.active=REST or SCHEDULER
```

####Output:

![](E:\eclipse_workspace_1\assessment\output.png)

