package connections;

import java.sql.Connection;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.SQLException;

/**
 * Class ConnectionFactory
 * this class is used to create a connection pool
 * 
 * @version 1.0
 * @since 1.0
 * 
 * @author JuanObandoDev
 */
public class ConnectionFactory {
    private final DataSource dataSource;

    /**
     * Constructor method that creates a new connection pool
     */
    public ConnectionFactory() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mariadb://localhost:3306/hotel_alura");
        cpds.setUser("root");
        cpds.setPassword("admin");
        cpds.setMaxPoolSize(10);
        this.dataSource = cpds;
    }

    /**
     * Method that returns a connection from the pool
     * 
     * @return Connection conn
     */
    public Connection getConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
