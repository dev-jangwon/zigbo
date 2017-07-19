package zigbo.model.dto;

public class PaymentDTO {

	private int paymentCode; //입력X
	private int sellingCode; //어떤 판매를
	private int memberCode; //어떤 회원이 구매를 하며
	private String address; //주문지는 어디다
	
	public PaymentDTO() {}
	
	public PaymentDTO(int sellingCode, int memberCode, String address) {
		this.sellingCode = sellingCode;
		this.memberCode = memberCode;
		this.address = address;
	}
	public PaymentDTO(int paymentCode, int sellingCode, int memberCode, String address) {
		this.paymentCode = paymentCode;
		this.sellingCode = sellingCode;
		this.memberCode = memberCode;
		this.address = address;
	}
	
	public int getPaymentCode() {
		return paymentCode;
	}
	
	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	
	public int getSellingCode() {
		return sellingCode;
	}
	
	public void setSellingCode(int sellingCode) {
		this.sellingCode = sellingCode;
	}
	
	public int getMemberCode() {
		return memberCode;
	}
	
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaymentDTO [paymentCode=").append(paymentCode).append(", sellingCode=").append(sellingCode)
				.append(", memberCode=").append(memberCode).append(", address=").append(address).append("]");
		return builder.toString();
	}
	
}
