package com.agastya.stepDefination;

import com.agastya.base.Keyword;
import io.cucumber.core.cli.Main;
import com.agastya.config.Configuration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FirstStepDef {
    Configuration config=new Configuration();
    Keyword keyword = new Keyword();


    @Given("Open chrome")
    public void openChrome() {
        keyword.openBrowser("chrome");
    }

    @When("Open Browser")
    public void openBrowser() {
    	keyword.openBrowser("Firefox");
    }

    @When("Launch URL")
    public void launchUrl() {
        keyword.launchUrl(config.getAppUrl("beta"));
    }
}