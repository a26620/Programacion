package action;

import com.google.gson.Gson;
import dao.ActuacionDAO;
import dao.GeneroDAO;
import model.Genero;
import model.Obra;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ActuacionAction implements IAction{
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

        ActuacionDAO actuacionDAO = new ActuacionDAO();

        ArrayList<Obra> lstGenero = actuacionDAO.list(Integer.parseInt(request.getParameter("ID_OBRA")));

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"obrasList\": [";
        for (Obra obra:lstGenero) {
            jsonObra += gson.toJson(obra) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";

        return jsonObra;
    }
}
