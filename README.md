# spotify-test-automation-training

**Test automation training project.**

Simple UI test automation in Java, using:
- Cucumber
- Selenium
- Failsafe plugin
- Awaitility
- Page Object Pattern with page factory
- WebDriverFactory pattern
- WebDriver manager
- Spring


**Launching the tests**
Open a terminal and type:
mvn clean verify

Supported arguments:
| argument name | possible values | default value | description                                        |
| ------------- | --------------- | ------------- | -------------------------------------------------- |
| browserName   | chrome, firefox | chrome        | tells the tests which browser to use for the tests |
| headless      | true, false     | false         | sets whether the tests should run with GUI enabled |

Example command to run tests with FireFox Driver in headless mode:
mvn clean verify -DbrowserName=firefox -Dheadless=true

You can also add -Dcucumber.filter.tags=@tagName.
Where "tagName" should be some custom tag you define.
With this parameter, only those scenarios will run that have this tag written before them in the feature files.