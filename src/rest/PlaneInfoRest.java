package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import service.PlaneInfoService;
import bean.PlaneInfo;

@Path("plane")
public class PlaneInfoRest {
	
	PlaneInfoService pis = new PlaneInfoService();

	@POST
	@Path("store")
	@Consumes(MediaType.APPLICATION_JSON)
	public String storePlaneInfoRest(PlaneInfo plane){
		
		String result = "";
		
		try {
			result = pis.storePlaneInfoService(plane);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@DELETE
	@Path("delete")
	public String deletePlaneInfoRest(@QueryParam("planeId") int planeId){
		String result = "";
		
		try {
			result = pis.deletePlaneInfoService(planeId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePlaneInfoRest(PlaneInfo plane){
		String result = "";
		
		try {
			result = pis.updatePlaneInfoViaIdService(plane);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@GET
	@Path("retrieveAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<PlaneInfo> retrieveAllPlanes(){
		List<PlaneInfo> planes = new ArrayList<PlaneInfo>();
		
		try {
			planes = pis.retrievePlaneInfoService();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return planes;
	}
	
	@GET
	@Path("retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public PlaneInfo retrievePlane(@QueryParam("planeId") int planeId){
		PlaneInfo plane = new PlaneInfo();
		
		try {
			plane = pis.retrievePlaneService(planeId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return plane;
	}
}
