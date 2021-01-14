package it.univpm.ProjectOOP.Data;

import java.io.Serializable;

public abstract class AbData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String city;
	protected double normalTemp;
	protected double maximalTemp;
	protected double minimalTemp;
	protected double feelsLikeTemp;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public void toCelsius() {
		normalTemp -= 273.15;
		maximalTemp -= 273.15;
		minimalTemp -= 273.15;
		feelsLikeTemp -=  273.15;
	}
	
	public void toFahrenheit() {
		normalTemp = (normalTemp - 273.15) * 9/5 + 32;
		maximalTemp = (maximalTemp - 273.15) * 9/5 + 32;
		minimalTemp = (minimalTemp - 273.15) * 9/5 + 32;
		feelsLikeTemp = (feelsLikeTemp - 273.15) * 9/5 + 32;
	}
	
	public void roundNum() {
		normalTemp = Math.round(normalTemp * 10.0) / 10.0;
		maximalTemp = Math.round(maximalTemp * 10.0) / 10.0;
		minimalTemp = Math.round(minimalTemp * 10.0) / 10.0;
		feelsLikeTemp = Math.round(feelsLikeTemp * 10.0) / 10.0;
	}
	
	public boolean changeTemp(String type) {
		switch(type) {
			case "Celsius":
			case "celsius":
			case "C":
			case "c":
				toCelsius();
				roundNum();
				break;
				
			case "Fahrenheit":
			case "fahrenheit":
			case "F":
			case "f":
				toFahrenheit();
				roundNum();
				break;
			
			case "Kelvin":
			case "kelvin":
			case "K":
			case "k":
				break;
			
			default:
				return false;
		}
		return true;
	}

	public String toString() {
		return "\ncity : " + city + "\nnormalTemp : " + normalTemp + "\nmaximalTemp : " + maximalTemp + "\nminimalTemp : "
				+ minimalTemp + "\nfeelsLikeTemp : " + feelsLikeTemp + "\n";
	}
	
	
}
