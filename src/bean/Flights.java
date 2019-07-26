package bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Flights {
	private String airportNameOrigin;
	private String locationOrigin;
	private String airportNameDestination;
	private String locationDestination;
	private String planeType;
	private String planeVendor;
	private Date validFrom;
	private Date validTo;
	private float cost;
	private int flightId;
	private int planeId;
	private Date departureTime;
	private Date arrivalTime;
	private int costId;
	private int delayMinutes;
	private int origin;
	private int destination;
	private String flightStatus;
	private int seatsAvailable;
	public String getAirportNameOrigin() {
		return airportNameOrigin;
	}
	public void setAirportNameOrigin(String airportNameOrigin) {
		this.airportNameOrigin = airportNameOrigin;
	}
	public String getLocationOrigin() {
		return locationOrigin;
	}
	public void setLocationOrigin(String locationOrigin) {
		this.locationOrigin = locationOrigin;
	}
	public String getAirportNameDestination() {
		return airportNameDestination;
	}
	public void setAirportNameDestination(String airportNameDestination) {
		this.airportNameDestination = airportNameDestination;
	}
	public String getLocationDestination() {
		return locationDestination;
	}
	public void setLocationDestination(String locationDestination) {
		this.locationDestination = locationDestination;
	}
	public String getPlaneType() {
		return planeType;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public String getPlaneVendor() {
		return planeVendor;
	}
	public void setPlaneVendor(String planeVendor) {
		this.planeVendor = planeVendor;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getPlaneId() {
		return planeId;
	}
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	public int getDelayMinutes() {
		return delayMinutes;
	}
	public void setDelayMinutes(int delayMinutes) {
		this.delayMinutes = delayMinutes;
	}
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public String getFlightStatus() {
		return flightStatus;
	}
	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
	@Override
	public String toString() {
		return "Flights [airportNameOrigin=" + airportNameOrigin
				+ ", locationOrigin=" + locationOrigin
				+ ", airportNameDestination=" + airportNameDestination
				+ ", locationDestination=" + locationDestination
				+ ", planeType=" + planeType + ", planeVendor=" + planeVendor
				+ ", validFrom=" + validFrom + ", validTo=" + validTo
				+ ", cost=" + cost + ", flightId=" + flightId + ", planeId="
				+ planeId + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", costId=" + costId
				+ ", delayMinutes=" + delayMinutes + ", origin=" + origin
				+ ", destination=" + destination + ", flightStatus="
				+ flightStatus + ", seatsAvailable=" + seatsAvailable + "]";
	}
	public Flights(String airportNameOrigin, String locationOrigin,
			String airportNameDestination, String locationDestination,
			String planeType, String planeVendor, Date validFrom, Date validTo,
			float cost, int flightId, int planeId, Date departureTime,
			Date arrivalTime, int costId, int delayMinutes, int origin,
			int destination, String flightStatus, int seatsAvailable) {
		super();
		this.airportNameOrigin = airportNameOrigin;
		this.locationOrigin = locationOrigin;
		this.airportNameDestination = airportNameDestination;
		this.locationDestination = locationDestination;
		this.planeType = planeType;
		this.planeVendor = planeVendor;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.cost = cost;
		this.flightId = flightId;
		this.planeId = planeId;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.costId = costId;
		this.delayMinutes = delayMinutes;
		this.origin = origin;
		this.destination = destination;
		this.flightStatus = flightStatus;
		this.seatsAvailable = seatsAvailable;
	}
	public Flights() {
		super();
		// TODO Auto-generated constructor stub
	}
}
