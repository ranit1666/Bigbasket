$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E:/Workspace/FlipKart/src/test/java/features/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Testcase for login into Flipkart",
  "description": "",
  "id": "testcase-for-login-into-flipkart",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "verify if user can log into flipkart",
  "description": "",
  "id": "testcase-for-login-into-flipkart;verify-if-user-can-log-into-flipkart",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user opens the browser for flipkart",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.user_opens_the_browser_for_flipkart()"
});
formatter.result({
  "duration": 27580397900,
  "status": "passed"
});
});