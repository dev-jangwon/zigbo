package zigbo.model.dto;

import java.util.Date;

public class SellingMemberDTO {
	private int sellingCode;
	private int memberCode;
	private int itemCode;
	private int views;
	private Date uploadDate;
	private String progress;
	private String location;
	private String email;
	
	public SellingMemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SellingMemberDTO(int sellingCode, int memberCode, int itemCode, int views, Date uploadDate, String progress, String location,
			String email) {
		super();
		this.sellingCode = sellingCode;
		this.memberCode = memberCode;
		this.itemCode = itemCode;
		this.views = views;
		this.uploadDate = uploadDate;
		this.progress = progress;
		this.location = location;
		this.email = email;
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
	public int getItemCode() {
		return itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SellingMemberDTO [sellingCode=").append(sellingCode).append(", memberCode=").append(memberCode)
				.append(", itemCode=").append(itemCode).append(", views=").append(views).append(", progress=").append(", uploadDate=")
				.append(uploadDate)
				.append(progress).append(", location=").append(location).append(", email=").append(email).append("]");
		return builder.toString();
	}
	
	
}
