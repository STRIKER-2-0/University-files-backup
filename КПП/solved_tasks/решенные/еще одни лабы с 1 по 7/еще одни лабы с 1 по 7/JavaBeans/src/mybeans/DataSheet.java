package mybeans;
import java.util.ArrayList;

public class DataSheet {
	private String name;
	private ArrayList<Data> data = null;
	
	public DataSheet() {
		this.name = null;
		data = new ArrayList<Data>();
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public String getName() {
		return this.name;
	}
	public void addDataItem(Data data) {
		this.data.add(data);
	}
	
	public Data getDataItem(int i) {
		return this.data.get(i);
	}
	
	public void removeDataItem(int i) {
		this.data.remove(i);
	}
	
	public int size() {
		return this.data.size();
	}
	
	public ArrayList<Data> getArr() {
		return data;
	}
}
