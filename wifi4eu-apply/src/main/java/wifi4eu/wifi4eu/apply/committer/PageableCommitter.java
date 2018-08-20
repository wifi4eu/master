package wifi4eu.wifi4eu.apply.committer;

import java.sql.BatchUpdateException;
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
public class PageableCommitter implements ICommitter {
	
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

	/**
	 * 
	 */
	public void commit() {
		List<LocalEntity> localEntities = new ArrayList<>();

		PageRequest pageRequest = PageRequest.of(0, 100);
		
		Page<LocalEntity> pageLocalEntity = this.localRep.findAll(pageRequest);
		
		localEntities.addAll(pageLocalEntity.getContent());
		
		//localEntities.addAll(this.localRep.findAll());
		localEntities.addAll(MasterCommitter.createValidEntities(49_999));
		localEntities.addAll(MasterCommitter.createInvalidEntities(1));
		localEntities.addAll(MasterCommitter.createValidEntities(50000));

		
		this.LOGGER.info("Entities Found: [{}]", localEntities.size());
		

		long overallStartTime = System.currentTimeMillis();
		
		this.commitToDB(localEntities, 1000);
		
		long totalTime = System.currentTimeMillis() - overallStartTime;
		this.LOGGER.info("QTY ENTITIES: [{}], TOTAL TIME: [{}]ms", localEntities.size(), totalTime);
		
		this.LOGGER.info("COMMIT FINISHED");
		
	}
	
	private void commitToDB(List<LocalEntity> listLocalEntities, int pageSize) {

		MasterPreparedStatementSetter masterPreparedStatementSetter = new MasterPreparedStatementSetter();
		
		for (int i = 0; i <= listLocalEntities.size(); i += pageSize) {
			int end = (i + pageSize) < listLocalEntities.size() ? (i + pageSize) : (listLocalEntities.size());
			List<LocalEntity> tempList = listLocalEntities.subList(i, end);
			masterPreparedStatementSetter.setListLocalEntities(tempList);

			this.LOGGER.info("COMMITTING FROM [{}] TO [{}]", i, end);
			long startTime = System.currentTimeMillis();
			
			try {
				jdbcTemplate.batchUpdate(this.INSERT_TEMPLATE, masterPreparedStatementSetter);
			} catch (DataAccessException e) {
				if (pageSize == 1) {
					LocalEntity localEntity = tempList.get(0);
					this.LOGGER.info("ERROS ID[{}]  CallId[{}] RegistrationId[{}]", localEntity.getId(), localEntity.getCallId(), localEntity.getRegistrationId());
					
				} else {
					this.commitToDB(tempList, 1);
					
				}
			}
			this.LOGGER.info("   IT TOOK [{}]ms", System.currentTimeMillis() - startTime);
		}
			
//		} catch (DataAccessException e) {
//			this.LOGGER.error("Error", e);
//			
//		}
	}

}
