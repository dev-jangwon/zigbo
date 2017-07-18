package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.RequestDTO;
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

	public static boolean addRequest(RequestDTO Request) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addRequest"));
			pstmt.setInt(1, Request.getMemberCode());
			pstmt.setInt(2, Request.getItemCode());
			pstmt.setInt(3, Request.getViews());
			pstmt.setString(4, Request.getLocation());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static RequestDTO getRequest(int RequestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		RequestDTO Request = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getRequest"));
			pstmt.setInt(1, RequestCode);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Request = new RequestDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4),
						rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return Request;
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
						rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	public static boolean updateRequestViews(int RequestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateRequestViews"));
			pstmt.setInt(1, RequestCode);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateRequestProgress(int RequestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("updateRequestProgress"));
			pstmt.setInt(1, RequestCode);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteRequest(int RequestCode) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("deleteRequest"));
			pstmt.setInt(1, RequestCode);
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
						rset.getString(5), rset.getString(6)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	public static RequestDTO getItemByRequestCode(RequestDTO Request) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getItemByRequestCode"));
			pstmt.setInt(1, Request.getItemCode()); //Request글의 itemCode로 ITEM상세보기
			rset = pstmt.executeQuery();
			if (rset.next()) {
				Request = new RequestDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4),
						rset.getString(5), rset.getString(6));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return Request;
	}

}
