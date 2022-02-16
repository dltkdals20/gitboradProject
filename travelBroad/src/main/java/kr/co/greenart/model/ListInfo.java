package kr.co.greenart.model;

public class ListInfo {
	private int id;
	private String nicName;
	private String title;
	private String location;
	private String date;
	private String writeDate;
	private String text;
	private int star;
	private int count;
	
	public ListInfo() {
		super();
	}

	

	
	
	
//	public ListInfo(int id, String nicName, String title, String date, int count) {
//		super();
//		this.id = id;
//		this.nicName = nicName;
//		this.title = title;
//		this.date = date;
//		this.count = count;
//	}






	public ListInfo(int id, String title, String date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
	}
	
	public ListInfo(int id, String nicName, String title, String writeDate, int count) {
	super();
	this.id = id;
	this.nicName = nicName;
	this.title = title;
	this.writeDate = writeDate;
	this.count = count;
	
	}






	public ListInfo(int id, String nicName, String title, String location, String date, String writeDate, String text,
			int star) {
		super();
		this.id = id;
		this.nicName = nicName;
		this.title = title;
		this.location = location;
		this.date = date;
		this.writeDate = writeDate;
		this.text = text;
		this.star = star;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNicName() {
		return nicName;
	}
	public void setNicName(String nicName) {
		this.nicName = nicName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ListInfo [id=" + id + ", nicName=" + nicName + ", title=" + title + ", location=" + location + ", date="
				+ date + ", writeDate=" + writeDate + ", text=" + text + ", star=" + star + ", count=" + count + "]";
	}

	
	
	
	
}
