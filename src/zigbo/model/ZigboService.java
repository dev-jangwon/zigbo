package zigbo.model;

import java.sql.SQLException;
import java.util.ArrayList;

import zigbo.exception.NotExistException;
import zigbo.model.dto.InterestDTO;
import zigbo.model.dto.ItemDTO;
import zigbo.model.dto.PaymentDTO;
import zigbo.model.dto.SellingDTO;

public class ZigboService {

	// ���ο� item ����
	public static boolean addItem(ItemDTO item) throws SQLException {
		return ItemDAO.addItem(item);
	}

	// get item
	public static ItemDTO getItem(int itemCode) throws NotExistException, SQLException {
		ItemDTO item = ItemDAO.getItem(itemCode);
		if (item == null) {
			throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�.");
		}
		return item;
	}

	// �������� item �˻�
	public static void getItemByLocation(String location) throws NotExistException, SQLException {
		ItemDTO item = ItemDAO.getItemByLocation(location);
		if (item == null) {
			throw new NotExistException("�˻����� ������ ��ǰ ������ �����ϴ�.");
		}
	}

	// ��� item �˻�
	public static ArrayList<ItemDTO> getAllItem() throws SQLException {
		return ItemDAO.getAllItem();
	}

	// item ����
	public boolean deleteItem(int itemCode) throws SQLException, NotExistException {
		if (getItem(itemCode) != null) {
			ItemDAO.deleteItem(itemCode);
		}
	}

	//////////////////////////////////////////////////
	// ���ο� ��
	public static boolean addInterest(InterestDTO interest) throws SQLException {
		return InterestDAO.addInterest(interest);
	}

	// get �� -- �ʿ����̰� ������ �̻��� ������ ���� �˻��ϴٴ�
	/*
	 * public static InterestDTO getInterest(InterestDTO interest) throws
	 * NotExistException, SQLException{ if(InterestDAO.getInterest(interest) ==
	 * null){ throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�."); } return
	 * interest; }
	 */
	// �� �ִ��� Ȯ��
	public static boolean checkInterest(int memberCode, int sellingCode) throws NotExistException, SQLException {
		if (InterestDAO.getInterest(memberCode, sellingCode) == null) {
			throw new NotExistException("�˻����� �� ������ �����ϴ�.");
			return false;
		}
		return true;
	}

	// Ư�� Selling���� �򰳼� ��ȯ
	public static int getInterestOfSelling(int sellingCode) throws NotExistException, SQLException {
		return InterestDAO.getInterestOfSelling(sellingCode);
	}

	// �� ����
	public boolean deleteInterest(int memberCode, int sellingCode) throws SQLException, NotExistException {
		if (checkInterest(memberCode, sellingCode)) {
			return InterestDAO.deleteInterest(memberCode, sellingCode);
		}

	}

	////////////////////////////////////////////////////
	// ���ο� Selling �߰�
	public static boolean addSelling(SellingDTO selling) throws SQLException {
		return SellingDAO.addSelling(selling);
	}
	// Ư�� Selling���� �򰳼� ��ȯ
	public static SellingDTO getSelling(int sellingCode) throws NotExistException, SQLException {
		return SellingDAO.getSelling(sellingCode);
	}
	// ��� Selling �˻�
	public static ArrayList<SellingDTO> getAllSelling() throws SQLException {
		return SellingDAO.getAllSelling();
	}
	//��ȸ�� ����
	public static boolean updateSellingViews(int sellingCode) throws SQLException, NotExistException{		
		if(checkSelling(sellingCode)){
			boolean result = SellingDAO.updateSellingViews(sellingCode);
			if(!result){
				throw new NotExistException("��ȸ�� ���� ����");
			}
			return result;
		}
	}
	//������� ����
	public static boolean updateSellingProgress(int sellingCode) throws SQLException, NotExistException{		
		if(checkSelling(sellingCode)){
			boolean result = SellingDAO.updateSellingProgress(sellingCode);
			if(!result){
				throw new NotExistException("������� ���� ����");
			}
			return result;
		}
	}
	// Selling�ִ��� Ȯ��
	public static boolean checkSelling(int sellingCode) throws NotExistException, SQLException {
		if (SellingDAO.getSelling(sellingCode) == null) {
			throw new NotExistException("�˻����� �Ǹ� ������ �����ϴ�.");
			return false;
		}
		return true;
	}
	//��ȸ�� ���� �� Sellings ��ȯ
	public static ArrayList<SellingDTO> getMostViews() throws SQLException {
		return SellingDAO.getMostViews();
	}
	// �ֽż� Sellings ��ȯ
	public static ArrayList<SellingDTO> getMostRecent() throws SQLException {
		return SellingDAO.getMostRecent();
	}
	// ��� Sellings ��ȯ
	public static ArrayList<SellingDTO> getMostInterest() throws SQLException {
		return SellingDAO.getMostInterest();
	}
	// ���� �߰�
	public static boolean addPayment(PaymentDTO payment) throws SQLException {
		return PaymentDAO.addPayment(payment);
	}
	// ��� ���� �˻� -- ��Ʈ�ѷ��� �ٲٱ�!!!!
	public static PaymentDTO getPayment() throws SQLException {
		return PaymentDAO.getPayment();
	}
	// ȸ���� ���� ���� ����
	public static ArrayList<PaymentDTO> getPaymentofMember(int memberCode) throws SQLException {
		return PaymentDAO.getPaymentofMember(memberCode);
	}
}
