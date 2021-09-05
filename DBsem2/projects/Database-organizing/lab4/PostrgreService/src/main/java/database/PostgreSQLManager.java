package database;
import entities.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PostgreSQLManager {
    private Connection openConnection(){
        String driver = "org.postgresql.Driver";
        String connectionString = "jdbc:postgresql://localhost:5432/service";
        String connectionUserName = "postgres";
        String connectionPassword = "root";

        try {
            Class.forName(driver);
            return DriverManager.getConnection(connectionString, connectionUserName, connectionPassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void insertIntoPosts(String name, String text) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = openConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String sql = "INSERT INTO Posts(publish_date, username, post_text) " +
                    "VALUES (NOW(), '"+name+"', '"+text+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
    public void insertIntoPostsCertainDate(String name, String text, String date) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = openConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            String sql = "INSERT INTO Posts(publish_date, username, post_text) " +
                    "VALUES (DATE('"+date+"'), '"+name+"', '"+text+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
    public List<Post> selectPosts (int pageNumber, int postsPerPage) throws SQLException {
        Connection conn = null;
        try {
           conn = openConnection();
           conn.setAutoCommit(false);
           List<Post> notes = new ArrayList<Post>();
           Statement stmt = conn.createStatement();
           String sql = "SELECT * FROM Posts " +
                   "ORDER BY post_id DESC " +
                   "LIMIT "+postsPerPage+" OFFSET "+(pageNumber-1)*postsPerPage+";";
           ResultSet rs = stmt.executeQuery(sql);
           while (rs.next()){
               Post note = new Post();
               note.setDate(rs.getString("publish_date"));
               note.setUserName(rs.getString("username"));
               note.setText(rs.getString("post_text"));
               notes.add(note);
           }
           rs.close();
           stmt.close();
           return notes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return null;
    }
    public int countPosts() throws SQLException {
        int postNumber = 0;
        Connection conn = null;
        try {
            conn = openConnection();
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            String sql = "SELECT COUNT(*) AS number FROM posts;";
            ResultSet rs = stmt.executeQuery(sql);
            postNumber = rs.next() ? rs.getInt("number") : 0;
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return postNumber;
    }
}
