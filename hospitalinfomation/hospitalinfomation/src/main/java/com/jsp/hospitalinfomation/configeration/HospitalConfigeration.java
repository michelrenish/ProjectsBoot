package com.jsp.hospitalinfomation.configeration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class HospitalConfigeration {
	
	@Bean
	public OpenAPI userOpenApi() {
		  Server server = new Server();
	        server.setUrl("http://localhost:8080");
	        server.setDescription("Local development server");
	        
	        Contact c = new Contact();
	        c.setName("Michel");
	        c.setUrl("https://github.com/michelrenish/Java-8-Program");
	        
	        License license = new License();
	        license.setName("MIT License");
	        license.setUrl("https://opensource.org/license/mit");
	        
	        Info info = new Info();
	        info.license(license);
	        info.contact(c);
	        
			return new OpenAPI().info(info);
	}
}
