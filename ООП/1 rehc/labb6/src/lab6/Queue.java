package lab6;

class Queue implements Container{
    private Vector vk;
   
    Queue(){
        vk=new Vector();
    }
    public void put(double val){
        vk.insert(val,0);
    }
    public double get(){
        double get=vk.get(vk.getSize()-1);
        vk.erase(vk.getSize()-1);
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