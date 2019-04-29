# churds-cafe
[![Build Status](https://travis-ci.com/cameronhurd/churds-cafe.svg?branch=master)](https://travis-ci.com/cameronhurd/churds-cafe)

# What
A simple web application to demonstrate usage of the churds-web-metrics library built for the contrast security Java Instrumentation Engineer Project

# How to deploy
* Clone the repository using git (example: ```git clone https://github.com/cameronhurd/churds-cafe.git```)
* Run the spring boot application.  A couple ways to do this:
  * Import the module into an IDE as a maven project and run the main class ChurdsCafeWebApplication (spring boot application)
  * Use maven at the command line: ```mvn spring-boot:run```
  
# How to use the web application
* Once the spring boot application is up, use a browser to navigate to http://localhost:8080/
* View dummy/test pages like "About Us", "Location" and "Contact Us"
* The metrics page has response size and response time metrics that are displayed.
  * The bottom of the metrics page has a "Lookup" section where a historical metric can be viewed by ID.  
    * Metric ID's can be found two places:
      * In the spring boot application log as they are recorded
      * In the response header churds-metrics-id
        * You can check this by using ```curl -v -X GET "http://localhost:8080/about"```
    
NOTE - For more details about the web metric tracking library see https://github.com/cameronhurd/churds-web-metrics
