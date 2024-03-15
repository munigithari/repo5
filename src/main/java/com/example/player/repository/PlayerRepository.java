// Write your code here
package com.example.player.repository;

import java.util.*;
import com.example.player.model.Player;

public interface PlayerRepository {
    ArrayList<Player> getAllPlayers();

    Player getPlayersById(int playerId);

    Player addPlayers(Player player);

    Player updatePlayers(int playerId, Player player);

    void deletePlayers(int playerId);
}