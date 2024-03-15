/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here

package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;

@RestController
public class PlayerController {

    @Autowired
    private PlayerJpaService service;

    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayersById(@PathVariable("playerId") int playerId) {
        return service.getPlayersById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayers(@RequestBody Player player) {
        return service.addPlayers(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayers(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return service.updatePlayers(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayers(@PathVariable("playerId") int playerId) {
        service.deletePlayers(playerId);
    }
}
