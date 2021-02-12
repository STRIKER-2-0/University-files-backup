import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class DataSheetTable extends JTable {
	private static final long serialVersionUID = 1L;
	private ArrayList<DataSheetChangeListener> listeners=new ArrayList<DataSheetChangeListener>();
    private DataSheetChangeEvent event=new DataSheetChangeEvent(this);

    public DataSheetTable() {
    	 super(new DataSheetTableModel());
	}
    public DataSheetTable(TableModel dm) {
        super(dm);
    }

    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
    }

    public DataSheetTableModel getModel() {
        return (DataSheetTableModel)super.getModel();
    }

    public ArrayList<DataSheetChangeListener> getListeners() {
        return listeners;
    }
}
