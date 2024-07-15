package com.baneff.gameroom;

import com.baneff.gameroom.Game.Game;
import com.baneff.gameroom.Game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GameroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameroomApplication.class, args);
	}

	@Autowired
	GameRepository gameRepository;

	@Bean
	public CommandLineRunner startup() {

		return args -> {

			gameRepository.save(
					new Game("baneff", "igat", "keith", LocalDateTime.now())
			);

			System.out.println("Database initialized!");

		};

	}
}


