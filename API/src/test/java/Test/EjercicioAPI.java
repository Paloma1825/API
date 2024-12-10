package Test;

import java.util.ArrayList;

import javax.annotation.meta.When;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class EjercicioAPI {
	

	@Test
	public void Test() {
		
		Response respuesta =RestAssured.get("https://duckduckgo.com/?q=Toledo&format=json");
				
		System.out.print(respuesta.getBody().asString());
		
		boolean resultado= respuesta.jsonPath().getString("AbstractSource").equals("Wikipedia");	
		
		if (resultado==true)
		{
			System.out.print("\n");
			System.out.print(respuesta.jsonPath().getString("AbstractSource"));
			String url = respuesta.jsonPath().getString("AbstractURL");
			System.out.print("\n");
			System.out.print(url);
			int navegar = RestAssured.get(url).getStatusCode();
			System.out.print("\n");
			if(navegar==200) {
				System.out.print(RestAssured.get(url).getStatusCode());
			}
			
		}
			
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(respuesta.jsonPath().getString("AbstractURL"));
		list.add(respuesta.jsonPath().getString("RelatedTopics.FirstURL[0]"));
		
		System.out.print("\n");
		System.out.print(list);
	
	}
}
