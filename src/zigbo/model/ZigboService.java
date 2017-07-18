package zigbo.model;

import java.sql.SQLException;
import java.util.ArrayList;

import zigbo.exception.NotExistException;
import zigbo.model.dto.InterestDTO;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.dto.SellingDTO;

public class ZigboService {

<<<<<<< HEAD
   // 새로운 item 저장
   public static boolean addItem(ItemDTO item) throws SQLException {
      return ItemDAO.addItem(item);
   }

   // get item
   public static ItemDTO getItem(int itemCode) throws NotExistException, SQLException {
      ItemDTO item = ItemDAO.getItem(itemCode);
      if (item == null) {
         throw new NotExistException("검색하진 상품 정보가 없습니다.");
      }
      return item;
   }

   // 지역으로 item 검색
   public static void getItemByLocation(String location) throws NotExistException, SQLException {
      ItemDTO item = ItemDAO.getItemByLocation(location);
      if (item == null) {
         throw new NotExistException("검색하진 지역에 상품 정보가 없습니다.");
      }
   }

   // 모든 item 검색
   public static ArrayList<ItemDTO> getAllItem() throws SQLException {
      return ItemDAO.getAllItem();
   }

   // item 삭제
   public boolean deleteItem(int itemCode) throws SQLException, NotExistException {
      if (getItem(itemCode) != null) {
         ItemDAO.deleteItem(itemCode);
      }
   }

   //////////////////////////////////////////////////
   // 새로운 찜
   public static boolean addInterest(InterestDTO interest) throws SQLException {
      return InterestDAO.addInterest(interest);
   }

   // get 찜 -- 필요없어보이고 굉장히 이상함 찜으로 찜을 검색하다니
   /*
    * public static InterestDTO getInterest(InterestDTO interest) throws
    * NotExistException, SQLException{ if(InterestDAO.getInterest(interest) ==
    * null){ throw new NotExistException("검색하진 상품 정보가 없습니다."); } return
    * interest; }
    */
   // 찜 있는지 확인
   public static boolean checkInterest(int memberCode, int sellingCode) throws NotExistException, SQLException {
      if (InterestDAO.getInterest(memberCode, sellingCode) == null) {
         throw new NotExistException("검색하진 찜 정보가 없습니다.");
         return false;
      }
      return true;
   }

   // 특정 Selling글의 찜개수 반환
   public static int getInterestOfSelling(int sellingCode) throws NotExistException, SQLException {
      return InterestDAO.getInterestOfSelling(sellingCode);
   }

   // 찜 삭제
   public boolean deleteInterest(int memberCode, int sellingCode) throws SQLException, NotExistException {
      if (checkInterest(memberCode, sellingCode)) {
         return InterestDAO.deleteInterest(memberCode, sellingCode);
      }

   }

   ////////////////////////////////////////////////////
   // 새로운 Selling 추가
   public static boolean addSelling(SellingDTO selling) throws SQLException {
      return SellingDAO.addSelling(selling);
   }
   // 특정 Selling글의 찜개수 반환
   public static SellingDTO getSelling(int sellingCode) throws NotExistException, SQLException {
      return SellingDAO.getSelling(sellingCode);
   }
   // 모든 Selling 검색
   public static ArrayList<SellingDTO> getAllSelling() throws SQLException {
      return SellingDAO.getAllSelling();
   }
   //조회수 증가
   public static boolean updateSellingViews(int sellingCode) throws SQLException, NotExistException{      
      if(checkSelling(sellingCode)){
         boolean result = SellingDAO.updateSellingViews(sellingCode);
         if(!result){
            throw new NotExistException("조회수 갱신 실패");
         }
         return result;
      }
   }
   //진행상태 업뎃
   public static boolean updateSellingProgress(int sellingCode) throws SQLException, NotExistException{      
      if(checkSelling(sellingCode)){
         boolean result = SellingDAO.updateSellingProgress(sellingCode);
         if(!result){
            throw new NotExistException("진행상태 갱신 실패");
         }
         return result;
      }
   }
   // Selling있는지 확인
   public static boolean checkSelling(int sellingCode) throws NotExistException, SQLException {
      if (SellingDAO.getSelling(sellingCode) == null) {
         throw new NotExistException("검색하진 판매 정보가 없습니다.");
         return false;
      }
      return true;
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
   // 결제 추가
   public static boolean addPayment(PaymentDTO payment) throws SQLException {
      return PaymentDAO.addPayment(payment);
   }
   // 모든 결제 검색 -- 컨트롤러도 바꾸기!!!!
   public static PaymentDTO getPayment() throws SQLException {
      return PaymentDAO.getPayment();
   }
   // 회원의 결제 정보 보기
   public static ArrayList<PaymentDTO> getPaymentofMember(int memberCode) throws SQLException {
      return PaymentDAO.getPaymentofMember(memberCode);
   }
}
























////////태수 태수 

public class ZigboService {

	private static ZigboService instance = new ZigboService();

	private ZigboService() {
	};

	public static ZigboService getInstance() {
		return instance;
	}

	// addMember(email, password, phone, address, account) 수정해야됌
	public static boolean addMember(MemberDTO ?) throws SQLException {
		return MemberDAO.addMember(?);
	}

	// getMember(Integer.parseInt(request.getParameter("MemberCode"))
	public static MemberDTO getMember(int MemberCode) throws NotExistException, SQLException {
		MemberDTO member = MemberDAO.getMember(MemberCode);
		if (member == null) {
			throw new NotExistException("검색하진 상품 정보가 없습니다.");
		}
		return member;
	}

	// MemberUpdate(Integer.pdarseInt(request.getParameter("MemberCode"))
	public static boolean MemberUpdate(int memberCode) throws SQLException, NotExistException {
		if (checkMember(memberCode)) {
			boolean result = MemberDAO.MemberUpdate(memberCode);
			if (!result) {
				throw new NotExistException("조회수 갱신 실패");
			}
			return result;
		}
	}

	// MemberDelete(Integer.parseInt(request.getParameter("MemberCode"))
	public boolean MemberDelete(int memberCode, int sellingCode) throws SQLException, NotExistException {
		if (checkMember(memberCode, sellingCode)) {
			return MemberDAO.MemberDelete(memberCode, sellingCode);
		}
	}

	// getSellingofMember(Integer.parseInt(request.getParameter("MemberCode"))
	public static SelingDTO getSellingofMember(int MemberCode) throws NotExistException, SQLException {
		SelingDTO member = SelingDAO.getSellingofMember(MemberCode);
		if (member == null) {
			throw new NotExistException("검색하진 상품 정보가 없습니다.");
		}
		return member;
	}

	// addRequest(myrequest) 수정해야됌
	public static boolean addRequest(RequestDTO request) throws SQLException {
		return RequestDAO.addRequest(request);
	}

	// getRequest(Integer.parseInt(request.getParameter("RequestCode"))
	public static RequestDTO getRequest(int RequestCode) throws NotExistException, SQLException {
		RequestDTO myrequest = RequestDAO.getRequest(RequestCode);
		if (myrequest == null) {
			throw new NotExistException("검색하진 상품 정보가 없습니다.");
		}
		return myrequest;
	}

	// getItemByRequestCode(Integer.parseInt(request.getParameter("ItemCode"))
	public static ItemDTO getItemByRequestCode(int ItemCode) throws NotExistException, SQLException {
		ItemDTO member = ItemDAO.getItemByRequestCode(ItemCode);
		if (member == null) {
			throw new NotExistException("검색하진 상품 정보가 없습니다.");
		}
		return member;
	}

	// getAllRequest()
	public ArrayList<RequestDTO> getAllRequest() throws NotExistException, SQLException {
		ArrayList<RequestDTO> rlist = RequestDAO.getAllRequest();
		if (rlist.size() == 0) {
			throw new NotExistException();
		}
		return rlist;
	}

	// updateRequestViews(Integer.parseInt(request.getParameter("RequestCode"))
	public static boolean updateRequestViews(int requestCode) throws SQLException, NotExistException {
		if (checkRequest(requestCode)) {
			boolean result = RequestDAO.updateRequestViews(requestCode);
			if (!result) {
=======
	// 새로운 item 저장
	public static boolean addItem(ItemDTO item) throws SQLException {
		return ItemDAO.addItem(item);
	}

	// get item
	public static ItemDTO getItem(int itemCode) throws NotExistException, SQLException {
		ItemDTO item = ItemDAO.getItem(itemCode);
		if (item == null) {
			throw new NotExistException("검색하진 상품 정보가 없습니다.");
		}
		return item;
	}

	// 지역으로 item 검색
	public static void getItemByLocation(String location) throws NotExistException, SQLException {
		ItemDTO item = ItemDAO.getItemByLocation(location);
		if (item == null) {
			throw new NotExistException("검색하진 지역에 상품 정보가 없습니다.");
		}
	}

	// 모든 item 검색
	public static ArrayList<ItemDTO> getAllItem() throws SQLException {
		return ItemDAO.getAllItem();
	}

	// item 삭제
	public boolean deleteItem(int itemCode) throws SQLException, NotExistException {
		if (getItem(itemCode) != null) {
			ItemDAO.deleteItem(itemCode);
		}
	}

	//////////////////////////////////////////////////
	// 새로운 찜
	public static boolean addInterest(InterestDTO interest) throws SQLException {
		return InterestDAO.addInterest(interest);
	}

	// get 찜 -- 필요없어보이고 굉장히 이상함 찜으로 찜을 검색하다니
	/*
	 * public static InterestDTO getInterest(InterestDTO interest) throws
	 * NotExistException, SQLException{ if(InterestDAO.getInterest(interest) ==
	 * null){ throw new NotExistException("검색하진 상품 정보가 없습니다."); } return
	 * interest; }
	 */
	// 찜 있는지 확인
	public static boolean checkInterest(int memberCode, int sellingCode) throws NotExistException, SQLException {
		if (InterestDAO.getInterest(memberCode, sellingCode) == null) {
			throw new NotExistException("검색하진 찜 정보가 없습니다.");
			return false;
		}
		return true;
	}

	// 특정 Selling글의 찜개수 반환
	public static int getInterestOfSelling(int sellingCode) throws NotExistException, SQLException {
		return InterestDAO.getInterestOfSelling(sellingCode);
	}

	// 찜 삭제
	public boolean deleteInterest(int memberCode, int sellingCode) throws SQLException, NotExistException {
		if (checkInterest(memberCode, sellingCode)) {
			return InterestDAO.deleteInterest(memberCode, sellingCode);
		}

	}

	////////////////////////////////////////////////////
	// 새로운 Selling 추가
	public static boolean addSelling(SellingDTO selling) throws SQLException {
		return SellingDAO.addSelling(selling);
	}
	// 특정 Selling글의 찜개수 반환
	public static SellingDTO getSelling(int sellingCode) throws NotExistException, SQLException {
		return SellingDAO.getSelling(sellingCode);
	}
	// 모든 Selling 검색
	public static ArrayList<SellingDTO> getAllSelling() throws SQLException {
		return SellingDAO.getAllSelling();
	}
	//조회수 증가
	public static boolean updateSellingViews(int sellingCode) throws SQLException, NotExistException{		
		if(checkSelling(sellingCode)){
			boolean result = SellingDAO.updateSellingViews(sellingCode);
			if(!result){
>>>>>>> b7be969a113cdaf0be64ea97de39741ccd5b869b
				throw new NotExistException("조회수 갱신 실패");
			}
			return result;
		}
	}
<<<<<<< HEAD

	// updateRequestProgress(Integer.parseInt(request.getParameter("RequestCode"))
	public static boolean updateRequestProgress(int requestCode) throws SQLException, NotExistException {
		if (checkRequest(requestCode)) {
			boolean result = RequestDAO.updateRequestProgress(requestCode);
			if (!result) {
				throw new NotExistException("조회수 갱신 실패");
=======
	//진행상태 업뎃
	public static boolean updateSellingProgress(int sellingCode) throws SQLException, NotExistException{		
		if(checkSelling(sellingCode)){
			boolean result = SellingDAO.updateSellingProgress(sellingCode);
			if(!result){
				throw new NotExistException("진행상태 갱신 실패");
>>>>>>> b7be969a113cdaf0be64ea97de39741ccd5b869b
			}
			return result;
		}
	}
<<<<<<< HEAD

	// getRequestofMember(Integer.parseInt(request.getParameter("MemberCode"))
	// 수정해야 됌
	public static RequestDTO getRequestofMember(int memberCode) throws NotExistException, SQLException {
		RequestDTO request = RequestDAO.getRequestofMember(memberCode);
		if (request == null) {
			throw new NotExistException("검색하진 상품 정보가 없습니다.");
		}
		return request;
	}

	// addApply(apply)
	public static boolean addApply(ApplyDTO apply) throws SQLException {
		return ApplyDAO.addApply(apply);
	}

	getApply(Integer.parseInt(request.getParameter("ApplyCode"))
			
	//getAllApply()
	public ArrayList<ApplyDTO> getAllApply() throws NotExistException, SQLException {
		ArrayList<ApplyDTO> alist = ApplyDAO.getAllApply();
		if (alist.size() == 0) {
			throw new NotExistException();
		}
		return alist;
	}

	// updateApplyDetail(Integer.parseInt(request.getParameter("ApplyCode"))
	public static boolean updateApplyDetail(int applyCode) throws SQLException, NotExistException {
		if (checkApply(requestCode)) {
			boolean result = ApplyDAO.updateApplyDetail(requestCode);
			if (!result) {
				throw new NotExistException("조회수 갱신 실패");
			}
			return result;
		}
	}

	// deleteApply(Integer.parseInt(request.getParameter("ApplyCode"))
	public boolean deleteApply(int applyCode) throws SQLException, NotExistException {
		if (getApply(applyCode) != null) {
			ApplyDAO.deleteApply(applyCode);
		}
	}

	// getApplyofMember(Integer.parseInt(request.getParameter("MemberCode"))
	// 수정해야됌
	static ApplyDTO getApplyofMember(int applyCode) throws NotExistException, SQLException {
		ApplyDTO member = ApplyDAO.getApplyofMember(ApplyCode);
		if (member == null) {
			throw new NotExistException("검색하진 상품 정보가 없습니다.");
		}
		return member;
=======
	// Selling있는지 확인
	public static boolean checkSelling(int sellingCode) throws NotExistException, SQLException {
		if (SellingDAO.getSelling(sellingCode) == null) {
			throw new NotExistException("검색하진 판매 정보가 없습니다.");
			return false;
		}
		return true;
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
	// 결제 추가
	public static boolean addPayment(PaymentDTO payment) throws SQLException {
		return PaymentDAO.addPayment(payment);
	}
	// 모든 결제 검색 -- 컨트롤러도 바꾸기!!!!
	public static PaymentDTO getPayment() throws SQLException {
		return PaymentDAO.getPayment();
	}
	// 회원의 결제 정보 보기
	public static ArrayList<PaymentDTO> getPaymentofMember(int memberCode) throws SQLException {
		return PaymentDAO.getPaymentofMember(memberCode);
>>>>>>> b7be969a113cdaf0be64ea97de39741ccd5b869b
	}
}
