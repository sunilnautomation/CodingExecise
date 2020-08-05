$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("WebDriverCodingExercise.feature");
formatter.feature({
  "line": 1,
  "name": "Find workshop flow validation",
  "description": "",
  "id": "find-workshop-flow-validation",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4610481600,
  "status": "passed"
});
formatter.before({
  "duration": 24818494,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "To Verify the Find workshop flow",
  "description": "",
  "id": "find-workshop-flow-validation;to-verify-the-find-workshop-flow",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@WebDriverExerciseTests"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on Home page of \"WW International\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I assert that loaded page title matches",
  "rows": [
    {
      "cells": [
        "\"WW (Weight Watchers): Weight Loss \u0026 Wellness Help | WW USA\""
      ],
      "line": 7
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I click on \"Find a Workshop\" found on the right corner",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I assert that loaded page title matches",
  "rows": [
    {
      "cells": [
        "\"Find WW Studios \u0026 Meetings Near You | WW USA\""
      ],
      "line": 10
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I search for the meetings at zip code",
  "rows": [
    {
      "cells": [
        "10011"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I print the title of the first result and the distance",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click on first search result",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I assert that loaded page title matches with first result",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I print TODAY’s hours of operation",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I print the number of meeting the each person for each day",
  "rows": [
    {
      "cells": [
        "SUN"
      ],
      "line": 18
    },
    {
      "cells": [
        "MON"
      ],
      "line": 19
    },
    {
      "cells": [
        "TUE"
      ],
      "line": 20
    },
    {
      "cells": [
        "WED"
      ],
      "line": 21
    },
    {
      "cells": [
        "THU"
      ],
      "line": 22
    },
    {
      "cells": [
        "FRI"
      ],
      "line": 23
    },
    {
      "cells": [
        "SAT"
      ],
      "line": 24
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "WW International",
      "offset": 22
    }
  ],
  "location": "WWStepDefinition.i_am_om_Home_page_of(String)"
});
formatter.write("WW International\u0027s home page url is ::https://www.weightwatchers.com/us/");
formatter.result({
  "duration": 1107394774,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_assert_that_loaded_page_title_matches(DataTable)"
});
formatter.result({
  "duration": 429412687,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Find a Workshop",
      "offset": 12
    }
  ],
  "location": "WWStepDefinition.i_click_on_found_on_the_right_corner(String)"
});
formatter.result({
  "duration": 717007603,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_assert_that_loaded_page_title_matches(DataTable)"
});
formatter.result({
  "duration": 21114338,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_search_for_the_meetings_at_zip_code(DataTable)"
});
formatter.result({
  "duration": 1934527259,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_print_the_title_of_the_first_result_and_the_distance()"
});
formatter.write("The title of the first result and the distance :: ");
formatter.write("WW Studio Flatiron");
formatter.write("0.49 mi");
formatter.result({
  "duration": 546924086,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_click_on_first_search_result()"
});
formatter.result({
  "duration": 206380204,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_assert_that_loaded_page_title_matches_with_first_result()"
});
formatter.result({
  "duration": 1394645668,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_print_TODAY_s_hours_of_operation()"
});
formatter.write("TODAY (WED)’s hours of operation :: ");
formatter.write("10:00 AM");
formatter.write("12:15 PM");
formatter.write("5:30 PM");
formatter.result({
  "duration": 764529168,
  "status": "passed"
});
formatter.match({
  "location": "WWStepDefinition.i_print_the_number_of_meeting_the_each_person_for_each_day(DataTable)"
});
formatter.write("Number of meeting the each person(under the scheduled time) has on SUNDAY of the week :: ");
formatter.write("JOHN B. 3");
formatter.write("Number of meeting the each person(under the scheduled time) has on MONDAY of the week :: ");
formatter.write("DANA F. 1");
formatter.write("LISA S. 2");
formatter.write("Number of meeting the each person(under the scheduled time) has on TUEDAY of the week :: ");
formatter.write("ARANSAS S. 2");
formatter.write("LAUREN C. 2");
formatter.write("Number of meeting the each person(under the scheduled time) has on WEDDAY of the week :: ");
formatter.write("CAMI B. 2");
formatter.write("MARIA S. 1");
formatter.write("Number of meeting the each person(under the scheduled time) has on THUDAY of the week :: ");
formatter.write("DIANE M. 1");
formatter.write("MINDI K. 2");
formatter.write("STEVEN H. 2");
formatter.write("Number of meeting the each person(under the scheduled time) has on FRIDAY of the week :: ");
formatter.write("RICARDO M. 1");
formatter.write("SILMARA R. 2");
formatter.write("Number of meeting the each person(under the scheduled time) has on SATDAY of the week :: ");
formatter.write("ROBERT B. 3");
formatter.result({
  "duration": 2430434597,
  "status": "passed"
});
formatter.after({
  "duration": 90356,
  "status": "passed"
});
formatter.after({
  "duration": 241767396,
  "status": "passed"
});
});