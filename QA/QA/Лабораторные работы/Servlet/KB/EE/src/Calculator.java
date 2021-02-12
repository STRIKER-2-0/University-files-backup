import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Calculator  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        float number1 = Float.parseFloat(req.getParameter("n1"));
        float number2 = Float.parseFloat(req.getParameter("n2"));
        String op = req.getParameter("operator");
        switch (op){
            case "+":
                req.setAttribute("result", number1+number2);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "-":
                req.setAttribute("result", number1-number2);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "*":
                req.setAttribute("result", number1*number2);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            case "/":
                req.setAttribute("result", number1/number2);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
        }
    }
}
