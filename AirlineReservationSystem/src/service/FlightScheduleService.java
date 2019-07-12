package service;

import java.util.List;

import bean.FlightSchedule;
import dao.FlightScheduleDao;

public class FlightScheduleService {
	FlightScheduleDao flight = new FlightScheduleDao();
	
	public String storeFlightScheduleInfoService(FlightSchedule flight) throws Exception{
		int result = this.flight.storeFlightScheduleInfo(flight);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public String deleteFlightScheduleInfoService(int flightId) throws Exception{
		int result = this.flight.deleteFlightScheduleInfo(flightId);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public String updateFlightScheduleInfoViaIdService(FlightSchedule flight) throws Exception{
		int result = this.flight.updateFlightScheduleInfoViaId(flight);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public List<FlightSchedule> retrieveFlightScheduleInfoService() throws Exception{
		List<FlightSchedule> flights= this.flight.retrieveFlightScheduleInfo();
		
		if(flights.size() == 0){
			System.out.println("Error");
			return flights;
		}else{
			return flights;
		}
	}
}
