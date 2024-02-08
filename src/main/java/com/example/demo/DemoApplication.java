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
		
		String post_url = "https://graph.facebook.com/v19.0/cricketvideosindian/feed";

		//String response = postText(message, token, rt, url);

//		System.out.println(response);

		String imagePostURL = "https://graph.facebook.com/v19.0/cricketvideosindian/photos";

		String imageURL = "https://static.toiimg.com/thumb/msid-107389941,width-400,resizemode-4/107389941.jpg";

//		String res = postImage(imageURL, token, rt, imagePostURL);

	}

	private static String postImage(String imageURL, String token, RestTemplate rt, String imagePostURL) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json = "{\n" +
				"           \"url\":\"" + imageURL + "\",\n" +
				"           \"access_token\":\""+ token +"\"\n" +
				"         }";

		HttpEntity<String> request = new HttpEntity<>(json,headers);

		return rt.postForObject(imagePostURL, request, String.class);
	}

	private static String postText(String message, String token, RestTemplate rt, String url) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		String json = "{\n" +
				"           \"message\":\"" + message + "\",\n" +
				"           \"access_token\":\""+ token +"\"\n" +
				"         }";

		HttpEntity<String> request = new HttpEntity<>(json,headers);

		return rt.postForObject(url, request, String.class);
	}

}
