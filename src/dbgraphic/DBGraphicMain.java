package dbgraphic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBGraphicMain {

  public static void main(String[] args){
    // TODO Auto-generated method stub
    DBGraphicFrameSystem frame = null;
    MySQL mysql = new MySQL();
    ResultSet rs = mysql.selectAll();
    int rowLength = mysql.getRowLength();
    Object[][] data = new Object[rowLength][5];
    
    try {
      int i = 0;
      while(rs.next()){
        data[i][0] = rs.getDate("Date");
        data[i][1] = rs.getDouble("Opening Price");
        data[i][2] = rs.getDouble("High Price");
        data[i][3] = rs.getDouble("Low Price");
        data[i][4] = rs.getDouble("Closing Price");
        /*
          System.out.print(data[i][0] + ",");
          System.out.print(data[i][1] + ",");
          System.out.print(data[i][2] + ",");
          System.out.print(data[i][3] + ",");
          System.out.println(data[i][4]);
        */
        i++;
      }
      frame = new DBGraphicFrameSystem(data);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    frame.setBounds(10, 10, 800, 600);
    frame.setVisible(true);
  }

}
