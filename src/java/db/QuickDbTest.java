package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class QuickDbTest {

  static private BasicDataSource datasource = null;

  public static List<String> getNames() {
    Connection conn = null;
    if (datasource == null) {
      datasource = new BasicDataSource();
      datasource.setDriverClassName("oracle.jdbc.OracleDriver");
      datasource.setUsername("lam");
      datasource.setPassword("lam");
      datasource.setUrl("jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat");
      datasource.setInitialSize(10);
    }
    List<String> names = new ArrayList();
    try {
      conn = datasource.getConnection();
      try (Statement s = conn.createStatement(); ResultSet rs = s.executeQuery("select name from names")) {
        while (rs.next()) {
          names.add(rs.getString(1));
        }
      }
    } catch (SQLException e) {
      System.out.println("Could not get names: " + e.getMessage());
    } finally {
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
        Logger.getLogger(QuickDbTest.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return names;
  }
}
