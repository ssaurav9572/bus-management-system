// BusDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusDAO {
    private Connection connection;

    public BusDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBus(String name, int capacity) throws SQLException {
        String sql = "INSERT INTO bus (name, capacity) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, capacity);
            statement.executeUpdate();
        }
    }
}
