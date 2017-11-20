package lk.pabc.restfulapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_agent")
public class agent implements Serializable {
	
	
	@Id
    @Column(name="m_am_code")
	private String agentcode;
	

	
	@Column(name="m_am_name")
	private String agentname;
	
	
	@Column(name="m_am_vostro")
	private String agentvostroacc;
	
	@Column(name="m_am_vostro_usd")
	private String agentvostroaccusd;
	
	@Column(name="m_am_vostro_eur")
	private String agentvostroacceur;
	
	@Column(name="m_am_commition_accno_gbp")
	private String agentvostroacccommgbp;
	
	@Column(name="m_am_vostro_gbp")
	private String agentvostroaccgbp;
	
	

	@Column(name="m_am_votsroacc_type_lkr")
	private String agentvostrotype;
	
	@Column(name="m_am_commition_accno")
	private String commitionaccno;
	
	@Column(name="m_am_commition_accno_usd")
	private String commitionaccnousd;
	
	@Column(name="m_am_commition_accno_eur")
	private String commitionaccnoeur;
	
	@Column(name="m_slip_global_acc")
	private String slipglobalaccno;
	
	
	@Column(name="m_am_cur_min_com_val")
	private Double currencyminimumcommisionval;
	
	
	@Column(name="reduce_amount_for_ceft")
	private Double reducedamountforceftasbenifit;
	
	

	@Column(name="maximum_tr_amount_lkr")
	private Double maximumtramount;
	
	@Column(name="maximum_tr_amount_usd")
	private Double maximumtramountusd;
	
	
	@Column(name="maximum_tr_amount_euro")
	private Double maximumtramounteuro;

	
	@Column(name="maximum_tr_amount_gbp")
	private Double maximumtramountgbp;
	
	@Column(name="comm_val_lkr")
	private Double comvallkr;
	
	@Column(name="comm_val_usd")
	private Double comvalusd;
	
	@Column(name="m_am_userid")
	private String userid;
	
	
	@Column(name="m_am_password")
	private String password;
	
	




	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Double getComvallkr() {
		return comvallkr;
	}


	public void setComvallkr(Double comvallkr) {
		this.comvallkr = comvallkr;
	}


	public Double getComvalusd() {
		return comvalusd;
	}


	public void setComvalusd(Double comvalusd) {
		this.comvalusd = comvalusd;
	}


	public Double getMaximumtramountgbp() {
		return maximumtramountgbp;
	}


	public void setMaximumtramountgbp(Double maximumtramountgbp) {
		this.maximumtramountgbp = maximumtramountgbp;
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


	public String getAgentvostroacc() {
		return agentvostroacc;
	}


	public void setAgentvostroacc(String agentvostroacc) {
		this.agentvostroacc = agentvostroacc;
	}


	public String getAgentvostroaccusd() {
		return agentvostroaccusd;
	}


	public void setAgentvostroaccusd(String agentvostroaccusd) {
		this.agentvostroaccusd = agentvostroaccusd;
	}


	public String getAgentvostroacceur() {
		return agentvostroacceur;
	}


	public void setAgentvostroacceur(String agentvostroacceur) {
		this.agentvostroacceur = agentvostroacceur;
	}


	public String getAgentvostroacccommgbp() {
		return agentvostroacccommgbp;
	}


	public void setAgentvostroacccommgbp(String agentvostroacccommgbp) {
		this.agentvostroacccommgbp = agentvostroacccommgbp;
	}


	public String getAgentvostroaccgbp() {
		return agentvostroaccgbp;
	}


	public void setAgentvostroaccgbp(String agentvostroaccgbp) {
		this.agentvostroaccgbp = agentvostroaccgbp;
	}


	public String getAgentvostrotype() {
		return agentvostrotype;
	}


	public void setAgentvostrotype(String agentvostrotype) {
		this.agentvostrotype = agentvostrotype;
	}


	public String getCommitionaccno() {
		return commitionaccno;
	}


	public void setCommitionaccno(String commitionaccno) {
		this.commitionaccno = commitionaccno;
	}


	public String getCommitionaccnousd() {
		return commitionaccnousd;
	}


	public void setCommitionaccnousd(String commitionaccnousd) {
		this.commitionaccnousd = commitionaccnousd;
	}


	public String getCommitionaccnoeur() {
		return commitionaccnoeur;
	}


	public void setCommitionaccnoeur(String commitionaccnoeur) {
		this.commitionaccnoeur = commitionaccnoeur;
	}


	public String getSlipglobalaccno() {
		return slipglobalaccno;
	}


	public void setSlipglobalaccno(String slipglobalaccno) {
		this.slipglobalaccno = slipglobalaccno;
	}


	public Double getCurrencyminimumcommisionval() {
		return currencyminimumcommisionval;
	}


	public void setCurrencyminimumcommisionval(Double currencyminimumcommisionval) {
		this.currencyminimumcommisionval = currencyminimumcommisionval;
	}


	public Double getReducedamountforceftasbenifit() {
		return reducedamountforceftasbenifit;
	}


	public void setReducedamountforceftasbenifit(Double reducedamountforceftasbenifit) {
		this.reducedamountforceftasbenifit = reducedamountforceftasbenifit;
	}


	public Double getMaximumtramount() {
		return maximumtramount;
	}


	public void setMaximumtramount(Double maximumtramount) {
		this.maximumtramount = maximumtramount;
	}


	public Double getMaximumtramountusd() {
		return maximumtramountusd;
	}


	public void setMaximumtramountusd(Double maximumtramountusd) {
		this.maximumtramountusd = maximumtramountusd;
	}


	public Double getMaximumtramounteuro() {
		return maximumtramounteuro;
	}


	public void setMaximumtramounteuro(Double maximumtramounteuro) {
		this.maximumtramounteuro = maximumtramounteuro;
	}
	
	
	
	
	
}
