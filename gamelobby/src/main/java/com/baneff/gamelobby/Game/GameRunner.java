package com.baneff.gamelobby.Game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Component
public class GameRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameRunner.class);

    @Async("GameLobbyExecutor")
    public CompletableFuture<Boolean> doGameAsync(Game theGame, GameRepository repo){
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            LOGGER.info("Game has crashed. {}", e.getLocalizedMessage());
            Thread.currentThread().interrupt();
            return CompletableFuture.completedFuture(false);
        }
        theGame.setGameEnd(LocalDateTime.now());

        repo.save(theGame);

        return CompletableFuture.completedFuture(true);
    }
}
