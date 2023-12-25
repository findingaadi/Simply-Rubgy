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
public interface TeamDAO {

    List<Team> getAllTeams();

    Team getTeamById(int teamId);
    
    Team getTeamByName(String teamName);

    boolean addTeam(Team team);

    boolean updateTeam(Team team);

    boolean deleteTeam(int teamId);
}
