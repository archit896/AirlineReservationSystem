package service;

import java.util.List;

import bean.PlaneInfo;
import dao.PlaneInfoDao;

public class PlaneInfoService {
	
	PlaneInfoDao pid = new PlaneInfoDao();
	
	public String storePlaneInfoService(PlaneInfo plane) throws Exception{
		int result = pid.storePlaneInfo(plane);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public String deletePlaneInfoService(int planeId) throws Exception{
		int result = pid.deletePlaneInfo(planeId);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public String updatePlaneInfoViaIdService(PlaneInfo plane) throws Exception{
		int result = pid.updatePlaneInfoViaId(plane);
		
		if(result > 0){
			return "Success";
		}else{
			return "Error";
		}
	}
	
	public List<PlaneInfo> retrievePlaneInfoService() throws Exception{
		List<PlaneInfo> planes = pid.retrievePlaneInfo();
		
		if(planes.size() == 0){
			System.out.println("Error");
			return planes;
		}else{
			return planes;
		}
	}
}
