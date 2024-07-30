# Project Goal
The goal of this project was to create a functional test framework for the website https://automationexercise.com/ testing numerous functional features.
The main goal of the project was to apply the knowledge that we had learned from the past few days of training including:
- Writing Gherkin Script
- Creation of Cucumber Scenarios.
- Use of selenium web framework to automate web testing.
- Utilising test reporting.
- Project management and use of issue tracking.
- Use of Git.

While application of the above skills was the critical part to performing this project we also aimed to identify any possible defects we could locate through our testing of the website and add them to reports.

# Plan
## Step 1 - Initial Meeting
Following on from the handout of the project we quickly had a meeting with all member of the project and worked on identifying what our first steps should be. We came together to plan the following:
1. Initialise a GitHub repository and project kanban board for tracking issues.
2. Manually research the website we are to test for the project and identify which testable features we should be writing up.
3. Having identified which testable features the website has we would begin to write Gherkin scripts in GitHub issues for each appropriate scenario.
4. Implement the skeleton of the test framework such as web driver functionallity,reporting and web page models.
5. Transfer the written Gherkin scripts into Cucumber features inside the project.
6. Create step definitions for the Cucumber steps; binding our Cucumber features and web page models.

## Step 2 - Initialise GitHub Repository and Project
Immediately following our meeting our first course of action was to initialise a simple barebones GitHub Repository and GitHub project Kanban board for tracking issues. \
[GitHub Repository](https://github.com/Erratika/AutomationExercise) \
[GitHub Project Kanban Board](https://github.com/users/Erratika/projects/3) 

## Step 3 - Identify Testable Features
We then proceeded to take a manual look around the website and identify what features that the website has that could be appropriate for testing in our framework. Here is a list of some of the functionallity we identified that could be tested:
- Sign-up
- Login
- Account Management
- Basket
- Checkout 
- Search & Categorisation
- View Product
- Review
- Contact Us
- Email Subscription

## Step 4 - Writing up Gherkin Scripts
The next step of pour process was to take the website features that we identified and to build test scenario's around them; further fleshing out what our test scenarios would look like. These were written into GitHub issues for each feature we identified and further elaborated upon with independent scenarios within.

## Step 5 - Implement Test Framework
After having fleshed out our testable features into Gherkin script we plan to start implementing the skeleton of our test framework. This will include:
- Instantiation of our web driver for use when running the tests for the project.
- Creating POM models for each webpage we would be utilising for our testing. 
- Adding reporting functionality so that it is available from the start.
## Step 6 Gherkin scripts to Cucumber scenarios.
Following on from the implementation of the skeleton of out test framework we then moved into taking the existing gherkin script scenarios we had written up in the issue board into Cucumber scenarios.

This was a fairly simple process, but we then made some adjustments to our scripts to adequately fit around reusability of steps.

## Step 7 
Our next step was to then take the test framework skeleton we created and our newly implemented Cucumber scenarios and meld them together with the creation of our step definitions. So that we could automate our testing through the use of our cucumber scenarios.

## Step 8 
# Running the Test Framework
1. Clone the repository. 
``git clone git@github.com:Erratika/AutomationExercise.git`` with ssh or ``git clone https://github.com/Erratika/AutomationExercise.git`` with https
2. Open terminal at root of the directory and run ``mvn clean test``

Alternatively if you are facing issues with above. (Like me)
1. Import the project into IntelliJ or your relevant IDE right-click the TestRunner.java and run.

# Features Tested
- Signup to the website.
- Login to website.
- Cart Functionallity.

# Test Metrics

Our test report can be found here: https://reports.cucumber.io/reports/90a85bae-5a9f-4eb9-9bfb-3d397f00e540
With the limited number of tests that we developed for our project 6/6 of the pass.

Duration for the test run was 55.53 seconds.

# Lessons
With the time that we had, we felt like there are a number of features and boundary tests that we could have expanded upon such as:
- Testing for Invalid Inputs and asserting errors.
- Further features such as 

Unfortunately it felt like we spent a lot of time being stuck on how to deal with the following:
- Identify appropriate selectors for selenium.
- Handling unforeseen popups such as cookie consent (when new instances of the driver are made).
- Refactoring of the project to improve reusability.
- Adding in wait handling for when test framework executes test steps too fast.

While we were unsuccessful in identifying any defects we feel like we could easily expand our existing framework and test scenarios to accommodate a lot more tests of feature functionallity.

# Contributors
Marc - README, Cart Gherkin script, Cucumber scenarios and relevant pages. Also refactoring to improve reusability of the test framework including addition of BasePage
Mamoon - Setting up the runner for the selenium/chrome web driver, Login and Signup Gherkin script, cucumber scenario and relevant pages for selenium automation.
Selam - Assisted Mamoon with implementation of the automated testing of the Login and Signup features.