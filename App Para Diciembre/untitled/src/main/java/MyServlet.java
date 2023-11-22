import action.ObraAction;
import action.SalaAction;
import action.UserAction;
import action.ValoracionAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    protected void doGet( HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        String answer = "";

        System.out.println(request.getParameter("USER"));

        switch (arrayAction[0]) {
            case "USER":
                out.print(new UserAction().execute(request, response));
                break;
            case "SALA":
                out.print(new SalaAction().execute(request, response));
                break;
            case "OBRA":
                out.print(new ObraAction().execute(request, response));
                break;
            case "VALORACION":
                out.print(new ValoracionAction().execute(request, response));
                break;
        }
        out.print(answer);
    }
}