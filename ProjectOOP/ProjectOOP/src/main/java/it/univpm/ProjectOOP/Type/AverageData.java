package it.univpm.ProjectOOP.Type;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AverageData extends MainData implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	protected int n;
	protected double varNormalTemp;
	protected double varFeelsLikeTemp;
	protected double maxFeelsLikeTemp;
	protected double minFeelsLikeTemp;
	
	@JsonIgnore
	protected Vector<Double> allNormalTemp = new Vector<Double>();
	@JsonIgnore
	protected Vector<Double> allMaximalTemp = new Vector<Double>();
	@JsonIgnore
	protected Vector<Double> allMinimalTemp = new Vector<Double>();
	@JsonIgnore
	protected Vector<Double> allFeelsLikeTemp = new Vector<Double>();

	public AverageData() {
	}
	
	public AverageData(String city, double normalTemp, double maximalTemp, double minimalTemp, double feelsLikeTemp, int n) {
		this.city = city;
		this.normalTemp = normalTemp;
		this.maximalTemp = maximalTemp;
		this.minimalTemp = minimalTemp;
		this.feelsLikeTemp = feelsLikeTemp;
		this.n = n;
	}
	
	public void addNormalTemp(double normalTemp) {
		this.normalTemp += normalTemp;
		allNormalTemp.add(normalTemp);
	}

	public void addMaximalTemp(double maximalTemp) {
		if(this.maximalTemp < maximalTemp)
			this.maximalTemp += maximalTemp;
		allMaximalTemp.add(maximalTemp);
	}
	
	public void addMinimalTemp(double minimalTemp) {
		if(allMinimalTemp.isEmpty())
			this.minimalTemp = minimalTemp;
		if(this.minimalTemp > minimalTemp)
			this.minimalTemp = minimalTemp;
		allMinimalTemp.add(minimalTemp);
	}
	
	public void addFeelsLikeTemp(double feelsLikeTemp) {
		this.feelsLikeTemp += feelsLikeTemp;
		allFeelsLikeTemp.add(feelsLikeTemp);
	}
	
	public Double getVarNormalTemp() {
		return varNormalTemp;
	}
	
	public double getMaxFeelsLikeTemp() {
		return maxFeelsLikeTemp;
	}

	public double getMinFeelsLikeTemp() {
		return minFeelsLikeTemp;
	}

	public Double getVarFeelsLikeTemp() {
		return varFeelsLikeTemp;
	}

	public int getN() {
		return n;
	}
	
	public int increaseN() {
		return n++;
	}
	
	public void calc() {
		this.normalTemp = getNormalTemp() / n;
		this.feelsLikeTemp = getFeelsLikeTemp() / n;
		
		this.varNormalTemp = round(getVar(allNormalTemp, normalTemp));
		this.varFeelsLikeTemp = round(getVar(allFeelsLikeTemp, feelsLikeTemp));
		
		minFeelsLikeTemp = this.feelsLikeTemp;
		for(double a : allFeelsLikeTemp) {
			if(maxFeelsLikeTemp < a)
				maxFeelsLikeTemp = a;
			if(minFeelsLikeTemp > a)
				minFeelsLikeTemp = a;
		}
		
	}
	
	private Double getVar(Vector<Double> all, double average) {
		double temp = 0;
		for(double a : all) 
			temp += ((a - average) * (a - average));
		return temp/n;
	}

	@Override
	public void toCelsius() {
		normalTemp -= 273.15;
		maximalTemp -= 273.15;
		minimalTemp -= 273.15;
		maxFeelsLikeTemp = round(maxFeelsLikeTemp -  273.15);
		minFeelsLikeTemp = round(minFeelsLikeTemp -  273.15);
		feelsLikeTemp -=  273.15;
	}
	
	@Override
	public void toFahrenheit() {
		normalTemp = (normalTemp - 273.15) * 9/5 + 32;
		maximalTemp = (maximalTemp - 273.15) * 9/5 + 32;
		minimalTemp = (minimalTemp - 273.15) * 9/5 + 32;
		maxFeelsLikeTemp = round((feelsLikeTemp - 273.15) * 9/5 + 32);
		minFeelsLikeTemp = round((feelsLikeTemp - 273.15) * 9/5 + 32);
		feelsLikeTemp = (feelsLikeTemp - 273.15) * 9/5 + 32;
		varFeelsLikeTemp = round(varFeelsLikeTemp * 5.0/9.0);
		varNormalTemp = round(varNormalTemp * 5.0/9.0);
	}
	
	@Override
	public String toString() {
		return "AverageData:" + super.toString() + "\nVarNormalTemp : " + varNormalTemp + "\nMaxFeelsLikeTemp : " + maxFeelsLikeTemp + "\nMinFeelsLikeTemp : "
				+ minFeelsLikeTemp + "\nVarFeelsLikeTemp : " + varFeelsLikeTemp + "\n";
	}
	
	
}
