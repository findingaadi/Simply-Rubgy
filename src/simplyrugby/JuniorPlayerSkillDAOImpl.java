/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JuniorPlayerSkillDAOImpl implements JuniorPlayerSkillDAO {

    private Connection connection = DBConnection.getConnection();

    // Add player skill record
    public boolean addPlayerSkill(JuniorPlayerSkill playerSkill) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO junior_player_skill(junior_player_id, category, skill, level) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, playerSkill.getPlayer().getJuniorPlayerId());
            preparedStatement.setString(2, playerSkill.getCategory());
            preparedStatement.setString(3, playerSkill.getSkill());
            preparedStatement.setString(4, playerSkill.getLevel());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update player skill record
    public boolean updatePlayerSkill(JuniorPlayerSkill playerSkill) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE junior_player_skill SET junior_player_id=?, category=?, skill=?, level=? WHERE junior_player_skill_id=?");
            preparedStatement.setInt(1, playerSkill.getPlayer().getJuniorPlayerId());
            preparedStatement.setString(2, playerSkill.getCategory());
            preparedStatement.setString(3, playerSkill.getSkill());
            preparedStatement.setString(4, playerSkill.getLevel());
            preparedStatement.setInt(5, playerSkill.getPlayerSkillId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete player skill record
    public boolean deletePlayerSkill(int playerSkillId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM junior_player_skill WHERE junior_player_skill_id=?");
            preparedStatement.setInt(1, playerSkillId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get player skill record by ID
    public JuniorPlayerSkill getPlayerSkillById(int playerSkillId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM junior_player_skill WHERE junior_player_skill_id=?");
            preparedStatement.setInt(1, playerSkillId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int playerId = resultSet.getInt("junior_player_id");
                JuniorPlayerDAO playerDAO = new JuniorPlayerDAOImpl();
                JuniorPlayer player = playerDAO.getJuniorPlayerById(playerId);
                String category = resultSet.getString("category");
                String skill = resultSet.getString("skill");
                String level = resultSet.getString("level");
                return new JuniorPlayerSkill(playerSkillId, player, category, skill, level);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get all player skill records
    @Override
    public List<JuniorPlayerSkill> getAllPlayerSkills() {
        List<JuniorPlayerSkill> playerSkills = new ArrayList<>();
        String sql = "SELECT * FROM junior_player_skill";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                JuniorPlayerSkill playerSkill = new JuniorPlayerSkill();
                playerSkill.setPlayerSkillId(rs.getInt("junior_player_skill_id"));
                int playerId = rs.getInt("junior_player_id");
                JuniorPlayerDAO playerDAO = new JuniorPlayerDAOImpl();
                JuniorPlayer player = playerDAO.getJuniorPlayerById(playerId);
                playerSkill.setPlayer(player);
                playerSkill.setCategory(rs.getString("category"));
                playerSkill.setSkill(rs.getString("skill"));
                playerSkill.setLevel(rs.getString("level"));
                playerSkills.add(playerSkill);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return playerSkills;
    }
}
