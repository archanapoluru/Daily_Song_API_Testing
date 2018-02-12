package com.get.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/main/java/com/get/feature/PostAPlaylist.feature"},
		glue = {"com.get.StepDfn"}
		)	

public class PostAPlaylistRunner {

}
