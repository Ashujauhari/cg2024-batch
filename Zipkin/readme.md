# Zipkin
## Problem:
Order of execution of microservice 
Identify the execution path of microservice
Chain of microservices
Total time taken for execution 
Help to find log line order
Solution
	Sleuth and Zipkin


## Sleuth
Spring Cloud Sleuth is a library used with Spring Boot applications to add distributed tracing capabilities.
 Sleuth integrates with various tracing systems like Zipkin. Here are the key features and components of Sleuth:
1. Automatic Trace and Span Management: Sleuth automatically creates trace and span IDs for requests.
2. Propagation: It ensures that trace and span IDs are propagated across different services.
3. Logging Integration: Sleuth integrates with logging frameworks to add trace and span IDs to log messages.
4. Instrumentations: Sleuth comes with built-in instrumentations for common Spring components like RestTemplate, WebClient, Feign, etc.
5. Create TraceID and SpanID by spring cloud for distributed Tracing.

## Zipkin 
Zipkin is a distributed tracing system that helps gather timing data needed to troubleshoot latency problems in microservice architectures.
It manages both the collection and lookup of these traces. Here are the key features and components of Zipkin:
1. Trace Collection: Zipkin collects trace data from different services. Each trace is a series of spans that represent units of work within a service.
2. Trace Storage: It stores trace data in a backend such as in-memory, MySQL, Elasticsearch, etc.
3. Trace Querying: It provides a user interface and API to query and visualize trace data.
4. Annotations and Tags: Zipkin allows adding annotations and tags to spans to provide additional context, like events and metadata.

## Zipkin Setup
https://zipkin.io/pages/quickstart

curl -sSL https://zipkin.io/quickstart.sh | bash -s
 java -jar zipkin.jar

 ![image](https://github.com/user-attachments/assets/bc9c93b8-4c97-4d66-9f26-aec21426caaa)


 ## Micrometer
 Micrometer is a tool that helps developers keep track of how their microservices are performing. 
It does this by collecting and displaying data about things like response times, errors, and how many requests are being made. Think of it like a dashboard for a car – it gives you a quick way to see what’s going on and lets you know if anything needs attention.
By using Micrometer, developers can gain insights into the performance of their microservices and make informed decisions about optimizing their systems.
 The library enables easy tracking of custom metrics, giving developers greater control over monitoring specific aspects of their application’s performance.

 ## Common Use Case
 Micrometer is a tool that helps developers keep track of how their microservices are performing. 
It does this by collecting and displaying data about things like response times, errors, and how many requests are being made. Think of it like a dashboard for a car – it gives you a quick way to see what’s going on and lets you know if anything needs attention.
By using Micrometer, developers can gain insights into the performance of their microservices and make informed decisions about optimizing their systems.
 The library enables easy tracking of custom metrics, giving developers greater control over monitoring specific aspects of their application’s performance.


## Workflow
Micrometer is a tool that helps developers keep track of how their microservices are performing. 
It does this by collecting and displaying data about things like response times, errors, and how many requests are being made. Think of it like a dashboard for a car – it gives you a quick way to see what’s going on and lets you know if anything needs attention.
By using Micrometer, developers can gain insights into the performance of their microservices and make informed decisions about optimizing their systems.
 The library enables easy tracking of custom metrics, giving developers greater control over monitoring specific aspects of their application’s performance.
