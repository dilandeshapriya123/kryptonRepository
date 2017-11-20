package lk.pabc.restfulapi.model;

import java.io.Serializable;

public class Errors implements Serializable {
	
	private String err_id;
	
	private String err_msg;
	
	public String getErr_id() {
		return err_id;
	}
	public void setErr_id(String err_id) {
		this.err_id = err_id;
	}
	public String getErr_msg() {
		return err_msg;
	}
	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}
	
	

}
