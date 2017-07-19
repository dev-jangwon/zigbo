package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import zigbo.model.dto.InterestDTO;
import zigbo.model.util.DBUtil;

public class InterestDAO {

    /*
       * CRUD - Create(add/insert),
       *       - Read(one/all)
       *       - Update
       *       - Delete
       * 
       * 
      addInterest // Âò Ãß°¡?? 
      getInterest1 // Æ¯Á¤ ÆÇ¸ÅÀÚ Âò °Ë»ö
      getInterest2 // ¹°Ç° Âò Ä«¿îÆ® 
       deleteInterest // Âò »èÁ¦
       */

	static ResourceBundle sql = DBUtil.getResourceBundle();
   
      public static boolean addInterest(InterestDTO Interest) throws SQLException{
         Connection con = null;
         PreparedStatement pstmt = null;
         try{
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(sql.getString("addInterest"));
            pstmt.setInt(1, Interest.getMemberCode());
            pstmt.setInt(2, Interest.getSellingCode());
            int result = pstmt.executeUpdate();
            if(result == 1){
               return true;
            }
         }finally{
            DBUtil.close(con, pstmt);
         }
         return false;
      }

      public static InterestDTO getInterest(int memberCode, int sellingCode) throws SQLException{
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         InterestDTO interest = null;
         try{
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(sql.getString("getInterest"));
            pstmt.setInt(1, memberCode);
            pstmt.setInt(2, sellingCode);
            rset = pstmt.executeQuery();
            if(rset.next()){
            	interest = new InterestDTO(rset.getInt(1), rset.getInt(2));
            }
         }finally{
            DBUtil.close(con, pstmt, rset);
         }
         return interest;
      }
         
      public static int getInterestOfSelling(int sellingCode) throws SQLException{
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rset = null;
            int interestCnt = 0;
            try{
               con = DBUtil.getConnection();
               pstmt = con.prepareStatement(sql.getString("getInterestOfSelling"));
               pstmt.setInt(1, sellingCode);
               rset = pstmt.executeQuery();
               if(rset.next()){
            	   interestCnt = rset.getInt(1);
               }
            }finally{
               DBUtil.close(con, pstmt, rset);
            }
            return interestCnt;
         }
      
      public static boolean deleteInterest(int memberCode, int sellingCode) throws SQLException{
         Connection con = null;
         PreparedStatement pstmt = null;
         try{
            con = DBUtil.getConnection();
            pstmt = con.prepareStatement(sql.getString("deleteInterest"));
            pstmt.setInt(1, memberCode);
            pstmt.setInt(2, sellingCode);
            int result = pstmt.executeUpdate();
            if(result == 1){
               return true;
            }
         }finally{
            DBUtil.close(con, pstmt);
         }
         return false;
      }
      
}