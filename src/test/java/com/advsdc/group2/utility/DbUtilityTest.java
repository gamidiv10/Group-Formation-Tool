package com.advsdc.group2.utility;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DbUtilityTest {
    @Test
    public void DbUtilityTest(){
        DbUtility dbUtility = new DbUtility();
        assertNotNull(dbUtility.connection);
    }

    // @Test
    // public void getUsersTest(){
    //     DbUtility dbUtility = new DbUtility();
    //     assertNotNull(dbUtility.getUsers());
    // }
    @Test
    public void closeConnectionTest(){
        DbUtility dbUtility = new DbUtility();
        dbUtility.closeConnection();
        try {
            assertTrue(dbUtility.connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
