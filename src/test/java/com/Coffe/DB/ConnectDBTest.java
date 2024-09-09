package com.Coffe.DB;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectDBTest {

    @Test
    void getConnection() {
        ConnectDB connectDB = new ConnectDB();
        connectDB.getConnection();
        connectDB.closeConnection();
    }

    @Test
    void closeConnection() {
        ConnectDB connectDB = new ConnectDB();
        connectDB.getConnection();
        connectDB.closeConnection();
    }
}