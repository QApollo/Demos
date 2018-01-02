# BDD

## Prerequisites

- Cucumber 1.2.5
- REST-assured 3.0.2


## Setup

1. Create a new Maven module on your project
2. Add the required dependencies to your pom.xml
```xml
<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>1.2.5</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>3.0.2</version>
</dependency>
<dependency>
    <groupId>info.cukes</groupId>
    <artifactId>cucumber-junit</artifactId>
    <version>1.2.5</version>
</dependency>
```
3. Create feature files, steps definition and the glue between them. See these [examples](examples).


## Usage

1. For a small introduction about BDD and Cucumber check [this link](https://cucumber.io/school).
2. For advance queries on the response body check [this link](https://github.com/rest-assured/rest-assured/wiki/Usage#json-using-jsonpath) and also search for 'Depth-first search'.
3. Run the tests directly from the **glue files** using your IDE. If you want to run all of them, then select to run all the tests on the src/test/java folder.
