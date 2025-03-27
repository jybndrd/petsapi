# Pets Api
an API to manage owners and pets


## Libraries/Tools Used
- Java 17
- [Spring Boot](https://spring.io/projects/spring-boot) with the following components:
    * Spring Web
    * Spring JPA
- [H2](https://www.h2database.com/html/main.html) - File based data based configuration

### Getting started
I created this repository since I was not satisfied with the work I presented via Codility and to be honest I am now rusty with the version of Spring that was used (2.0.5). I created this app using a newer version of Spring. Although this is a different version, I am enthusiastic to learn the Spring framework that the team will be using. Please kindly reconsider this. I am also available to show a demo of this application if its necessary.

With this, please clone this project into your local machine and let's make sure that everything is set up before going into details.
Here are also some of the features that i've included in this app:
- get all available persons
- get pet of a person using its ID
- add a pet using a person ID and a pet name
#### A. We will be using H2 as out database. This makes things easier for testing. Make sure that you have the db file for H2.
1. Check this file if existing: /db/data/[petsapidb.mv.db](db/data/petsapidb.mv.db)
2. Check the `application.yml` under the **src/main/resources** if configured correctly, here are the expected configurations:
   ```
   spring:
    application:
      name: Pets API Application
  
    datasource:
      url: jdbc:h2:file:./db/data/petsapidb
      driver-class-name: org.h2.Driver
      username: sa
      password: admin
  
    h2:
      console:
        enabled: true #Enable H2 web console
        path: /h2-console #Path http://localhost:8090/h2-console
   ```
3. Check if you are able to connect and see some PRE LOADED data in the database (Dummy data is already inserted and is available for testing). Use the above credentials. We are expected to see `person`, and `pet` tables. These tables should also have rows inside of it.
   
#### B. Run the Spring Boot application
1. Open your IDE (**e.g.,** IntelliJ)
2. Go to [PetsapiApplication.java](src/main/java/com/demo/petsapi/PetsapiApplication.java)
3. Right-click then select **Run/Debug**.
4. This will run the Spring Boot application - below is the expected logs at startup.
**NOTE** : You won't be able to start the application if you are currently connected to the database, it is one of the limitation of H2. Kindly check if you database is connected.

```
__________        __              _____ __________.___
\______   \ _____/  |_  ______   /  _  \\______   \   |
 |     ___// __ \   __\/  ___/  /  /_\  \|     ___/   |
 |    |   \  ___/|  |  \___ \  /    |    \    |   |   |
 |____|    \___  >__| /____  > \____|__  /____|   |___|
               \/          \/          \/
Pets API Application
Powered by Spring Boot 3.4.4
2025-03-27T19:40:58.081+08:00  INFO 30278 --- [Pets API Application] [  restartedMain] com.demo.petsapi.PetsapiApplication      : Starting PetsapiApplication using Java 17.0.14 with PID 30278 (/media/sf_SharedFolderVM/sampleprojects/petsapi/target/classes started by docker in /media/sf_SharedFolderVM/sampleprojects/petsapi)
2025-03-27T19:40:58.083+08:00  INFO 30278 --- [Pets API Application] [  restartedMain] com.demo.petsapi.PetsapiApplication      : No active profile set, falling back to 1 default profile: "default"

.....

2025-03-27T19:41:01.139+08:00  INFO 30278 --- [Pets API Application] [  restartedMain] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:file:./db/data/petsapidb'
2025-03-27T19:41:01.206+08:00  INFO 30278 --- [Pets API Application] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2025-03-27T19:41:01.239+08:00  INFO 30278 --- [Pets API Application] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2025-03-27T19:41:01.249+08:00  INFO 30278 --- [Pets API Application] [  restartedMain] com.demo.petsapi.PetsapiApplication      : Started PetsapiApplication in 3.562 seconds (process running for 4.114)
```

#### C. Test all the API! We can use Postman or "Generate Request in HTTP Client" via your IntelliJ IDE. Here are some of the sample requests that I've made and its details:

### Sanity Check
GET http://localhost:8080/sanityCheck

### Get All Person Details
GET http://localhost:8080/getAllPersons

### Get Pet record using a Person ID
GET http://localhost:8080/getPet/1

### Add Pet using a Person ID and a Pet Name
POST http://localhost:8080/addPet/1/tiger

### Error handling
#### Get of pet with person not existing
GET http://localhost:8080/getPet/999

#### Add of pet with person not existing
POST http://localhost:8080/addPet/999/tiger


Thanks a lot in advance! I hope you still check this out and give me a change to show my technical skills. Thank you!
