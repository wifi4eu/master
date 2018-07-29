package wifi4eu.wifi4eu.apply;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;


public class LocalDB {

    private Connection db;

    private final String insertSQL = "INSERT INTO applications (redis_id, r, u, m, ip, data) VALUES (?,?,?,?,?,?)";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LocalDB() throws Exception {

        Class.forName("org.sqlite.JDBC");

        logger.info("Setting up local DB {}", Config.getEnvironment("wifi4eu.localdb.uri"));

        db = DriverManager.getConnection(Config.getEnvironment("wifi4eu.localdb.uri"));

        bootstrapSchema();
    }

    ///
    /// Initialise table(s) if they don't exist
    ///
    private void bootstrapSchema() throws Exception {
        logger.info("[I] bootstrapSchema");

        String sql = Util.getResource("/static/dbschema.sql");

        Statement st = db.createStatement();
        st.executeUpdate(sql);

        logger.info("[F] bootstrapSchema");
    }

    public int countApplications() throws Exception {
        logger.info("[I] countApplications");
        int count = 0;

        String sql = "SELECT count(*) AS total FROM applications";
        Statement st = db.createStatement();

        ResultSet r = st.executeQuery(sql);

        if (r != null) {
            count = r.getInt("total");
        } else {
            logger.error("countApplications: Query error");
        }

        logger.info("[F] countApplications");
        return count;
    }

    ///
    /// Persist a redis message to local DB
    ///
    public void saveMessage(Application app) throws SQLException {

        PreparedStatement ps = db.prepareStatement(insertSQL);

        ps.setString(1, app.redis_id);
        ps.setString(2, app.r);
        ps.setString(3, app.u);
        ps.setString(4, app.m);
        ps.setString(5, app.ip);
        ps.setString(6, app.data);

        ps.executeUpdate();

    }
}
