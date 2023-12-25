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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author HP
 */
public class JuniorPlayerDAOImpl implements JuniorPlayerDAO {

    Connection conn = DBConnection.getConnection();

    TeamDAO teamDAO = new TeamDAOImpl();

    @Override
    public boolean addJuniorPlayer(JuniorPlayer juniorPlayer) {
        try {
            String query = "INSERT INTO junior_player (name, sru_num, address, phone, post_code, doctor, next_of_kin, guardian1, guardian1_relation, guardian2, guardian2_relation, team_id,known_health) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, juniorPlayer.getName());
            stmt.setString(2, juniorPlayer.getSruNum());
            stmt.setString(3, juniorPlayer.getAddress());
            stmt.setString(4, juniorPlayer.getPhone());
            stmt.setInt(5, juniorPlayer.getPostCode());
            stmt.setString(6, juniorPlayer.getDoctor());
            stmt.setString(7, juniorPlayer.getNextOfKin());
            stmt.setString(8, juniorPlayer.getGuardian1());
            stmt.setString(9, juniorPlayer.getGuardian1Relation());
            stmt.setString(10, juniorPlayer.getGuardian2());
            stmt.setString(11, juniorPlayer.getGuardian2Relation());
            stmt.setInt(12, juniorPlayer.getTeam().getTeamId());
            stmt.setString(13, juniorPlayer.getNextOfKin());
            int count = stmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateJuniorPlayer(JuniorPlayer juniorPlayer) {
        try {
            String query = "UPDATE junior_player SET name = ?, sru_num = ?, address = ?, phone = ?, post_code = ?, doctor = ?, next_of_kin = ?, guardian1 = ?, guardian1_relation = ?, guardian2 = ?, guardian2_relation = ?, team_id = ?, known_health=? WHERE junior_player_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, juniorPlayer.getName());
            stmt.setString(2, juniorPlayer.getSruNum());
            stmt.setString(3, juniorPlayer.getAddress());
            stmt.setString(4, juniorPlayer.getPhone());
            stmt.setInt(5, juniorPlayer.getPostCode());
            stmt.setString(6, juniorPlayer.getDoctor());
            stmt.setString(7, juniorPlayer.getNextOfKin());
            stmt.setString(8, juniorPlayer.getGuardian1());
            stmt.setString(9, juniorPlayer.getGuardian1Relation());
            stmt.setString(10, juniorPlayer.getGuardian2());
            stmt.setString(11, juniorPlayer.getGuardian2Relation());
            stmt.setInt(12, juniorPlayer.getTeam().getTeamId());
            stmt.setString(13, juniorPlayer.getKnownHealth());
            stmt.setInt(14, juniorPlayer.getJuniorPlayerId());
            int count = stmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteJuniorPlayer(int juniorPlayerId) {
        try {
            String query = "DELETE FROM junior_player WHERE junior_player_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, juniorPlayerId);
            int result = stmt.executeUpdate();
            return (result == 1); // If one row was deleted, return true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public JuniorPlayer getJuniorPlayerById(int juniorPlayerId) {
        try {
            String query = "SELECT * FROM junior_player WHERE junior_player_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, juniorPlayerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JuniorPlayer juniorPlayer = new JuniorPlayer();
                juniorPlayer.setJuniorPlayerId(rs.getInt("junior_player_id"));
                juniorPlayer.setName(rs.getString("name"));
                juniorPlayer.setSruNum(rs.getString("sru_num"));
                juniorPlayer.setAddress(rs.getString("address"));
                juniorPlayer.setPhone(rs.getString("phone"));
                juniorPlayer.setPostCode(rs.getInt("post_code"));
                juniorPlayer.setDoctor(rs.getString("doctor"));
                juniorPlayer.setNextOfKin(rs.getString("next_of_kin"));
                juniorPlayer.setGuardian1(rs.getString("guardian1"));
                juniorPlayer.setGuardian1Relation(rs.getString("guardian1_relation"));
                juniorPlayer.setGuardian2(rs.getString("guardian2"));
                juniorPlayer.setGuardian2Relation(rs.getString("guardian2_relation"));
                juniorPlayer.setKnownHealth(rs.getString("known_health"));
            
                int teamId = rs.getInt("team_id");
                Team team = teamDAO.getTeamById(teamId);
                juniorPlayer.setTeam(team);

                return juniorPlayer;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<JuniorPlayer> getAllJuniorPlayers() {
        try {
            List<JuniorPlayer> juniorPlayers = new ArrayList<>();
            String query = "SELECT * FROM junior_player";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                JuniorPlayer juniorPlayer = new JuniorPlayer();
                juniorPlayer.setJuniorPlayerId(rs.getInt("junior_player_id"));
                juniorPlayer.setName(rs.getString("name"));
                juniorPlayer.setSruNum(rs.getString("sru_num"));
                juniorPlayer.setAddress(rs.getString("address"));
                juniorPlayer.setPhone(rs.getString("phone"));
                juniorPlayer.setPostCode(rs.getInt("post_code"));
                juniorPlayer.setDoctor(rs.getString("doctor"));
                juniorPlayer.setNextOfKin(rs.getString("next_of_kin"));
                juniorPlayer.setGuardian1(rs.getString("guardian1"));
                juniorPlayer.setGuardian1Relation(rs.getString("guardian1_relation"));
                juniorPlayer.setGuardian2(rs.getString("guardian2"));
                juniorPlayer.setGuardian2Relation(rs.getString("guardian2_relation"));
                juniorPlayer.setKnownHealth(rs.getString("known_health"));

                int teamId = rs.getInt("team_id");
                Team team = teamDAO.getTeamById(teamId);
                juniorPlayer.setTeam(team);

                juniorPlayers.add(juniorPlayer);
            }
            return juniorPlayers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JuniorPlayer getPlayerByName(String playerName) {
        try {
            String query = "SELECT * FROM junior_player WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, playerName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                JuniorPlayer juniorPlayer = new JuniorPlayer();
                juniorPlayer.setJuniorPlayerId(rs.getInt("junior_player_id"));
                juniorPlayer.setName(rs.getString("name"));
                juniorPlayer.setSruNum(rs.getString("sru_num"));
                juniorPlayer.setAddress(rs.getString("address"));
                juniorPlayer.setPhone(rs.getString("phone"));
                juniorPlayer.setPostCode(rs.getInt("post_code"));
                juniorPlayer.setDoctor(rs.getString("doctor"));
                juniorPlayer.setNextOfKin(rs.getString("next_of_kin"));
                juniorPlayer.setGuardian1(rs.getString("guardian1"));
                juniorPlayer.setGuardian1Relation(rs.getString("guardian1_relation"));
                juniorPlayer.setGuardian2(rs.getString("guardian2"));
                juniorPlayer.setGuardian2Relation(rs.getString("guardian2_relation"));
                juniorPlayer.setKnownHealth(rs.getString("known_health"));

                int teamId = rs.getInt("team_id");
                Team team = teamDAO.getTeamById(teamId);
                juniorPlayer.setTeam(team);

                return juniorPlayer;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<JuniorPlayer> getAllPlayersByTeamId(int teamId) {
        try {
            List<JuniorPlayer> juniorPlayers = new ArrayList<>();
            String query = "SELECT * FROM junior_player WHERE team_id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, teamId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JuniorPlayer juniorPlayer = new JuniorPlayer();
                juniorPlayer.setJuniorPlayerId(rs.getInt("junior_player_id"));
                juniorPlayer.setName(rs.getString("name"));
                juniorPlayer.setSruNum(rs.getString("sru_num"));
                juniorPlayer.setAddress(rs.getString("address"));
                juniorPlayer.setPhone(rs.getString("phone"));
                juniorPlayer.setPostCode(rs.getInt("post_code"));
                juniorPlayer.setDoctor(rs.getString("doctor"));
                juniorPlayer.setNextOfKin(rs.getString("next_of_kin"));
                juniorPlayer.setGuardian1(rs.getString("guardian1"));
                juniorPlayer.setGuardian1Relation(rs.getString("guardian1_relation"));
                juniorPlayer.setGuardian2(rs.getString("guardian2"));
                juniorPlayer.setGuardian2Relation(rs.getString("guardian2_relation"));
                juniorPlayer.setKnownHealth(rs.getString("known_health"));

                Team team = teamDAO.getTeamById(rs.getInt("team_id"));
                juniorPlayer.setTeam(team);

                juniorPlayers.add(juniorPlayer);
            }
            return juniorPlayers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
