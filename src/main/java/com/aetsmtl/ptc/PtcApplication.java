package com.aetsmtl.ptc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
public class PtcApplication extends ServletInitializer{

	private static Class<PtcApplication> applicationClass = PtcApplication.class;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(applicationClass, args);
	}

}
