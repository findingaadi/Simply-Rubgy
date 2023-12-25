/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

import java.util.List;

/**
 *
 * @author HP
 */
public interface PlayerDAO {

    boolean addPlayer(Player player);

    boolean updatePlayer(Player player);

    boolean deletePlayer(int playerId);

    Player getPlayerById(int playerId);

    List<Player> getAllPlayers();

    List<Player> getAllPlayersByTeamId(int teamId);

    Player getPlayerByName(String playerName);
}
