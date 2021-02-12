public class User {
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(String.format("create: name = %s, age = %s", name, age));
    }
    public Memento save(){
        System.out.println(String.format("save: name = %s, age = %s", name, age));
        return new Memento(name, age);
    }
    public void restore(Memento memento){
        name = memento.getName();
        age = memento.getAge();
        System.out.println(String.format("restore: name = %s, age = %s", name, age));
    }
}
