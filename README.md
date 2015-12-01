# SpringBatchFirstTry

This project is about getting first experience of workin with batching. Mainly this is template that uses oracle db as db for job repository and for business data. It could be split if it needs.

To run application you need to:
spring-boot:run -Dspring.profiles.active=oracle
so that schema-oracle.sql is run to make schema

There are two tests:
1. Integration that requires hsqldb to be run:
class: org.hsqldb.server.Server, parameters: --database.0 file:src\test\resources\db\mydb --dbname.0 mydb
connection link: jdbc:hsqldb:hsql://localhost:9001/mydb
2. Unit test that uses in memory hsqldb
