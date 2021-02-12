public class Student implements Person {
    private String name ;
    private String group;

    public Student(){
        name="Vasya";
        group="KS-23";
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public  String getName(){

        return name;
    }
    public  void   setName(String name){
        this.name = name;
    }

    public void rename(String new_name){
        if (!new_name.equals(name)) this.name = new_name;
    }
}