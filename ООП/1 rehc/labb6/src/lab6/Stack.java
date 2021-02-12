package lab6;

class Stack implements Container{
    private Vector vk;
   
    Stack(){
        vk=new Vector();
    }
    public void put(double val){
        vk.insert(val,0);
    }
    public double get(){
        double get=vk.get(0);
        vk.erase(0);
        return get;
    }
    public int getSize() {
    	return vk.getSize();
    }
    public void clear(){
        vk.clear();
    }
    public void print(){
        vk.print();
    }
}