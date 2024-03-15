/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here

package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.player.repository.PlayerRepository;
import com.example.player.repository.PlayerJpaRepository;
import com.example.player.model.Player;

@Service
public class PlayerJpaService implements PlayerRepository {

    @Autowired
    private PlayerJpaRepository repository;

    @Override
    public ArrayList<Player> getAllPlayers() {
        List<Player> list = repository.findAll();
        ArrayList<Player> palyers = new ArrayList<>(list);
        return palyers;
    }

    @Override
    public Player getPlayersById(int playerId) {
        try {
            Player players = repository.findById(playerId).get();
            return players;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player addPlayers(Player player) {
        repository.save(player);
        return player;
    }

    @Override
    public Player updatePlayers(int playerId, Player player) {
        try {
            Player players = repository.findById(playerId).get();
            if (player.getPlayerName() != null) {
                players.setPlayerId(player.getPlayerId());
            }
            if (player.getJerseyNumber() != null) {
                players.setJerseyNumber(player.getJerseyNumber());
            }
            if (player.getRole() != null) {
                players.setRole(player.getRole());
            }

            repository.save(players);
            return players;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayers(int playerId) {
        try {
           repository.deleteById(playerId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}