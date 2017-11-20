package lk.pabc.restfulapi.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.pabc.restfulapi.dto.exchangeratedto;
import lk.pabc.restfulapi.dto.exchangerateindividualdto;
import lk.pabc.restfulapi.dto.exrateindividualparentdto;
import lk.pabc.restfulapi.middlewareclient.middleclientcurrency;
import lk.pabc.restfulapi.middlewarerequest.MiddleWareRequestAccount;
import lk.pabc.restfulapi.middlewarerequest.currencyratesrequest;
import lk.pabc.restfulapi.model.CommonProperties;
import lk.pabc.restfulapi.model.currencyrates;
import lk.pabc.restfulapi.repository.CommonPropertiesDAO;
import lk.pabc.restfulapi.repository.currencyratesDAO;

@Service
public class ExchagerateimportImpl implements Exchagerateimport {

	Logger log = Logger.getLogger(ExchagerateimportImpl.class);
	
	@Autowired
	currencyratesDAO currencyretesDAO;
	
	@Autowired
	CommonPropertiesDAO commonPropertiesDAO;
	
	

	
	
	@Override
	public List<currencyrates> getallexchangerates(){
		currencyrates curratesdto=new currencyrates();
		
		Calendar calobj = Calendar.getInstance();
		
		List<currencyrates> currencyratesdata = new ArrayList<currencyrates>();
		currencyratesdata=(List<currencyrates>) currencyretesDAO.findAll();
		
		List<currencyrates> currencyrateaftermiddleware = new ArrayList<currencyrates>();
		for(currencyrates data:currencyratesdata){
			
			
			
			if(data.getFlag()==1){
				
				System.out.println("-------->"+data.getCucode());
			
			String curval=checkcurrencyratemiddleware("LKR","1",data.getCucode(),"TTB");
			if(curval.equals("na")){
				
				System.out.println("invalid response from middle to cur codes    "+data.getCucode());
			}else{
			double curvald=Double.parseDouble(curval);
			data.setCurrencyselling(curvald);
			data.setUpdatedate(calobj.getTime());
			
			currencyretesDAO.save(data);
			
			currencyrateaftermiddleware.add(data);
			
			}
			
			
		}else{
			
			
		}
			
		}
		
		return currencyrateaftermiddleware;
	}

	
	@Override
	public exrateindividualparentdto getindividualexchangerate(String varcur,String requestid,String fixedcur,String RateCode){
		
		Calendar calobj = Calendar.getInstance();
		exchangerateindividualdto exratedto=new exchangerateindividualdto();
		
		exrateindividualparentdto exrateindividualprtdto=new exrateindividualparentdto();
		
		String curval=checkcurrencyratemiddleware(varcur,requestid,fixedcur,RateCode);
		
		
		if(curval.equals("na")){
			
			System.out.println("invalid response from middle to cur codes    ");
		}else{
		double curvald=Double.parseDouble(curval);
	
		exratedto.setCurrencyselling(curvald);
		exratedto.setVar_cur_code(varcur);
		exratedto.setFx_cur_code(fixedcur);
		
		Date utildate=calobj.getTime();
		
		String sdate=utildatetoStringdate(utildate);
		
		exratedto.setUpdatedate(sdate);
		exrateindividualprtdto.setExchange_rate(exratedto);
		
		}
		
				
				return exrateindividualprtdto;
	} 
	
	
	@Override
	public String checkcurrencyratemiddleware(String varycurrency,String requetId,String fixedcurrency,String ratecode) {
		
		String responsetomiddleware = "";

		String currencyvalue = "";
		try{
		middleclientcurrency client = new middleclientcurrency();
		currencyratesrequest MiddleWarecurrency = new currencyratesrequest();
		CommonProperties cp = new CommonProperties();
		
		cp=getcommanvalsmain();
	
		
	Double currencyvaluelong = null;
		

		MiddleWarecurrency.setVariablecurrency(varycurrency);
		MiddleWarecurrency.setFixedcurrency(fixedcurrency);
		MiddleWarecurrency.setRatecode(ratecode);

		MiddleWarecurrency.setRequestId(requetId);
		
	

		
		
		responsetomiddleware = client.createClient(MiddleWarecurrency,cp);
		
		
		
		long clearbal = 0;
		if (responsetomiddleware.equals("na")) {
              System.out.println("no response");
               currencyvalue = "na";
		} else {

			JSONObject json = new JSONObject(responsetomiddleware);
			
			
			JSONArray jArray = json.getJSONArray("ErrorList");
			JSONObject j;
			JSONObject js1;

			String errorcode = "";
			String errordes = "";
			
			for (int i = 0; i < jArray.length(); i++) {
				js1 = jArray.getJSONObject(i);

				// if (js1.getString("Type").equals(type)) {

				errorcode = js1.getString("Err_Code");
				errordes = js1.getString("Err_Des");
				break;
				// }

			}
			
			
			if(errorcode.length()==0){

		/*	System.out.println("JSON OUTPUT=====" + json.get("StatusCode"));
			System.out.println("JSON OUTPUT1=====" + json.get("Result"));
			System.out.println("JSON OUTPUT2====="
					+ json.getJSONObject("Result").getJSONObject("BalanceDetal").getJSONArray("BalanceDet").get(0));*/

			JSONArray jArray2 = json.getJSONObject("Result").getJSONArray("RateDetail");
			JSONObject j2;
			JSONObject js3;
			String type = "var_crncy_units";

			for (int i = 0; i < jArray2.length(); i++) {
				j2 = jArray2.getJSONObject(i);
				//js1.getString("var_crncy_units");
				currencyvaluelong =j2.getDouble("var_crncy_units");;
				System.out.println("--->>>"+currencyvaluelong);

              break;
			}
			currencyvalue=Double.toString(currencyvaluelong);
			System.out.println("---->" + currencyvalue);
			}else{
				System.out.println("responsetomiddleware---->" + responsetomiddleware);
				//-------------------error to database 
				currencyvalue="na";
			}
		}
		}catch(Exception ex){
			System.out.println("error in checkbalancemiddleware-------->"+ex.getMessage());
			currencyvalue="na";
		}
		return currencyvalue;
		
		
	}	
	
	
	
	
	@Override
	public String checkbalancemiddleware(String accountnumbalance, String requetId) {
		middleclientcurrency client = new middleclientcurrency();
		MiddleWareRequestAccount middleWareRequestAccount = new MiddleWareRequestAccount();
		CommonProperties cp = new CommonProperties();
		
	
		
		String responsetomiddleware = "";

		String clearbalstring = "";
		
		//String requetIds="1";
		try{
			
			System.out.println("befor -----------");
			cp=getcommanvalsmain();	
			System.out.println("cp middle online url -----------"+cp.getOnlinebalmiddleurl());
			

		middleWareRequestAccount.setAcctId(accountnumbalance);

		middleWareRequestAccount.setRequestId(requetId);
		
	
		
		//MiddleWareRequestparameters.set

		// TODO Auto-generated method stub
		
		
		responsetomiddleware = client.createClientonlinebalence(middleWareRequestAccount,cp);
		//System.out.println("responsetomiddleware------------>" + responsetomiddleware);
		long clearbal = 0;
		if (responsetomiddleware.equals("na")) {
System.out.println("no response");
			clearbalstring = "na";
		} else {
System.out.println(responsetomiddleware);
			JSONObject json = new JSONObject(responsetomiddleware);

			System.out.println("JSON OUTPUT=====" + json.get("StatusCode"));
			System.out.println("JSON OUTPUT1=====" + json.get("Result"));
			System.out.println("JSON OUTPUT2====="
					+ json.getJSONObject("Result").getJSONObject("BalanceDetal").getJSONArray("BalanceDet").get(0));

			JSONArray jArray = json.getJSONObject("Result").getJSONObject("BalanceDetal").getJSONArray("BalanceDet");
			JSONObject j;
			JSONObject js1;
			String type = "CLRBAL";

			for (int i = 0; i < jArray.length(); i++) {
				js1 = jArray.getJSONObject(i);
				js1.getString("Type");

				if (js1.getString("Type").equals(type)) {

					clearbal = js1.getLong("Amount");
					clearbalstring = Double.toString(clearbal);
					break;
				}

			}

			log.info("---->" + clearbal);

		}
		
		}catch(Exception ex ){
			clearbalstring = "na";	
			
		}

		return clearbalstring;
	}
	
	public String utildatetoStringdate(Date utildate) {
		String sdate="";
	
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			sdate = sdf.format(utildate);
			
		//	String uppersdate = sdate.toUpperCase();

		


		} catch (Exception ex) {
			System.out.println("utildatetoStringdate error-----" + ex.getMessage());
			log.info("utildatetoStringdate error-----" + ex.getMessage());

		}
		return sdate;
	}	
	@Override
	@Transactional
	public CommonProperties getcommanvalsmain() {
		
	System.out.println("inside getcommanvalsmain ");
		CommonProperties comvals=new CommonProperties();	
		
		comvals=commonPropertiesDAO.findOne("1");
		
		
		System.out.println("-------"+comvals.getAgentcode()+"-token--"+comvals.getToken()+"---tqval---"+comvals.getTokenValue()+"--middle--"+comvals.getDofundmiddleurl());
		
		
		
		return comvals;

	}
}
