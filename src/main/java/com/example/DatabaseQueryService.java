package com.example;

import com.example.dto.*;
import com.example.utils.FileUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class DatabaseQueryService {

    private final Connection connection =
            Database.getInstance().getConnection();

    public List<MaxProjectCountClient> findMaxProjectsClient() {

        String sql = FileUtils.readFile(
                "sql/find_max_projects_client.sql"
        );

        List<MaxProjectCountClient> result =
                new ArrayList<>();

        try (
                Statement statement =
                        connection.createStatement();
                ResultSet rs =
                        statement.executeQuery(sql)
        ) {

            while (rs.next()) {

                result.add(
                        new MaxProjectCountClient(
                                rs.getString("name"),
                                rs.getInt("project_count")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<LongestProject> findLongestProject() {

        String sql = FileUtils.readFile(
                "sql/find_longest_project.sql"
        );

        List<LongestProject> result =
                new ArrayList<>();

        try (
                Statement statement =
                        connection.createStatement();
                ResultSet rs =
                        statement.executeQuery(sql)
        ) {

            while (rs.next()) {

                result.add(
                        new LongestProject(
                                rs.getLong("id"),
                                rs.getInt("month_count")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {

        String sql = FileUtils.readFile(
                "sql/find_max_salary_worker.sql"
        );

        List<MaxSalaryWorker> result =
                new ArrayList<>();

        try (
                Statement statement =
                        connection.createStatement();
                ResultSet rs =
                        statement.executeQuery(sql)
        ) {

            while (rs.next()) {

                result.add(
                        new MaxSalaryWorker(
                                rs.getString("name"),
                                rs.getInt("salary")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() {

        String sql = FileUtils.readFile(
                "sql/find_youngest_eldest_workers.sql"
        );

        List<YoungestEldestWorker> result =
                new ArrayList<>();

        try (
                Statement statement =
                        connection.createStatement();
                ResultSet rs =
                        statement.executeQuery(sql)
        ) {

            while (rs.next()) {

                result.add(
                        new YoungestEldestWorker(
                                rs.getString("type"),
                                rs.getString("name"),
                                rs.getDate("birthday").toLocalDate()
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public List<ProjectPrice> printProjectPrices() {

        String sql = FileUtils.readFile(
                "sql/print_project_prices.sql"
        );

        List<ProjectPrice> result =
                new ArrayList<>();

        try (
                Statement statement =
                        connection.createStatement();
                ResultSet rs =
                        statement.executeQuery(sql)
        ) {

            while (rs.next()) {

                result.add(
                        new ProjectPrice(
                                rs.getLong("project_id"),
                                rs.getLong("price")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}