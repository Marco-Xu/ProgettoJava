package it.univpm.ProjectOOP.Type;

/**Rappresenta la classe contenente il periodo di inizio e fine del filtraggio.
 * 
 * @author Marco Xu
 * @author Davide Balducci
 */
public class PeriodFilter {
	private int start, end;

	public PeriodFilter() {
	}
	
	public PeriodFilter(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
