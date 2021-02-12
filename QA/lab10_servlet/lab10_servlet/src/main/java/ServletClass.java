import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        Double a = Double.parseDouble(req.getParameter("a"));
        String operator = req.getParameter("operator");
        Double b = Double.parseDouble(req.getParameter("b"));
        String answer = a+" "+operator+" "+b+" = ";
        switch (operator){
            case "+": answer+=(a+b); break;
            case "-": answer+=(a-b); break;
            case "*": answer+=(a*b); break;
            case "/": answer+=(a/b); break;
            default: answer = "Unknown operation!";
        }
        PrintWriter writer = resp.getWriter();
        writer.println("<h1> "+answer+" </h1>");
        writer.close();
        return;
    }
}

