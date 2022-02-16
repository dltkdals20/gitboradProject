package kr.co.greenart.model;

import java.util.Date;

public class WritInfo {
	private String title;
	private String location;
	private String date;
	private String text;
	private double star;
	
	
	public WritInfo() {
		super();
	}


	public WritInfo(String title, String location, String date, String text, double star) {
		super();
		this.title = title;
		this.location = location;
		this.date = date;
		this.text = text;
		this.star = star;
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


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public double getStar() {
		return star;
	}


	public void setStar(double star) {
		this.star = star;
	}


	@Override
	public String toString() {
		return "writInfo [title=" + title + ", location=" + location + ", date=" + date + ", text=" + text + ", star="
				+ star + "]";
	}
	
	
	
	
}
