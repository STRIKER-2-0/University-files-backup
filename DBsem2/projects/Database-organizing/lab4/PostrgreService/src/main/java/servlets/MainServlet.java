package servlets;
import database.PostgreSQLManager;
import entities.Post;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("cp1251");
        resp.setContentType("text/html;charset=cp1251");
        List<Post> posts = null;
        int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
        int postNumber = 0;
        int postsPerPage = 5;
        try {
            PostgreSQLManager pm = new PostgreSQLManager();
            postNumber = pm.countPosts();
            posts = pm.selectPosts(page, postsPerPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("posts", posts);
        req.setAttribute("postNumber", postNumber);
        req.setAttribute("postsPerPage", postsPerPage);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp?page="+page);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {;
        try {
            PostgreSQLManager pm = new PostgreSQLManager();
            String userName = req.getParameter("userName");
            String text = req.getParameter("text");
            if((userName != null && !userName.isEmpty()) && (text != null && !text.isEmpty())){
                String userNameString = new String(req.getParameter("userName").getBytes("ISO-8859-1"), "cp1251");
                String textString = new String(req.getParameter("text").getBytes("ISO-8859-1"), "cp1251");

                pm.insertIntoPosts(userNameString, textString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }
}
