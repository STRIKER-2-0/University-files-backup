package ind2;

public class Ship{
    private int[][] arr;
     
    Ship(){
        arr=new int[4][3];
        for(int i=0; i<arr.length; i++) {
            arr[i][0]=0;
            arr[i][1]=i;
            arr[i][2]=1;
        }
    }  
    Ship(int n){    //кол-во палуб
        if((n<1)&&(n>4))
            n=4;               
        arr=new int[n][3];
        for(int i=0; i<arr.length; i++){
            arr[i][0]=0;
            arr[i][1]=i;
            arr[i][2]=1;
        }
    }
    Ship(int x, int y, char axis, int n){	//координаты начала, напрваление(ось), кол-во палуб
        if((x<0)||(x>9)||(y<0)||(y>9)){
            x=0;
            y=0;            
        }
        if((axis!='x')&&(axis!='y'))
        	axis='y';            
        
        if((n<1)||(n>4))
            n=4;            
               
        arr=new int[n][3];
        if(axis=='y'){           
        	for(int i=0; i<arr.length; i++){
        		arr[i][0]=x;
        		if((10-y)<n)
        			arr[i][1]=y-n+i+1;
                else
                    arr[i][1]=y+i;
                arr[i][2]=1;
            }   
        }
        else{            
        	for(int i=0; i<arr.length; i++){
        		if((10-x)<n)
        			arr[i][0]=x-n+i+1;                    
        		else 
        			arr[i][0]=x+i;
        		arr[i][1]=y;
        		arr[i][2]=1;
        	}            
        }
    }
    
    public boolean shoot(int x, int y) {	//выстрелить по координатам    	
    	for(int i=0; i<arr.length; i++) {
    		if((arr[i][0]==x)&&(arr[i][1]==y)) {
    			arr[i][2]=0;
    			return true;
    		}
    	}
    	return false;
    }
    public boolean turn(char axis, int n) {	//подвинуть корабль
    	if((axis!='x')&&(axis!='y'))
    		axis='x';
    	if(axis=='x') {
    		if(((arr[arr.length-1][0]+n)<10)&&(arr[0][0]+n>=0)) {
    			for(int i=0; i<arr.length; i++)
    				arr[i][0]+=n;
    			return true;
    		}
    		else return false;
    	}
    	else {
    		if(((arr[arr.length-1][1]+n)<10)&&(arr[0][1]+n>=0)) {
    			for(int i=0; i<arr.length; i++)
    				arr[i][1]+=n;
    			return true;
    		}
    		else return false;
    	}
    }
    public int getX(int cell) {	//х-координата €чейки
    	cell--;
    	if((cell>=0)&&(cell<arr.length)) {
    		return arr[cell][0];
    	}
    	else return 0;
    }
    public int getY(int cell) {	//y-координата €чейки
    	cell--;
    	if((cell>=0)&&(cell<arr.length)) {
    		return arr[cell][1];
    	}
    	else return 0;
    }
    public boolean getLifeCell(int x, int y) {	//здоровье €чейки
    	for(int i=0; i<arr.length; i++) {
    		if((arr[i][0]==x)&&(arr[i][1]==y)) {
    			if(arr[i][2]==1)
    				return true;
    			else
    				return false;
    		}
    	}
    	return false;
    }
    public int getLife() {	//кол-во целых палуб
    	int counter=0;
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i][2]==1) {
    			counter++;
    		}
    	}
    	return counter;
    }
    public boolean isAlive() {	//жив/мертв
    	if(getLife()>0)
    		return true;
    	else return false;
    }
    public void printCoord() {	//координаты на экран
    	for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length-1; j++) {
                System.out.print(arr[i][j]);
                if((j+1)!=(arr[i].length-1))
                	System.out.print(",");
            }
            System.out.println(";");
        }
    }
    public void printLife() {	//статус на экран
    	for(int i=0; i<arr.length; i++)             
            System.out.println(arr[i][2]);   
    }    
}
