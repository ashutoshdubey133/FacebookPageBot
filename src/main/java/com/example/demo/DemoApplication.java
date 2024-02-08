package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		RestTemplate rt = new RestTemplate();

		String message = "Hi From Java";

		//Add Your Token Here

		String token = "";
		String url = "https://graph.facebook.com/v19.0/cricketvideosindian/feed";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json = "{\n" +
				"           \"message\":\"" + message + "\",\n" +
				"           \"access_token\":\""+ token +"\"\n" +
				"         }";

		HttpEntity<String> request = new HttpEntity<>(json,headers);

		String response = rt.postForObject(url, request, String.class);

		System.out.println(response);
	}

}
