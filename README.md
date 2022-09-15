


# Rewards App

## Coding Assignment


### Version 1.0


14/09/2022

Version History

1.0, 2022-09-14, Vijay Sanghani, Initial Version.

## 1. Introduction

Following is the problem statement for the coding assignment:

A retailer offers a rewards program to its customers awarding points based on each recorded purchase as follows: 
For every dollar spent over $50 on the transaction, the customer receives one point. In addition, for every dollar spent over $100, the customer receives another point. Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points 
Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.
Write a REST API that calculates and returns the reward points in the language of your choice. If you are writing in Java, Using Spring Boot is highly recommended but not mandatory.

### 1.1 Purpose of the Technical Design Document

This Technical Design Document is tailored to fit the purpose of the
coding assignment. The audience meant for is the technical panel
assessing the candidate. It outlines a possible solution approach.

## 2. Scope, Assumptions, Constraints and Risks

This design and development will focus only towards the goal of solving
the problem statement and will not be able to expand on the larger
context of the solution in terms of the overall business requirement as
there is no such information nor related business client.

Hence, we will implement a focused solution as a Proof of Concept for
the end result of the assignment.

## 3. Technology stack

As we are required to implement REST API, we select **Java Spring Boot**
framework which helps to achieve it with minimal configuration, thus
saving development time. It also has embedded web server, e.g. Tomcat,
which can help us create standalone apps for distribution without
relying on external apps.

We use **H2** in-memory database as we can implement our PoC relatively
fast. We do not have the larger context of the business available hence
we focus on the end result of the assignment.

We use **JPA Hibernate** to map and operate on database entities.

To test the application, we will **JUnit**, **Mockito** and an Internet
browser.

### 3.1 Development and Testing Tools

Operating System: Mac OS 11.x on Macbook 11 inch mid-2013 model

Java Platform: Amazon Corretto JDK 1.8

Java Spring Boot development: STS -- Spring Tool Suite 4.x

MySQL Database: MySQL Server 8.x, MySQL Workbench 8.x

REST API Testing: Postman 9.x and Google Chrome based Browser 105.x

Build: Maven 3.x

Distribution of code: GitHub

Distribution of app: Docker Desktop, Docker Hub

### 3.2 Naming Conventions

Standard naming conventions

## 4. High Level Design

Java 1.8 is selected which suffices our requirement in terms of
features. We will use Amazon Corretto JDK which is well maintained.
Overall, this helps us create a smaller distribution file.

For our focused assignment PoC, H2 in memory database will be used to
keep things light. Also, we could quickly change the schema and data if
needed for quick tests.

### 4.1 Endpoints

/customer/{customerId}

This endpoint will show month wise reward points for a specified
customer id.

/customer/{customerId}/total

This endpoint will show total reward points for a specified customer id.

Returned data in JSON format.

### 4.2 Entity Model

H2 database: shopdb schema will hold a table of transactions which we
will define in schema.sql

```sql
DROP TABLE IF EXISTS tbl_transaction;

CREATE TABLE tbl_transaction ( 
id_transaction INT NOT NULL PRIMARY KEY,  
date_transaction TIMESTAMP,  
id_customer INT NOT NULL,  
id_product INT NOT NULL,  
quantity_transaction INT,  
amount_transaction INT,  
reward_points_transaction INT 
);
```

id_customer is a foreign key to master tbl_customer

id_product is a foreign key to master tbl_product

For our purpose, we do not define these tables and focus only on the
transaction data.

amount_transaction is taken as integer and arrived by multiplying
quantity_transaction and cost price of product which is got from product
master. Here it is already provided in sample data set.

Since reward points are per transaction, it is best stored at
transaction level. Hence here, it is assumed that is blank by default
and our program calculates and populates immediately after it starts.

As the requirement states that this transaction data is available in 3
months set, we will insert a sample 3 months data via the data.sql.

```sql
INSERT INTO tbl_transaction VALUES (1,'2022-01-01 10:00:00',1,1,1,60,0);  
INSERT INTO tbl_transaction VALUES (2,'2022-01-10 11:00:00',2,2,1,80,0);  
INSERT INTO tbl_transaction VALUES (3,'2022-02-01 12:00:00',3,3,1,40,0);  
INSERT INTO tbl_transaction VALUES (4,'2022-02-10 14:00:00',2,4,2,40,0);  
INSERT INTO tbl_transaction VALUES (5,'2022-02-15 13:00:00',1,1,2,120,0);  
INSERT INTO tbl_transaction VALUES (6,'2022-02-20 15:00:00',2,3,3,60,0);  
INSERT INTO tbl_transaction VALUES (7,'2022-03-10 16:00:00',3,2,2,160,0);  
INSERT INTO tbl_transaction VALUES (8,'2022-03-15 10:00:00',1,1,1,60,0);  
INSERT INTO tbl_transaction VALUES (9,'2022-03-20 10:00:00',3,2,1,80,0);  
INSERT INTO tbl_transaction VALUES (10,'2022-03-25 10:00:00',2,2,1,80,0);  
```

### 4.3 Logic Flow

Client \<\--\> Controller \<\--\> Service \<\--\> Repository \<\--\>
Entity \<\--\> Database

When app is run, H2 database will be created along with schema and
sample data. As per requirement, we need to calculate reward points on
the transaction amount for each transaction. We can do this immediately
upon data load using ApplicationRunner in main application.

Client will trigger a GET API call which will be handled by the
Controller. It will pass on the request to a Service object, which in
turn will pass the request to a Repository object. The Repository object
will operate on the database via an Entity object. Upon processing, the
response data is returned to the client via the return route.

For results of SQL queries run on the entity, we will define Interface
Projections to map the results:

viz. IpMonthlyRewards and IpTotalRewards

## 5. Low Level Design

### 5.1 Development Setup

Download and install OpenJDK 1.8 Amazon Corretto from:

<https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html>

Configure the IDE to point towards it

Initialize Spring as per:

![image](https://user-images.githubusercontent.com/19529430/190193256-39a65442-d2ff-4792-9bcd-b8464120a9ba.png)

Generate and extract the application zip file.

Import it as Existing Maven Project in STS

![image](https://user-images.githubusercontent.com/19529430/190193429-122b154c-3767-451e-8c1c-40e2273b46a3.png)

Create empty project repository in GitHub

Clone the empty git repo in STS

![image](https://user-images.githubusercontent.com/19529430/190194028-12e59beb-b282-4269-9df9-ce59d5f28e8f.png)

Link downloaded initialized project with empty git repo using Team Share
option in STS

![image](https://user-images.githubusercontent.com/19529430/190194156-bdb6f616-385c-4beb-b323-74393a1ac74a.png)

Configure H2 in memory database modifying application.properties.

Create transactions table in schema.sql and insert sample data via
data.sql.

Create an entity for Transaction, define Constructor, Getter and Setter
methods.

Create an AppController with endpoints.

Create a Service to service the endpoints. Implement loose coupling via
Interface.

In Repository, implement Native SQL Queries:

For monthly rewards by customer id:

```sql
SELECT SUM(t.reward_points_transaction) reward_points,
MONTH(t.date_transaction) reward_month FROM tbl_transaction t WHERE
t.id_customer = :customerId GROUP BY reward_month
```

For total rewards by customer id:

```
SELECT SUM(t.reward_points_transaction) reward_points_total FROM
tbl_transaction AS t WHERE t.id_customer = :customerId
```

We need to capture the results of above query though it is not mapped to
a database entity. Here we implement Interface projection to achieve
that,

viz. IpMonthlyRewards and IpTotalRewards.

## 6. Testing

### 6.1 H2 database console

We can have access to H2 database console at the location:

localhost:8080/h2-console

![image](https://user-images.githubusercontent.com/19529430/190194503-2667da23-fade-4119-8dc9-ada3213b0276.png)

We can test the connection and connect to the database, upon which we
get access to the schema and can run operations on it.

![image](https://user-images.githubusercontent.com/19529430/190194670-60c44e64-ad70-4b28-8f88-026d65f78126.png)

Above we see transaction table has been populated via data.sql and then
app has calculated reward points and saved for each transaction.

### 6.2 Using Web Browser

Home Page:

![image](https://user-images.githubusercontent.com/19529430/190194815-582a5c7d-3de4-4ad1-b90a-bea2a9f59818.png)

Month wise reward points for customer id = 1

![image](https://user-images.githubusercontent.com/19529430/190195009-b43ff90c-bb24-41e5-aa89-9999bc094ef0.png)

### 6.3 Using Postman

Month wise reward points for customer id = 2

![image](https://user-images.githubusercontent.com/19529430/190195092-b46e71bf-c4cc-4c87-8d9d-245d9dfc0de9.png)

Total reward points for customer id = 2

![image](https://user-images.githubusercontent.com/19529430/190195165-ab31b67c-be28-4c66-8b0b-e7ca4ddb610c.png)

### 6.4 Using JUnit

We write JUnit test cases in folder:

src/test/java

and within our package name.

We right click the test program and select JUnit to run it.

![image](https://user-images.githubusercontent.com/19529430/190195224-e2837b08-faf5-42c2-9194-080694d52e0c.png)

#### 6.4.1 Smoke Test

Test if AppController is loaded and instantiated properly.

![image](https://user-images.githubusercontent.com/19529430/190195284-a7af8776-abe2-41b2-8ccb-8b211a2b2857.png)


The test is run and shows results in the JUnit view as show above -- Run
1, Success tick with no Errors.

#### 6.4.2 Controller and REST GetMapping test

Test REST GetMapping in Controller and the Response

![image](https://user-images.githubusercontent.com/19529430/190195341-6a46b171-f2df-42c0-9742-3a88d21267ca.png)

### 6.5 Using Mockito

#### 6.5.1 Controller Service Test

Test Controller call to Service and Response using Mock data. We create
mock data for total reward points we get when controller makes a service
call. We later assert if controller receives the data correctly.

![image](https://user-images.githubusercontent.com/19529430/190195444-3af59e80-f5f6-4225-90a3-6d6f0c5c0c37.png)

## 7. Building the application

Edit pom.xml under \<build\> \<finalName\> and give the name of the app jar file
to execute

```xml
<build>

  <finalName>rewards</finalName>
```

In IDE, perform Maven Install to generate the app jar file in the target
folder

Test run app by shell command:

```sh
java -jar rewards.jar
```

![image](https://user-images.githubusercontent.com/19529430/190195541-ef3f61e1-b6f7-406b-aadb-31657bbdad16.png)

## 8. Dockerizing

We will be using docker hub to distribute our app jar file.

Create Dockerfile in project root folder. We need to make sure that the
file is named as given only.

Edit with following parameters:

```xml
FROM openJDK:8-jdk-alpine 
COPY target/rewards.jar rewards.jar 
ENTRYPOINT ["java", "-jar", "rewards.jar"]
```

Open a terminal and go to the project root folder where we have the
Dockerfile

To build docker image:

```
docker build -t vsdh/rewards 
```

To run the image as a container:

```
docker run -p 9090:8080 vsdh/rewards
```

We map port 9090 at our local machine, hence to access the application, we need to use the same:

```
localhost:9090
```

To push to docker hub:

```
docker push vsdh/rewards
```

To pull from docker hub:

```
docker pull vsdh/rewards
```
