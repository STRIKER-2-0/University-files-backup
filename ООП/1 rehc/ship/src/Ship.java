
public class Ship{
    private int[][] arr;
    private char axis;
     
    Ship(){
        arr=new int[4][3];
        for(int i=0; i<arr.length; i++) {
            arr[i][0]=0;
            arr[i][1]=i;
            arr[i][2]=1;
        }
        axis='y';
    }
      
    Ship(int n){    //���-�� �����
        if((n<1)&&(n>4))
            n=4;               
        arr=new int[n][3];
        for(int i=0; i<arr.length; i++){
            arr[i][0]=0;
            arr[i][1]=i;
            arr[i][2]=1;
        }
        axis='y';
    }
    
    Ship(int x, int y, char axis, int n){	//���������� ������, �����������(���), ���-�� �����
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
            this.axis=axis;
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
        	this.axis=axis;
        }
    }
    
    public boolean shoot(int x, int y) {	//���������� �� �����������    	
    	for(int i=0; i<arr.length; i++) {
    		if((arr[i][0]==x)&&(arr[i][1]==y)) {
    			if(arr[i][2]==0)
    				return false;
    			arr[i][2]=0;
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean turn(char axis, int n) {	//��������� �������
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
    
    public boolean rotate(){		//���������� �������
    	if(axis=='x'){
    		if(arr[0][1]+arr[arr.length-1][0]>9)
    			return false;
    		for(int i=1; i<arr.length; i++){
    			arr[i][0]=arr[0][0];
    			arr[i][1]=arr[0][1]+i;
    		}
    		axis='y';
    	}
    	else{
    		if(arr[0][0]+arr[arr.length-1][1]>9)
    			return false;
    		for(int i=1; i<arr.length; i++){
    			arr[i][1]=arr[0][1];
    			arr[i][0]=arr[0][0]+i;
    		}
    		axis='x';
    	}
    	return true;
    }
    
    public int getX(int cell) {	//�-���������� ������
    	cell--;
    	if((cell>=0)&&(cell<arr.length)) {
    		return arr[cell][0];
    	}
    	else return 0;
    }
    
    public int getY(int cell) {	//y-���������� ������
    	cell--;
    	if((cell>=0)&&(cell<arr.length)) {
    		return arr[cell][1];
    	}
    	else return 0;
    }
    
    public char getAxis(){	//���������
    	return axis;
    }
    
    public boolean getLifeCell(int x, int y) {	//�������� ������
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
    
    public int getLife() {	//���-�� ����� �����
    	int counter=0;
    	for(int i=0; i<arr.length; i++) {
    		if(arr[i][2]==1) {
    			counter++;
    		}
    	}
    	return counter;
    }
   
    public boolean isAlive() {	//���/�����
    	if(getLife()>0)
    		return true;
    	else return false;
    }
    
    public void printCoord() {	//���������� �� �����
    	for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length-1; j++) {
                System.out.print(arr[i][j]);
                if((j+1)!=(arr[i].length-1))
                	System.out.print(",");
            }
            if(axis=='y')
            	System.out.println(";");
            else
            	System.out.print("; ");
        }
        if(axis=='x')
        	System.out.println();
    }
    
    public void printLife() {	//������ �� �����
    	for(int i=0; i<arr.length; i++){
    		if(axis=='y')             
           	System.out.println(arr[i][2]);
           else
              System.out.print(arr[i][2]+" ");
   		}
    	if(axis=='x')
    		System.out.println();
    }    
    
}