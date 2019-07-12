package bean;

public class Airports {
	private int airportId;
	private String airportName;
	private String location;
	public int getAirportId() {
		return airportId;
	}
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Airports [airportId=" + airportId + ", airportName="
				+ airportName + ", location=" + location + "]";
	}
	public Airports(int airportId, String airportName, String location) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.location = location;
	}
	public Airports() {
		super();
		// TODO Auto-generated constructor stub
	}
}
