package it.univpm.ProjectOOP.Type;

/**Classe che permette di rappresentare le informazioni riguardanti un parametro delle classi MyData e AveragData.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class InfData {
	protected String name;
	protected String description;
	protected String type;
	
	public InfData(String name, String description, String type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "InfData:" + "\nname : " + name + "\ndescription : " + description + "\ntype : " + type + "\n";
	}
	
}
