package dbgraphic;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_View extends Frame implements ActionListener, WindowListener{
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public Graph_View(){
    setTitle("Graph");
    ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
    DefaultCategoryDataset data = new DefaultCategoryDataset();
    data.addValue(300, "米国", "2005年");
    data.addValue(500, "米国", "2006年");
    data.addValue(120, "米国", "2007年");
    data.addValue(200, "中国", "2005年");
    data.addValue(400, "中国", "2006年");
    data.addValue(320, "中国", "2007年");
    JFreeChart chart = 
      ChartFactory.createLineChart("Import Volume 輸入量",
                                   "Year 年度",
                                   "Ton トン(t)",
                                   data,
                                   PlotOrientation.VERTICAL,
                                   true,
                                   false,
                                   false);
    LegendTitle legend = chart.getLegend();
    legend.setItemFont(new Font("メイリオ",Font.PLAIN, 18));
    ChartPanel cpanel = new ChartPanel(chart);
    add(cpanel, BorderLayout.CENTER);
    
    addWindowListener(this);
    

  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowActivated(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowClosed(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowClosing(WindowEvent arg0) {
    // TODO Auto-generated method stub
    System.exit(0);
  }

  @Override
  public void windowDeactivated(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowDeiconified(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowIconified(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowOpened(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }
  
}
