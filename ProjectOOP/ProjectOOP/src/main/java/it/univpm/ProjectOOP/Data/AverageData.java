package it.univpm.ProjectOOP.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AverageData extends AbData implements Serializable {
	
	private static final long serialVersionUID = 1;
	@JsonIgnore
	protected int n;
	
	public AverageData() {
	}
	
	public AverageData(String city, double normalTemp, double maximalTemp, double minimalTemp, double feelsLikeTemp, int n) {
		super();
		this.city = city;
		this.normalTemp = normalTemp;
		this.maximalTemp = maximalTemp;
		this.minimalTemp = minimalTemp;
		this.feelsLikeTemp = feelsLikeTemp;
		this.n = n;
	}
	
	public void addNormalTemp(double normalTemp) {
		this.normalTemp += normalTemp;
	}

	public void addMaximalTemp(double maximalTemp) {
		this.maximalTemp += maximalTemp;
	}
	
	public void addMinimalTemp(double minimalTemp) {
		this.minimalTemp += minimalTemp;
	}
	
	public void addFeelsLikeTemp(double feelsLikeTemp) {
		this.feelsLikeTemp += feelsLikeTemp;
	}
	
	public int increaseN() {
		return n++;
	}
	
	public void calc() {
		this.normalTemp = getNormalTemp() / n;
		this.maximalTemp = getMaximalTemp() / n;
		this.minimalTemp = getMinimalTemp() / n;
		this.feelsLikeTemp = getFeelsLikeTemp() / n;
	}
	
	@Override
	public String toString() {
		return "AverageData:" + super.toString();
	}
}
