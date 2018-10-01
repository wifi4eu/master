package wifi4eu.wifi4eu.apply;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalDB {

	private static final Logger LOG = LoggerFactory.getLogger(LocalDB.class);

	private static final String JDBC_DRIVER_CLASS = "org.sqlite.JDBC";

	private static final String JDBC_SCHEMA = "/static/dbschema.sql";

	private static final String SQL_INSERT_APPLICATION = "INSERT INTO applications (redis_id, r, u, m, ip, data, call_id) VALUES (?,?,?,?,?,?,?)";
	private static final String SQL_SELECT_APPLICATIONS = "SELECT count(*) AS total FROM applications";

	private Connection db;

	public LocalDB() throws SQLException, ClassNotFoundException, IOException {
		Class.forName(JDBC_DRIVER_CLASS);
		LOG.info("Setting up local DB {}", Config.getEnvironment("wifi4eu.localdb.uri"));
		db = DriverManager.getConnection(Config.getEnvironment("wifi4eu.localdb.uri"));
		bootstrapSchema();
	}

	///
	/// Initialise table(s) if they don't exist
	///
	private void bootstrapSchema() throws SQLException, IOException {
		LOG.info("[I] bootstrapSchema");

		String sql = Util.getResource(JDBC_SCHEMA);
		LOG.info("Creating the schema...");
		LOG.info(sql);

		try (Statement st = db.createStatement()) {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			LOG.error("Error creating the schema");
			throw e;
		}

		LOG.info("[F] bootstrapSchema");
	}

	public int countApplications() throws SQLException {
		LOG.info("[I] countApplications");

		int count = 0;
		try (Statement st = db.createStatement(); ResultSet r = st.executeQuery(SQL_SELECT_APPLICATIONS)) {
			if (r != null) {
				count = r.getInt("total");
			} else {
				LOG.error("countApplications: Query error");
			}
		} catch (SQLException e) {
			LOG.error("Error counting the applications from the database");
			throw e;
		}

		LOG.info("[F] countApplications");
		return count;
	}

	///
	/// Persist a redis message to local DB
	///
	public void saveMessage(Application app) throws SQLException {

		try (PreparedStatement ps = db.prepareStatement(SQL_INSERT_APPLICATION)) {
			ps.setString(1, app.redis_id);
			ps.setString(2, app.r);
			ps.setString(3, app.u);
			ps.setString(4, app.m);
			ps.setString(5, app.ip);
			ps.setString(6, app.data);
			ps.setInt(7, 1);

			ps.executeUpdate();
		} catch (SQLException e) {
			LOG.error("Error inserting a new application into the database");
			throw e;
		}
	}
}
