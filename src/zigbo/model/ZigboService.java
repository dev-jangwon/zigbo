package zigbo.model;

import java.sql.SQLException;
import java.util.ArrayList;

import zigbo.exception.NotExistException;
import zigbo.model.dto.InterestDTO;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.dto.SellingDTO;

public class ZigboService {

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
