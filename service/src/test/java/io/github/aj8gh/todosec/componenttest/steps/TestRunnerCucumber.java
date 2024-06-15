package io.github.aj8gh.todosec.componenttest.steps;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import io.cucumber.spring.CucumberContextConfiguration;
import io.github.aj8gh.todosec.Application;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@CucumberContextConfiguration
//@AutoConfigureEmbeddedDatabase
@ActiveProfiles("test")
@SpringBootTest(classes = {Application.class}, webEnvironment = RANDOM_PORT)
public class TestRunnerCucumber {

}
