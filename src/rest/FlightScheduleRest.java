package rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;







import service.FlightScheduleService;
import bean.FlightSchedule;
import bean.Flights;

@Path("flightSchedule")
public class FlightScheduleRest {
	FlightScheduleService pi=new FlightScheduleService();
	//FlightCostService pi=new FlightCostService();
	
	List<FlightSchedule> listOfFlightSchedule=null;
	String s=null;
	
	@GET
	@Path("retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightSchedule> retriveFlightScheduleRest()
	{
        try {
            listOfFlightSchedule= pi.retrieveFlightScheduleInfoService();
     } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
     }
     return listOfFlightSchedule;
}
	@GET
	@Path("retrieveId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FlightSchedule> retriveFlightScheduleRest(@QueryParam("flightId") int flightId)
	{
        try {
            listOfFlightSchedule= pi.retrieveFlightScheduleInfoService(flightId);
     } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
     }
     return listOfFlightSchedule;
}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("insert/{dept}/{arriv}")
public String storeFlightScheduleInfoRest(FlightSchedule p, @PathParam("dept") String dept,@PathParam("arriv") String arriv){
	
	try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss");

        Date departure = sdf.parse(dept);
        Date arrival=sdf.parse(arriv);
        p.setDepartureTime(departure);
        p.setArrivalTime(arrival);
        
		
	    s=pi.storeFlightScheduleInfoService(p);
	} catch (Exception e) {
		 System.out.println(e);
		// TODO: handle exception
	}
	return s;
}
	
	@DELETE
	@Path("delete")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)

	public String deleteFlightScheduleInfoRest(@QueryParam("flightId") int costId){
		
		try {
			s=pi.deleteFlightScheduleInfoService(costId);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return s;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFlightScheduleInfoRest(FlightSchedule p){
		try {
			s=pi.updateFlightScheduleInfoViaIdService(p);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return s;
	}
	
	@GET
	@Path("search/{origin}/{destination}/{date}/{seats}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flights> searchFlights(@PathParam("origin") String origin, @PathParam("destination") String destination, @PathParam("date") String date, @PathParam("seats") int seats){
		List<Flights> flights = new ArrayList<Flights>();

		try {
			//System.out.println(origin+"\n"+destination+"\n"+date+"\n"+seats+"\n");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			Date d = sdf.parse(date);
			System.out.println(d);
			flights = pi.searchFlightService(origin, destination, d, seats);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flights;
	}
	
	@GET
	@Path("searchById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flights> searchFlightsById(@PathParam("id") int id){
		List<Flights> flights = new ArrayList<Flights>();

		try {
			flights = pi.searchFlightByIdService(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flights;
	}
}
