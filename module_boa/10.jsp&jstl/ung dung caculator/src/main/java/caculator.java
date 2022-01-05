import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "caculator", value = "/caculator")
public class caculator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double f = Double.parseDouble(request.getParameter("a"));
        double s = Double.parseDouble(request.getParameter("b"));
        String operator = request.getParameter("operator");
        double result = 0;
        if (operator.equals("+")) {
            result = f + s;
            request.setAttribute("add","selected");
        } else if (operator.equals("-")) {
            result = f - s;
            request.setAttribute("sub","selected");
        } else if (operator.equals("*")) {
            result = f * s;
            request.setAttribute("multi","selected");
        } else {
            result = f / s;
            request.setAttribute("divv","selected");
        }
        request.setAttribute("r",result);
        request.setAttribute("first",f);
        request.setAttribute("second",s);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

