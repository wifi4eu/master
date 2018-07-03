package cec.budg.soatube.client.sync;
import java.util.HashMap;

import javax.ejb.Local;

@Local
public interface SoatubeWSClientLocal {

	public HashMap<String, String> sendMessage(String messageCorrelationId) throws Exception;
}
