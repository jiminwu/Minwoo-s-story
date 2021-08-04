package com.ssafy.happyhouse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.happyhouse.model.dto.Member;
import com.ssafy.happyhouse.model.dto.Region;
import com.ssafy.happyhouse.util.DBUtil;

public class MemberDaoImpl implements MemberDao{

	@Override
	public void insertUser(Member member) throws SQLException {
		// 데이터베이스에 저장
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into Member( ");
			sql.append("     id,password,name,address_default,phoneNum,address_detail,postNum,homeNum ");
			sql.append(") values ( ");
			sql.append(" ?,?,?,?,?,?,?,? ");
			sql.append(" ) ");
			stmt = con.prepareStatement(sql.toString());
			int index = 1;
			stmt.setString(index++, member.getId());
			stmt.setString(index++, member.getPassword());
			stmt.setString(index++, member.getName());
			stmt.setString(index++, member.getAddressDefault());
			stmt.setString(index++, member.getPhonenum());
			stmt.setString(index++, member.getAddressDetail());
			stmt.setString(index++, member.getPostnum());
			stmt.setString(index++, member.getHomenum());
			stmt.executeUpdate();
			
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		
	}

	@Override
	public List<Member> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Member> memList = new LinkedList<>();
		try {
			con = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select * from Member");
			stmt = con.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			int idx = 1;
			rs = stmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setAddressDefault(rs.getString("address_default"));
				member.setAddressDetail(rs.getString("address_detail"));
				member.setHomenum(rs.getString("homenum"));
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setPhonenum(rs.getString("phoneNum"));
				member.setPostnum(rs.getString("postNum"));
				memList.add(member);
			}
			return memList;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

}
