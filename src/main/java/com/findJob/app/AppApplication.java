package com.findJob.app;

import com.findJob.app.service.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class AppApplication{
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}
