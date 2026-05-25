package com.example;

import org.flywaydb.core.Flyway;

public class FlywayConfig {
    public static void migrate() {

        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:h2:./test",
                        "",
                        ""
                )
                .load();

        flyway.migrate();
    }
}
