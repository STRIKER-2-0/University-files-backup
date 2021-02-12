import java.io.IOException;
import java.util.ArrayList;

public class Shop {
    private String name;
    private String adr;
    private ArrayList<Vehicle> reg;
    private double bank;
    
    Shop(){
    	name="some_shop";
    	adr="any_adress";
    	reg = new ArrayList<>();
    	try {
    		download();
		} catch (IOException e) {
			System.out.println("Не удалось подгрузить  регистр!!!");
		}
    }
    Shop(String name, String adr){
    	this.name=name;
    	this.adr=adr;
    	reg = new ArrayList<>();
    	/*try {
    		download();
		} catch (IOException e) {
			System.out.println("Не удалось подгрузить  регистр!!!");
		}*/
    }
    Shop(String name, String adr, Vehicle[] reg_arr){
    	this.name=name;
    	this.adr=adr;
    	reg = new ArrayList<>();
    	for (int i = 0; i < reg_arr.length; i++) {
			reg.add(reg_arr[i]);
		}
    }
    
    
    public void download() throws IOException{
    	//ф-я подкачки из файла, вызов автоматически при создании объекта
    	CSV f = new CSV();
    	reg=f.get_list();
    }
    public void upload() throws IOException{
    	//ф-я загрузки в файл, перед завершением программы нужно дополнительно вызвать извне.
    	CSV f = new CSV();
    	f.write(reg);
    }
    
    
    public void add(Vehicle v) { //добавление
    	reg.add(v);
    }
    public void delete(Vehicle v) {			//удаление
    	for (int i = 0; i < reg.size(); i++) {
			if(reg.get(i).equals(v)) {
				reg.remove(i);
				break;

			}
		}
    }
    public Vehicle sellVehicle(Vehicle v) {
    	for (int i = 0; i < reg.size(); i++) {
			if(reg.get(i).equals(v)) {
				bank+=reg.get(i).getCost();
				return reg.remove(i);

			}
		}
    	return null;
    }
    public ArrayList<Vehicle> getPetrolRegistry(PetrolType type){
    	ArrayList<Vehicle> tmp = new ArrayList<>();
    	for (Vehicle vehicle : reg) {
			if(vehicle.getPetrolType()==type)
				tmp.add(vehicle);
		}
    	return tmp;
    }
    
    public void setName(String name){
    	this.name = name;
    }
    public String getName(){
    	return name;
    }
    public void setAdr(String adr){
    	this.adr = adr;
    }
    public String getAdr(){
    	return adr;
    }
    public void setRegistry(Vehicle[] reg_arr){
    	reg = new ArrayList<>();
    	for (int i = 0; i < reg_arr.length; i++) {
			reg.add(reg_arr[i]);
		}
    }
    public ArrayList<Vehicle> getRegistry(){
    	ArrayList<Vehicle> tmp = new ArrayList<>();
    	for (Vehicle vehicle : reg) {
			tmp.add(vehicle);
		}
    	return tmp;
    }
    public double getBank() {
		return bank;
	}
}
