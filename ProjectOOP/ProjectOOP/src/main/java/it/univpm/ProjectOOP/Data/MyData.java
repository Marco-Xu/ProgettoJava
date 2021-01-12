package it.univpm.ProjectOOP.Data;

import java.io.Serializable;

public class MyData implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected String city;
	protected String description;
	protected double normalTemp;
	protected double maximalTemp;
	protected double minimalTemp;
	protected double feelsLikeTemp;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getNormalTemp() {
		return normalTemp;
	}


	public void setNormalTemp(double normalTemp) {
		this.normalTemp = normalTemp;
	}


	public double getMaximalTemp() {
		return maximalTemp;
	}


	public void setMaximalTemp(double maximalTemp) {
		this.maximalTemp = maximalTemp;
	}


	public double getMinimalTemp() {
		return minimalTemp;
	}


	public void setMinimalTemp(double minimalTemp) {
		this.minimalTemp = minimalTemp;
	}


	public double getFeelsLikeTemp() {
		return feelsLikeTemp;
	}


	public void setFeelsLikeTemp(double feelsLikeTemp) {
		this.feelsLikeTemp = feelsLikeTemp;
	}


	public int getDate() {
		return date;
	}


	public void setDate(int date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "MyData [" + "\ncity=" + city + "\ndescription=" + description + "\nnormalTemp="
				+ normalTemp + "\nmaximalTemp=" + maximalTemp + "\nminimalTemp=" + minimalTemp + "\nfeelsLikeTemp="
				+ feelsLikeTemp + "\ndate=" + date + "\n]";
	}
	
}
