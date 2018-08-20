package wifi4eu.wifi4eu.apply.committer;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.apply.MasterCommitter;
import wifi4eu.wifi4eu.apply.localEntity.LocalEntity;
import wifi4eu.wifi4eu.apply.localEntity.LocalRepository;

@Service
public class SimpleCommitter implements ICommitter {

	private final String INSERT_TEMPLATE = "INSERT INTO applications (call_id, registration, supplier, voucher_awarded, date, _status, invalidate_reason, lef_export, " +
	"lef_import, lef_status, bc_export, bc_import, bc_status,lc_export, lc_import, lc_status) " +
	"VALUES (?, ?, NULL, 0, ?, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
	
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private LocalRepository localRep;

	@Autowired
	@Qualifier(value="masterDataSource")
	private DataSource masterDataSource;
	
    private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void init() {
		this.jdbcTemplate = new JdbcTemplate(this.masterDataSource);
	}

	public void commit() {
		List<LocalEntity> localEntities = new ArrayList<>();

		PageRequest pageRequest = PageRequest.of(0, 100);
		
		Page<LocalEntity> pageLocalEntity = this.localRep.findAll(pageRequest);
		
		localEntities.addAll(pageLocalEntity.getContent());
		
		//localEntities.addAll(this.localRep.findAll());
		int quantity = 100_000;
		localEntities.addAll(MasterCommitter.createValidEntities(quantity));
		//localEntities.addAll(this.createInvalidEntities(1));
		this.LOGGER.info("Entities Found: [{}]", localEntities.size());
		
		MasterPreparedStatementSetter masterPreparedStatementSetter = new MasterPreparedStatementSetter();
		masterPreparedStatementSetter.setListLocalEntities(localEntities);
		
		long start = System.currentTimeMillis();
		int savingPageSize = 1000;
		
		try {
			this.LOGGER.info("COMMITTING TO MASTER DATABASE");
			
			for (int i = 0; i <= localEntities.size(); i += savingPageSize) {
				localEntities.subList(i, i + savingPageSize);
				this.jdbcTemplate.batchUpdate(this.INSERT_TEMPLATE, masterPreparedStatementSetter);
			}
			
		} catch (DataAccessException e) {
			this.LOGGER.error("Error", e);
			
		}
		
		long totalTime = System.currentTimeMillis() - start;
		
		this.LOGGER.info("QTY ENTITIES: [{}], TOTAL TIME: [{}]ms", localEntities.size(), totalTime);
		this.LOGGER.info("COMMIT FINISHED");
	}
}
