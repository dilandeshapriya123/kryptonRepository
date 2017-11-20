package lk.pabc.restfulapi.dto;

public class exchangerateindividualdto {
	
	
	private String var_cur_code;
	
	private String fx_cur_code;
	
	
	private Double currencyselling;
	
	
	private String updatedate;


	public String getVar_cur_code() {
		return var_cur_code;
	}


	public void setVar_cur_code(String var_cur_code) {
		this.var_cur_code = var_cur_code;
	}


	public String getFx_cur_code() {
		return fx_cur_code;
	}


	public void setFx_cur_code(String fx_cur_code) {
		this.fx_cur_code = fx_cur_code;
	}


	public Double getCurrencyselling() {
		return currencyselling;
	}


	public void setCurrencyselling(Double currencyselling) {
		this.currencyselling = currencyselling;
	}


	public String getUpdatedate() {
		return updatedate;
	}


	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	
	
}
