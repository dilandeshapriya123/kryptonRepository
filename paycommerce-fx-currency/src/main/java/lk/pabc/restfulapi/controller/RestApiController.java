package lk.pabc.restfulapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lk.pabc.restfulapi.dto.ExchangeratedtoList;
import lk.pabc.restfulapi.dto.exchangeratedto;
import lk.pabc.restfulapi.dto.exrateindividualparentdto;
import lk.pabc.restfulapi.dto.onlineBalanceDTO;
import lk.pabc.restfulapi.dto.onlinebalancedtolist;

import lk.pabc.restfulapi.model.CurrencyratesLists;
import lk.pabc.restfulapi.model.Errors;
import lk.pabc.restfulapi.model.ErrorsList;
import lk.pabc.restfulapi.model.agent;
import lk.pabc.restfulapi.model.currencyrates;
import lk.pabc.restfulapi.model.paycommercevostrodetails;
import lk.pabc.restfulapi.repository.AgentDAO;

import lk.pabc.restfulapi.repository.PaycomVostroDAO;
import lk.pabc.restfulapi.repository.currencyratesDAO;
import lk.pabc.restfulapi.service.*;

@RestController
@RequestMapping("/PABCRemittenceSerivce")
public class RestApiController {

	@Autowired
	currencyratesDAO currencyretesDAO;

	@Autowired
	AgentDAO agentdao;

	@Autowired
	Exchagerateimport Exchagerateimport;

	@Autowired
	PaycomVostroDAO paycomVostroDAO;

	Logger log = Logger.getLogger(RestApiController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to PABC Online Account Details Rest Service !!";
	}

	@RequestMapping(value = "onlineBalance", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity onlineBalance(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password, @RequestParam(value = "RequestId") String RequestId,
			@RequestParam(value = "AcctId") String AcctId) {
		ResponseEntity res = null;
		boolean flag = false;

		boolean flag2 = false;

		// ---------------------------- null check start
		// ----------------------------user name null

		if (username.length() == 0 || password.length() == 0 || RequestId.length() == 0 || AcctId.length() == 0) {

			// ----------------------------user name null

			Errors err = new Errors();
			ErrorsList errlist = new ErrorsList();

			err.setErr_id("001");
			err.setErr_msg("Requested Parameters empty !");
			errlist.setErr_list(err);
			res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(errlist);

		} else {
			// ---------------------------- null check END

			flag = credentialsValidation(username, password);
			flag2 = accountauthorized(AcctId);

			if (flag == false) {
				Errors err = new Errors();
				ErrorsList errlist = new ErrorsList();

				err.setErr_id("002");
				err.setErr_msg("Authentication Failed !");
				errlist.setErr_list(err);
				res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(errlist);

			} else {

				if (flag2 == false) {

					Errors err = new Errors();
					ErrorsList errlist = new ErrorsList();

					err.setErr_id("003");
					err.setErr_msg("Unauthorized Account Number !");
					errlist.setErr_list(err);
					res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(errlist);
				} else {

					// -------------------------get online balance

					String accountbalence = Exchagerateimport.checkbalancemiddleware(AcctId, RequestId);

					String curcode = "LKR";

					onlineBalanceDTO onlinebaldto = new onlineBalanceDTO();
					onlinebalancedtolist onlineballist = new onlinebalancedtolist();

					List<onlineBalanceDTO> onlinelist = new ArrayList<onlineBalanceDTO>();

					onlinebaldto.setBalance(accountbalence);
					onlinebaldto.setCucode(curcode);

					onlinelist.add(onlinebaldto);
					onlineballist.setOnlineballist(onlinelist);

					res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(onlineballist);

				}

			}
		}

		return res;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "exchangerate", method = RequestMethod.POST)
	public ResponseEntity get(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password,@RequestParam(value="Variable_Cur")String varcur,@RequestParam(value="RequestId")String requestid,@RequestParam(value="Fixed_Cur")String fixedcur,@RequestParam(value="Rate_Code")String RateCode) {
		log.info("username----" + username);
		log.info("password---" + password);
		ResponseEntity res;

		boolean flag = false;
		
		exrateindividualparentdto exrateindividualprtdto=new exrateindividualparentdto();

		flag = credentialsValidation(username, password);

		// -----------------------------------------

		if (flag) {

			log.info("inside else");
			
			exrateindividualprtdto=Exchagerateimport.getindividualexchangerate(varcur,requestid,fixedcur,RateCode);
			
			if(exrateindividualprtdto.getExchange_rate()==null){
				
				Errors err = new Errors();
				ErrorsList errlist = new ErrorsList();

				err.setErr_id("004");
				err.setErr_msg("No Response");
				errlist.setErr_list(err);
				res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(errlist);
				
			}else{
				
				res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(exrateindividualprtdto);
				
			}
			
			
			
			
			
			
			
			
	

		} else {

			Errors err = new Errors();
			ErrorsList errlist = new ErrorsList();

			err.setErr_id("002");
			err.setErr_msg("Authentication Failed !");
			errlist.setErr_list(err);
			res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(errlist);
		}

		// --------------------------------

		return res;

	}

	@RequestMapping(value = "exchangeratelist", method = RequestMethod.POST)
	public ResponseEntity get(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {
		log.info("username----" + username);
		log.info("password---" + password);
		ResponseEntity res;

		boolean flag = false;

		flag = credentialsValidation(username, password);

		// -----------------------------------------

		if (flag) {

			log.info("inside else");
			ExchangeratedtoList exchangeratedtoList = new ExchangeratedtoList();

			List<currencyrates> rates = Exchagerateimport.getallexchangerates();
			
			List<exchangeratedto> exchangerate = new ArrayList<exchangeratedto>();

			for (currencyrates rt : rates) {

				exchangeratedto newrate = new exchangeratedto();

				newrate.setCucode(rt.getCucode());

				newrate.setCurrencyselling(rt.getCurrencyselling());
				
				Date updatedate=rt.getUpdatedate();
				
				
				String stringdate=utildatetoStringdate(updatedate);
				
				newrate.setUpdatedate(stringdate);

				exchangerate.add(newrate);
			}
			exchangeratedtoList.setExchangerate_list(exchangerate);
			if(exchangeratedtoList.getExchangerate_list().isEmpty()){
				Errors err = new Errors();
				ErrorsList errlist = new ErrorsList();

				err.setErr_id("004");
				err.setErr_msg("No Response");
				errlist.setErr_list(err);
				res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(errlist);
			}else{
				res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(exchangeratedtoList);
				log.info("flag Succcess");
			}

			
		

		} else {

			Errors err = new Errors();
			ErrorsList errlist = new ErrorsList();

			err.setErr_id("002");
			err.setErr_msg("Authentication Failed !");
			errlist.setErr_list(err);
			res = (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED).body(errlist);
		}

		// --------------------------------

		return res;

	}

	public boolean credentialsValidation(String username, String password) {
		boolean stat = false;

		log.info("username----" + username);
		log.info("password---" + password);

		// -----------------------------------------
		List<agent> agentlist = (List<agent>) agentdao.findAll();

		for (agent agnt : agentlist) {
			log.info("agnt.getUserid()---" + agnt.getUserid());
			if (agnt.getUserid() == null) {
				log.info("if agnt.getUserid()---" + agnt.getUserid());
				continue;

			} else {
				log.info("inside agent PW else");
				if (agnt.getPassword() == null) {
					log.info("if agnt.getPassword()---" + agnt.getPassword());

					Errors err = new Errors();
					ErrorsList errlist = new ErrorsList();

					err.setErr_id("001");
					err.setErr_msg("Invalied User Name");
					errlist.setErr_list(err);

					continue;

				} else {

					if ((agnt.getUserid().equals(username)) && (agnt.getPassword().equals(password))) {

						log.info("if Succcess");
						stat = true;

						break;

					}
				}

			}
		}

		return stat;

	}

	public boolean accountauthorized(String accountid) {
		boolean stat = false;

		log.info("accountid----" + accountid);

		// -----------------------------------------
		List<paycommercevostrodetails> paycomvostrolist = (List<paycommercevostrodetails>) paycomVostroDAO.findAll();

		for (paycommercevostrodetails paycomacc : paycomvostrolist) {
			log.info("paycommercevostrodetails acc no---" + paycomacc.getAgentacc());
			if (paycomacc.getAgentacc() == null) {
				log.info("if agnt.getUserid()---" + paycomacc.getAgentacc());
				continue;

			} else {

				if (paycomacc.getAgentacc().equals(accountid)) {

					stat = true;

					break;

				}

			}
		}

		return stat;

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

}
