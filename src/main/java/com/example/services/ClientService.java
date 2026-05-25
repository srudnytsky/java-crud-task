package com.example.services;

import com.example.Database;
import com.example.dto.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private final Connection connection =
            Database.getInstance().getConnection();

    public long create(String name) {

        validateName(name);

        String sql =
                "INSERT INTO client(name) VALUES (?)";

        try (
                PreparedStatement ps =
                        connection.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            ps.setString(1, name);

            ps.executeUpdate();

            ResultSet rs =
                    ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getLong(1);
            }

            throw new RuntimeException(
                    "Cannot get generated ID"
            );

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public String getById(long id) {

        validateId(id);

        String sql =
                "SELECT name FROM client WHERE id = ?";

        try (
                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setLong(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {
                return rs.getString("name");
            }

            throw new RuntimeException(
                    "Client not found"
            );

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void setName(long id, String name) {

        validateId(id);
        validateName(name);

        String sql =
                "UPDATE client SET name = ? WHERE id = ?";

        try (
                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setLong(2, id);

            int updatedRows =
                    ps.executeUpdate();

            if (updatedRows == 0) {

                throw new RuntimeException(
                        "Client not found"
                );
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) {

        validateId(id);

        String sql =
                "DELETE FROM client WHERE id = ?";

        try (
                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setLong(1, id);

            int deletedRows =
                    ps.executeUpdate();

            if (deletedRows == 0) {

                throw new RuntimeException(
                        "Client not found"
                );
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public List<Client> listAll() {

        String sql =
                "SELECT id, name FROM client";

        List<Client> result =
                new ArrayList<>();

        try (
                Statement statement =
                        connection.createStatement();

                ResultSet rs =
                        statement.executeQuery(sql)
        ) {

            while (rs.next()) {

                result.add(
                        new Client(
                                rs.getLong("id"),
                                rs.getString("name")
                        )
                );
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return result;
    }

    private void validateName(String name) {

        if (name == null ||
                name.trim().isEmpty() ||
                name.length() < 2 ||
                name.length() > 100) {

            throw new IllegalArgumentException(
                    "Invalid client name"
            );
        }
    }

    private void validateId(long id) {

        if (id <= 0) {

            throw new IllegalArgumentException(
                    "Invalid client id"
            );
        }
    }
}
