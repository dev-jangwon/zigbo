package zigbo.model.dto;

public class RequestMemberDTO {

	private int requestCode;
	private int itemCode; 
	private int memberCode;
	private int views;
	private String uploadDate;
	private String progress; 
	private String location;
	private String email;
	public RequestMemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestMemberDTO(int requestCode, int itemCode, int memberCode, int views, String uploadDate,
			String progress, String location, String email) {
		super();
		this.requestCode = requestCode;
		this.itemCode = itemCode;
		this.memberCode = memberCode;
		this.views = views;
		this.uploadDate = uploadDate;
		this.progress = progress;
		this.location = location;
		this.email = email;
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
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestMemberDTO [requestCode=").append(requestCode).append(", itemCode=").append(itemCode)
				.append(", memberCode=").append(memberCode).append(", views=").append(views).append(", uploadDate=")
				.append(uploadDate).append(", progress=").append(progress).append(", location=").append(location)
				.append(", email=").append(email).append("]");
		return builder.toString();
	}
	
	
}
