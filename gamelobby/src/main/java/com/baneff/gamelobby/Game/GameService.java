package com.baneff.gamelobby.Game;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);

    private final GameRepository gameRepository;
    private final GameRunner gameRunner;


    public GameService(GameRepository gameRepository, GameRunner gameRunner) {
        this.gameRepository = gameRepository;
        this.gameRunner = gameRunner;
    }

    public Game createGame(String p1, String p2) {
        LOGGER.info("Creating game with p1:{}, p2:{}", p1, p2);
        Game newGame = new Game(p1,p2);
        newGame.setGameEnd(null);
        Game saved = gameRepository.save(newGame);

        Future<Boolean> runTask = gameRunner.doGameAsync(saved, gameRepository);
        return newGame;
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }


}
