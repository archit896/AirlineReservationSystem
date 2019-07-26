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

import service.TransactionsService;
import bean.Transactions;

@Path("transaction")
public class TransactionsRest {

	TransactionsService ts = new TransactionsService();
	
	@POST
	@Path("store")
	@Consumes(MediaType.APPLICATION_JSON)
	public String storeTransactionsRest(Transactions transaction){
		String result = "";
		
		try {
			result = ts.storeTransactionsInfoService(transaction);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@DELETE
	@Path("delete")
	public String deleteTransactionsRest(@QueryParam("transactionId") int transactionId){
		String result = "";
		
		try {
			result = ts.deleteTransactionsInfoService(transactionId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateTransactionsRest(Transactions transaction){
		String result = "";
		
		try {
			result = ts.updateTransactionsInfoServiceViaId(transaction);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	@GET
	@Path("retrieveAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transactions> retrieveAllTransactions(){
		List<Transactions> transactions = new ArrayList<Transactions>();
		
		try {
			transactions = ts.retrieveTransactionsInfoService();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return transactions;
	}
	
	@GET
	@Path("retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public Transactions retrieveTransaction(@QueryParam("transactionId") int transactionId){
		 Transactions transaction = new Transactions();
		 
		 try {
			transaction = ts.retrieveTransaction(transactionId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return transaction;
	}
	
}
