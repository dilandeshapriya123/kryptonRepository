package lk.pabc.restfulapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_curncy_rts")
public class currencyrates implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
    @Column(name="P_CR_Code")
	private String crcode;
	
	@Column(name="P_CU_Code")
	private String cucode;
	
	@Column(name="P_CR_Date")
	private Date crdate;
	
	@Column(name="P_CR_Buying")
	private Double currencybuying;
	
	@Column(name="P_CR_Selling")
	private Double currencyselling;
	
	@Column(name="last_update_date")
	private Date updatedate;
	
	@Column(name="flag")
	private int flag;
	
	

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getCrcode() {
		return crcode;
	}

	public void setCrcode(String crcode) {
		this.crcode = crcode;
	}

	public String getCucode() {
		return cucode;
	}

	public void setCucode(String cucode) {
		this.cucode = cucode;
	}

	public Date getCrdate() {
		return crdate;
	}

	public void setCrdate(Date crdate) {
		this.crdate = crdate;
	}

	public Double getCurrencybuying() {
		return currencybuying;
	}

	public void setCurrencybuying(Double currencybuying) {
		this.currencybuying = currencybuying;
	}

	public Double getCurrencyselling() {
		return currencyselling;
	}

	public void setCurrencyselling(Double currencyselling) {
		this.currencyselling = currencyselling;
	}
	
	
	

}
