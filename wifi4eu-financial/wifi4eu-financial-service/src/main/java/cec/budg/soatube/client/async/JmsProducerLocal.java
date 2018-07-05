package cec.budg.soatube.client.async;

import java.util.HashMap;

import javax.ejb.Local;

import cec.budg.soatube.client.util.BudgSOAException;

@Local
public interface JmsProducerLocal {

	public abstract HashMap<String, String> sendMessage(String messageCorID)
			throws BudgSOAException;

}