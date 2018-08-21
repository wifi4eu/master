package wifi4eu.wifi4eu.apply;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.apply.committer.ICommitter;
import wifi4eu.wifi4eu.apply.localEntity.ApplicationSQLite;


@Service
public class MasterCommitter {
	
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier(value="pageableCommitter")
	private ICommitter committer;
	
	public void commit() {
		this.committer.commit();
	}

	static public List<ApplicationSQLite> createValidEntities(int quantity) {
		List<ApplicationSQLite> listResult = new ArrayList<>();
		
		for (int i = 0; i < quantity; i++) {
			ApplicationSQLite localEntity = new ApplicationSQLite();
			localEntity.setCallId(/*1000 + i*/ 1L);
			localEntity.setRegistrationId(/*1000_000 + i*/ "1254");
			
			listResult.add(localEntity);
		}
		
		return listResult;
	}
	
	static public List<ApplicationSQLite> createInvalidEntities(int quantity) {
		List<ApplicationSQLite> listResult = new ArrayList<>();
		
		for (int i = 0; i < quantity; i++) {
			ApplicationSQLite localEntity = new ApplicationSQLite();
			localEntity.setCallId(999L);
			localEntity.setRegistrationId(/*1000_000 + i*/ "1254");
			
			listResult.add(localEntity);
		}
		
		return listResult;
	}
	
	
}