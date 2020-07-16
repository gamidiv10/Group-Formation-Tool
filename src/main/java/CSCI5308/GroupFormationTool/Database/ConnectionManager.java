package CSCI5308.GroupFormationTool.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import CSCI5308.GroupFormationTool.SystemConfig;

// Singleton for retrieving connections.
public class ConnectionManager {
    private Logger log = Logger.getLogger(ConnectionManager.class.getName());
    private static ConnectionManager uniqueInstance = null;

    private String dbURL;
    private String dbUserName;
    private String dbPassword;

    public ConnectionManager() {
        IDatabaseConfiguration config = SystemConfig.instance().getDatabaseConfiguration();
        dbURL = config.getDatabaseURL();
        dbUserName = config.getDatabaseUserName();
        dbPassword = config.getDatabasePassword();
    }

    public static ConnectionManager instance() {
        if (null == uniqueInstance) {
            uniqueInstance = new ConnectionManager();
        }
        return uniqueInstance;
    }

    public Connection getDBConnection() throws SQLException {
        log.log(Level.WARNING, "Getting the connection: " + dbURL + ", might throw SQL Exception");
        return DriverManager.getConnection(dbURL, dbUserName, dbPassword);
    }
}
