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

import service.AirportsService;
import bean.Airports;

@Path("airports")
public class AirportsRest {

	@POST
	@Path("store")
	@Consumes(MediaType.APPLICATION_JSON)
	public String storeAirportsInfoRest(Airports airport){
		String result = "";
		
		try {
			AirportsService as = new AirportsService();
			result = as.storeAirportsInfoService(airport);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@DELETE
	@Path("delete")
	public String deleteAirportsInfoRest(@QueryParam("airportId") int airportId){
		String result = "";
		
		try {
			AirportsService as = new AirportsService();
			result = as.deleteAirportsInfoService(airportId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAirportsInfoRest(Airports airport){
		String result = "";
		
		try {
			AirportsService as = new AirportsService();
			result = as.updateAirportsInfoViaIdService(airport);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@GET
	@Path("retrieveAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Airports> retrieveAllAirports(){
		List<Airports> airports = new ArrayList<Airports>();
		
		try {
			AirportsService as = new AirportsService();
			airports = as.retrieveAirportsInfoService();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return airports;
	}
	
	@GET
	@Path("retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public Airports retrieveAirport(@QueryParam("airportId") int airportId){
		Airports airport = new Airports();
		
		try {
			AirportsService as = new AirportsService();
			
			airport = as.retrieveAirport(airportId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return airport;
	}
	
}
