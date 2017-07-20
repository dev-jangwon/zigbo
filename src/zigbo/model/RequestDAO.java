package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.RequestDTO;
import zigbo.model.dto.RequestMemberDTO;
import zigbo.model.util.DBUtil;

public class RequestDAO {

	/*
	 * CRUD - Create(add/insert), - Read(one/all) - Update - Delete
	 * 
	 * addRequest //구매글 작성시 getRequest //id로 구매글 검색 getAllRequest //모든 구매글 검색
	 * updateRequestViews //조회수 증가 updateRequestProgress //진행상태 변경 deleteRequest
	 * //글 삭제 getRequestofMember //회원이 올린 Request글 불러옴
	 */

	static ResourceBundle sql = DBUtil.getResourceBundle();

	public static boolean addRequest(RequestDTO request) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addRequest"));
			pstmt.setInt(1, request.getItemCode());
			pstmt.setInt(2, request.getMemberCode());
			pstmt.setInt(3, request.getViews());
			pstmt.setString(4, request.getProgress());
			pstmt.setString(5, request.getLocation());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static RequestDTO getRequest(int requestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RequestDTO request = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getRequest"));
			pstmt.setInt(1, requestCode);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				request = new RequestDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4),
						rset.getDate(5), rset.getString(6), rset.getString(7));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return request;
	}

	public static ArrayList<RequestDTO> getAllRequest() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RequestDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllRequest"));
			rset = pstmt.executeQuery();
			list = new ArrayList<RequestDTO>();
			while (rset.next()) {
				list.add(new RequestDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4),
						rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	public static boolean updateRequestViews(int requestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateRequestViews"));
			pstmt.setInt(1, requestCode);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateRequestProgress(int requestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateRequestProgress"));
			pstmt.setInt(1, requestCode);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteRequest(int requestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteRequest"));
			pstmt.setInt(1, requestCode);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static ArrayList<RequestDTO> getRequestofMember(int memberCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RequestDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getRequestofMember"));
			pstmt.setInt(1, memberCode);
			rset = pstmt.executeQuery();
			list = new ArrayList<RequestDTO>();
			while (rset.next()) {
				list.add(new RequestDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4),
						rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<RequestDTO> getMostRecentRequest() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RequestDTO> list = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getMostRecentRequest"));
			rset = pstmt.executeQuery();
			list = new ArrayList<RequestDTO>();
			while (rset.next()) {
				list.add(new RequestDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4),
						rset.getDate(5), rset.getString(6), rset.getString(7)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<RequestMemberDTO> getAllRequestMember() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<RequestMemberDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getAllRequestMember"));
			rset = pstmt.executeQuery();
			list = new ArrayList<RequestMemberDTO>();
			while (rset.next()) {
				list.add(new RequestMemberDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4),
						rset.getDate(5), rset.getString(6), rset.getString(7), rset.getString(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}
