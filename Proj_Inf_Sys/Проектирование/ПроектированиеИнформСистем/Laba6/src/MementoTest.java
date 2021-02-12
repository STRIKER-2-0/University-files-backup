public class MementoTest {
    public static void main(String[] args) {
        SaveUser saveUser = new SaveUser();
        User user1 = new User("Anna", 20);
        User user2 = new User("Sabina", 19);
        saveUser.add(user1.save());
        user1.restore(saveUser.get(0));
    }
}
