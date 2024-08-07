package com.baneff.gamelobby.Game;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameRepository gameRepository;
    private final GameService gameService;

    public GameController(GameRepository gameRepository, GameService gameService) {
        this.gameRepository = gameRepository;
        this.gameService = gameService;
    }

    @GetMapping("/searchp1/{idPlayer1}")
    public List<Game> findByidPlayer1(@PathVariable String idPlayer1){
        return gameRepository.findByidPlayer1(idPlayer1);
    }

    @GetMapping("/{p1}/{p2}")
    public Game createGame(@PathVariable String p1, @PathVariable String p2){
        return gameService.createGame(p1,p2);
    }

}
