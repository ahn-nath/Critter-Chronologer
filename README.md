# Critter Chronologer Project Starter
### "Is it time for my appointment yet?"
Critter Chronologer a Software as a Service application that provides a scheduling interface for a small business that takes care of animals. This Spring Boot project will allow users to create pets, owners, and employees, and then schedule events for employees to provide services for pets.

## Tech

* [Java SE Development Kit 8+](https://www.oracle.com/technetwork/java/javase/downloads/index.html) - computing platform for development and deployment of portable code for desktop and server environments.
* [Maven](https://maven.apache.org/download.cgi) - software project management and comprehension tool
* [PostgreSQL](https://www.postgresql.org/) - open source object-relational database system
* [Postman](https://www.getpostman.com/downloads/)  - collaboration platform for API development
* [Spring Boot](https://spring.io/projects/spring-boot) - framework providing dependency injection, web framework, data binding, resource management, transaction management, and more.
* [Google Guava](https://github.com/google/guava) - set of core libraries used in this project for their collections utilities.
* [H2 Database Engine](https://www.h2database.com/html/main.html) - sn in-memory database used in this project to run unit tests.


## Installation
Part of this project involves configuring a Spring application to connect to an external data source. Before beginning this project, you must install a database to connect to. Here are [instructions for installing PostgreSQL 8](https://www.postgresql.org/docs/9.3/tutorial-install.html). 

You should install the Server and Connector/J, but it is also convenient to install the Documentation and Workbench.

For this project, I used PostgreSQL. However, another SQL database may be used if desired.
### Steps
Clone this repository and import into your preferred IDE.

```
https://github.com/ahn-nath/Critter-Chronologer.git
```

Run the project, open a browser and navigate to the url: [http://localhost:8082/test](http://localhost:8082/test)

You should see the message "Critter Starter installed successfully" in your browser.

## Testing

Once you have completed the above installation, you should also be able to run the included unit tests to verify basic functionality as you complete it. To run unit tests:

1. Within your project in IDEA, Navigate to `src/test/java/com.udacity.jdnd.course3.critter`.
2. Within that directory, click on `CritterFunctionalTest.java` and select `Run` -> `Run CritterFunctionalTest`.

### Tested Conditions
Tests will pass under the following conditions:

* `testCreateCustomer` - **UserController.saveCustomer** returns a saved customer matching the request
* `testCreateEmployee` - **UserController.saveEmployee** returns a saved employee matching the request
* `testAddPetsToCustomer` - **PetController.getPetsByOwner** returns a saved pet with the same id and name as the one saved with **UserController.savePet** for a given owner
* `testFindPetsByOwner` - **PetController.getPetsByOwner** returns all pets saved for that owner.
* `testFindOwnerByPet` - **UserController.getOwnerByPet** returns the saved owner used to create the pet.
* `testChangeEmployeeAvailability` - **UserController.getEmployee** returns an employee with the same availability as set for that employee by **UserControler.setAvailability**
* `testFindEmployeesByServiceAndTime` - **UserController.findEmployeesForService** returns all saved employees that have the requested availability and skills and none that do not
* `testSchedulePetsForServiceWithEmployee` - **ScheduleController.createSchedule** returns a saved schedule matching the requested activities, pets, employees, and date
* `testFindScheduleByEntities` - **ScheduleController.getScheduleForEmployee** returns all saved schedules containing that employee. **ScheduleController.getScheduleForPet** returns all saved schedules for that pet. **ScheduleController.getScheduleForCustomer** returns all saved schedules for any pets belonging to that owner.

### Postman
In addition to the included unit tests, a Postman collection has been provided. 

1. Open Postman.
2. Select the `Import` button.
3. Import the file found in this repository under `src/main/resource/Udacity.postman_collection.json`
4. Expand the Udacity folder in postman.

Each entry in this collection contains information in its `Body` tab if necessary and all requests should function for a completed project. Depending on your key generation strategy, you may need to edit the specific ids in these requests for your particular project.


 
