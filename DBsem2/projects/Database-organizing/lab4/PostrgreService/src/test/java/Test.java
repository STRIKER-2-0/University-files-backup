import database.PostgreSQLManager;
import entities.Post;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        PostgreSQLManager mn = new PostgreSQLManager();
        mn.insertIntoPostsCertainDate("Bezruk", "Its only a test such a test for this testing test.", "2021-04-15");
        //mn.insertIntoPostsCertainDate("Yurii", "UPDATED: many text many text many text many", "2021-04-15");
        //mn.insertIntoPostsCertainDate("Roman", "По асфальту, мимо цемента, избегая зевак, под апплодисменты..", "2021-04-14");
        List<Post> l = mn.selectPosts(1, 5);
        for (Post post : l) {
            System.out.println(post);
        }
        System.out.println(mn.countPosts());
    }
}
