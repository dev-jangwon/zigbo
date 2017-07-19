package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.PaymentDTO;
import zigbo.model.util.DBUtil;

public class PaymentDAO {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	/*
	 * addPayment //결제 완료시
	 * getAllPayment //마이페이지에서 특정 memberCode의 모든 결제정보 보기
	 * -- update, delete는 없음 --
	 */
	
	public static boolean addPayment(PaymentDTO payment) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("addPayment"));
			pstmt.setInt(1, payment.getSellingCode());
			pstmt.setInt(2, payment.getMemberCode());
			pstmt.setString(3, payment.getAddress());
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static PaymentDTO getPayment(int paymentCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PaymentDTO payment = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getPayment"));
			pstmt.setInt(1, paymentCode);
			rset = pstmt.executeQuery();
			
			 if (rset.next()) {
				 payment = new PaymentDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return payment;
	}
	
	public static ArrayList<PaymentDTO> getPaymentofMember(int memberCode) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<PaymentDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getString("getPaymentofMember"));
			pstmt.setInt(1, memberCode);
			rset = pstmt.executeQuery();
			list = new ArrayList<PaymentDTO>();
			while(rset.next()){
				list.add(new PaymentDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}
