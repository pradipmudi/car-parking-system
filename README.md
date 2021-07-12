# car-parking-system

A command line based car parking system implementation 

## How to configure the project?
* Java version used: 1.8
* Maven version used: 4.0.0
* Clone the project from GIT repo and import the project as "Existing Maven Project"(If you are using Eclipse)
* All the dependencies are metioned in the **'pom.xml'** file, after cloning the project simply clean and build it
* Build configurations and Dependencies used in the project : 


        
  
        <build>
          <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <classpathPrefix>libs/</classpathPrefix>
                            <mainClass>
                                com.carparkingsystem.ParkingLotSystem
                            </mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
          </plugins>
        </build>
        <dependencies>
          <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
          </dependency>
        </dependencies>
  

### How to create the command line based runnable jar?
Create a runnable JAR with **com.carparkingsystem.ParkingLotSystem.java** in **Launch Configuration**

## Build from CLI
* Open terminal
* Go to project directory
* Run "mvn clean"
* Run "mvn install"
* Runnable jar will be created in the "target" directory


#### How to run from command line ?

* Go to the target directory of the jar and run as shown in the examples : 



 ## Examples :
 First run the jar, then keep entering the commands:
 
**java -jar jar_name.jar**

**Create_parking_lot 6**

**Park KA-01-HH-1234 driver_age 21**

**Slot_numbers_for_driver_of_age 21**

**Slot_number_for_car_with_number PB-01-HH-1234**

**Vehicle_registration_number_for_driver_of_age 18**

**Leave 2**

**Terminate**

Terminate to exit the command line argument
