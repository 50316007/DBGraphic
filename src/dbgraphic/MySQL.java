package dbgraphic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
  //JDBCドライバの登録
  private String driver;
  // データベースの指定
  private String server, dbname, url, user, password;
  private Connection con;
  private Statement stmt;
  private ResultSet rs;
  private int rowLength = 0;
  
  public MySQL() {
    this.driver = "org.gjt.mm.mysql.Driver";
    this.server = "j11000.sangi01.net";
    this.dbname = "50316007";
    this.url = "jdbc:mysql://" + server + "/" + dbname + "?useUnicode=true&characterEncoding=UTF-8";
    this.user = "50316007";
    this.password = "50316007";
    try {
      this.con = DriverManager.getConnection(url, user, password);
      this.stmt = con.createStatement();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void close(){
    try {
      rs.close();
      stmt.close();
      con.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
  
  public ResultSet selectAll(){
    String sql = "SELECT * FROM USDJPY";
    ResultSet rs = null;
    try {
      rs = stmt.executeQuery (sql);
      rs.last();
      rowLength = rs.getRow();
      rs.beforeFirst();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }  //try catchで
    return rs;
  }
  
  public int getRowLength(){
    return this.rowLength;
  }
}
