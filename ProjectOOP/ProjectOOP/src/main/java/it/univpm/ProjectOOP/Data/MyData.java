package it.univpm.ProjectOOP.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyData extends AbData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String description;
	@JsonIgnore
	protected int date;


	public MyData() {
	}
	
	public MyData(String city, String description, double normalTemp, double maximalTemp, double minimalTemp, double feelsLikeTemp, int date) {
		this.city = city;
		this.description = description;
		this.normalTemp = normalTemp;
		this.maximalTemp = maximalTemp;
		this.minimalTemp = minimalTemp;
		this.feelsLikeTemp = feelsLikeTemp;
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
		return "MyData:" + "\ncity=" + city + "\ndescription=" + description + "\nnormalTemp="
				+ normalTemp + "\nmaximalTemp=" + maximalTemp + "\nminimalTemp=" + minimalTemp + "\nfeelsLikeTemp="
				+ feelsLikeTemp + "\ndate=" + date + "\n";
	}
	
}
