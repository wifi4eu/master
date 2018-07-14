package wifi4eu.wifi4eu.apply;


import io.lettuce.core.StreamMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.InputStream;
import java.sql.*;


public class LocalDB {

    private Connection db;

    private final String insertSQL = "INSERT INTO applications (id, r, u, m, ip, ecas, data) VALUES (?,?,?,?,?,?,?)";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LocalDB() throws Exception {

        Class.forName("org.sqlite.JDBC");

        logger.info("Setting up local DB {}", Config.getEnvironment("wifi4eu.localdb.uri"));

        db = DriverManager.getConnection(Config.getEnvironment("wifi4eu.localdb.uri"));

        //bootstrapSchema();
    }

    private void bootstrapSchema() throws Exception {

        String sql = Util.getResource("/static/dbschema.sql");

        Statement st = db.createStatement();
        st.executeUpdate(sql);
    }

    public void saveMessage(Application app) throws SQLException {

        PreparedStatement ps = db.prepareStatement(insertSQL);

        ps.setString(1, app.id);
        ps.setString(2, app.r);
        ps.setString(3, app.u);
        ps.setString(4, app.m);
        ps.setString(5, app.ip);
        ps.setString(6, app.ecas);
        ps.setString(7, app.data);

        ps.executeUpdate();

    }
}
