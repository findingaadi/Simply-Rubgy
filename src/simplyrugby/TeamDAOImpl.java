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
public class TeamDAOImpl implements TeamDAO {

    private Connection conn = DBConnection.getConnection();

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM team");

            while (rs.next()) {
                int teamId = rs.getInt("team_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                Team team = new Team(teamId, name, type);
                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    public Team getTeamById(int teamId) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM team WHERE team_id=?");
            ps.setInt(1, teamId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                return new Team(teamId, name, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addTeam(Team team) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO team (name, type) VALUES (?, ?)");
            ps.setString(1, team.getName());
            ps.setString(2, team.getType());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTeam(Team team) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE team SET name=?, type=? WHERE team_id=?");
            ps.setString(1, team.getName());
            ps.setString(2, team.getType());
            ps.setInt(3, team.getTeamId());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTeam(int teamId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM team WHERE team_id=?");
            ps.setInt(1, teamId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Team getTeamByName(String teamName) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM team WHERE name=?");
            ps.setString(1, teamName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Integer teamId = rs.getInt("team_id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                return new Team(teamId, name, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
