//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/*public class DatabaseConnectionPool {
    private static DatabaseConnectionPool instance;
    ///private HikariDataSource dataSource;

    // Private constructor to enforce Singleton
    private DatabaseConnectionPool() {
        *//*HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/your_database");
        config.setUsername("your_username");
        config.setPassword("your_password");
        config.setMaximumPoolSize(10); // Maximum number of connections
        config.setMinimumIdle(2); // Minimum idle connections
        config.setIdleTimeout(30000); // Idle timeout in milliseconds
        config.setMaxLifetime(1800000); // Connection max lifetime
        config.setConnectionTimeout(30000); // Timeout for getting a connection

        dataSource = new HikariDataSource(config);*//*
    }

    // Thread-safe Singleton instance
    public static synchronized DatabaseConnectionPool getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionPool();
        }
        return instance;
    }

    // Method to get a database connection
    *//*public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }*//*

    // Close the DataSource when the application shuts down
    *//*public void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }*//*

    *//*public static void main(String[] args) {
        try {
            DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            System.out.println("Database connection established!");

            // Use the connection (Don't forget to close it)
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*//*
}*/
