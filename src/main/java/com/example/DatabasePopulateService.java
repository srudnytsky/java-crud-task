package com.example;

import com.example.utils.FileUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {

        String sql =
                FileUtils.readFile("sql/populate_db.sql");

        Connection connection =
                Database.getInstance()
                        .getConnection();

        try (
                Statement statement =
                        connection.createStatement()
        ) {

            statement.execute(sql);

            System.out.println(
                    "Database populated"
            );

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
