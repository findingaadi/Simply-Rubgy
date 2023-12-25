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
import java.util.List;

public interface PlayerSkillDAO {

    boolean addPlayerSkill(PlayerSkill playerSkill);

    boolean updatePlayerSkill(PlayerSkill playerSkill);

    boolean deletePlayerSkill(int playerSkillId);

    PlayerSkill getPlayerSkillById(int playerSkillId);

    List<PlayerSkill> getAllPlayerSkills();
}
