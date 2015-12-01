# SpringBatchFirstTry

This project is about getting first experience of workin with batching. Mainly this is template that uses oracle db<br/>
 as db for job repository and for business data. It could be split if it needs.

To run application you need to:<br/>
spring-boot:run -Dspring.profiles.active=oracle<br/>
so that schema-oracle.sql is run to make schema<br/>

There are two tests:<br/>
1. Integration that requires hsqldb to be run:<br/>
class: org.hsqldb.server.Server, parameters: --database.0 file:src\test\resources\db\mydb --dbname.0 mydb<br/>
connection link: jdbc:hsqldb:hsql://localhost:9001/mydb<br/>
2. Unit test that uses in memory hsqldb<br/>
