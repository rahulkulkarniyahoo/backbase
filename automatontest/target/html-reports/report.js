$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BackbaseTest.feature");
formatter.feature({
  "line": 1,
  "name": "Execute Test Cases as per requirement set",
  "description": "",
  "id": "execute-test-cases-as-per-requirement-set",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1011007077,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Have fun",
  "description": "",
  "id": "execute-test-cases-as-per-requirement-set;have-fun",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on test main page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click on Add a new computer button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Enter valid data values for \u003cComputer name\u003e in test",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I sleep tonight",
  "rows": [
    {
      "cells": [
        "Computer name"
      ],
      "line": 9
    },
    {
      "cells": [
        "\"Duplicate\""
      ],
      "line": 10
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.i_am_on_test_main_page()"
});
formatter.result({
  "duration": 1571448923,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_click_on_Add_a_new_computer_button()"
});
formatter.result({
  "duration": 185004765,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.enter_valid_data_values_for_Computer_name_in_test()"
});
formatter.result({
  "duration": 44306,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.i_sleep_tonight(DataTable)"
});
formatter.result({
  "duration": 2230653,
  "status": "passed"
});
formatter.after({
  "duration": 5135360891,
  "status": "passed"
});
});