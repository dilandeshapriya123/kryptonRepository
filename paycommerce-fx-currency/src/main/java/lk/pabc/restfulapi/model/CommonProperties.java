package lk.pabc.restfulapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_middleware")
public class CommonProperties implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @Column(name="index")
	private String index;
	
	
    @Column(name="bank_code_local")
	private  String bankCode;
	

	
	@Column(name="bank_code_swfs")
	private  String bankCodeswfs;
	
	@Column(name="token_value")
	private String token;
	
	@Column(name="token_name")
	private String TokenValue;
	
	@Column(name="onlinebalmiddleurl")
	private String onlinebalmiddleurl;
	
	@Column(name="dofundmiddleurl")
	private String dofundmiddleurl;
	
	@Column(name="ceftdofundmiddleurl")
	private String ceftdofundmiddleurl;
	
	@Column(name="ceftdocardmiddleurl")
	private String ceftdocardmiddleurl;
	
	@Column(name="curatesmiddleurl")
	private String curatesmiddleurl;
	
	
	


	
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getCuratesmiddleurl() {
		return curatesmiddleurl;
	}
	public void setCuratesmiddleurl(String curatesmiddleurl) {
		this.curatesmiddleurl = curatesmiddleurl;
	}
	@Column(name="payerlocationpabc")
	private  String  payerlocationpabc;
	
	@Column(name="payerlocationceft")
	private  String  payerlocationceft;
	
	@Column(name="payerlocationslip")
	private  String  payerlocationslip;
	
	
	@Column(name="agentcode")
	private  String  agentcode;
	
	
	@Column(name="agentname")
	private  String  agentname;
	
	
	
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankCodeswfs() {
		return bankCodeswfs;
	}
	public void setBankCodeswfs(String bankCodeswfs) {
		this.bankCodeswfs = bankCodeswfs;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getOnlinebalmiddleurl() {
		return onlinebalmiddleurl;
	}
	public void setOnlinebalmiddleurl(String onlinebalmiddleurl) {
		this.onlinebalmiddleurl = onlinebalmiddleurl;
	}
	public String getDofundmiddleurl() {
		return dofundmiddleurl;
	}
	public void setDofundmiddleurl(String dofundmiddleurl) {
		this.dofundmiddleurl = dofundmiddleurl;
	}
	public String getCeftdofundmiddleurl() {
		return ceftdofundmiddleurl;
	}
	public void setCeftdofundmiddleurl(String ceftdofundmiddleurl) {
		this.ceftdofundmiddleurl = ceftdofundmiddleurl;
	}
	public String getCeftdocardmiddleurl() {
		return ceftdocardmiddleurl;
	}
	public void setCeftdocardmiddleurl(String ceftdocardmiddleurl) {
		this.ceftdocardmiddleurl = ceftdocardmiddleurl;
	}
	public String getTokenValue() {
		return TokenValue;
	}
	public void setTokenValue(String tokenValue) {
		TokenValue = tokenValue;
	}
	public String getAgentcode() {
		return agentcode;
	}
	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}
	public String getAgentname() {
		return agentname;
	}
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	public String getPayerlocationpabc() {
		return payerlocationpabc;
	}
	public void setPayerlocationpabc(String payerlocationpabc) {
		this.payerlocationpabc = payerlocationpabc;
	}
	public String getPayerlocationceft() {
		return payerlocationceft;
	}
	public void setPayerlocationceft(String payerlocationceft) {
		this.payerlocationceft = payerlocationceft;
	}
	public String getPayerlocationslip() {
		return payerlocationslip;
	}
	public void setPayerlocationslip(String payerlocationslip) {
		this.payerlocationslip = payerlocationslip;
	}
	
	
	
	

}
