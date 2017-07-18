package zigbo.model.dto;

public class RequestDTO {

	private int requestCode; // NUMBER(3) NOT NULL ,
	private int itemCode; // NUMBER(3) NOT NULL ,
	private int memberCode; // NUMBER(3) NOT NULL ,
	private int views; // NUMBER(4) NULL ,
	private String progress; 
	private String location; // 
	
	public RequestDTO(int requestCode, int itemCode, int memberCode, int views, String progress, String location) {
		super();
		this.requestCode = requestCode;
		this.itemCode = itemCode;
		this.memberCode = memberCode;
		this.views = views;
		this.progress = progress;
		this.location = location;
	}

	public RequestDTO() {
		super();
	}

	public int getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(int requestCode) {
		this.requestCode = requestCode;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
	
}
