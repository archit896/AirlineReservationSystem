package bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Universal {
 private int transactionId;
 private int reservationId;
 private String status;
 private float transactionCost;
 private Date transactionDate;
 private int userId;
 private int seatNo;
 private Date dateOfBooking;
 private float bookedTicketHistoryCost;
 
 private String ticketStatus;
 private String name;
	private int age;
	private String gender;
	
	private String userName;
	private String email;
	private int phone;
	private String password;
	private String type;
	private int userAge;
	private String userGender;
	private String secQues;
	private String secAns;
	
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
	
	public Universal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Universal(int transactionId, int reservationId, String status,
			float transactionCost, Date transactionDate, int userId,
			int seatNo, Date dateOfBooking, float bookedTicketHistoryCost,
			String ticketStatus, String name, int age, String gender,
			String userName, String email, int phone, String password,
			String type, int userAge, String userGender, String secQues,
			String secAns, String airportNameOrigin, String locationOrigin,
			String airportNameDestination, String locationDestination,
			String planeType, String planeVendor, Date validFrom, Date validTo,
			float cost, int flightId, int planeId, Date departureTime,
			Date arrivalTime, int costId, int delayMinutes, int origin,
			int destination, String flightStatus, int seatsAvailable) {
		super();
		this.transactionId = transactionId;
		this.reservationId = reservationId;
		this.status = status;
		this.transactionCost = transactionCost;
		this.transactionDate = transactionDate;
		this.userId = userId;
		this.seatNo = seatNo;
		this.dateOfBooking = dateOfBooking;
		this.bookedTicketHistoryCost = bookedTicketHistoryCost;
		this.ticketStatus = ticketStatus;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.type = type;
		this.userAge = userAge;
		this.userGender = userGender;
		this.secQues = secQues;
		this.secAns = secAns;
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
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getTransactionCost() {
		return transactionCost;
	}
	public void setTransactionCost(float transactionCost) {
		this.transactionCost = transactionCost;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
	public float getBookedTicketHistoryCost() {
		return bookedTicketHistoryCost;
	}
	public void setBookedTicketHistoryCost(float bookedTicketHistoryCost) {
		this.bookedTicketHistoryCost = bookedTicketHistoryCost;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getSecQues() {
		return secQues;
	}
	public void setSecQues(String secQues) {
		this.secQues = secQues;
	}
	public String getSecAns() {
		return secAns;
	}
	public void setSecAns(String secAns) {
		this.secAns = secAns;
	}
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
	
	
	
	
	
	
	
}
