# JupiterFrontEndTest

### Jupiter Money Test Automation 

#### Table of Contents

  * About the Project
  * BuiltWith
  * Getting Started
  * Pre-requisites
  * Installation guide


#### About the Project
The scope of this project is to automate the sanity as well as regression test suites for Jupiter Money application using Java, Appium based on cucumber framework.

#### Built With
* Java
* [Cucumber](https://cucumber.io/docs/cucumber/)
* [Appium](https://appium.io/docs/en/about-appium/intro/)

#### Getting Started
To start with this tool, some prerequisites have to be made, which are described below.

#### Pre-requisites
The major software or tools needed to setup and run the test script using the tool are listed down below.
* Java Development Kit 1.8
* Appium

#### Installation guide
* Install Java using the [following steps for installation](https://www.java.com/en/download/help/download_options.html) (Prefer version 1.8)
* Install Appium from the [official website](https://appium.io/)
  Appium is a server written in Node.js. It can be built and installed from source or installed directly from NPM:
  ```javascript
  $ npm install -g appium
  $ appium
  ```

#### Run Command Details
Upon installing the above-required software. Follow the below steps to trigger the execution for web :


* Navigate to the respective project directory folder where the project has been cloned using [git@github.com:rahul-varade/JupiterFrontEndTest.git](git@github.com:rahul-varade/JupiterFrontEndTest.git) and placed in a local directory from GitHub.
* In terminal, enter the following commands:
  * mvn clean - The Maven Clean Plugin, as the name implies, attempts to clean the files and directories generated by Maven during its build. While there are plugins that generate additional files, the Clean Plugin assumes that these files are generated inside the target directory.
  * mvn test - This command will start the test execution.

#### Test Execution Results
Find all of  the test execution results under JupiterFrontEndTest/target folder.
