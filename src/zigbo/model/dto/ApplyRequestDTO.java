package zigbo.model.dto;

public class ApplyRequestDTO {
	private int applyCode; 	//NUMBER(3) NOT NULL 
	private int requestCode;//NUMBER(3) NOT NULL 
	private int memberCode; //NUMBER(3) NOT NULL
	private String detail;	//VARCHAR2(200) NULL 
	private String progress;

	public ApplyRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplyRequestDTO(int applyCode, int requestCode, int memberCode, String detail, String progress) {
		super();
		this.applyCode = applyCode;
		this.requestCode = requestCode;
		this.memberCode = memberCode;
		this.detail = detail;
		this.progress = progress;
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
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApplyMemberDTO [applyCode=").append(applyCode).append(", requestCode=").append(requestCode)
				.append(", memberCode=").append(memberCode).append(", detail=").append(detail).append(", progress=")
				.append(progress).append("]");
		return builder.toString();
	} 

}
