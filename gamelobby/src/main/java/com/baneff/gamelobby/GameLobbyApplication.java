package com.baneff.gamelobby;

import com.baneff.gamelobby.Game.Game;
import com.baneff.gamelobby.Game.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(GameLobbyApplication.class);
	@Autowired
	GameRepository gameRepository;


	public static void main(String[] args) {
		SpringApplication.run(GameLobbyApplication.class, args);

		/*
			Hardcoded for now to display swagger endpoint
			Change log message later to
			extract the url from application.properties via @Configuration
		*/
		LOGGER.info("Swagger UI exposed at {}", "/swagger-ui/swag/wagger");
	}


	@Bean
	public CommandLineRunner startup() {
		return args -> {

			gameRepository.save(
					new Game("baneff", "igat", "keith", LocalDateTime.now())
			);

			LOGGER.info("Database initialized!");
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


