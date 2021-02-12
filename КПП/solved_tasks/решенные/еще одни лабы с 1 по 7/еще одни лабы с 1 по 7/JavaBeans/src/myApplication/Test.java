package myApplication;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.transform.TransformerException;

import mybeans.DataSheetTable;
import xml.DataSheetToXML;
import xml.XMLSAXParser;

import mybeans.Data;
import mybeans.DataSheet;
import mybeans.DataSheetChangeEvent;
import mybeans.DataSheetChangeListener;
import mybeans.DataSheetGraph;

public class Test extends JFrame {
	private static final long serialVersionUID = 1L;
	private DataSheetTable dataSheetTable = null;
	private DataSheet dataSheet;
	private JPanel contentPane;
	private final JFileChooser fileChooser = new JFileChooser();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Test() {
		fileChooser.setCurrentDirectory(new java.io.File("."));
		dataSheet = new DataSheet();
		dataSheet.addDataItem(new Data());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnOpen = new JButton("Open");
		panel.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		panel.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		panel.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		
		panel.add(btnExit);
		
		
		DataSheetGraph dataSheetGraph = new DataSheetGraph();
		dataSheetGraph.setDataSheet(dataSheet);
		contentPane.add(dataSheetGraph, BorderLayout.EAST);
		
		JCheckBox link = new JCheckBox("link");
		link.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (dataSheetGraph.getConnected() == false)
					dataSheetGraph.setConnected(true);
				else
					dataSheetGraph.setConnected(false);
			}
		});
		panel.add(link);
		
		dataSheetTable = new DataSheetTable();
		dataSheetTable.getTableModel().setDataSheet(dataSheet);
		dataSheetTable.getTableModel().addDataSheetChangeListener(
				new DataSheetChangeListener() {
				public void dataChanged(DataSheetChangeEvent e) {
				dataSheetGraph.revalidate();
				dataSheetGraph.repaint();
				}
				});
		contentPane.add(dataSheetTable, BorderLayout.WEST);
		
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataSheet = new DataSheet();
				dataSheet.addDataItem(new Data());
				dataSheetTable.getTableModel().setDataSheet(dataSheet);
				dataSheetTable.revalidate();
				dataSheetGraph.setDataSheet(dataSheet);
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(null)) {
					String fileName = fileChooser.getSelectedFile().getPath();
					try {
						DataSheetToXML.ToXML(dataSheet,fileName);
					} catch (FileNotFoundException | TransformerException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,
					"File " + fileName.trim() + " saved!", "",
					JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(null)) {
					String fileName = fileChooser.getSelectedFile().getPath();
					dataSheet = XMLSAXParser.getParse(fileName);
					dataSheetTable.getTableModel().setDataSheet(dataSheet);
					dataSheetTable.revalidate();
					dataSheetGraph.setDataSheet(dataSheet);
				}
			}
		});
	}
}
