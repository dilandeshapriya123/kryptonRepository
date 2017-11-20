package lk.pabc.restfulapi.service;

import java.util.List;

import lk.pabc.restfulapi.dto.exchangeratedto;
import lk.pabc.restfulapi.dto.exchangerateindividualdto;
import lk.pabc.restfulapi.dto.exrateindividualparentdto;
import lk.pabc.restfulapi.model.CommonProperties;
import lk.pabc.restfulapi.model.currencyrates;

public interface Exchagerateimport {

	

	CommonProperties getcommanvalsmain();

	List<currencyrates> getallexchangerates();

	String checkcurrencyratemiddleware(String varycurrency, String requetId, String fixedcurrency, String ratecode);

	String checkbalancemiddleware(String accountnumbalance, String requetId);

	exrateindividualparentdto getindividualexchangerate(String varcur, String requestid, String fixedcur, String RateCode);
}
