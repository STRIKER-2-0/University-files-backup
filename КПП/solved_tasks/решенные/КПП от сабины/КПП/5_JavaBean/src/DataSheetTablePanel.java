import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataSheetTablePanel extends JPanel {
    private JButton addButton,delButton;
    private JPanel buttonPanel;
    private JScrollPane scrollPane;
    private DataSheetTable dataSheetTable;

    public DataSheetTablePanel(){
        this.setLayout(new BorderLayout());

        buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 5));
        buttonPanel.add(addButton = new JButton("Add (+)"));
        buttonPanel.add(delButton = new JButton("Del (-)"));
        this.add(buttonPanel,BorderLayout.SOUTH);

        dataSheetTable=new DataSheetTable(new DataSheetTableModel());
        scrollPane=new JScrollPane();
        scrollPane.setViewportView(dataSheetTable);
        this.add(scrollPane,BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataSheetTable.getModel().setRowCount(dataSheetTable.getModel().getRowCount() + 1);
                dataSheetTable.getModel().getDataSheet().addData(dataSheetTable.getModel().getDataSheet().createNewElement());
                dataSheetTable.revalidate();
                dataSheetTable.getModel().fireDataSheetChange();
            }
        });
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataSheetTable.getModel().getDataSheet().removeData(dataSheetTable.getModel().getRowCount() - 1);
                dataSheetTable.getModel().setRowCount(dataSheetTable.getModel().getRowCount() - 1);
                dataSheetTable.revalidate();
                dataSheetTable.getModel().fireDataSheetChange();
            }
        });
    }

    public DataSheetTable getDataSheetTable() {
        return dataSheetTable;
    }
}
