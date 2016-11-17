package com.backbase.automatontest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( 

		plugin = {"pretty", "html:target/html-reports"},
		features = "src/test/resources/",
		//tags = {"@regression"}
		tags = {"@test"}	
		)

public class RunnerTest {
	
	
}