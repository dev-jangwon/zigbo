package zigbo.model.dto;

public class CommentDTO {
	
	private int divisionCode;
	private int textCode;
	private int memberCode;
	private String comment;
	private String reply;
	
	public CommentDTO() {}
	public CommentDTO(int divisionCode, int textCode, int memberCode, String comment, String reply) {
		super();
		this.divisionCode = divisionCode;
		this.textCode = textCode;
		this.memberCode = memberCode;
		this.comment = comment;
		this.reply = reply;
	}

	public int getTextCode() {
		return textCode;
	}
	public void setTextCode(int textCode) {
		this.textCode = textCode;
	}
	public int getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(int divisionCode) {
		this.divisionCode = divisionCode;
	}
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", divisionCode=").append(divisionCode)
				.append(", textCode=").append(textCode).append(", memberCode=").append(memberCode).append(", comment=")
				.append(comment).append(", reply=").append(reply).append("]");
		return builder.toString();
	}

}
