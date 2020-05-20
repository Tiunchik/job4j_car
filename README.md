## job4j_car (accident database) 

[![Build Status](https://travis-ci.org/Tiunchik/job4j_car.svg?branch=master)](https://travis-ci.org/Tiunchik/job4j_car)

### Overall descripiton:

The learning task to work with spring. Developing a spring application that looks like a simple copy of the accident police database. There are several different pages: 
* login page, 
![login](https://user-images.githubusercontent.com/58567444/82467331-3b77ce00-9aca-11ea-909f-6cd2e356f8e8.jpg)
* main accident list page, 
![mainaccidentlist](https://user-images.githubusercontent.com/58567444/82467334-3ca8fb00-9aca-11ea-816c-fcad8255b811.jpg)
* info page about an accident where we can see additional information like the photo or list of participants, 
![fullinfoaboutaccident](https://user-images.githubusercontent.com/58567444/82467344-3dda2800-9aca-11ea-928a-4eaaad5732cf.jpg)
* and page for editing information about the accident.
![changelist](https://user-images.githubusercontent.com/58567444/82467339-3d419180-9aca-11ea-9ec0-bd172b6e66a2.jpg)

### Deploment
My web project is deployed on [heroku](https://polise-department-database.herokuapp.com/) For passing login page please use following login/password: admin/admin.

### Used the following modules: 
* Spring Boot(+ security, data(hibernate), web, thymeleaf, test)
* PostgreSQL
* Liquebase (create all database on the first start and fill in data about admin)
* JUnit (for controllers testing)
* Front-end only with thymeleaf and HTML (bootstrap4) dialect (I didn't use js for goal to learn featches of thyneleaf). 

* Container - Tomcat. There aren't any XML, only Java config and application.properties for spring config.

### About project architecture
There is three-tier architecture is used in the project (presentation, business, and data access layers)




