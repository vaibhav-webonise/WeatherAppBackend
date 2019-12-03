Project Name: 
`Weather application backend`

Description: 
`This is a backend application that is developed to provide api's for weather frontend application`

Application type:
`Spring boot application`

Platform used: 
`Ubuntu 16.04.6 LTS`

IDE used: 
`Spring Tool Suite 4 Version: 4.4.0.RELEASE`

Tools & Framework used: 
`Java spring boot framework, JDK 1.8`

Dependencies:

`1.Spring web`

`2.PostgreSql driver`

`3.Spring data JPA`

`4.Spring Security`

Prerequisites: 

<<<<<<< HEAD
`1.postgreSql database`

`Once you have it create application.properties file in your home directory and add following lines in it,`
=======
`Must have postgreSql database configured on the system, Once you have it create application.properties file and add    following lines in it,`
>>>>>>> e72cb995a3f66f5e4bbc6c69c9728b8388940f46

`spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect`

`spring.jpa.hibernate.ddl-auto = update`

`spring.datasource.url=jdbc:postgresql://localhost:5432/{database_name}`

`spring.datasource.username={username}`

`spring.datasource.password={password}`

Note:

<<<<<<< HEAD
`1.Create database or use existing one`
`2.To create new database type following command on your postgres console`
	`CREATE DATABASE database_name;`
`3.5432 is the default port for postgreSql`
`4.postgres is the default user if you are working with default user add postgres at the username property`
`5.Otherwise give proper username to this property`
`6.If you have authenticated your postgeSql with password, Give valid password to the mentioned password property`
=======
`Create database or use existing one`

`To create new database type following command on your postgres console`
	
	`CREATE DATABASE database_name;`
	
`5432 is the default port for postgreSql`

`Postgres is the default user if you are working with default user add postgres at the username property`

`Otherwise give proper username to this property`

`If you have authenticated your postgeSql with password, Give valid password to the mentioned password property`

`Copy path of your application.properties file and paste it into the WeatherApplication.java file`
>>>>>>> e72cb995a3f66f5e4bbc6c69c9728b8388940f46

Installation: To run this app follow given steps,

`1.Clone or download project directory`

`2.Go to the directory and type`

`3.mvn clean install`

`4.mvn spring-boot:run`

After follwing these all steps your application will be running on 
`http://localhost:8080/`

Author: 
`vaibhav-webonise`
`vaibhav.anasune@weboniselab.com`
