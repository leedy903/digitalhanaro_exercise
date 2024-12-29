package com.example.demo;

import com.example.demo.vo.Members;
import jakarta.servlet.ServletContext;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends JDBConnect {
    public MemberDAO(ServletContext application) {
        super(application);
    }

    public int insert(Members member) {
        int result = 0;
        String sql = "INSERT INTO MEMBERS (USERID, USERPWD, USERNAME, EMAIL) VALUES (?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getUserName());
            pstmt.setString(4, member.getEmail());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Members getMember(String id) {
        Members member = new Members();
        String sql = "SELECT * FROM MEMBERS WHERE USERID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                setMembers(member);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return member;
    }

    public List<Members> getList() {
        List<Members> list = new ArrayList<>();
        String sql = "SELECT * FROM MEMBERS";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Members member = new Members();
                setMembers(member);
                list.add(member);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public int update(Members member) {
        int result = 0;
        String sql = "UPDATE MEMBERS SET USERPWD = ?, USERNAME = ?, EMAIL = ? WHERE USERID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getUserPwd());
            pstmt.setString(2, member.getUserName());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getUserId());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int delete(String userId) {
        int result = 0;
        String sql = "DELETE FROM MEMBERS WHERE USERID = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private void setMembers(Members member) throws SQLException {
        member.setUserId(rs.getString("userId"));
        member.setUserPwd(rs.getString("userPwd"));
        member.setUserName(rs.getString("userName"));
        member.setPhoneNo(rs.getString("phoneNo"));
        member.setAddress(rs.getString("address"));
        member.setEmail(rs.getString("email"));
        member.setRegDate(rs.getString("regDate"));
    }
}
