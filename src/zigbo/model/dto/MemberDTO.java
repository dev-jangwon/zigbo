package zigbo.model.dto;

public class MemberDTO {
	
	private int memberCode; //입력X
	private String email;
	private String password;
	private String phone;
	private String address;
	private String account;
	
	public MemberDTO() {}

	public MemberDTO(String email, String password, String phone, String address, String account) {
		super();
		//입력받는거 기반
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.account = account;
	}

	public MemberDTO(int memberCode, String email, String password, String phone, String address, String account) {
		this.memberCode = memberCode;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.account = account;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberDTO [memberCode=").append(memberCode).append(", email=").append(email)
				.append(", password=").append(password).append(", phone=").append(phone).append(", address=")
				.append(address).append(", account=").append(account).append("]");
		return builder.toString();
	}

}
