package it.univpm.ProjectOOP.Type;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AverageData extends AbData implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	protected Double VarNormalTemp;
	protected Double VarMaximalTemp;
	protected Double VarMinimalTemp;
	protected Double VarFeelsLikeTemp;
	
	@JsonIgnore
	protected int n;
	protected Vector<Double> allNormalTemp = new Vector<Double>();
	@JsonIgnore
	protected Vector<Double> allMaximalTemp = new Vector<Double>();
	@JsonIgnore
	protected Vector<Double> allMinimalTemp = new Vector<Double>();
	@JsonIgnore
	protected Vector<Double> allFeelsLikeTemp = new Vector<Double>();
	
	
	
	

	
	public Vector<Double> getAllNormalTemp() {
		return allNormalTemp;
	}

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
	
	public int increaseN() {
		return n++;
	}
	
	public void calc() {
		this.normalTemp = getNormalTemp() / n;
		this.maximalTemp = getMaximalTemp() / n;
		this.minimalTemp = getMinimalTemp() / n;
		this.feelsLikeTemp = getFeelsLikeTemp() / n;
		
		this.VarNormalTemp = getVar(allNormalTemp, normalTemp);
		this.VarMaximalTemp = getVar(allMaximalTemp, maximalTemp);
		this.VarMinimalTemp = getVar(allMinimalTemp, minimalTemp);
		this.VarFeelsLikeTemp = getVar(allFeelsLikeTemp, feelsLikeTemp);
	}
	
	private Double getVar(Vector<Double> all, double average) {
		double temp = 0;
		for(Double a : all) 
			temp += ((a - average) * (a - average));
		return temp/n;
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

	@Override
	public String toString() {
		return "AverageData:" + super.toString();
	}
}
