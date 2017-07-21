package zigbo.model.dto;

public class RequestPaymentDTO {
	private int payment_code;
	private int request_code;
	private int member_code;
	private String address;
	
	public RequestPaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RequestPaymentDTO(int payment_code, int request_code, int member_code, String address) {
		super();
		this.payment_code = payment_code;
		this.request_code = request_code;
		this.member_code = member_code;
		this.address = address;
	}


	public int getPayment_code() {
		return payment_code;
	}


	public void setPayment_code(int payment_code) {
		this.payment_code = payment_code;
	}


	public int getRequest_code() {
		return request_code;
	}


	public void setRequest_code(int request_code) {
		this.request_code = request_code;
	}


	public int getMember_code() {
		return member_code;
	}


	public void setMember_code(int member_code) {
		this.member_code = member_code;
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
		builder.append("ReqeustPaymentDTO [payment_code=").append(payment_code).append(", request_code=")
				.append(request_code).append(", member_code=").append(member_code).append(", address=").append(address)
				.append("]");
		return builder.toString();
	}
	
	
	
	
}
