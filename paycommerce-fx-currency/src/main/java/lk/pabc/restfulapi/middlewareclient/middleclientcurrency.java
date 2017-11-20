package lk.pabc.restfulapi.middlewareclient;



import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import lk.pabc.restfulapi.middlewarerequest.MiddleWareRequestAccount;
import lk.pabc.restfulapi.middlewarerequest.currencyratesrequest;
import lk.pabc.restfulapi.model.CommonProperties;





@Service
@Configuration
public class middleclientcurrency {
	

	
	
	public String createClient(currencyratesrequest mwr,CommonProperties cp) {
		
		
		String responsetomiddleware="na";
		
		
		
		
		
		String token=cp.getToken();
		String TokenValue=cp.getTokenValue();
		String curratesmiddleurl=cp.getCuratesmiddleurl();
		
		String trimcurratesmiddleurl=curratesmiddleurl.trim();
	
		System.out.println("//------------>>"+trimcurratesmiddleurl+"-----------"+token+"-------------"+trimcurratesmiddleurl);
		

		try {
			
			 //RestfulClient restfulClient = new RestfulClient();

			//ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create();
          String output="na";
			WebResource webResource = client
					.resource(trimcurratesmiddleurl);
			
			System.out.println("onlinebalmiddleurl ------------->"+trimcurratesmiddleurl);

			ClientResponse response = webResource.type("application/json")
					.header(TokenValue, token).post(ClientResponse.class, mwr);
			
			
			System.out.println("response------------->"+response);

			if (response.getStatus() != 200) {
				System.out.println("Failed : HTTP error code : "+ response.getStatus());
				
				//throw new RuntimeException("Failed : HTTP error code : "
				//		+ response.getStatus());
				
				
			}else{

			 output = response.getEntity(String.class);
			}
			responsetomiddleware=output;

			System.out.println("Server response .... \n");
			//System.out.println(output);

		} catch (Exception e) {
			System.out.println("inside catch----" + e.getMessage());
			responsetomiddleware="na";
		
		}
		//Client daclient =Client.create();
		
		
		
		return responsetomiddleware;
		
	
	}

	
	
	public String createClientonlinebalence(MiddleWareRequestAccount mwr,CommonProperties cp) {
		
		
		String responsetomiddleware="na";
		
		
		
		
		
		String token=cp.getToken();
		String TokenValue=cp.getTokenValue();
		String onlinebalmiddleurl=cp.getOnlinebalmiddleurl();
		
		String trimonlinebalmiddleurl=onlinebalmiddleurl.trim();
	
		System.out.println("//------------>>"+onlinebalmiddleurl+"-----------"+token+"-------------"+onlinebalmiddleurl);
		

		try {

			//ClientConfig clientConfig = new DefaultClientConfig();
			Client client = Client.create();
          String output="na";
			WebResource webResource = client
					.resource(trimonlinebalmiddleurl);
			
			System.out.println("onlinebalmiddleurl ------------->"+trimonlinebalmiddleurl);

			ClientResponse response = webResource.type("application/json")
					.header(TokenValue, token).post(ClientResponse.class,mwr);
			
			
			System.out.println("response------------->"+response);

			if (response.getStatus() != 200) {
				System.out.println("Failed : HTTP error code : "+ response.getStatus());
				
				//throw new RuntimeException("Failed : HTTP error code : "
				//		+ response.getStatus());
				
				
			}else{

			 output = response.getEntity(String.class);
			}
			responsetomiddleware=output;

			System.out.println("Server response .... \n");
			//System.out.println(output);

		} catch (Exception e) {
			System.out.println("inside catch----" + e.getMessage());
			responsetomiddleware="na";
		
		}
		//Client daclient =Client.create();
		
		
		
		return responsetomiddleware;
		
	
	}
}
