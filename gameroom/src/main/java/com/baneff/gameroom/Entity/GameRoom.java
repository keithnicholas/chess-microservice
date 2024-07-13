package com.baneff.gameroom.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "GAME_ROOM")
public class GameRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROOM_NAME")
    private String roomName;
}
