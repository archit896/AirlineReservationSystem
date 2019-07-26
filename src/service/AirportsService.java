package service;

import java.util.List;

import bean.Airports;
import dao.AirportsDao;

public class AirportsService {
	
	AirportsDao airport = new AirportsDao();
	
	public String storeAirportsInfoService(Airports airport) throws Exception{
		
		int result = this.airport.storeAirportsInfo(airport);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public String deleteAirportsInfoService(int airportId) throws Exception{
		
		int result = this.airport.deleteAirportsInfo(airportId);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public String updateAirportsInfoViaIdService(Airports airport) throws Exception{
		
		int result = this.airport.updateAirportsInfoViaId(airport);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public List<Airports> retrieveAirportsInfoService() throws Exception{
		
		List<Airports> airports = airport.retrieveAirportsInfo();
		
		if(airports.size() == 0){
			System.out.println("Error");
			return airports;
		}else{
			return airports;
		}
	}
	
	public Airports retrieveAirport(int airportId) throws Exception{
		Airports airport1 = airport.selectAirport(airportId);
		return airport1;
	}
}