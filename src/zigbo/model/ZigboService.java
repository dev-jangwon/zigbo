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
























////////�¼� �¼� 

public class ZigboService {

	private static ZigboService instance = new ZigboService();

	private ZigboService() {
	};

	public static ZigboService getInstance() {
		return instance;
	}

	// addMember(email, password, phone, address, account) �����ؾ߉�
	public static boolean addMember(MemberDTO ?) throws SQLException {
		return MemberDAO.addMember(?);
	}

	// getMember(Integer.parseInt(request.getParameter("MemberCode"))
	public static MemberDTO getMember(int MemberCode) throws NotExistException, SQLException {
		MemberDTO member = MemberDAO.getMember(MemberCode);
		if (member == null) {
			throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�.");
		}
		return member;
	}

	// MemberUpdate(Integer.pdarseInt(request.getParameter("MemberCode"))
	public static boolean MemberUpdate(int memberCode) throws SQLException, NotExistException {
		if (checkMember(memberCode)) {
			boolean result = MemberDAO.MemberUpdate(memberCode);
			if (!result) {
				throw new NotExistException("��ȸ�� ���� ����");
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
			throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�.");
		}
		return member;
	}

	// addRequest(myrequest) �����ؾ߉�
	public static boolean addRequest(RequestDTO request) throws SQLException {
		return RequestDAO.addRequest(request);
	}

	// getRequest(Integer.parseInt(request.getParameter("RequestCode"))
	public static RequestDTO getRequest(int RequestCode) throws NotExistException, SQLException {
		RequestDTO myrequest = RequestDAO.getRequest(RequestCode);
		if (myrequest == null) {
			throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�.");
		}
		return myrequest;
	}

	// getItemByRequestCode(Integer.parseInt(request.getParameter("ItemCode"))
	public static ItemDTO getItemByRequestCode(int ItemCode) throws NotExistException, SQLException {
		ItemDTO member = ItemDAO.getItemByRequestCode(ItemCode);
		if (member == null) {
			throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�.");
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
>>>>>>> b7be969a113cdaf0be64ea97de39741ccd5b869b
				throw new NotExistException("��ȸ�� ���� ����");
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
				throw new NotExistException("��ȸ�� ���� ����");
=======
	//������� ����
	public static boolean updateSellingProgress(int sellingCode) throws SQLException, NotExistException{		
		if(checkSelling(sellingCode)){
			boolean result = SellingDAO.updateSellingProgress(sellingCode);
			if(!result){
				throw new NotExistException("������� ���� ����");
>>>>>>> b7be969a113cdaf0be64ea97de39741ccd5b869b
			}
			return result;
		}
	}
<<<<<<< HEAD

	// getRequestofMember(Integer.parseInt(request.getParameter("MemberCode"))
	// �����ؾ� ��
	public static RequestDTO getRequestofMember(int memberCode) throws NotExistException, SQLException {
		RequestDTO request = RequestDAO.getRequestofMember(memberCode);
		if (request == null) {
			throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�.");
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
				throw new NotExistException("��ȸ�� ���� ����");
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
	// �����ؾ߉�
	static ApplyDTO getApplyofMember(int applyCode) throws NotExistException, SQLException {
		ApplyDTO member = ApplyDAO.getApplyofMember(ApplyCode);
		if (member == null) {
			throw new NotExistException("�˻����� ��ǰ ������ �����ϴ�.");
		}
		return member;
=======
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
>>>>>>> b7be969a113cdaf0be64ea97de39741ccd5b869b
	}
}
