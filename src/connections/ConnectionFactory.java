package connections;

import java.sql.Connection;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.SQLException;

public class ConnectionFactory {
    private final DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mariadb://localhost:3306/hotel_alura");
        cpds.setUser("root");
        cpds.setPassword("admin");
        cpds.setMaxPoolSize(10);
        this.dataSource = cpds;
    }

    public Connection getConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
