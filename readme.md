# Mortgage Calculation App

## Setup

Parent folder contains following two folders:

	angular -> contains UI code
	spring-boot -> contains java code

#### UI 

from inside the angular folder run following commands

	npm install -g karma-cli
	npm install -g webpack
	npm install

this folder contains webpack.config.js, karma.config.js and package.json

	npm run build -> copies compiled (prod-ready) angular code to java gatewaycontroller
	(optional)npm run test -> run test (configuration can be changed from karma.conf.js)


#### Spring

go to spring-boot folder and run following :

	clean install

just run following main application file using java:

	mortages-app/spring-boot/gatewaycontroller/src/main/java/com/ing/mortgage/web/Application.java


(optional) move to mortages-app/spring-boot/gatewaycontroller and run following command to create war:

	 mvn clean package

## go to localhost:8080 in your browser

###### spring boot setup contains following folders:
	entities -> contains User class
	services -> authentication and mortgage services
	gatewaycontroller -> Rest service implementation , Angular/UI compressed code
	utils -> authentication utilites 


######Defaults:

	username:jones
	password:indiana
	
These are the only username and password that are accepted to login the page

## improvements (todo):
1. validations
2. change get requests to post
3. Loading indicator for ajax requests
4. more test cases on java and angular
5. user registration system

## Issues faced:

1. https://github.com/angular/angular/issues/18254
2. https://github.com/webpack-contrib/karma-webpack/issues/188
