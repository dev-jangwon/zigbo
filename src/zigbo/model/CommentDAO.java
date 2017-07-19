package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.CommentDTO;
import zigbo.model.util.DBUtil;

public class CommentDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	/*
	 * addComment //판매나 요청글에 Comment작성시
	 * getComment //필요한가?
	 * getAllComment //특정 글의 모든 Comment 검색
	 * updateComment //Comment수정 시: 글만 수정
	 * deleteComment //삭제
	 */
	
	public static boolean addComment(CommentDTO comment) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addComment"));
			pstmt.setInt(1, comment.getDivisionCode());
			pstmt.setInt(2, comment.getTextCode());
			pstmt.setInt(3, comment.getMemberCode());
			pstmt.setString(4, comment.getComment());
			pstmt.setString(5, comment.getReply());
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static CommentDTO getComment(int divisionCode, int textCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CommentDTO comment = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getComment"));
			pstmt.setInt(1, divisionCode);
			pstmt.setInt(2, textCode);
			rset = pstmt.executeQuery();
			if(rset.next()){
				comment = new CommentDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4), rset.getString(5));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return comment;
	}
	
	public static ArrayList<CommentDTO> getAllComment(int divisionCode, int textCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CommentDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllComment"));
			pstmt.setInt(1, divisionCode);
			pstmt.setInt(2, textCode);
			rset = pstmt.executeQuery();
			list = new ArrayList<CommentDTO>();
			while(rset.next()){
				list.add(new CommentDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4), rset.getString(5)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static boolean updateComment(int divisionCode, int textCode, String comment) throws SQLException{		
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateComment"));
			pstmt.setString(1, comment);
			pstmt.setInt(2, divisionCode);
			pstmt.setInt(3, textCode);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean deleteComment(int divisionCode, int textCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteComment"));
			pstmt.setInt(1, divisionCode);
			pstmt.setInt(2, textCode);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static int getCommentNumber(int divisionCode, int textCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getCommentNumber"));
			pstmt.setInt(1, divisionCode);
			pstmt.setInt(2, textCode);
			rset = pstmt.executeQuery();
			if(rset.next()){
				count = rset.getInt(1);
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return count;
	}	

}
