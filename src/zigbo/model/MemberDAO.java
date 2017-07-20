package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.MemberDTO;
import zigbo.model.util.DBUtil;

public class MemberDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	/*
	 * addMember //회원가입 시
	 * getMember //code로 회원 검색
	 * getAllMember //모든 회원 검색
	 * updateMember //회원 정보 수정
	 * deleteMember //회원 삭제
	 * 
	 */
	
	public static String getEmailByMemberCode(int memberCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String email = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getEmailByMemberCode"));
			pstmt.setInt(1, memberCode);
			rset = pstmt.executeQuery();
			if(rset.next()){
				email = rset.getString(1);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return email;
	}
	
	public static int getCountByEmail(String email) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getCountByEmail"));
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if(rset.next()){
				count = rset.getInt(1);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return count;
	}
	
	public static MemberDTO getMemberByEmail(String email) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMemberByEmail"));
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if(rset.next()){
				member = new MemberDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}
	
	public static boolean addMember(MemberDTO member) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addMember"));
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getPhone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getAccount());
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static MemberDTO getMember(String email,String password) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMember"));
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			if(rset.next()){
				member = new MemberDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}
	
	public static ArrayList<MemberDTO> getAllMember() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllMember"));
			rset = pstmt.executeQuery();
			list = new ArrayList<MemberDTO>();
			while(rset.next()){
				list.add(new MemberDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static boolean updateMember(int memberCode, String password, String phone, String address, String account) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateMember"));
			pstmt.setString(1, password);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setString(4, account);
			pstmt.setInt(5, memberCode);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean deleteMember(int memberCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteMember"));
			pstmt.setInt(1, memberCode);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static MemberDTO getMemberByMemberCode(int memberCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMemberByMemberCode"));
			pstmt.setInt(1, memberCode);
			rset = pstmt.executeQuery();
			if(rset.next()){
				member = new MemberDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}
	
}
