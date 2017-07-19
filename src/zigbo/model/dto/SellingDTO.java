package zigbo.model.dto;

public class SellingDTO {
	
	private int sellingCode;
	private int memberCode;
	private int itemCode;
	private int views;
	private String progress;
	private String location;
	
	public SellingDTO() {}
	
	public SellingDTO(int memberCode, int itemCode, String location) { //입력받는 data기반
		this.memberCode = memberCode;
		this.itemCode = itemCode;
		this.views = 0;
		this.progress = "wait"; //"wait"가 대기(DB에서는 W), "done"가 진행(DB에서는 D)
		this.location = location;
	}
	
	public SellingDTO(int sellingCode, int memberCode, int itemCode, int views, String progress, String location) { //Selling 검색시 사용
		this.sellingCode = sellingCode;
		this.memberCode = memberCode;
		this.itemCode = itemCode;
		this.views = views;
		this.progress = progress;
		this.location = location;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SellingDTO [sellingCode=").append(sellingCode).append(", memberCode=").append(memberCode)
				.append(", itemCode=").append(itemCode).append(", views=").append(views).append(", progress=")
				.append(progress).append(", location=").append(location).append("]");
		return builder.toString();
	}
	
}
