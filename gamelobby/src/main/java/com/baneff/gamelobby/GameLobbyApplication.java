package com.baneff.gamelobby;

import com.baneff.gamelobby.Game.Game;
import com.baneff.gamelobby.Game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableAsync
public class GameLobbyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLobbyApplication.class, args);
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

	@Bean(name="GameLobbyExecutor")
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setThreadNamePrefix("baneff-");
		threadPoolTaskExecutor.setCorePoolSize(2);
		threadPoolTaskExecutor.setMaxPoolSize(6);
		threadPoolTaskExecutor.setQueueCapacity(5);
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}
}


