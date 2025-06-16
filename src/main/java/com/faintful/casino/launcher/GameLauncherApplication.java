package com.faintful.casino.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.faintful.casino.client")
public class GameLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLauncherApplication.class, args);
	}

}
