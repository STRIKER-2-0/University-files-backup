public class Stakan {
	private float m=30,v=200,c=0;//��������� ����������
	public 
	Stakan() {}//������ �����������
	Stakan(float m, float v){//����������� � �����������
		if((m>0)&&(v>0)) {
		this.m=m;
		this.v=v;
		}
	}	
	float getMass() {	//������ ����������� ����������
		return this.m;
	}
	float getVolume() {
		return this.v;
	}
	float getContent() {
		return this.c;
	}
	boolean setMass(float m) {	//������ ��������� ����������
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
	void print() {	//������
		System.out.println("Mass: "+m+" g, Volume: "+v+" ml, Content: "+c+" ml.");
	}
}
