package mybeans;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class DataSheetTable extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DataSheetTableModel tableModel;

	public DataSheetTable() {
		setPreferredSize(new Dimension(200, 300));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 5));
		
		
		table = new JTable();
		tableModel = new DataSheetTableModel();
		table.setModel(tableModel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.GREEN);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tableModel.setRowCount(tableModel.getRowCount()+1);
			tableModel.getDataSheet().addDataItem(new Data());
			table.revalidate();
			tableModel.fireDataSheetChange();
			}
		});
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (tableModel.getRowCount() > 1) {
				tableModel.setRowCount(tableModel.getRowCount() - 1);
				tableModel.getDataSheet().removeDataItem(tableModel.getDataSheet().size()-1);
				table.revalidate();
				tableModel.fireDataSheetChange();
			} else {
				tableModel.getDataSheet().getDataItem(0).setDate("");
				tableModel.getDataSheet().getDataItem(0).setX(0);
				tableModel.getDataSheet().getDataItem(0).setY(0);
				table.revalidate();
				table.repaint();
				tableModel.fireDataSheetChange();
			}
			}
			});
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
	}
	
	public DataSheetTableModel getTableModel() {
		return tableModel;
	}
		
	public void setTableModel(DataSheetTableModel tableModel) {
		this.tableModel = tableModel;
		table.revalidate();
	}
		
	public void revalidate() {
		if (table != null) table.revalidate();
	}
}
