package bean;

import java.util.Date;

public class FlightCost {
	private int costId;
	private int planeId;
	private Date validFrom;
	private Date validTo;
	private float cost;
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
	}
	public int getPlaneId() {
		return planeId;
	}
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
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
	@Override
	public String toString() {
		return "FlightCost [costId=" + costId + ", planeId=" + planeId
				+ ", validFrom=" + validFrom + ", validTo=" + validTo
				+ ", cost=" + cost + "]";
	}
	public FlightCost(int costId, int planeId, Date validFrom, Date validTo,
			float cost) {
		super();
		this.costId = costId;
		this.planeId = planeId;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.cost = cost;
	}
	public FlightCost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
