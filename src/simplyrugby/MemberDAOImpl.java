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
public class MemberDAOImpl implements MemberDAO {

    Connection conn = DBConnection.getConnection();

    @Override
    public boolean registerMember(Member member) throws SQLException {
        String query = "INSERT INTO members (first_name, last_name, email, password, address, is_admin, is_coach) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, member.getFirstName());
        stmt.setString(2, member.getLastName());
        stmt.setString(3, member.getEmail());
        stmt.setString(4, member.getPassword());
        stmt.setString(5, member.getAddress());
        stmt.setBoolean(6, member.isIsAdmin());
        stmt.setBoolean(7, member.isIsCoach());
        int rowsInserted = stmt.executeUpdate();
        return rowsInserted > 0;
    }

    @Override
    public Member login(String email, String password) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int memberId = rs.getInt("member_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                boolean isAdmin = rs.getBoolean("is_admin");
                boolean isCoach = rs.getBoolean("is_coach");

                // Create a new Member object with the retrieved data
                Member member = new Member(memberId, firstName, lastName, email, password, address, isAdmin, isCoach, null);

                return member;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addMember(Member member) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO members (first_name, last_name, email, password, address, is_admin, is_coach, team_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getPassword());
            ps.setString(5, member.getAddress());
            ps.setBoolean(6, member.isIsAdmin());
            ps.setBoolean(7, member.isIsCoach());
            ps.setInt(8, member.getTeam().getTeamId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateMember(Member member) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE members SET first_name=?, last_name=?, email=?, password=?, address=?, is_admin=?, is_coach=?, team_id=? WHERE member_id=?");
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getPassword());
            ps.setString(5, member.getAddress());
            ps.setBoolean(6, member.isIsAdmin());
            ps.setBoolean(7, member.isIsCoach());
            ps.setInt(8, member.getTeam().getTeamId());
            ps.setInt(9, member.getMemberId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMember(int memberId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM members WHERE member_id=?");
            ps.setInt(1, memberId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Member getMemberById(int memberId) {
        Member member = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members WHERE member_id=? and is_coach=1");
            ps.setInt(1, memberId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                member = new Member();
                member.setMemberId(rs.getInt("member_id"));
                member.setFirstName(rs.getString("first_name"));
                member.setLastName(rs.getString("last_name"));
                member.setEmail(rs.getString("email"));
                member.setPassword(rs.getString("password"));
                member.setAddress(rs.getString("address"));
                member.setIsAdmin(rs.getBoolean("is_admin"));
                member.setIsCoach(rs.getBoolean("is_coach"));
                Team team = new Team();
                team.setTeamId(rs.getInt("team_id"));
                member.setTeam(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return member;
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        try {
            String query = "SELECT * FROM members where is_coach=1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Member member = new Member();
                member.setMemberId(rs.getInt("member_id"));
                member.setFirstName(rs.getString("first_name"));
                member.setLastName(rs.getString("last_name"));
                member.setEmail(rs.getString("email"));
                member.setPassword(rs.getString("password"));
                member.setAddress(rs.getString("address"));
                member.setIsAdmin(rs.getBoolean("is_admin"));
                member.setIsCoach(rs.getBoolean("is_coach"));
                Team team = new Team();
                team.setTeamId(rs.getInt("team_id"));
                member.setTeam(team);
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

}
