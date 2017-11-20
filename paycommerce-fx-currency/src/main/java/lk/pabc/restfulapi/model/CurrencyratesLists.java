package lk.pabc.restfulapi.model;

import java.io.Serializable;
import java.util.List;

public class CurrencyratesLists implements Serializable {

	private List<currencyrates> curr_list;

	public List<currencyrates> getCurr_list() {
		return curr_list;
	}

	public void setCurr_list(List<currencyrates> curr_list) {
		this.curr_list = curr_list;
	}
	
	
}