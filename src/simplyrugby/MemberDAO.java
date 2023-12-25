/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface MemberDAO {

    boolean registerMember(Member member) throws SQLException;

    Member login(String email, String password);

    boolean addMember(Member member);

    boolean updateMember(Member member);

    boolean deleteMember(int memberId);

    public Member getMemberById(int memberId);

    public List<Member> getAllMembers();
}
