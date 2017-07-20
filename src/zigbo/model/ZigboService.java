package zigbo.model;

import java.sql.SQLException;
import java.util.ArrayList;

import zigbo.exception.NotExistException;
import zigbo.model.dto.ApplyDTO;
import zigbo.model.dto.ApplyRequestDTO;
import zigbo.model.dto.InterestDTO;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.MemberDTO;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.dto.RequestDTO;
import zigbo.model.dto.RequestMemberDTO;
import zigbo.model.dto.SellingDTO;
import zigbo.model.dto.SellingMemberDTO;

public class ZigboService {

   //// ITEM SERVICE ////
	
   // 새로운 item 저장
   public static boolean addItem(ItemDTO item) throws SQLException {
      return ItemDAO.addItem(item);
   }

   // get item
   public static ItemDTO getItem(int itemCode) throws SQLException {
      return ItemDAO.getItem(itemCode);
   }

   // 모든 item 검색
   public static ArrayList<ItemDTO> getAllItem() throws SQLException {
      return ItemDAO.getAllItem();
   }

   // item 삭제
   public static boolean deleteItem(int itemCode) throws SQLException {
	   return ItemDAO.deleteItem(itemCode);
   }
   
   //// INTEREST SERVICE ////

   // 새로운 찜
   public static boolean addInterest(InterestDTO interest) throws SQLException {
      return InterestDAO.addInterest(interest);
   }

   // 특정 Selling글의 찜개수 반환
   public static int getInterestOfSelling(int sellingCode) throws SQLException {
      return InterestDAO.getInterestOfSelling(sellingCode);
   }

   // 찜 삭제
   public static boolean deleteInterest(int memberCode, int sellingCode) throws SQLException {
         return InterestDAO.deleteInterest(memberCode, sellingCode);
   }
   
   //// SELLING SERVICE ////
   
   // 새로운 Selling 추가
   public static boolean addSelling(SellingDTO selling) throws SQLException {
      return SellingDAO.addSelling(selling);
   }
   
   // 특정 Selling 반환
   public static SellingDTO getSelling(int sellingCode) throws SQLException {
      return SellingDAO.getSelling(sellingCode);
   }
   
   // 모든 Selling 검색
   public static ArrayList<SellingDTO> getAllSelling() throws SQLException {
      return SellingDAO.getAllSelling();
   }
   
   //조회수 증가
   public static boolean updateSellingViews(int sellingCode) throws SQLException {      
      return SellingDAO.updateSellingViews(sellingCode);
   }
   
   //진행상태 업뎃
   public static boolean updateSellingProgress(int sellingCode) throws SQLException {      
      return SellingDAO.updateSellingProgress(sellingCode);
   }
   
   //조회수 많은 순 Sellings 반환
   public static ArrayList<SellingDTO> getMostViews() throws SQLException {
      return SellingDAO.getMostViews();
   }
   
   // 최신순 Sellings 반환
   public static ArrayList<SellingDTO> getMostRecent() throws SQLException {
      return SellingDAO.getMostRecent();
   }
   
   // 찜순 Sellings 반환
   public static ArrayList<SellingDTO> getMostInterest() throws SQLException {
      return SellingDAO.getMostInterest();
   }
   
   public static ArrayList<SellingMemberDTO> getAllSellingMember() throws SQLException{ 
	   return SellingDAO.getAllSellingMember();
   }
   
   ////PAYMENT SERVICE ////
   
   // 결제 추가
   public static boolean addPayment(PaymentDTO payment) throws SQLException {
      return PaymentDAO.addPayment(payment);
   }
   
   // 특정 결제 탐색
   public static PaymentDTO getPayment(int paymentCode) throws SQLException {
      return PaymentDAO.getPayment(paymentCode);
   }
   
   // 회원의 결제 정보 보기
   public static ArrayList<PaymentDTO> getPaymentofMember(int memberCode) throws SQLException {
      return PaymentDAO.getPaymentofMember(memberCode);
   }
   
   ////MEMBER SERVICE ////
   public static String getEmailByMemberCode(int memberCode) throws SQLException{
	   return MemberDAO.getEmailByMemberCode(memberCode);
   }
   
   public static int getCountByEmail(String email) throws SQLException{
	   return MemberDAO.getCountByEmail(email);
   }
   
   public static MemberDTO getMemberByEmail(String email) throws SQLException{
	   return MemberDAO.getMemberByEmail(email);
   }
   
   public static MemberDTO getMemberByMemberCode(int memberCode) throws SQLException {
	   return MemberDAO.getMemberByMemberCode(memberCode);
   }
   
	public static boolean addMember(MemberDTO member) throws SQLException {
		return MemberDAO.addMember(member);
	}

	public static MemberDTO getMember(String email, String password) throws NotExistException, SQLException {
		return MemberDAO.getMember(email,password);
	}

	public static boolean updateMember(int memberCode, String password, String phone, String address, String account) throws SQLException, NotExistException {
		return MemberDAO.updateMember(memberCode, password, phone, address, account);
	}

	public static boolean deleteMember(int memberCode) throws SQLException {
			return MemberDAO.deleteMember(memberCode);
	}

	public static ArrayList<SellingDTO> getSellingofMember(int MemberCode) throws SQLException {
		return SellingDAO.getSellingofMember(MemberCode);
	}
	
	////REQUEST SERVICE ////

	public static boolean addRequest(RequestDTO request) throws SQLException {
		return RequestDAO.addRequest(request);
	}

	public static RequestDTO getRequest(int requestCode) throws SQLException {
		return RequestDAO.getRequest(requestCode);
	}

	// getAllRequest()
	public static ArrayList<RequestDTO> getAllRequest() throws SQLException {
		return RequestDAO.getAllRequest();
	}
	
	public static ArrayList<RequestMemberDTO> getAllRequestMember() throws SQLException {
		return RequestDAO.getAllRequestMember();
	}

	public static boolean updateRequestViews(int requestCode) throws SQLException {
			return RequestDAO.updateRequestViews(requestCode);
	}
	
	public static boolean updateRequestProgress(int requestCode) throws SQLException {
		return RequestDAO.updateRequestProgress(requestCode);
	}
	
	public static ArrayList<RequestDTO> getRequestofMember(int memberCode) throws SQLException {
		return RequestDAO.getRequestofMember(memberCode);
	}
	
	public static ArrayList<RequestDTO> getMostRecentRequest() throws SQLException {
		return RequestDAO.getMostRecentRequest();
	}
	
	////APPLY SERVICE ////
	 public static boolean addApply(ApplyDTO apply) throws SQLException {
		 return ApplyDAO.addApply(apply);
	 }
	 
	 public static ApplyDTO getApply(int ApplyCode) throws SQLException {
		 return ApplyDAO.getApply(ApplyCode);
	 }
	 
	 public static ArrayList<ApplyDTO> getAllApply() throws SQLException {
		 return ApplyDAO.getAllApply();
	 }
	 
	 public static boolean deleteApply(int applyCode) throws SQLException {
		 return ApplyDAO.deleteApply(applyCode);
	 }
	
	 public static ArrayList<ApplyDTO> getApplyofMember(int memberCode) throws SQLException {
		 return ApplyDAO.getApplyofMember(memberCode);
	 }
	 
	 public static ArrayList<ApplyRequestDTO> getApplyMemberRequest(int memberCode) throws SQLException {
		 return ApplyDAO.getApplyMemberRequest(memberCode);
	 }
}
