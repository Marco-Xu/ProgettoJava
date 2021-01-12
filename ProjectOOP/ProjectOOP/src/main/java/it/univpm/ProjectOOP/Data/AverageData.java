package it.univpm.ProjectOOP.Data;

import java.io.Serializable;

public class AverageData implements Serializable{
	
	private static final long serialVersionUID = 1;

	protected String city;
	protected double normalTemp;
	protected double maximalTemp;
	protected double minimalTemp;
	protected double feelsLikeTemp;
	protected int n;
	
	public AverageData() {
		
	}
	
	public AverageData(String city, double normalTemp, double maximalTemp, double minimalTemp, double feelsLikeTemp,
			int n) {
		super();
		this.city = city;
		this.normalTemp = normalTemp;
		this.maximalTemp = maximalTemp;
		this.minimalTemp = minimalTemp;
		this.feelsLikeTemp = feelsLikeTemp;
		this.n = n;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public double getNormalTemp() {
		return normalTemp/n;
	}
	
	public void addNormalTemp(double normalTemp) {
		this.normalTemp += normalTemp;
	}
	
	public double getMaximalTemp() {
		return maximalTemp/n;
	}
	
	public void addMaximalTemp(double maximalTemp) {
		this.maximalTemp += maximalTemp;
	}
	
	public double getMinimalTemp() {
		return minimalTemp/n;
	}
	
	public void addMinimalTemp(double minimalTemp) {
		this.minimalTemp += minimalTemp;
	}
	
	public double getFeelsLikeTemp() {
		return feelsLikeTemp/n;
	}
	
	public void addFeelsLikeTemp(double feelsLikeTemp) {
		this.feelsLikeTemp += feelsLikeTemp;
	}
	
	public int increaseN() {
		return n++;
	}
	
	
}
