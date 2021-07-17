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
  

### How to create the command line based runnable jar from IDE like eclipse?
Create a runnable JAR with **com.carparkingsystem.ParkingLotSystem.java** in **Launch Configuration**

## Or Build from CLI
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

**Input:**
------------
Create_parking_lot 6

**Output**
------------
Created parking of 6 slots

**Input:**
------------
Park KA-01-HH-1234 driver_age 21

**Output**
------------
Car with vehicle registration number "KA-01-HH-1234" has been parked at slot number 1

**Input:**
------------
Park PB-01-HH-1234 driver_age 21

**Output**
------------
Car with vehicle registration number "PB-01-HH-1234" has been parked at slot number 2

**Input:**
------------
Slot_numbers_for_driver_of_age 21

**Output**
------------
1,2

**Input:**
------------
Slot_numbers_for_driver_of_age 18

**Output**
------------
No parked car matches the query

**Input:**
------------
Park PB-01-TG-2341 driver_age 40

**Output**
------------
Car with vehicle registration number "PB-01-TG-2341" has been parked at slot number 3

**Input:**
------------
Slot_number_for_car_with_number PB-01-HH-1234

**Output**
------------
2

**Input:**
-----------
Leave 2

**Output**
------------
Slot number 2 vacated, the car with vehicle registration number "PB-01-HH-1234" left the space, the driver of the car was of age 21

**Input:**
------------
Park HR-29-TG-3098 driver_age 39

**Output**
------------
Car with vehicle registration number "HR-29-TG-3098" has been parked at slot number 2

**Input:**
------------
Slot_number_for_car_with_number PB-01-HH-6789

**Output**
------------
No parked car matches the query

**Input:**
------------
Vehicle_registration_number_for_driver_of_age 18

**Output**
------------
No parked car matches the query

**Input:**
------------
Terminate

**Output**
------------
Terminating the program...exiting the command line interface....
