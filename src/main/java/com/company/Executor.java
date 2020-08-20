package com.company;

import com.company.logic.Database;

import java.io.IOException;
import java.sql.SQLException;

public class Executor {
    public void run() throws IOException, SQLException {
        new Database().dropDB();
    }
}
