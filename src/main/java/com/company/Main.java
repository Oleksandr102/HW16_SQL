package com.company;

import com.company.logic.Database;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    @lombok.SneakyThrows
    public static void main(String[] args) {
        new Executor().run();
    }

}
