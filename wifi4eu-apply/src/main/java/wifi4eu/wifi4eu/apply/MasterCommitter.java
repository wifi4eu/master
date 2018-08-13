package wifi4eu.wifi4eu.apply;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.apply.localEntity.LocalEntity;
import wifi4eu.wifi4eu.apply.localEntity.LocalRepository;


@Service
public class MasterCommitter {
	
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

		localEntities.addAll(this.localRep.findAll());
		
		//localEntities.addAll(this.createValidEntities(100_000));
		//localEntities.addAll(this.createInvalidEntities(1));
		this.LOGGER.info("Entities Found: [{}]", localEntities.size());
		
		MasterPreparedStatementSetter masterPreparedStatementSetter = new MasterPreparedStatementSetter();
		masterPreparedStatementSetter.setListLocalEntities(localEntities);
		
		long start = System.currentTimeMillis();
		
		try {
			this.LOGGER.info("COMMITTING TO MASTER DATABASE");
			jdbcTemplate.batchUpdate(this.INSERT_TEMPLATE, masterPreparedStatementSetter);
			
		} catch (DataAccessException e) {
			this.LOGGER.error("Error", e);
			
		}
		
		long totalTime = System.currentTimeMillis() - start;
		
		this.LOGGER.info("QTY ENTITIES: [{}], TOTAL TIME: [{}]ms", localEntities.size(), totalTime);
		this.LOGGER.info("COMMIT FINISHED");
		
	}

	private List<LocalEntity> createValidEntities(int quantity) {
		List<LocalEntity> listResult = new ArrayList<>();
		Date date = new Date();
		
		for (int i = 0; i < quantity; i++) {
			LocalEntity localEntity = new LocalEntity();
			localEntity.setCallId(/*1000 + i*/ 1);
			localEntity.setRegistrationId(/*1000_000 + i*/ 1254);
			localEntity.setDate(date);
			
			listResult.add(localEntity);
		}
		
		return listResult;
	}
	
	private List<LocalEntity> createInvalidEntities(int quantity) {
		List<LocalEntity> listResult = new ArrayList<>();
		Date date = new Date();
		
		for (int i = 0; i < quantity; i++) {
			LocalEntity localEntity = new LocalEntity();
			localEntity.setCallId(999);
			localEntity.setRegistrationId(/*1000_000 + i*/ 1254);
			localEntity.setDate(date);
			
			listResult.add(localEntity);
		}
		
		return listResult;
	}
	
	
	class MasterPreparedStatementSetter implements BatchPreparedStatementSetter {
		
		List<LocalEntity> listLocalEntities;

		public List<LocalEntity> getListLocalEntities() {
			return listLocalEntities;
		}

		public void setListLocalEntities(List<LocalEntity> listLocalEntities) {
			this.listLocalEntities = listLocalEntities;
		}

		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			ps.setLong(1, this.getListLocalEntities().get(i).getCallId());
			ps.setLong(2, this.getListLocalEntities().get(i).getRegistrationId());
			ps.setLong(3, this.getListLocalEntities().get(i).getDate().getTime());
			
		}

		@Override
		public int getBatchSize() {
			return listLocalEntities.size();

		}
	}
}






