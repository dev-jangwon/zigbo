package zigbo.model.dto;

public class ItemDTO {

	private int itemCode; //NUMBER(3) NOT NULL ,
	private String price; //VARCHAR2(20) NULL ,
	private String detail; //VARCHAR2(200) NULL ,
	private String location; //VARCHAR2(100) NULL ,
	private String picture1; //BLOB NULL ,
	private String picture2; //BLOB NULL 
	
	public ItemDTO() {	}
	public ItemDTO(String price, String detail, String location, String picture1, String picture2) {
		super();
		this.price = price;
		this.detail = detail;
		this.location = location;
		this.picture1 = picture1;
		this.picture2 = picture2;
	}
	public ItemDTO(int itemCode, String price, String detail, String location, String picture1, String picture2) {
		super();
		this.itemCode = itemCode;
		this.price = price;
		this.detail = detail;
		this.location = location;
		this.picture1 = picture1;
		this.picture2 = picture2;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
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

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	
	
	
}
