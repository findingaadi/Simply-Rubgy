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

public interface JuniorPlayerSkillDAO {

    boolean addPlayerSkill(JuniorPlayerSkill playerSkill);

    boolean updatePlayerSkill(JuniorPlayerSkill playerSkill);

    boolean deletePlayerSkill(int playerSkillId);

    JuniorPlayerSkill getPlayerSkillById(int playerSkillId);

    List<JuniorPlayerSkill> getAllPlayerSkills();
}
