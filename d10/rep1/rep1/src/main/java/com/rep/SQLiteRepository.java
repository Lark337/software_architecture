package com.rep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class SQLiteRepository implements PhoneRepository {
        private Connection connection;

    public SQLiteRepository(String connectionString) {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS phones (" +
                    "id INTEGER PRIMARY KEY," +
                    "name TEXT," +
                    "brand TEXT,"+
                    "details TEXT,"+
                    "price REAL)";
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Phone getById(int id) {
        Phone phone = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM phones WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int phoneId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String brand = resultSet.getString("brand");
                String details = resultSet.getString("details");
                double price = resultSet.getDouble("price");
                phone = new Phone(phoneId, name, brand, details , price);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phone;
    }

    @Override
    public List<Phone> getAll() {
        List<Phone> phones = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM phones");

            while (resultSet.next()) {
                int phoneId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String brand = resultSet.getString("brand");
                String details = resultSet.getString("details");
                double price = resultSet.getDouble("price");
                Phone phone = new Phone(phoneId, name, brand, details , price);
                phones.add(phone);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phones;
    }

    @Override
    public void add(Phone phone) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO phones (name, brand, details, price) VALUES (?, ?, ?, ?)");
            statement.setString(1, phone.getName());
            statement.setString(2, phone.getBrand());
            statement.setString(3, phone.getDetails());
            statement.setDouble(4, phone.getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Phone phone) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE phones SET name = ?,brand = ?, details = ?, price = ? WHERE id = ?");
            statement.setString(1, phone.getName());
            statement.setString(2, phone.getBrand());
            statement.setString(3, phone.getDetails());
            statement.setDouble(4, phone.getPrice());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM phones WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
