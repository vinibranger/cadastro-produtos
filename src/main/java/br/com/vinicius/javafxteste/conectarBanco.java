
package br.com.vinicius.javafxteste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectarBanco {
    
  static Connection getConnection() throws SQLException {
        return DriverManager.getConnection( //
                "jdbc:mysql://localhost:3306/produtojavafx", //
                "root", //
                "");
    }
    
}
