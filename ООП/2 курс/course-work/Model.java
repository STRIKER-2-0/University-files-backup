import java.io.Serializable;

public class Model implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2854578626949150843L;
	public String name;
    public int num;
    
    Model(){}
    Model(String name, int num){
        this.name = name;
        this.num = num;
    }    
}
