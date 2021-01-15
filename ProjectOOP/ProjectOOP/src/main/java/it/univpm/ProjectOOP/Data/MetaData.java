package it.univpm.ProjectOOP.Data;

import java.util.Vector;

import it.univpm.ProjectOOP.Type.InfData;

public class MetaData {
	private Vector<InfData> metadata = new Vector<InfData>();
	
	public Vector<InfData> getMetadata(){
		metadata.add(new InfData("city", "Nome della città", "String"));
		metadata.add(new InfData("description", "Informazioni riguardanti il meteo", "String"));
		metadata.add(new InfData("normalTemp", "Temperatura media", "Double"));
		metadata.add(new InfData("maximalTemp", "Temperatura massima", "Double"));
		metadata.add(new InfData("minimalTemp", "Temperatura minima", "Double"));
		metadata.add(new InfData("feelsLikeTemp", "Temperatura percepita", "Double"));
		metadata.add(new InfData("date", "Data in formato unix", "Int"));
		metadata.add(new InfData("VarNormalTemp", "Varianza temperatura media", "Double"));
		metadata.add(new InfData("VarMaximalTemp", "Varianza temperatura massima", "Double"));
		metadata.add(new InfData("VarMinimalTemp", "Varianza temperatura minima", "Double"));
		metadata.add(new InfData("VarFeelsLikeTemp", "Varianza temperatura percepita", "Double"));
		metadata.add(new InfData("n", "Numero elementi nello storico", "Int"));
		
		return metadata;
	}
}
