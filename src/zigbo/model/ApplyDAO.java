package zigbo.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.ApplyDTO;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.util.DBUtil;

public class ApplyDAO {

	   /*
	    * CRUD - Create(add/insert),
	    *       - Read(one/all)
	    *       - Update
	    *       - Delete
	    * 
	   addApply //������ �߰�
	   getApply //������ �˻�
	   getAllApply //��� ������ �˻�
	   updateApplyDetail //�󼼼��� ����
	   deleteApply //�� ����
	    */
	
	static ResourceBundle sql = DBUtil.getResourceBundle();
	   
	   public static boolean addApply(ApplyDTO Apply) throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("addApply"));
	         pstmt.setInt(1, Apply.getApplyCode());
	         pstmt.setInt(2, Apply.getMemberCode());
	         pstmt.setInt(3, Apply.getRequestCode());
	         pstmt.setString(4, Apply.getDetail());
	         int result = pstmt.executeUpdate();
	         if(result == 1){
	            return true;
	         }
	      }finally{
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	   }

	   public static ApplyDTO getApply(int ApplyCode) throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ApplyDTO Apply = null;
	      
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("getApply"));
	         pstmt.setInt(1, ApplyCode);
	         rset = pstmt.executeQuery();
	         if(rset.next()){
	            Apply = new ApplyDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4));
	         }
	      }finally{
	         DBUtil.close(con, pstmt, rset);
	      }
	      return Apply;
	   }
	   
	   public static ArrayList<ApplyDTO> getAllApply() throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<ApplyDTO> list = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("getAllApply"));
	         rset = pstmt.executeQuery();
	         list = new ArrayList<ApplyDTO>();
	         while(rset.next()){
	            list.add(new ApplyDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4)));
	         }
	      }finally{
	         DBUtil.close(con, pstmt, rset);
	      }
	      return list;
	   }
	   
	   public static boolean updateApplyDetail(int ApplyCode) throws SQLException{      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("updateApplyDetail"));
	         pstmt.setInt(1, ApplyCode);
	         int result = pstmt.executeUpdate();
	         if(result == 1){
	            return true;
	         }
	      }finally{
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	   }
	   	   
	   public static boolean deleteApply(int ApplyCode) throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("deleteApply"));
	         pstmt.setInt(1, ApplyCode);
	         int result = pstmt.executeUpdate();
	         if(result == 1){
	            return true;
	         }
	      }finally{
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	   }
	   
	   public static ArrayList<ApplyDTO> getApplyofMember(int memberCode) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<ApplyDTO> list = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql.getString("getApplyofMember"));
				pstmt.setInt(1, memberCode);
				rset = pstmt.executeQuery();
				list = new ArrayList<ApplyDTO>();
				while(rset.next()){
					list.add(new ApplyDTO(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getString(4)));
				}
			}finally{
				DBUtil.close(con, pstmt, rset);
			}
			return list;
		}
		
		/*
		 * getApplyofMember //ȸ���� ����ְڴٰ� apply�� ���� �ҷ���
		 */
}