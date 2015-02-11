package dbgraphic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.xy.DefaultHighLowDataset;

public class DBGraphicFrameSystem extends JFrame implements ActionListener, WindowListener{

  private static final long serialVersionUID = 1L;
  private Object[] columnNames = {
      "Date", "Opening Price", "High Price", "Low Price", "Closing Price"
  };
  
  private JPanel basePanel = new JPanel();
  private JPanel mainPanel = new JPanel();
  
  private JPanel northPanel = new JPanel();
  private JButton button1 = new JButton("Close");
  private JButton button2 = new JButton("Show table");
  private JButton button3 = new JButton("Show graph");
  private JPanel centerPanel = new JPanel();
  private CardLayout layout = new CardLayout();
  private DefaultTableModel tablemodel = new DefaultTableModel(columnNames, 0);
  private JTable table = new JTable(tablemodel);
  private JScrollPane sp = new JScrollPane(table);
  private JPanel tablePanel = new JPanel();
  private ChartPanel chart;
  
  public DBGraphicFrameSystem(Object[][] obj){
    table.setName("USD / JPY by month from April 2007 to February 2015");
    setData2Table(obj);
    ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
    Date[] date = new Date[obj.length];
    double[] open = new double[obj.length];
    double[] high = new double[obj.length];
    double[] low = new double[obj.length];
    double[] close = new double[obj.length];
    double[] volume = new double[obj.length];
    for(int i = 0; i < obj.length; i++){
      date[i] = (Date)obj[i][0];
      open[i] = (double)obj[i][1];
      high[i] = (double)obj[i][2];
      low[i] = (double)obj[i][3];
      close[i] = (double)obj[i][4];
      volume[i] = 30.0d;
    }
    
    DefaultHighLowDataset data = new DefaultHighLowDataset("USD / JPY",
                                                            date,
                                                            high,
                                                            low,
                                                            open,
                                                            close,
                                                            volume);
    
    JFreeChart chart = 
        ChartFactory.createHighLowChart("USD / JPY by month from April 2007 to February 2015",
                                     "Yeah",
                                     "Price",
                                     data,
                                     true);
    this.chart = new ChartPanel(chart);
    
    setTitle("DBGraphic");
    basePanel.setLayout(new GridLayout(1,0));
    mainPanel.setLayout(new BorderLayout());
    northPanel.setLayout(new FlowLayout());
    centerPanel.setLayout(layout);
    
    add(basePanel);
    basePanel.add(mainPanel);
    mainPanel.add(northPanel, BorderLayout.NORTH);
    northPanel.add(button2);
    northPanel.add(button3);
    northPanel.add(button1);
    mainPanel.add(centerPanel, BorderLayout.CENTER);
    tablePanel.setLayout(new BoxLayout(tablePanel,BoxLayout.Y_AXIS));
    JLabel label = new JLabel("USD / JPY by month from April 2007 to February 2015");
    label.setAlignmentX(CENTER_ALIGNMENT);
    tablePanel.add(label);
    tablePanel.add(sp);
    centerPanel.add("b1", tablePanel);
    centerPanel.add("b2", this.chart);
    layout.show(centerPanel, "b1");
    
    addWindowListener(this);
    button1.addActionListener(this);
    button2.addActionListener(this);
    button3.addActionListener(this);
  }
  
  public void setData2Table(Object[][] obj){
    int i = 0;
    for(i = 0; i < obj.length; i++){
      tablemodel.addRow(obj[i]);
    }
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    if(arg0.getSource() == button1){
      System.exit(0);
    }else if(arg0.getSource() == button2){
      layout.show(centerPanel, "b1");
    }else if(arg0.getSource() == button3){
      layout.show(centerPanel, "b2");
    }
  }

  @Override
  public void windowActivated(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void windowClosed(WindowEvent arg0) {
    // TODO Auto-generated method stub
    System.exit(0);
  }

  @Override
  public void windowClosing(WindowEvent arg0) {
    // TODO Auto-generated method stub
    
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
