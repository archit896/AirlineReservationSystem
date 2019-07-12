package bean;

import java.util.Date;


public class FlightSchedule {
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
		return "FlightSchedule [flightId=" + flightId + ", planeId=" + planeId
				+ ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", costId=" + costId + ", delayMinutes="
				+ delayMinutes + ", origin=" + origin + ", destination="
				+ destination + ", flightStatus=" + flightStatus
				+ ", seatsAvailable=" + seatsAvailable + "]";
	}
	public FlightSchedule(int flightId, int planeId, Date departureTime,
			Date arrivalTime, int costId, int delayMinutes, int origin,
			int destination, String flightStatus, int seatsAvailable) {
		super();
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
	public FlightSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
