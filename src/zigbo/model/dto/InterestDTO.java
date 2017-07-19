package zigbo.model.dto;

public class InterestDTO {

   private int memberCode; //NUMBER(3) NOT NULL ,
   private int sellingCode; //NUMBER(3) NOT NULL
   
   public InterestDTO() {}

   public InterestDTO(int memberCode, int sellingCode) {
	      super();
	      this.memberCode = memberCode;
	      this.sellingCode = sellingCode;
   }
   
   public int getMemberCode() {
      return memberCode;
   }

   public void setMemberCode(int memberCode) {
      this.memberCode = memberCode;
   }

   public int getSellingCode() {
      return sellingCode;
   }

   public void setSellingCode(int sellingCode) {
      this.sellingCode = sellingCode;
   }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InterestDTO [memberCode=").append(memberCode).append(", sellingCode=").append(sellingCode)
				.append("]");
		return builder.toString();
	}

}