package service;

import java.util.List;

import bean.FlightCost;
import dao.FlightCostDao;

public class FlightCostService {
	
	FlightCostDao cost = new FlightCostDao();
	
	public String storeFlightCostInfoService(FlightCost cost) throws Exception{
		
		int result = this.cost.storeFlightCostInfo(cost);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}	
	}
	
	public String deleteFlightCostInfoService(int costId) throws Exception{
		
		int result = this.cost.deleteFlightCostInfo(costId);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}	
	}
	
	public String updateFlightCostInfoViaIdService(FlightCost cost) throws Exception{
		
		int result = this.cost.updateFlightCostInfoViaId(cost);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public List<FlightCost> retrieveFlightCostInfoService() throws Exception{
		
		List<FlightCost> costs = this.cost.retrieveFlightCostInfo();

		if(costs.size() == 0){
			System.out.println("Error");
			return costs;
		}else{
			return costs;
		}
	}
	
	public FlightCost retrieveCost(int costId) throws Exception{
		FlightCost cost1 = cost.selectCost(costId);
		return cost1;
	} 
}
