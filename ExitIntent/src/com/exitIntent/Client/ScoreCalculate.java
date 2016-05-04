package com.exitIntent.Client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ScoreCalculate {
	
	
	public static String calculateScore()
	{
	   // final String uri = "http://exit.intent.com:9090/getIntent";
	    final String uri = "http://localhost:9090/getIntent";
	    
	    
	    String token ="mykdf";
	    String totalTime = "450";
	    String pageTime="12" ;
	    String mouseHover="2";
	    String initScore ="420";
	    String pageVisited ="1" ;
	 
	  
	    
	    RestTemplate restTemplate = new RestTemplate();

	   
	 //   String mess0 =" {\"token\":\"mykdf\", \"totalTime\" : \"45\", \"pageTime\" :\"12\" ,  \"mouseHover\" :\"2\" ,  \"initScore\" :\"421\" , \"pageVisited\" :\"2\" }" ;
	      
	    

	    String mess =" {"
	    		+ "\"token\"          :" + "\""+ token         +      "\","
	    		+ "\"totalTime\"      :" + "\""+totalTime      +      "\","
	    		+ "\"pageTime\"       :" + "\""+ pageTime      +      "\","
	    		+ "\"mouseHover\"     :" + "\""+mouseHover     +      "\","
	    		+ "\"initScore\"      :"+ "\""+ initScore      +      "\","
	    		+ "\"pageVisited\"    :"+ "\""+pageVisited      
	    		
	    		+    "\"}" ;
	    
	    
	   // System.out.println(mess0);
	    System.out.println(mess);
	    
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<String> entity = new HttpEntity<String>(mess,headers);
	    String answer = restTemplate.postForObject(uri, entity, String.class);
	    System.out.println(answer);
	    
		return answer;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

}
