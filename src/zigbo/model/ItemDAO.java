package zigbo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import zigbo.model.dto.ItemDTO;
import zigbo.model.util.DBUtil;

public class ItemDAO {

	 /*
	    * CRUD - Create(add/insert),
	    *       - Read(one/all)
	    *       - Update
	    *       - Delete
	    * 
	   addItem //아이템 추가 ?? 그림은 어떻게 할지 모르겠음.
	   getItem1 //아이템 검색 (코드) ?? 고민
	   getItem2 //아이템 검색 (위치) 
	   getItem3 //아이템 검색 (가격)
	   getAllItem //모든 아이템 검색
	   updateItemPrice // 아이템 가격 수정 ?? sql 고민
	   updateItemLocation // 아이템 위치 수정
	   deleteItem //글 삭제
	    */

	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	   public static boolean addItem(ItemDTO Item) throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("addItem"));
	         pstmt.setInt(1, Item.getItemCode());
	         pstmt.setString(2, Item.getPrice());
	         pstmt.setString(3, Item.getDetail());
	         pstmt.setString(4, Item.getLocation());
	         int result = pstmt.executeUpdate();
	         if(result == 1){
	            return true;
	         }
	      }finally{
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	   }

	   public static ItemDTO getItem(int ItemCode) throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ItemDTO Item = null;
	      
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("getItem"));
	         pstmt.setInt(1, ItemCode);
	         rset = pstmt.executeQuery();
	         if(rset.next()){
	            Item = new ItemDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
	         }
	      }finally{
	         DBUtil.close(con, pstmt, rset);
	      }
	      return Item;
	   }
	   
	   public static ItemDTO getItemByPrice(String price) throws SQLException{
		      Connection con = null;
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      ItemDTO Item = null;
		      
		      try{
		         con = DBUtil.getConnection();
		         pstmt = con.prepareStatement(sql.getString("getItemByPrice"));
		         pstmt.setString(1, price);
		         rset = pstmt.executeQuery();
		         if(rset.next()){
		            Item = new ItemDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
		         }
		      }finally{
		         DBUtil.close(con, pstmt, rset);
		      }
		      return Item;
		   }
	   
	   public static ItemDTO getItemByLocation(String location) throws SQLException{
		      Connection con = null;
		      PreparedStatement pstmt = null;
		      ResultSet rset = null;
		      ItemDTO Item = null;
		      
		      try{
		         con = DBUtil.getConnection();
		         pstmt = con.prepareStatement(sql.getString("getItemByLocation"));
		         pstmt.setString(1, location);
		         rset = pstmt.executeQuery();
		         if(rset.next()){
		            Item = new ItemDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6));
		         }
		      }finally{
		         DBUtil.close(con, pstmt, rset);
		      }
		      return Item;
		   }
	   
	   public static ArrayList<ItemDTO> getAllItem() throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<ItemDTO> list = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("getAllItem"));
	         rset = pstmt.executeQuery();
	         list = new ArrayList<ItemDTO>();
	         while(rset.next()){
	            list.add(new ItemDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6)));
	         }
	      }finally{
	         DBUtil.close(con, pstmt, rset);
	      }
	      return list;
	   }
	   
	   public static boolean updateItemPrice(int ItemCode) throws SQLException{      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("updateItemPrice"));
	         pstmt.setInt(1, ItemCode);
	         int result = pstmt.executeUpdate();
	         if(result == 1){
	            return true;
	         }
	      }finally{
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	   }
	   
	   public static boolean updateItemLocation(int ItemCode) throws SQLException{      
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("updateItemLocation"));
	         pstmt.setInt(1, ItemCode);
	         int result = pstmt.executeUpdate();
	         if(result == 1){
	            return true;
	         }
	      }finally{
	         DBUtil.close(con, pstmt);
	      }
	      return false;
	   }
	   
	   public static boolean deleteItem(int ItemCode) throws SQLException{
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      try{
	         con = DBUtil.getConnection();
	         pstmt = con.prepareStatement(sql.getString("deleteItem"));
	         pstmt.setInt(1, ItemCode);
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
