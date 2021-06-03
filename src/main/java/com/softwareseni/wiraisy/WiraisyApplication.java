package com.softwareseni.wiraisy;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class WiraisyApplication {

	public static void main(String[] args) {
       SpringApplication.run(WiraisyApplication.class, args);	
	}
	
	 @Bean
	 private static void openHomePage() throws IOException {
	       Runtime rt = Runtime.getRuntime();
	       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8010/swagger-ui.html");
	    }

}
