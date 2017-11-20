package lk.pabc.restfulapi.middlewarerequest;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class MiddleWareRequestAccount {
	
	
	
	@XmlElement(name = "AcctId")
	private String AcctId;
	
	@XmlElement(name = "RequestId")
	private String RequestId;

	
	@XmlElement(name = "Debit_Account")
	private String Debit_Account;

	@XmlElement(name = "Credit_Account")
	private String Credit_Account;
	
	@XmlElement(name = "Remarks")
	private String Remarks;
	
	@XmlElement(name = "Tran_Perticular")
	private String Tran_Perticular;
	
	@XmlElement(name = "Amount")
	private String Amount;
	
	

	public String getAcctId() {
		return AcctId;
	}

	public void setAcctId(String acctId) {
		AcctId = acctId;
	}

	public String getRequestId() {
		return RequestId;
	}

	public void setRequestId(String requestId) {
		RequestId = requestId;
	}

	public String getDebit_Account() {
		return Debit_Account;
	}

	public void setDebit_Account(String debit_Account) {
		Debit_Account = debit_Account;
	}

	public String getCredit_Account() {
		return Credit_Account;
	}

	public void setCredit_Account(String credit_Account) {
		Credit_Account = credit_Account;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getTran_Perticular() {
		return Tran_Perticular;
	}

	public void setTran_Perticular(String tran_Perticular) {
		Tran_Perticular = tran_Perticular;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}
	
	



	
	

}