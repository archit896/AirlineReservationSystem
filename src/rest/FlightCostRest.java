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

import bean.FlightCost;
import service.FlightCostService;

@Path("cost")
public class FlightCostRest {

	FlightCostService fcs = new FlightCostService();
	
	@POST
	@Path("store")
	@Consumes(MediaType.APPLICATION_JSON)
	public String storeFlightCostRest(FlightCost cost){
		String result = "";
		
		try {
			result = fcs.storeFlightCostInfoService(cost);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@DELETE
	@Path("delete")
	public String deleteFlightCostRest(@QueryParam("costId") int costId){
		String result = "";
		
		try {
			result = fcs.deleteFlightCostInfoService(costId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateFlightCostRest(FlightCost cost){
		String result = "";
		
		try {
			result = fcs.updateFlightCostInfoViaIdService(cost);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@GET
	@Path("retrieveAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightCost> retrieveAllCosts(){
		List<FlightCost> costs = new ArrayList<FlightCost>();
		
		try {
			costs = fcs.retrieveFlightCostInfoService();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return costs;
	}
	
	@GET
	@Path("retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public FlightCost retrieveCost(@QueryParam("costId") int costId){
		FlightCost cost = new FlightCost();
		
		try {
			cost = fcs.retrieveCost(costId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cost;
	}
}
