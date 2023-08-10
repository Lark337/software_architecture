package d5;

// Data Mapper

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class UserMapper  {

    private Connection dbase;
    
    public void insert(int id, User user) throws SQLException {
        String sql = String.format("INSERT INTO students (id, name, phoneNumber) VALUES (%d, '%s', '%d')", id, user.getName(), user.getPhoneNumber());
        Statement statement = dbase.createStatement();
        statement.execute(sql);
    }

    public void update(int id, User user) throws SQLException {
        String sql = String.format("UPDATE students SET name = '%s', phoneNumber = '%d' WHERE id = %d", user.getName(), user.getPhoneNumber(), id);
        Statement statement = dbase.createStatement();
        statement.execute(sql);
    }

    public void delete(int id) throws SQLException {
        String sql = String.format("DELETE FROM students WHERE id = %d", id);
        Statement statement = dbase.createStatement();
        statement.execute(sql);
    }
    
}
