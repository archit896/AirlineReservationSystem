package bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transactions {
	private int transactionId;
	private int reservationId;
	private String status;
	private float cost;
	private Date transactionDate;
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId
				+ ", reservationId=" + reservationId + ", status=" + status
				+ ", cost=" + cost + ", transactionDate=" + transactionDate
				+ "]";
	}
	public Transactions(int transactionId, int reservationId, String status,
			float cost, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.reservationId = reservationId;
		this.status = status;
		this.cost = cost;
		this.transactionDate = transactionDate;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
