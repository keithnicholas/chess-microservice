package com.baneff.gameroom.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

//    Optional<Game> findByidPlayer1(String idPlayer1);
    List<Game> findByidPlayer1(String idPlayer1);
    List<Game> findByidPlayer2(String idPlayer2);



}
