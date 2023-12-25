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
public interface JuniorPlayerDAO {

    boolean addJuniorPlayer(JuniorPlayer juniorPlayer);

    boolean updateJuniorPlayer(JuniorPlayer juniorPlayer);

    boolean deleteJuniorPlayer(int juniorPlayerId);

    JuniorPlayer getJuniorPlayerById(int juniorPlayerId);

    List<JuniorPlayer> getAllJuniorPlayers();

    JuniorPlayer getPlayerByName(String playerName);

    List<JuniorPlayer> getAllPlayersByTeamId(int teamId);
}
