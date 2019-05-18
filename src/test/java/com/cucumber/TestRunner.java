package com.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources",tags={},glue="com.cucumber",plugin="html:target",monochrome=true,dryRun=false,strict=true)
public class TestRunner {

}
