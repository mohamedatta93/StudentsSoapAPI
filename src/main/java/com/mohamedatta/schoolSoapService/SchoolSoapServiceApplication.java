package com.mohamedatta.schoolSoapService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.mohamedatta.schoolSoapService.services.StudentRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.mohamedatta.schoolSoapService","https.www_howtodoinjava_com.xml.school"})
public class SchoolSoapServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolSoapServiceApplication.class, args);
	}

}
