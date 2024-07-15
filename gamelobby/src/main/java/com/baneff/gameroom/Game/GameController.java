package com.baneff.gameroom.Game;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/igat/{idPlayer1}")
    public List<Game> findByidPlayer1(@PathVariable String idPlayer1){
        return gameRepository.findByidPlayer1(idPlayer1);
    }
}
