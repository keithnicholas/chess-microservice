package com.baneff.gameroom.Game;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }











    public Game createGame(String p1, String p2) {
        Game newGame = new Game(p1,p2);
        Game saved = gameRepository.save(newGame);

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        saved.setGameEnd(LocalDateTime.now());
        return gameRepository.save(saved);

    }


















    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Optional<Game> getGameByPlayer(){
        return null;
    }


}
