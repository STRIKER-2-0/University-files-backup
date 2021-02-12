package mybeans;

public class Data {	
	private String date;
	private double x;
	private double y;

	public Data() {
		this.date = "16/03/2018";
		this.x = 1;
		this.y = 1;
	}
	
	public void setDate(String s) {
		this.date = s;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
}
