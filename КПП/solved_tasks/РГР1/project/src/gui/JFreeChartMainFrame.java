package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class JFreeChartMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldA;
	private XYSeries series;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFreeChartMainFrame frame = new JFreeChartMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFreeChartMainFrame() {
		setResizable(false);
		setTitle("fFreeChart Test Plot");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setHgap(15);
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnNewButtonPlot = new JButton("Plot");
		btnNewButtonPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double start = -9.0;
				double stop = 9.0;
				double step = 0.01;
				double a = 0;
				
				a = Double.parseDouble(textFieldA.getText());
				series.clear();
				for (double x = start; x < stop; x += step) {
					series.add(x, f(a, x));
				}				
			}
		});
		panelButtons.add(btnNewButtonPlot);
		
		JButton btnNewButtonExit = new JButton("Exit");
		btnNewButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelButtons.add(btnNewButtonExit);
		
		JPanel panelData = new JPanel();
		contentPane.add(panelData, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("a:");
		panelData.add(lblNewLabel);
		
		textFieldA = new JTextField();
		textFieldA.setText("1.0");
		panelData.add(textFieldA);
		textFieldA.setColumns(10);
		
		JFreeChart chart = createChart();
		ChartPanel chartPanel = new ChartPanel(chart);
		contentPane.add(chartPanel, BorderLayout.CENTER);		
	}
	
	private double f(double a, double x) {
		return Math.sin(a*x)/x;
	}
	
	private JFreeChart createChart() {
		series = new XYSeries("Function");
		
		double start = -9.0;
		double stop = 9.0;
		double step = 0.01;
		double a = 0;
		
		a = Double.parseDouble(textFieldA.getText());
		
		for (double x = start; x < stop; x += step) {
			series.add(x, f(a, x));
		}
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart("y = sin(a x)/x", //chart title
				"X", //x axis label
				"Y", //y axis label
				dataset, //data
				PlotOrientation.VERTICAL, true, //include lege
				true, //tooltips
				true //urls
		);
		//CUSTOMIZATION
		chart.setBackgroundPaint(Color.white);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainGridlinePaint(Color.white);
		
		return chart;		
	}
}
