package zigbo.model.dto;

public class ItemDTO {

	private int itemCode; //NUMBER(3) NOT NULL ,
	private String title;
	private String price; //VARCHAR2(20) NULL ,
	private String detail; //VARCHAR2(200) NULL ,
	private String location; //VARCHAR2(100) NULL ,
	private String picture; //BLOB NULL ,
	
	public ItemDTO() {}
	
	public ItemDTO(String title, String price, String detail, String location, String picture) {
		this.title = title;
		this.price = price;
		this.detail = detail;
		this.location = location;
		this.picture = picture;
	}
	
	public ItemDTO(int itemCode, String title, String price, String detail, String location, String picture) {
		this.itemCode = itemCode;
		this.title = title;
		this.price = price;
		this.detail = detail;
		this.location = location;
		this.picture = picture;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemDTO [itemCode=");
		builder.append(itemCode);
		builder.append(", title=");
		builder.append(title);
		builder.append(", price=");
		builder.append(price);
		builder.append(", detail=");
		builder.append(detail);
		builder.append(", location=");
		builder.append(location);
		builder.append(", picture=");
		builder.append(picture);
		builder.append("]");
		return builder.toString();
	}
	
}
