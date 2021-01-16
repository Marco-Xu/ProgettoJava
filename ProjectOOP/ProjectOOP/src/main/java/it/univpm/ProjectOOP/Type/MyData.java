package it.univpm.ProjectOOP.Type;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyData extends MainData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String description;
	@JsonIgnore
	protected int date;


	public MyData() {
	}
	
	public MyData(String city, String description, double normalTemp, double maximalTemp, double minimalTemp, double feelsLikeTemp, int date) {
		super(city, normalTemp, maximalTemp, minimalTemp, feelsLikeTemp);
		this.description = description;
		this.date = date;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "MyData:" + super.toString() + "\ndescription : " + description + "\ndate : " + date + "\n";
	}
	
}
