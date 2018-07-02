package serenityrest.actions;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import serenityrest.runner.ConfigReader;
import serenityrest.runner.UrlConstantsAPI;

public class SixtApiActions  {

public Response response;
public static String URL_ENDPOINT;

   static
   {
	   Map<String,String> hmap = ConfigReader.configRead("src//test//resources//config.properties");
	   URL_ENDPOINT = hmap.get("api.endpoint");	   
   }

	@Step
	public void getApi()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		//response = SerenityRest.given().headers(map).body("").when().post();
		System.out.println(URL_ENDPOINT + UrlConstantsAPI.SAMPLE.url().toString());
		response = SerenityRest.given().contentType("application/json").when().get(URL_ENDPOINT + UrlConstantsAPI.SAMPLE.url().toString());
	}
	
	@Step
	public int getStatusCode()
	{
		return response.getStatusCode();
	}
	
	@Step
	public String getJsonValue(String jsonKey)
	{
		return response.getBody().jsonPath().get(jsonKey);
	}
}