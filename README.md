# Automation testing of "My Awesome App" website

I would like to express my gratitude to IT Bootcamp course and especially to the instructors Milan Jovanovic and Vladimir Minic, who provided me and my colleagues with the opportunity to learn and grow as automation testers. They have taught us a great deal and were always there to help whenever we needed it.

This is an exercise automation test using Selenium and TestNG for one of the final projects on IT Bootcamp QA course. The project was built using Maven and Java 19.

The test suite is based on the instructions from our instructors at ITBootcamp. (URL of tested website: https://vue-demo.daniel-avellaneda.com/)

## The following test cases were executed:


### Login

Test #1: Visits the login page

Test #2: Checks input types

Test #3: Displays errors when user does not exist

Test #4: Displays errors when password is wrong

Test #5: Login

Test #6: Logout


### Signup

Test #1: Visits the signup page

Test #2: Checks input types

Test #3: Displays errors when user already exists

Test #4: Signup


### Admin Cities Tests

Test #1: Visits the admin cities page and list cities

Test #2: Checks input types for create/edit new city

Test #3: Create new city

Test #4: Edit city

Test #5: Search city

Test #5: Delete city


### Auth Routes Tests

Test #1: Forbids visits to home url if not authenticated

Test #2: Forbids visits to profile url if not authenticated

Test #3: Forbids visits to admin cities url if not authenticated

Test #4: Forbids visits to admin users url if not authenticated


### Locale Tests

Test #1: Set locale to ES

Test #2: Set locale to EN

Test #3: Set locale to CN

Test #4: Set locale to FR


### Profile Tests

Test #1: Visits the profile page

Test #2: Checks input types

Test #3: Edits profile
