/*
 * You can use the following import statements
 * import javax.persistence.*;
 * 
 */

// Write your code here

package com.example.player.model;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
public class Player {

    @Id
    @Column(name = "playerid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    @Column(name = "playername")
    private String playerName;

    @Column(name = "jerseynumber")
    private String jerseyNumber;

    @Column(name = "role")
    private String role;

    public Player() {
    }

    public Player(int playerId, String playerName, String jerseyNumber, String role) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
