package CSCI5308.GroupFormationTool.Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CallStoredProcedure {
    private Logger log = Logger.getLogger(CallStoredProcedure.class.getName());
    private String storedProcedureName;
    private Connection connection;
    private CallableStatement statement;

    public CallStoredProcedure(String storedProcedureName) throws SQLException {
        this.storedProcedureName = storedProcedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement();
    }

    private void createStatement() throws SQLException {
        statement = connection.prepareCall("{call " + storedProcedureName + "}");
    }

    private void openConnection() throws SQLException {
        connection = ConnectionManager.instance().getDBConnection();
        log.log(Level.INFO, "Connection Opened: " + connection);
    }

    public void cleanup() {
        try {
            if (null != statement) {
                statement.close();
            }
            if (null != connection) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Encountered SQL Exception while closing the connection");
        }
    }

    public void setParameter(int paramIndex, String value) throws SQLException {
        log.log(Level.WARNING, "Setting the parameter, Might throw SQL Exception");
        statement.setString(paramIndex, value);
    }

    public void registerOutputParameterString(int paramIndex) throws SQLException {
        log.log(Level.WARNING, "Registering the out parameter, Might throw SQL Exception");
        statement.registerOutParameter(paramIndex, java.sql.Types.VARCHAR);
    }

    public void setParameter(int paramIndex, long value) throws SQLException {
        log.log(Level.WARNING, "Setting the parameter, Might throw SQL Exception");
        statement.setLong(paramIndex, value);
    }

    public void registerOutputParameterLong(int paramIndex) throws SQLException {
        log.log(Level.WARNING, "Registering the out parameter, Might throw SQL Exception");
        statement.registerOutParameter(paramIndex, java.sql.Types.BIGINT);
    }

    public ResultSet executeWithResults() throws SQLException {
        if (statement.execute()) {
            log.log(Level.WARNING, "Returning result set from DB, Might throw SQL Exception");
            return statement.getResultSet();
        }
        return null;
    }

    public void execute() throws SQLException {
        log.log(Level.WARNING, "Executing the SQL statement, Might throw SQL Exception");
        statement.execute();
    }

}
