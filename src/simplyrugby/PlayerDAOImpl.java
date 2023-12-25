/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PlayerDAOImpl implements PlayerDAO {

    private Connection connection = DBConnection.getConnection();
    TeamDAO teamDAO = new TeamDAOImpl();

    @Override
    public boolean addPlayer(Player player) {
        boolean success = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO player (name, sru_num, address, phone, post_code, doctor, next_of_kin, team_id,known_health) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");
            statement.setString(1, player.getName());
            statement.setString(2, player.getSruNum());
            statement.setString(3, player.getAddress());
            statement.setString(4, player.getPhone());
            statement.setInt(5, player.getPostCode());
            statement.setString(6, player.getDoctor());
            statement.setString(7, player.getNextOfKin());
            statement.setInt(8, player.getTeam().getTeamId());
            statement.setString(9, player.getKnownHealth());
            success = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean updatePlayer(Player player) {
        boolean success = false;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE player SET name=?, sru_num=?, address=?, phone=?, post_code=?, doctor=?, next_of_kin=?, team_id=?, known_health=? WHERE player_id=?");
            statement.setString(1, player.getName());
            statement.setString(2, player.getSruNum());
            statement.setString(3, player.getAddress());
            statement.setString(4, player.getPhone());
            statement.setInt(5, player.getPostCode());
            statement.setString(6, player.getDoctor());
            statement.setString(7, player.getNextOfKin());
            statement.setInt(8, player.getTeam().getTeamId());
            statement.setString(9, player.getKnownHealth());
            statement.setInt(10, player.getPlayerId());
            
            success = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean deletePlayer(int playerId) {
        boolean success = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM player WHERE player_id=?");
            statement.setInt(1, playerId);
            success = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Player getPlayerById(int playerId) {
        Player player = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM player WHERE player_id=?");
            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("name"),
                        resultSet.getString("sru_num"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("post_code"),
                        resultSet.getString("doctor"),
                        resultSet.getString("next_of_kin"),
                        resultSet.getString("known_health")
                );
                int teamId = resultSet.getInt("team_id");
                Team team = teamDAO.getTeamById(teamId);
                player.setTeam(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM player");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Player player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("name"),
                        resultSet.getString("sru_num"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("post_code"),
                        resultSet.getString("doctor"),
                        resultSet.getString("next_of_kin"),
                        resultSet.getString("known_health")
                );
                int teamId = resultSet.getInt("team_id");
                Team team = teamDAO.getTeamById(teamId);
                player.setTeam(team);
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public List<Player> getAllPlayersByTeamId(int teamId) {
        List<Player> players = new ArrayList<>();
        try {
            String query = "SELECT * FROM player WHERE team_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, teamId);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Player player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("name"),
                        resultSet.getString("sru_num"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("post_code"),
                        resultSet.getString("doctor"),
                        resultSet.getString("next_of_kin"),
                        resultSet.getString("known_health")
                );
                Team team = teamDAO.getTeamById(resultSet.getInt("team_id"));
                player.setTeam(team);
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    @Override
    public Player getPlayerByName(String playerName) {
        Player player = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM player WHERE name=?");
            statement.setString(1, playerName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                player = new Player(
                        resultSet.getInt("player_id"),
                        resultSet.getString("name"),
                        resultSet.getString("sru_num"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("post_code"),
                        resultSet.getString("doctor"),
                        resultSet.getString("next_of_kin"),
                        resultSet.getString("known_health")
                );
                int teamId = resultSet.getInt("team_id");
                Team team = teamDAO.getTeamById(teamId);
                player.setTeam(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

}
