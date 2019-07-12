package bean;

import java.util.Date;

public class BookedTicketHistory {
	private int reservationId;
	private int userId;
	private int seatNo;
	private Date dateOfBooking;
	private float cost;
	private int flightId;
	private String ticketStatus;
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	@Override
	public String toString() {
		return "BookedTicketHistory [reservationId=" + reservationId
				+ ", userId=" + userId + ", seatNo=" + seatNo
				+ ", dateOfBooking=" + dateOfBooking + ", cost=" + cost
				+ ", flightId=" + flightId + ", ticketStatus=" + ticketStatus
				+ "]";
	}
	public BookedTicketHistory(int reservationId, int userId, int seatNo,
			Date dateOfBooking, float cost, int flightId, String ticketStatus) {
		super();
		this.reservationId = reservationId;
		this.userId = userId;
		this.seatNo = seatNo;
		this.dateOfBooking = dateOfBooking;
		this.cost = cost;
		this.flightId = flightId;
		this.ticketStatus = ticketStatus;
	}
	public BookedTicketHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
