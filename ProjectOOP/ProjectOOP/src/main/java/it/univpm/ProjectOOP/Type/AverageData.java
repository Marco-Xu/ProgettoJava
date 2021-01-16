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
	protected Vector<MyData> allData = new Vector<MyData>();

	public AverageData() {
	}

	public AverageData(String city, double normalTemp, double maximalTemp, double minimalTemp, double feelsLikeTemp, int n) {
		super(city, normalTemp, maximalTemp, minimalTemp, feelsLikeTemp);
		this.n = n;
	}

	public void addData(MyData data) {
		this.allData.add(data);
		n++;
	}
	
	@JsonIgnore
	public double getSumNormalTemp() {
		double sum = 0;
		for(MyData a : allData)
			sum += a.getNormalTemp();
		return sum;
	}

	public double getMaximalTemp() {
		return maximalTemp;
	}
	
	public double getMinimalTemp() {
		return minimalTemp;
	}
	@JsonIgnore
	public double getSumFeelsLikeTemp() {
		double sum = 0;
		for(MyData a : allData)
			sum += a.getFeelsLikeTemp();
		return sum;
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
	
	public void calc() {
		this.normalTemp = getSumNormalTemp() / n;
		this.feelsLikeTemp = getSumFeelsLikeTemp() / n;
		
		this.varNormalTemp = round(getVarN());
		this.varFeelsLikeTemp = round(getVarF());
		
		this.minimalTemp = getNormalTemp();
		for(MyData a : allData) {
			if(this.maximalTemp < a.getMaximalTemp())
				this.maximalTemp = a.getMaximalTemp();
			if(this.minimalTemp > a.getMinimalTemp())
				this.minimalTemp = a.getMinimalTemp();
		}
			
		this.minFeelsLikeTemp = this.feelsLikeTemp;
		for(MyData a : allData) {
			if(this.maxFeelsLikeTemp < a.getFeelsLikeTemp())
				this.maxFeelsLikeTemp = a.getFeelsLikeTemp();
			if(this.minFeelsLikeTemp > a.getFeelsLikeTemp())
				this.minFeelsLikeTemp = a.getFeelsLikeTemp();
		}
		
		roundNum();
	}
	
	private double getVar(Vector<Double> all, double average) {
		double temp = 0;
		for(double a : all) 
			temp += ((a - average) * (a - average));
		return temp/n;
	}
	
	private double getVarF() {
		Vector<Double> allFeelsLikeTemp = new Vector<Double>();
		for(MyData a : allData)
			allFeelsLikeTemp.add(a.getFeelsLikeTemp());
		return getVar(allFeelsLikeTemp, this.feelsLikeTemp);
	}
	
	private double getVarN() {
		Vector<Double> allNormalTemp = new Vector<Double>();
		for(MyData a : allData)
			allNormalTemp.add(a.getNormalTemp());
		return getVar(allNormalTemp, this.normalTemp);
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
