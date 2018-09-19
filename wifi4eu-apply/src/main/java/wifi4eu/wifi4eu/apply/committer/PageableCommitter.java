package wifi4eu.wifi4eu.apply.committer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wifi4eu.wifi4eu.apply.localEntity.ApplicationSQLite;
import wifi4eu.wifi4eu.apply.localEntity.LocalRepository;
import wifi4eu.wifi4eu.apply.masterEntity.ApplicationSQLServer;

@Service
public class PageableCommitter implements ICommitter {
	
	private final String INSERT_TEMPLATE = "INSERT INTO applications (call_id, registration, supplier, voucher_awarded, date, _status, invalidate_reason, lef_export, " +
	"lef_import, lef_status, bc_export, bc_import, bc_status,lc_export, lc_import, lc_status, order) " +
	"VALUES (?, ?, NULL, 0, ?, 0, NULL, 0, 0, 0, 0, 0, 0, 0, 0, 0, ?)";
	
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private LocalRepository localRep;

	@Autowired
	@Qualifier(value="masterDataSource")
	private DataSource masterDataSource;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void init() {
		this.jdbcTemplate.setDataSource(this.masterDataSource);
	}

	/**
	 * 
	 */
	@Transactional(transactionManager="masterTransactionManager")
	public void commit() {
		List<ApplicationSQLite> localEntities = new ArrayList<>();

		//PageRequest pageRequest = PageRequest.of(0, 10000);
		//Page<ApplicationSQLite> pageLocalEntity = this.localRep.findAll(pageRequest);
		//localEntities.addAll(pageLocalEntity.getContent());
		
		this.LOGGER.info("READING APPLICATIONS FROM SQLite");
		long startingReadingTime = System.currentTimeMillis();

		localEntities.addAll(this.localRep.findAll());

		this.LOGGER.info("READ [{}] LINES. IT TOOK [{}]ms", localEntities.size(), System.currentTimeMillis() - startingReadingTime);

		//localEntities.addAll(this.localRep.findAll());
		//localEntities.addAll(MasterCommitter.createValidEntities(49_999));
		//localEntities.addAll(MasterCommitter.createInvalidEntities(1));
		//localEntities.addAll(MasterCommitter.createValidEntities(50000));

		
		this.LOGGER.info("Entities Found: [{}]", localEntities.size());
		

		long overallStartTime = System.currentTimeMillis();
		
		this.commitToDB(localEntities, 1000);
		
		long totalTime = System.currentTimeMillis() - overallStartTime;
		this.LOGGER.info("QTY ENTITIES: [{}], TOTAL TIME: [{}]ms", localEntities.size(), totalTime);
		
		this.LOGGER.info("COMMIT FINISHED");
		
	}
	
	private void commitToDB(List<ApplicationSQLite> listLocalEntities, int pageSize) {
		MasterPreparedStatementSetter masterPreparedStatementSetter = new MasterPreparedStatementSetter();
		
//		Statement stmt;
//		try {
//			stmt = this.masterDataSource.getConnection().createStatement();
//			
//			this.LOGGER.info("DELETING PREVIOUS APPLICATIONS");
//			long startingDeletingTime = System.currentTimeMillis();
//
//			int deletedLines = stmt.executeUpdate("delete from applications");
//			
//			this.LOGGER.info("DELETED [{}] LINES. IT TOOK [{}]ms", deletedLines, System.currentTimeMillis() - startingDeletingTime);
//			
//		} catch (SQLException e) {
//			this.LOGGER.error("ERROR DELETING LINES", e);
//		}
		
		for (int i = 0; i <= listLocalEntities.size(); i += pageSize) {
			int end = (i + pageSize) < listLocalEntities.size() ? (i + pageSize) : (listLocalEntities.size());
			List<ApplicationSQLite> tempList = listLocalEntities.subList(i, end);
			
			//
			List<ApplicationSQLServer> applications = tempList.stream().map(a ->
				new ApplicationSQLServer(Long.valueOf(a.getCallId()), Long.valueOf(a.getRegistrationId()), Long.valueOf(a.getId().substring(0, a.getId().indexOf('-'))), (a.getId().contains("-") ? Long.parseLong(a.getId().substring(a.getId().indexOf("-")) + 1) : 0L))
			).collect(Collectors.toList());
			
			masterPreparedStatementSetter.setListLocalEntities(applications);

			this.LOGGER.info("COMMITTING FROM [{}] TO [{}]", i, end);
			long startTime = System.currentTimeMillis();
			
			try {
				jdbcTemplate.batchUpdate(this.INSERT_TEMPLATE, masterPreparedStatementSetter);
				
			} catch (DataAccessException e) {
				if (pageSize == 1) {
					ApplicationSQLite localEntity = tempList.get(0);
					this.LOGGER.info("ERROS ID[{}]  CallId[{}] RegistrationId[{}]", localEntity.getId(), localEntity.getCallId(), localEntity.getRegistrationId());
					
				} else {
					this.LOGGER.error("Error inserting a page", e);
					this.commitToDB(tempList, 1);
					
				}

			} catch (Exception e) {
				this.LOGGER.error("Error inserting a page", e);

			}
			
			this.LOGGER.info("   IT TOOK [{}]ms", System.currentTimeMillis() - startTime);
		}
	}
}