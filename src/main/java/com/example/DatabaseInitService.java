package com.example;

import com.example.utils.FileUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {

        String sql =
                FileUtils.readFile("sql/init_db.sql");

        Connection connection =
                Database.getInstance()
                        .getConnection();

        try (
                Statement statement =
                        connection.createStatement()
        ) {

            statement.execute(sql);

            System.out.println(
                    "Database initialized"
            );

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
