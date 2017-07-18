package zigbo.model.dto;

public class InterestDTO {

   private int memberCode; //NUMBER(3) NOT NULL ,
   private int sellingCode; //NUMBER(3) NOT NULL 
   
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

   public InterestDTO() {
      super();
   }

   public InterestDTO(int memberCode, int sellingCode) {
      super();
      this.memberCode = memberCode;
      this.sellingCode = sellingCode;
   }
      
}