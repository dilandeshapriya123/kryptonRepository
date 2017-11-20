package lk.pabc.restfulapi.middlewarerequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class currencyratesrequest {
	
	

	@XmlElement(name = "Fixed_Cry")
	private String fixedcurrency;
	
	@XmlElement(name = "RequestId")
	private String requestId;

	
	@XmlElement(name = "Variable_Cry")
	private String variablecurrency;

	
	
	@XmlElement(name = "Rate_Code")
	private String ratecode;



	public String getFixedcurrency() {
		return fixedcurrency;
	}



	public void setFixedcurrency(String fixedcurrency) {
		this.fixedcurrency = fixedcurrency;
	}



	public String getRequestId() {
		return requestId;
	}



	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}



	public String getVariablecurrency() {
		return variablecurrency;
	}



	public void setVariablecurrency(String variablecurrency) {
		this.variablecurrency = variablecurrency;
	}



	public String getRatecode() {
		return ratecode;
	}



	public void setRatecode(String ratecode) {
		this.ratecode = ratecode;
	}
	
	

}
