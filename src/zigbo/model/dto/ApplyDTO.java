package zigbo.model.dto;

public class ApplyDTO {

	private int applyCode; 	//NUMBER(3) NOT NULL 
	private int requestCode;//NUMBER(3) NOT NULL 
	private int memberCode; //NUMBER(3) NOT NULL
	private String detail;	//VARCHAR2(200) NULL 
	
	public ApplyDTO() {
		super();
	}

	public ApplyDTO(int applyCode, int requestCode, int memberCode, String detail) {
		super();
		this.applyCode = applyCode;
		this.requestCode = requestCode;
		this.memberCode = memberCode;
		this.detail = detail;
	}

	public int getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(int applyCode) {
		this.applyCode = applyCode;
	}

	public int getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(int requestCode) {
		this.requestCode = requestCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}

