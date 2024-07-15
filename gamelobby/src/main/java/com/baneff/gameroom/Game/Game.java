package com.baneff.gameroom.Game;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "GAME")
@Data
@NoArgsConstructor
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @Column(name = "ID_PLAYER_1")
    private String idPlayer1;

    @Column(name = "ID_PLAYER_2")
    private String idPlayer2;

    @CreationTimestamp
    @Column(name = "GAME_START_TIME")
    private LocalDateTime gameStart;

    @Column(name = "GAME_END_TIME")
    private LocalDateTime gameEnd;

    public Game(String roomName, String idPlayer1, String idPlayer2, LocalDateTime gameStart) {
        this.roomName = roomName;
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
        this.gameStart = gameStart;
    }


    public Game(String idPlayer1, String idPlayer2) {
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
    }
}
