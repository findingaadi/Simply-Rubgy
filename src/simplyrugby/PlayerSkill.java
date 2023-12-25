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
public class PlayerSkill {

    private int playerSkillId;
    private Player player;
    private String category;
    private String skill;
    private String level;

    public PlayerSkill() {
    }
    
    

    // Constructor
    public PlayerSkill(int playerSkillId, Player player, String category, String skill, String level) {
        this.playerSkillId = playerSkillId;
        this.player = player;
        this.category = category;
        this.skill = skill;
        this.level = level;
    }

    // Getters and setters
    public int getPlayerSkillId() {
        return playerSkillId;
    }

    public void setPlayerSkillId(int playerSkillId) {
        this.playerSkillId = playerSkillId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
