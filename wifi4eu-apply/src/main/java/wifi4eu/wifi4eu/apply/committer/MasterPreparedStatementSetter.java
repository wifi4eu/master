package wifi4eu.wifi4eu.apply.committer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import wifi4eu.wifi4eu.apply.masterEntity.ApplicationSQLServer;

public class MasterPreparedStatementSetter implements BatchPreparedStatementSetter {
		
	List<ApplicationSQLServer> listLocalEntities;

	public List<ApplicationSQLServer> getListLocalEntities() {
		return listLocalEntities;
	}

	public void setListLocalEntities(List<ApplicationSQLServer> listApplications) {
		this.listLocalEntities = listApplications;
	}

	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
		ps.setLong(1, this.getListLocalEntities().get(i).getCallId());
		ps.setLong(2, this.getListLocalEntities().get(i).getRegistrationId());
		ps.setLong(3, this.getListLocalEntities().get(i).getDate());
	}

	@Override
	public int getBatchSize() {
		return listLocalEntities.size();

	}
}
