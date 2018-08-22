package wifi4eu.wifi4eu.apply.committer;

import org.springframework.transaction.annotation.Transactional;

public interface ICommitter {
	
	@Transactional
	public void commit();

}
