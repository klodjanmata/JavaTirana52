package CarRentalSystem.dbConnection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection dbConnection(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/carrentalsystem");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
