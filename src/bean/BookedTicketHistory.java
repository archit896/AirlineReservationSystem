package bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookedTicketHistory {
	private int reservationId;
	private int userId;
	private int seatNo;
	private Date dateOfBooking;
	private float cost;
	private int flightId;
	private String ticketStatus;
	private String name;
	private int age;
	private String gender;
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
	public void setCost(float cost) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "BookedTicketHistory [reservationId=" + reservationId
				+ ", userId=" + userId + ", seatNo=" + seatNo
				+ ", dateOfBooking=" + dateOfBooking + ", cost=" + cost
				+ ", flightId=" + flightId + ", ticketStatus=" + ticketStatus
				+ ", name=" + name + ", age=" + age + ", gender=" + gender
				+ "]";
	}
	public BookedTicketHistory(int reservationId, int userId, int seatNo,
			Date dateOfBooking, float cost, int flightId, String ticketStatus,
			String name, int age, String gender) {
		super();
		this.reservationId = reservationId;
		this.userId = userId;
		this.seatNo = seatNo;
		this.dateOfBooking = dateOfBooking;
		this.cost = cost;
		this.flightId = flightId;
		this.ticketStatus = ticketStatus;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public BookedTicketHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
