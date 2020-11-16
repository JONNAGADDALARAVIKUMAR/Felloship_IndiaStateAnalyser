package IndiaStateAnalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensusWrongHeader {
	@CsvBindByName(column = "Steat", required = true)
	private String state;
	
	@CsvBindByName(column = "Pople", required = true)
	private String population;
	
	@CsvBindByName(column = "AreaInSqKm", required = true)
	private String areaInSqKm;
	
	@CsvBindByName(column = "DensityPerSqFeet", required = true)
	private String densityPerSqKm;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getAreaInSqKm() {
		return areaInSqKm;
	}
	public void setAreaInSqKm(String areaInSqKm) {
		this.areaInSqKm = areaInSqKm;
	}
	public String getDensityPerSqKm() {
		return densityPerSqKm;
	}
	public void setDensityPerSqKm(String densityPerSqKm) {
		this.densityPerSqKm = densityPerSqKm;
	}
	
	@Override
	public String toString() {
		return "state Name = " + state + 
				", population = " + population +
				", areaInSqKm = " + areaInSqKm +
				", densityPerSqKm = " + densityPerSqKm;
	}
}
