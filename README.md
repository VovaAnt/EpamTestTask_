# EpamTestTask
 
In this project we use:
1) Java 8 (jdk 1.8.0_281)
2) Cucumber (6.10.2)
3) TestNG (6.9.10)
4) Allure
5) Test.properties file which includs parameters for project( for searching word, domain and browser type)




Allure:
You should have instaled Allure on your machine here the link where you can find instruction (https://www.seleniumeasy.com/testng-tutorials/allure-example)


For runnig tests use comand in terminal:
1) "mvn clean test -Dthread.number=?" (?= type here the number of threads, for parallelization)
2) "allure serve" this comand will execute and open allure report)
