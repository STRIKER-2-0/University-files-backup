package expantion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class FunctionFrame extends JFrame {

		private static final long serialVersionUID = 1L;
		private AnalyticFunction f;
		private JPanel contentPane;
		
		private JPanel headPanel;
		private JLabel functionLabel;
		private JLabel variableLabel;
		private JLabel parameterLabel;
		private JLabel parameterValueLabel;
		private JTextField functionTextField;
		private JTextField variableTextField;
		private JTextField parameterTextField;
		private JTextField parameterValueTextField;
		
		private XYSeries function;
		private XYSeries deritative;
		
		private JPanel panelButtons;
		private JButton plot;
		private JButton exit;
		private double start = -9.0;
		private double stop = 9.0;
		private double step = 0.01;
		private JLabel startLabel; 
		private JLabel stopLabel; 
		private JLabel stepLabel; 
		private JTextField startTextField; 
		private JTextField stopTextField; 
		private JTextField stepTextField; 
		
		private JFreeChart chart;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FunctionFrame frame = new FunctionFrame();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		public FunctionFrame() {
			setResizable(false);
			setTitle("Function Frame");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(150, 150, 550, 550);
			contentPane = new JPanel();
			contentPane.setLayout(new BorderLayout());
			setContentPane(contentPane);
			
			panelButtons = new JPanel();
			contentPane.add(panelButtons, BorderLayout.SOUTH);
			
			plot = new JButton("Plot");
			plot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(parameterTextField.getText().equals(""))
						f = new AnalyticFunction(functionTextField.getText(), variableTextField.getText());
					else { 
						f = new AnalyticFunction(functionTextField.getText(), variableTextField.getText(), parameterTextField.getText());
						if(!parameterValueTextField.getText().equals("")) {
							f.setParameterValue(Double.parseDouble(parameterValueTextField.getText()));
						}
					}
					start = Double.parseDouble(startTextField.getText());
					stop = Double.parseDouble(stopTextField.getText());
					step = Double.parseDouble(stepTextField.getText());
					
					function.clear();
					deritative.clear();
					for (double x = start; x < stop; x += step) {
						function.add(x, f.evalf(x));
						deritative.add(x, f.deritative().evalf(x));
					}
					
					((XYPlot)chart.getPlot()).getDomainAxis().setRangeAboutValue(0, 10);
					((XYPlot)chart.getPlot()).getRangeAxis().setRangeAboutValue(0, 10);
				}
			});
			panelButtons.add(plot);
			
			exit = new JButton("Exit");
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			panelButtons.add(exit);
			
			startLabel = new JLabel("start:");
			panelButtons.add(startLabel);
			startTextField = new JTextField(Double.toString(start)); 
			startTextField.setColumns(5);
			startTextField.addKeyListener(new EnterListener());
			panelButtons.add(startTextField);
			
			stopLabel = new JLabel("stop:");
			panelButtons.add(stopLabel);
			stopTextField = new JTextField(Double.toString(stop)); 
			stopTextField.setColumns(5);
			stopTextField.addKeyListener(new EnterListener());
			panelButtons.add(stopTextField);
			
			stepLabel = new JLabel("step:");
			panelButtons.add(stepLabel);
			stepTextField = new JTextField(Double.toString(step)); 
			stepTextField.setColumns(5);
			stepTextField.addKeyListener(new EnterListener());
			panelButtons.add(stepTextField);
			
			headPanel = new JPanel();
						
			functionLabel = new JLabel("Function: ");
			headPanel.add(functionLabel);
			functionTextField = new JTextField("x^2");
			functionTextField.setColumns(12);
			functionTextField.addKeyListener(new EnterListener());
			headPanel.add(functionTextField);
			
			variableLabel = new JLabel("Variable: ");
			headPanel.add(variableLabel);
			variableTextField = new JTextField("x");
			variableTextField.setColumns(4);
			variableTextField.addKeyListener(new EnterListener());
			headPanel.add(variableTextField);
			
			parameterLabel = new JLabel("Parameter: ");
			headPanel.add(parameterLabel);
			parameterTextField = new JTextField("");
			parameterTextField.setColumns(4);
			parameterTextField.addKeyListener(new EnterListener());
			headPanel.add(parameterTextField);
			
			parameterValueLabel = new JLabel("Value: ");
			headPanel.add(parameterValueLabel);
			parameterValueTextField = new JTextField("");
			parameterValueTextField.setColumns(4);
			parameterValueTextField.addKeyListener(new EnterListener());
			headPanel.add(parameterValueTextField);
			
			contentPane.add(headPanel, BorderLayout.NORTH);
			
			JFreeChart chart = createChart();
			ChartPanel chartPanel = new ChartPanel(chart);
			contentPane.add(chartPanel, BorderLayout.CENTER);		
		}
				
		private JFreeChart createChart() {
			function = new XYSeries("Function");
			deritative = new XYSeries("Deritative");			
			
			f = new AnalyticFunction(functionTextField.getText(), variableTextField.getText());		
			for (double x = start; x < stop; x += step) {
				function.add(x, f.evalf(x));
				deritative.add(x, f.deritative().evalf(x));
			}
			
			XYSeriesCollection dataset = new XYSeriesCollection();
			dataset.addSeries(function);
			dataset.addSeries(deritative);
			
			chart = ChartFactory.createXYLineChart("", //chart title
					"X", //x axis label
					"Y", //y axis label
					dataset, //data
					PlotOrientation.VERTICAL, true, //include legend
					true, //tooltips
					false //urls
			);
			//CUSTOMIZATION
			chart.setBackgroundPaint(Color.white);
			
			XYPlot plot = (XYPlot) chart.getPlot();
			plot.setBackgroundPaint(Color.lightGray);
			plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
			plot.setDomainGridlinePaint(Color.white);
			//ValueAxis domaine = plot.getDomainAxis();
			//domaine.setAutoRangeMinimumSize(20);
			//domaine.setRangeAboutValue(0, 20);
			//domaine.zoomRange(0, 1);
			//ValueAxis range = plot.getRangeAxis();
			//range.setDefaultAutoRange(new Range(start, stop));
			//range.setAutoRangeMinimumSize(5);
			//range.setFixedAutoRange(10);
			//range.setRangeAboutValue(0, 20);
			
			//range.centerRange(2);
			//domaine.set
			//plot.setDomainAxis(n);
			return chart;		
		}
		private class EnterListener implements KeyListener {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(parameterTextField.getText().equals(""))
						f = new AnalyticFunction(functionTextField.getText(), variableTextField.getText());
					else {
						f = new AnalyticFunction(functionTextField.getText(), variableTextField.getText(), parameterTextField.getText());
						if(!parameterValueTextField.getText().equals("")) {
							f.setParameterValue(Double.parseDouble(parameterValueTextField.getText()));
						}
					}
					start = Double.parseDouble(startTextField.getText());
					stop = Double.parseDouble(stopTextField.getText());
					step = Double.parseDouble(stepTextField.getText());
					
					function.clear();
					deritative.clear();
					for (double x = start; x < stop; x += step) {
						function.add(x, f.evalf(x));
						deritative.add(x, f.deritative().evalf(x));
					}
				}
			}			
		}
}
