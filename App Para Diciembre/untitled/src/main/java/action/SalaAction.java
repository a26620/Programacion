package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import dao.SalaDAO;
import model.Sala;

public class SalaAction implements IAction {

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
        return pagDestino;
    }
    
    private String listAction(HttpServletRequest request,
            HttpServletResponse response) {
        
        SalaDAO salaDAO = new SalaDAO();
        
        ArrayList<Sala> lstSala = salaDAO.list();

        String jsonSala = "";
        Gson gson = new Gson();
        jsonSala += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"salasList\": [";
        for (Sala sala:lstSala) {
            jsonSala += gson.toJson(sala) + ", ";
        }
        jsonSala = jsonSala.substring(0, jsonSala.length()-2);
        jsonSala += "]}";
                
        return jsonSala;
    }
}