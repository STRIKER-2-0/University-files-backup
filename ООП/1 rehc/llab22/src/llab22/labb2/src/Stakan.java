public class Stakan {
	private float m=30,v=200,c=0;//приватные переменные
	public 
	Stakan() {}//пустой конструктор
	Stakan(float m, float v){//конструктор с параметрами
		if((m>0)&&(v>0)) {
		this.m=m;
		this.v=v;
		}
	}	
	float getMass() {	//методы возвращения параметров
		return this.m;
	}
	float getVolume() {
		return this.v;
	}
	float getContent() {
		return this.c;
	}
	boolean setMass(float m) {	//методы установки параметров
		if(m>0) {
			this.m=m;
			return true;
		}
		else return false;
	}
	boolean setVolume(float v) {
		if(v>0) {
			this.v=v;
			return true;
		}
		else return false;
	}
	boolean setContent(float c) {
		if((c>=0)&&(c<=this.v)) {
			this.c=c;
			return true;
		}
		else return false;
	}
	void print() {	//печать
		System.out.println("Mass: "+m+" g, Volume: "+v+" ml, Content: "+c+" ml.");
	}
}
