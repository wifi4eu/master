package cec.budg.soatube.client.util;


public class BudgSOAException extends Exception
{



	private static final long serialVersionUID = 1L;

	private String customMessage;

	public BudgSOAException(String customMessage){
		super(customMessage);
		this.customMessage=customMessage;
	}
	
	public BudgSOAException(String customMessage, Throwable cause){
		super (cause);
		this.customMessage=customMessage;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}


}