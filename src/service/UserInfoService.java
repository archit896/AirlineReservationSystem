package service;

import java.util.List;

import bean.Universal;
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
	
	public  String updatePasswordViaEmailService(UserInfo u) throws Exception{
		int result=ui.updatePasswordViaEmail(u);
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
	
	public List<Universal> viewUsersAllService(int userId) throws Exception{
		System.out.println("In Service alyer");
		List<Universal> listOfRec= ui.viewUsersAll(userId);
		
		 if(listOfRec.size() == 0){
		    	System.out.println("Error");
		        return listOfRec;
		    }else{
		        return listOfRec;
		    }
	}
	
	public List<Universal> viewTicketAllService(int userId) throws Exception{
		System.out.println("In Service alyer");
		List<Universal> listOfRec= ui.viewTicketAll(userId);
		
		 if(listOfRec.size() == 0){
		    	System.out.println("Error");
		        return listOfRec;
		    }else{
		        return listOfRec;
		    }
	}
	
	public UserInfo loginService(UserInfo user) throws Exception{
		UserInfo user1 = ui.login(user);
		return user1;
	}
	
	public UserInfo selectUserService(int userId) throws Exception{
		UserInfo user = ui.selectUser(userId);
		return user;
	}
	
	public String getSecurityQuesService(String email) throws Exception{
		return ui.getSecurityQues(email);
	}
	
	public String getSecurityAnsService(String email) throws Exception{
		return ui.getSecurityAns(email);
	}
}
