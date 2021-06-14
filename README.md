Coverage: 80.6 %

##Java based IMS Project

   This project involves a simple inventory management coded in java system that allows a user to perform CRUD functionalities customers, items and orders as well as showing the   total cost of the order.
  

## Getting Started

1. Download GIT bash from:https://git-scm.com/
2. Fork the repository to your own account
3. Click on green code button to clone repo
4. Open up git bash and git clone the https link
5. If you have an IDE, you can import the project or follow links below
6. Run the file by typing java -jarims-0.01-jar-with-dependencies.jar

### Prerequisites

1.MySQL - https://dev.mysql.com/downloads/installer/
2.Eclipse IDE - https://www.eclipse.org/downloads/
3.MAVEN - https://maven.apache.org/
4.JAVA - 
5.JUnit dependancy - <dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
</dependencies>

```

### Installing

JAVA For Windows:
1. Get the JDK(Java development kit) - https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
2. Click on the download link and download
3. Keep clicking next until it is installed
4. Press the Windows button and select "Edit the system environment variables"
5. Click Environmental variables
6. Click new
7. Write "JAVA_HOME" as variable name and click OK
8. Click  Edit Path under System Variables
9. Append the path bypey writing %JAVA_HOME%\bin;

JAVA for Ubuntu:
1.Open terminal
2.Type: "sudo apt install openjdk-8-jdk -y"
3.Verify by running java -versuon


MySQL
1.Download the installer from the link above 
2.Choose your system preference
3.Pick MySQL server 8 and MySQL Workbench
4.Clcik next
5.Open a command prompt and type:  cd C:\Program Files\MySQL\MySQL Server 8.0\bin
6.Then write:  mysqld --console --initialize
7.Check if it has initialised by: mysqld --console
8.Open a new prompt and type: cd C:\Program Files\MySQL\MySQL Server 8.0\bin
 mysql -u root -p
9. Resest the password:  ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';

MAVEN:
Download from above and add dependancies in the pom.xml file
JUnit:
JUnit 5 can be found on the Maven repository. Copy and paste the dependance and place it in the pom.xml file.
It should look like:
xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.qa</groupId>
    <artifactId>maven-example</artifactId>
    <version>1.0.0-SNAPSHOT</version>

    <properties>
        <junit.version>4.12</junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

Download Eclipse from Website above.

The .jar file can be run by typing: In the command prompt.

```

## Running the tests
Once you have Eclipse and maven installed, as well as the JUnit dependancy, the tests can be run by left clicking on the respective test class or the whole folder, and select run as JUnit configuration. Select coverage as to see the all the bits of code that are tested.

### Unit Tests 

Unit tests are test where bits of code or classes are tested individually. All tests in this project are unit tests

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Agile Board
[JIRA] (https://team-1616578727154.atlassian.net/secure/RapidBoard.jspa?rapidView=3&projectKey=IMS&atlOrigin=eyJpIjoiYWQ5ZTI2MjU4YjI0NGNkYzljZDE3MjA1ODE1Yjk0Y2QiLCJwIjoiaiJ9) - 



## Authors

* **Neel Dudhia** - * - [NeelDudhia](https://github.com/NeelDQA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*

## Acknowledgments
Thank you to Savannah, Aswene, Shafeeq and Alan for all their help throughout the project.
