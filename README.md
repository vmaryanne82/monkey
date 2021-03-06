#QA Automation challenge 
#site https://www.monkeyuser.com. 
#Build an automation suite that checks that verifies the following features:
  - Views a random comic
  - Views the latest comic
  - User can view the next comic
  - Views the history of comics
  - Opens the comics from the following dates:
    - December 4, 2018
    - June 19, 2018
    - May 30, 2017
  - Verify a product can be added to cart and the checkout screen works
  - Modify the automation to accept any list of dates, and verify that there are or are not comic on those dates.

#Instructions
Please install the Eclipse version 2018-09 onto your Windows system
Install JDK/JRE.
During Eclipse set up point it towards the JDK/JRE file.
Install TestNG from the eclipse market
Install the Maven related applications
Go to Github and search for the repo Monkey/QA Automation Challenge
Set it up on the eclipse and follow the below instructions
Maven Install
Maven Clean
Maven Build
Maven Test 

#Troubleshooting
Pom.xml has been set up with all the required jar files. However, if you experience issues, please add the jar files manually from the mvn repository and download. Please do not tamper with pom.xml. Some commands which will help is update project, refresh project, Maven build, Maven clean.

#Tools and Technology
Selenium is the latest automation testing tool in the market which allows flexibility across all platforms. It supports many languages Java, Ruby, Javascript, Python.
Java programming language is one of the most popular languages in the market
Eclipse is very user friendly tool for java developers and automation testing.
We generally use Jenkins for continuous integration of the automation testing in the real world. This is set up on the server as it takes up a lot of system resources. 

#Improvisation
Test cases and Bug report - I have steered away from the traditional way of running test cases and reporting bugs.  I have improvised this process based on the latest industry trends - test runs with bug relations technique. This technique ensures that the test cases shows the related bugs and associated Jira ticket under one excel sheet.

Automation Framework - I had built a basic data driven framework to handle automation testing. It currently has the functionality to capture screenshots when a test case fails. I want to improvise my framework to do Jira integration for bug report and capture video snippets of the bugs.
