package action;

import com.google.gson.Gson;
import dao.GeneroDAO;
import dao.ObraDAO;
import model.Genero;
import model.Obra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GeneroAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "LIST":
                pagDestino = listAction(request, response);
                break;
                  }
        System.out.println(pagDestino);
        return pagDestino;
    }

    private String listAction(HttpServletRequest request,
                        HttpServletResponse response) {

        GeneroDAO generoDAO = new GeneroDAO();

        ArrayList<Genero> lstGenero = generoDAO.list();

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"generosList\": [";
        for (Genero genero:lstGenero) {
            jsonObra += gson.toJson(genero) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";

        return jsonObra;
    }
}
