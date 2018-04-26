package com.setDeals.service;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.setDeals.dao.SetDealsDao;
import com.setDeals.data.SetDealsRequest;
import com.setDeals.data.SetDealsResponse;
@Path("/api")
public class SetDealsService {
	@Path("/v1")
	@POST
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({ MediaType.APPLICATION_JSON})
    public SetDealsResponse setDeals(SetDealsRequest request) {
		System.out.println("Invoked API : /setDeals/api/v1");
		
		SetDealsResponse response = new SetDealsResponse();
		response=populateRequestInfo(request);
		if(request.getShopName()==null || request.getShopContactNum()==0 || request.getShopName().equals(""))
		{
			System.out.println("Shop Name or Shop Contact Number is missing");
			response.setErrorCode("400");
			response.setErrorMessage("Mandatory Field Shop Name and/or Shop Contact Number is/are missing");
			response.setSuccess("FALSE");
		}
		else
		{
			SetDealsDao dao=new SetDealsDao();
			try {
				dao.insertRecordIntoTable(request);
			} catch (SQLException e) {
				e.printStackTrace();
				response.setErrorCode("500");
				response.setErrorMessage(e.getMessage());
				response.setSuccess("FALSE");
			}
		}
		if(response.getSuccess()==null)
		response.setSuccess("TRUE");
		if(response.getErrorCode()==null)
		response.setErrorCode("200");
		return response;
	

	}
	public SetDealsResponse populateRequestInfo(SetDealsRequest request)
	{
		SetDealsResponse response = new SetDealsResponse();
		response.setShopName(request.getShopName());
		response.setShopContactNum(request.getShopContactNum());
		return response;
	}

}
