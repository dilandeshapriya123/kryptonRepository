package lk.pabc.restfulapi.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_paycommerce_vostro")
public class paycommercevostrodetails implements Serializable{

	/**
	 * 
	 */
	
	
	@Id
    @Column(name="accid")
	private String accid;
	

	
	@Column(name="agent")
	private String agentcode;
	
	
	@Column(name="accountno")
	private String agentacc;	
	
	@Column(name="agentdescription")
	private String agentdescription;
	
	@Column(name="accountcurrency")
	private String accountcurrencytype;
	
	

	public String getAccountcurrencytype() {
		return accountcurrencytype;
	}

	public void setAccountcurrencytype(String accountcurrencytype) {
		this.accountcurrencytype = accountcurrencytype;
	}

	public String getAccid() {
		return accid;
	}

	public void setAccid(String accid) {
		this.accid = accid;
	}

	public String getAgentcode() {
		return agentcode;
	}

	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}

	public String getAgentacc() {
		return agentacc;
	}

	public void setAgentacc(String agentacc) {
		this.agentacc = agentacc;
	}

	public String getAgentdescription() {
		return agentdescription;
	}

	public void setAgentdescription(String agentdescription) {
		this.agentdescription = agentdescription;
	}	
	
	

}
