import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Constr {
	private Class c;
	private Constructor[] cons;
	
	public Constr(Class c) throws ClassNotFoundException{
		this.c = c;
	}
	
	public Constructor[] getConstr(){
		cons = this.c.getConstructors();
		return this.cons;
	}
	
	public Constructor getConstr(int i){
		cons = this.c.getConstructors();
		return this.cons[i];
	}

}
