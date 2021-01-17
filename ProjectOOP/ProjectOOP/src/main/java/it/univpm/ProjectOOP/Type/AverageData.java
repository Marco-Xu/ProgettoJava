package it.univpm.ProjectOOP.Type;

import java.io.Serializable;
import java.util.Vector;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**Sottoclasse di MainData, contiene tutti i dati relativi alle richieste sulle statistiche.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class AverageData extends MainData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected double maxFeelsLikeTemp;
	protected double minFeelsLikeTemp;
	protected double varNormalTemp;
	protected double varFeelsLikeTemp;
	protected int n;
	protected Vector<MyData> allData = new Vector<MyData>();

	public AverageData() {
	}

	public AverageData(String city, double normalTemp, double maximalTemp, double minimalTemp, double feelsLikeTemp, int n) {
		super(city, normalTemp, maximalTemp, minimalTemp, feelsLikeTemp);
		this.n = n;
	}

	/**
	 * Metodo per popolare un vettore di oggetti MyData e incrementare un contatore.
	 * @param data è un oggetto di MyData
	 */
	public void addData(MyData data) {
		this.allData.add(data);
		n++;
	}
	
	/**
	 * Metodo che calcola la somma di tutte le normalTemp.
	 * @return somma delle temperature medie reali
	 */
	@JsonIgnore
	public double getSumNormalTemp() {
		double sum = 0;
		for(MyData a : allData)
			sum += a.getNormalTemp();
		return sum;
	}

	/**
	 * Metodo che calcola la somma di tutte le feelsLikeTemp.
	 * @return somma delle temperature medie percepite.
	 */
	@JsonIgnore
	public double getSumFeelsLikeTemp() {
		double sum = 0;
		for(MyData a : allData)
			sum += a.getFeelsLikeTemp();
		return sum;
	}
	
	public double getMaxFeelsLikeTemp() {
		return maxFeelsLikeTemp;
	}

	public double getMinFeelsLikeTemp() {
		return minFeelsLikeTemp;
	}
	
	public Double getVarNormalTemp() {
		return varNormalTemp;
	}

	public Double getVarFeelsLikeTemp() {
		return varFeelsLikeTemp;
	}

	public int getN() {
		return n;
	}
	
	/**
	 * Metodo che calcola le statistiche (media di temperatura nornale e percepita) in base ai dati caricati nel vettore allData.
	 * Viene calcolata anche la varianza, temperatura massima e minima dei valori reali e percepiti.
	 */
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
	
	/**
	 * Metodo per il calcolo della varianza generale.
	 * @param all vettore di oggetti Double, valori di temperatura
	 * @param average media della temperatura
	 * @return varianza
	 */
	@JsonIgnore
	private double getVar(Vector<Double> all, double average) {
		double temp = 0;
		for(double a : all) 
			temp += ((a - average) * (a - average));
		return temp/n;
	}
	
	/**
	 * Metodo per il calcolo della varianza delle temperature percepite.
	 * @return varianza feelsLikeTemp
	 */
	@JsonIgnore
	private double getVarF() {
		Vector<Double> allFeelsLikeTemp = new Vector<Double>();
		for(MyData a : allData)
			allFeelsLikeTemp.add(a.getFeelsLikeTemp());
		return getVar(allFeelsLikeTemp, this.feelsLikeTemp);
	}
	
	/**
	 * Metodo per il calcolo della varianza delle temperature reali.
	 * @return varianza normalTemp
	 */
	@JsonIgnore
	private double getVarN() {
		Vector<Double> allNormalTemp = new Vector<Double>();
		for(MyData a : allData)
			allNormalTemp.add(a.getNormalTemp());
		return getVar(allNormalTemp, this.normalTemp);
	}

	/**
	 * Metodo che modifica l'unità di misura in gradi Celsius.
	 */
	@Override
	public void toCelsius() {
		normalTemp -= 273.15;
		maximalTemp -= 273.15;
		minimalTemp -= 273.15;
		maxFeelsLikeTemp = round(maxFeelsLikeTemp -  273.15);
		minFeelsLikeTemp = round(minFeelsLikeTemp -  273.15);
		feelsLikeTemp -=  273.15;
	}
	
	/**
	 * Metodo che modifica l'unità di misura in gradi Fahrenheit.
	 */
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
