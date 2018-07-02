package serenityrest.stepdefinitions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import serenityrest.actions.SixtApiActions;

import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import java.util.HashMap;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import org.junit.Assert;

public class SixtApiStepDefinitions  {

	@Steps
	private SixtApiActions sixtApiActions;
	
	@When("I Get Sixt Api")
	public void whenXCallOnSomeApi()
	{
		sixtApiActions.getApi();
	}
	

	@Then("Status Code returned $statusCode")
	public void thenValidateStatusCode(String statusCode)
	{
		Assert.assertEquals(statusCode, String.valueOf(sixtApiActions.getStatusCode()));
	}
	
	@Then("Value returned by jsonKey $jsonKey as jsonValue $jsonValue")
	public void thenValidateJsonValue(String jsonKey,String jsonValue)
	{
		Assert.assertEquals(sixtApiActions.getJsonValue(jsonKey),jsonValue);
	}
    
}