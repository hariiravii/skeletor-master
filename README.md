

## Overview and Requirements
* Java 8
* Maven
*****

  
  
**Part 1:  Web API Technical Assessment**

The Movie DB project (www.themoviedb.org) is a free community built database of movie and TV meta data.  TMDB also provides a free API web service that provides movie buffs with a wealth of information and details regarding their favorite movies and allows the information to be integrated with both commercial and open source media related applications.  A large consumer of TDMB data is the web applications Plex Media Server https://www.plex.tv/

The APIs are all REST and return JSON data.  Visit https://developers.themoviedb.org/3/getting-started for detailed documentation regarding the API.  Your assignment should you choose to accept it is to pretend as though you were writing automated test cases on a new release of the TMDB API.

The requirements for the assessment are as follows:
1. Assume the new "feature" for the release you are testing is movie search
2. Use our existing framework and libraries to create some tests for movie search
3. Stub out all those tests with functions and using comments in the code write TODOs for the name of the tests and 1-2 sentences describing what the test will do and why
4. Implement 3-4 of the tests with actual runnable code
5. Clear, concise code is important
6. Code maintenance is paramount... any new libraries added should account for this
7. Bonus points are given for non-happy path test scenarios and more creative approaches
8. The TV search tests are samples to get you started.  While we would expect that you are following a similar **pattern** don't assume that the TV tests are complete, i.e.:
     - An **exact** copy/paste of the TV tests modified to Movie tests is not what your goal should be
     - They are probably not doing all the assertion needed
     - They are not covering all the test scenarios
     
`NOTE:  if you are using IntelliJ, to run the tests you should be able to just right click on the test Class or Method and select "Run '<test>'"`
     
     
**Part 2:  Web UI Technical Assessment**

We would like to assess how you create a simple Web test. 

Test case:
1.	Use the website https://www.saucedemo.com/ as the test site
2.	Create a test that logs in as the user: standard_user  password: secret_sauce
3.	Add the “Sauce Labs Onesie” to the cart
4.	Add the “Sauce Labs Bike Light” to the cart
5.	Verify both items are in the cart

The requirements for the assessment are as follows:
1. Use our existing framework and libraries to create this additional test case
2. Clear, concise code is important
3. Code maintenance and robustness is paramount... any new libraries/page object added should account for this. **Fragile** page elements will lose points


`NOTE:  if you are using IntelliJ, to run the tests you should be able to just right click on the test Class or Method and select "Run '<test>'"`

