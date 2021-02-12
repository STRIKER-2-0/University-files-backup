/*import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class CSV {
    String file_name = "database.csv";
    ArrayList <Vehicle> list = new ArrayList();
    
    public void read() throws FileNotFoundException{
        Scanner fin = new Scanner(new File(file_name)); 
        fin.useDelimiter(",");
        Vehicle v = null;
        int comma_counter =0;
        while (fin.hasNext()){
            
            String tmp = fin.next();
            
            System.out.println(tmp);
            
            
            
            switch(comma_counter){
                case 0:
                    
                break;
                
                case 1:
                    v.setName(tmp);
                    comma_counter +=1;
                break;
                
                case 2:
                    char[] s = tmp.toCharArray();
                    int letters = 0;
                    while(s[letters]<='0' && s[letters]>='9'){letters +=1;}
                    String str = null;
                    int n = 0;
                    for(int i=0;i<letters;i+=1){ str+=s[i]; }
                    for(int i=letters;i<tmp.length();i+=1){ n+=s[i]-'0'; }
                    v.setModel(new Model(str,n));
                    comma_counter+=1;
                break;
                
                case 3:
                    v.setYear(Integer.parseInt(tmp));
                    comma_counter+=1;
                break;
                
                case 4:
                	switch (tmp) {
					case "GAS":
						v.setPetrolType(PetrolType.GAS);
						break;
					case "DIEZEL":
						v.setPetrolType(PetrolType.DIEZEL);
						break;
					case "ELECTRIC":
						v.setPetrolType(PetrolType.ELECTRIC);
						break;
					case "NUCLEAR":
						v.setPetrolType(PetrolType.NUCLEAR);
						break;
                	}
                    comma_counter+=1;
                break;
                
                case 5:
                    v.setTankCapacity(Double.parseDouble(tmp));
                    comma_counter+=1;
                break;
                
                case 6:
                    v.setCost(Double.parseDouble(tmp));
                    comma_counter+=1;
                    list.add(v);
                break;
            }
            
            if((Type.AVTO.toString().equals(tmp)) || (("\n"+Type.AVTO.toString()).equals(tmp))){
                
                System.out.println("Auto");
                
                v = new Avto();
                comma_counter =1;
            }
            
            if((Type.MOTO.toString().equals(tmp)) || (("\n"+Type.MOTO.toString()).equals(tmp))){
                
                //System.out.println("Moto");
                
                v = new Moto();
                comma_counter =1;
            }
            
        }
        fin.close();
    }
    
    public ArrayList<Vehicle> get_list() throws FileNotFoundException{
        read();
        return list;
    }
    
    public void write(ArrayList<Vehicle> ls) throws IOException{
        FileWriter fout = new FileWriter(file_name);
        for(int i=0;i<ls.size();i+=1){
            Vehicle v = (Vehicle) ls.get(i);
            String tmp = v.getType().toString() + "," + v.getName()+ "," + v.getModel().name+v.getModel().num + "," + v.getYear() + "," +  v.getPetrolType()+ "," + v.getTankCapacity()+ "," + v.getCost()+",\n";
            fout.write(tmp);            
        }
        fout.close();
    }
}*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class CSV {
    String file_name = "database.csv";
    ArrayList <Vehicle> list = new ArrayList<>();
    
    public void read() throws FileNotFoundException{    	
    	try {
    		FileInputStream fis = new FileInputStream(file_name);
			ObjectInputStream oin = new ObjectInputStream(fis);
			while(true) {
	    		Vehicle tmp = (Vehicle) oin.readObject();
	    		if(tmp==null)
	    			break;
	    		list.add(tmp);
	    	}
			oin.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	/*
        Scanner fin = new Scanner(new File(file_name)); 
        fin.useDelimiter(",");
        Vehicle v = null;
        int comma_counter =0;
        String model_name=null;
        while (fin.hasNext()){
            
            String tmp = fin.next();
            
            
            //System.out.println(tmp);
            
            
            
            switch(comma_counter){
                case 1:
                    v.setName(tmp);
                    comma_counter +=1;
                break;
                
                case 2:
                	model_name=tmp;
                	/*
                    char[] s = tmp.toCharArray();
                    int letters = 0;
                    while(s[letters]<='0' && s[letters]>='9'){letters +=1;}
                    String str = null;
                    int n = 0;
                    for(int i=0;i<letters;i+=1){ str+=s[i]; }
                    for(int i=letters;i<tmp.length();i+=1){ n+=s[i]-'0'; }
                    v.setModel(new Model(str,n));
                    comma_counter+=1;
                break;
                case 3: 
                	v.setModel(new Model(model_name, Integer.parseInt(tmp)));
                	comma_counter+=1;
                	break;
                case 4:
                    v.setManufacturer(tmp);
                    comma_counter+=1;
                break;
                    
                case 5:
                    v.setYear(Integer.parseInt(tmp));
                    comma_counter+=1;
                break;
                
                case 6:
                	switch (tmp) {
					case "GAS":
						v.setPetrolType(PetrolType.GAS);
						break;
					case "DIEZEL":
						v.setPetrolType(PetrolType.DIEZEL);
						break;
					case "ELECTRIC":
						v.setPetrolType(PetrolType.ELECTRIC);
						break;
					case "NUCLEAR":
						v.setPetrolType(PetrolType.NUCLEAR);
						break;
                	}
                    comma_counter+=1;
                break;
                
                case 7:
                    v.setTankCapacity(Double.parseDouble(tmp));
                    comma_counter+=1;
                break;
                
                case 8:
                    v.setCost(Double.parseDouble(tmp));
                    comma_counter=0;
                    list.add(v);
                break;
            }
            
            if((Type.AVTO.toString().equals(tmp)) || (("\n"+Type.AVTO.toString()).equals(tmp))){
                
                System.out.println("Auto");
                
                v = new Avto();
                comma_counter =1;
            }
            
            if((Type.MOTO.toString().equals(tmp)) || (("\n"+Type.MOTO.toString()).equals(tmp))){
                
                //System.out.println("Moto");
                
                v = new Moto();
                comma_counter =1;
            }
            
        }
        fin.close();*/
    }
    
    public ArrayList<Vehicle> get_list() throws FileNotFoundException{
        read();
        return list;
    }
    
    public void write(ArrayList<Vehicle> ls) throws IOException{
    	FileOutputStream fos = new FileOutputStream(file_name);
    	try {
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
        	for (Vehicle vehicle : ls) {
        		oos.writeObject(vehicle);
            	
    		}
        	oos.flush();
        	oos.close();
		} catch (Exception e) {
			System.out.println("mistake");
		}
    	
        /*
        FileWriter fout = new FileWriter(file_name);
        for(int i=0;i<ls.size();i+=1){
            Vehicle v = (Vehicle) ls.get(i);
            String tmp = v.getType().toString() + "," + v.getName()+ "," + v.getModel().name + "," +v.getModel().num + "," + v.getManufacturer() + "," + v.getYear() + "," +  v.getPetrolType().toString()+ "," + v.getTankCapacity()+ "," + v.getCost()+",\n";
            fout.write(tmp);
            
        }
        fout.close();*/
    }
}
  
