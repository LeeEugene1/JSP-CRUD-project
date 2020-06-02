package kr.or.ddit.vo;

public class StatisticsVO {
	private String gender;
	private String genderCount;
	private String age;
	private String ageCount;
	private String board;
	private String image;
	private String notice;
	private String qanda;
	private String reference;
	private String count;
	private String dropout;
	private String dropoutCount;
	private String join;
	private String joinCount;
	
	
	//private String count(*);
	
	public String getBoard() {
		return board;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getQanda() {
		return qanda;
	}
	public void setQanda(String qanda) {
		this.qanda = qanda;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGenderCount() {
		return genderCount;
	}
	public void setGenderCount(String genderCount) {
		this.genderCount = genderCount;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAgeCount() {
		return ageCount;
	}
	public void setAgeCount(String ageCount) {
		this.ageCount = ageCount;
	}
	public String getDropout() {
		return dropout;
	}
	public void setDropout(String dropout) {
		this.dropout = dropout;
	}
	public String getDropoutCount() {
		return dropoutCount;
	}
	public void setDropoutCount(String dropoutCount) {
		this.dropoutCount = dropoutCount;
	}
	public String getJoin() {
		return join;
	}
	public void setJoin(String join) {
		this.join = join;
	}
	public String getJoinCount() {
		return joinCount;
	}
	public void setJoinCount(String joinCount) {
		this.joinCount = joinCount;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
}
