package service;

import java.util.List;


import dao.TransactionsDao;
import bean.Transactions;
public class TransactionsService {
	TransactionsDao ui = new TransactionsDao();
	
	public String storeTransactionsInfoService(Transactions p) throws Exception {
		
		int result = ui.storeTransactionsInfo(p);
		
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
				
	}

	public String updateTransactionsInfoServiceViaId(Transactions p) throws Exception{
		int result = ui.updateTransactionsInfoViaId(p);
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
	}

	public String deleteTransactionsInfoService(int transactionId) throws Exception{
		int result = ui.deleteTransactionsInfo(transactionId);
		if(result > 0){
			return "Success";
		}
		else{
			return "Error";
		}
	}

	public List<Transactions> retrieveTransactionsInfoService() throws Exception{
		
	    List<Transactions> listOfRec = ui.retrieveTransactionsInfo();

	    if(listOfRec.size() == 0){
	            System.out.println("Error");
	            return listOfRec;
	    }else{
	            return listOfRec;
	    }
	}
}
