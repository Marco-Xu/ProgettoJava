package it.univpm.ProjectOOP.Type;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AverageData extends MainData implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	protected int n;
	protected Double VarNormalTemp;
	protected Double VarMaximalTemp;
	protected Double VarMinimalTemp;
	protected Double VarFeelsLikeTemp;
	
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
		this.maximalTemp += maximalTemp;
		allMaximalTemp.add(maximalTemp);
	}
	
	public void addMinimalTemp(double minimalTemp) {
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

	public Double getVarMaximalTemp() {
		return VarMaximalTemp;
	}

	public Double getVarMinimalTemp() {
		return VarMinimalTemp;
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
		this.maximalTemp = getMaximalTemp() / n;
		this.minimalTemp = getMinimalTemp() / n;
		this.feelsLikeTemp = getFeelsLikeTemp() / n;
		
		this.VarNormalTemp = round(getVar(allNormalTemp, normalTemp));
		this.VarMaximalTemp = round(getVar(allMaximalTemp, maximalTemp));
		this.VarMinimalTemp = round(getVar(allMinimalTemp, minimalTemp));
		this.VarFeelsLikeTemp = round(getVar(allFeelsLikeTemp, feelsLikeTemp));
	}
	
	private Double getVar(Vector<Double> all, double average) {
		double temp = 0;
		for(double a : all) 
			temp += ((a - average) * (a - average));
		return temp/n;
	}

	@Override
	public String toString() {
		return "AverageData:" + super.toString() + "\nVarNormalTemp : " + VarNormalTemp + "\nVarMaximalTemp : " + VarMaximalTemp + "\nVarMinimalTemp : "
				+ VarMinimalTemp + "\nVarFeelsLikeTemp : " + VarFeelsLikeTemp + "\n";
	}
	
	
}
