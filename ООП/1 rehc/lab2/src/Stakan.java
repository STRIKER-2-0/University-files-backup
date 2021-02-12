
public class Stakan {
	private float mass=30,volume=200,content=0;
	public	
	Stakan() {}
	Stakan(float m, float v){
		if((m>0)&&(v>0)) {
		mass=m;
		volume=v;
		}
	}	
	float getMass() {
		return mass;
	}
	float getVolume() {
		return volume;
	}
	float getContent() {
		return content;
	}
	boolean setMass(float m) {
		if(m>0) {
			mass=m;
			return true;
		}
		else return false;
	}
	boolean setVolume(float v) {
		if(v>0) {
			volume=v;
			return true;
		}
		else return false;
	}
	boolean setContent(float c) {
		if(c>0) {
			content=c;
			return true;
		}
		else return false;
	}
	void print() {
		System.out.println("Mass: "+mass+" g, Volume: "+volume+" ml, Content: "+content+" ml.");
	}
}
