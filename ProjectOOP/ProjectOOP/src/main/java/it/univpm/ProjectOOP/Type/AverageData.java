package it.univpm.ProjectOOP.Type;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AverageData extends MainData implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	protected int n;
	protected double VarNormalTemp;
	protected double VarFeelsLikeTemp;
	protected double MaxFeelsLikeTemp;
	protected double MinFeelsLikeTemp;
	
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
		if(this.minimalTemp > minimalTemp)
			this.minimalTemp += minimalTemp;
		allMinimalTemp.add(minimalTemp);
	}
	
	public void addFeelsLikeTemp(double feelsLikeTemp) {
		this.feelsLikeTemp += feelsLikeTemp;
		allFeelsLikeTemp.add(feelsLikeTemp);
	}
	
	public Double getVarNormalTemp() {
		return VarNormalTemp;
	}
	
	public double getMaxFeelsLikeTemp() {
		return MaxFeelsLikeTemp;
	}

	public double getMinFeelsLikeTemp() {
		return MinFeelsLikeTemp;
	}

	public Double getVarFeelsLikeTemp() {
		return VarFeelsLikeTemp;
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
		
		this.VarNormalTemp = round(getVar(allNormalTemp, normalTemp));
		this.VarFeelsLikeTemp = round(getVar(allFeelsLikeTemp, feelsLikeTemp));
		
		for(double a : allFeelsLikeTemp) {
			if(MaxFeelsLikeTemp < a)
				MaxFeelsLikeTemp = a;
			if(MinFeelsLikeTemp > a)
				MinFeelsLikeTemp = a;
		}
		
	}
	
	private Double getVar(Vector<Double> all, double average) {
		double temp = 0;
		for(double a : all) 
			temp += ((a - average) * (a - average));
		return temp/n;
	}

	@Override
	public String toString() {
		return "AverageData:" + super.toString() + "\nVarNormalTemp : " + VarNormalTemp + "\nMaxFeelsLikeTemp : " + MaxFeelsLikeTemp + "\nMinFeelsLikeTemp : "
				+ MinFeelsLikeTemp + "\nVarFeelsLikeTemp : " + VarFeelsLikeTemp + "\n";
	}
	
	
}
