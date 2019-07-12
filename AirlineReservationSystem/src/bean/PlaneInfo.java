package bean;

public class PlaneInfo {
	private int planeId;
	private String planeType;
	private String planeVendor;
	public int getPlaneId() {
		return planeId;
	}
	public void setPlaneId(int planeId) {
		this.planeId = planeId;
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
	@Override
	public String toString() {
		return "PlaneInfo [planeId=" + planeId + ", planeType=" + planeType
				+ ", planeVendor=" + planeVendor + "]";
	}
	public PlaneInfo(int planeId, String planeType, String planeVendor) {
		super();
		this.planeId = planeId;
		this.planeType = planeType;
		this.planeVendor = planeVendor;
	}
	public PlaneInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
