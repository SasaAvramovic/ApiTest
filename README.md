# **RealStaq test project**

## **How to run tests**
- by Junit runner - just run class CucumberRunner in runners package (src/test/java/api/runners)

NOTE: One test is failing since response is unexpected
Report is generated as cucumber-reports.html

**Prerequisites**
- Apache Maven 3.8.2
- Open JDK 18
- IntelliJIDEA - with lombok, cucumber plugins

**Dependencies**
- JUnit runner
- cucumber
- rest assured
- Gson
- Allure
- assertJ

**Introduction**

The task is to cover one API request with both positive and negative automated tests.
The request is to find all houses in a specific city with a defined price range.
For example, you want to find a house in New York with a price range from 200k to 500k.
How to run the "Houses API" locally:
- Install npm - https://www.npmjs.com/get-npm
- Run command: "npm install -g json-server", if you need any additional information you can visit
  this link https://github.com/typicode/json-server
- Unzip the attachment file and copy provided db.json file locally
- Go to the path where you copied the db.json file
- Run command: "json-server --watch db.json"
  Now the API you need to test is up and running on the localhost:3000.
  If you go the route http://localhost:3000/houses you will be able to see all houses that the API
  can return.
  For the request that you need to write tests for you will need three parameters:
- city - City name
- price_gte - Price lower limit
- price_lte - Price upper limit
  Example of the request:
  http://localhost:3000/houses?price_gte=450000&price_lte=666000&city=Austin




