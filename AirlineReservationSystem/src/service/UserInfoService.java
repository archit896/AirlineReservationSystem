package service;

import java.util.List;


import bean.UserInfo;
import dao.UserInfoDao;

public class UserInfoService {
	UserInfoDao ui= new UserInfoDao();
	
	public String storeUserInfoService(UserInfo u) throws Exception {
		int result=ui.storeUserInfo(u);
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
				
	}
	
	public  String updateUserInfoViaIdService(UserInfo u) throws Exception{
		int result=ui.updateUserInfoViaId(u);
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
	}
	
	public  String deleteUserInfoService(int userId) throws Exception{
		int result=ui.deleteUserInfo(userId);
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
	}
	
	public List<UserInfo> retrieveUserInfoService() throws Exception{
	
	    List<UserInfo> listOfRec = ui.retrieveUserInfo();
	
	    if(listOfRec.size() == 0){
	    	System.out.println("Error");
	        return listOfRec;
	    }else{
	        return listOfRec;
	    }
	}
}
