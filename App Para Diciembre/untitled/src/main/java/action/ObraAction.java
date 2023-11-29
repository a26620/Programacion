package action;

import action.IAction;
import com.google.gson.Gson;
import dao.ObraDAO;
import model.Mensaje;
import model.Obra;

import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObraAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "ADD":
                pagDestino = addAction(request, response);
                break;
            case "LISTMOSTSELL":
                pagDestino = listmostsellAction(request, response);
                break;
            case "LIST":
                pagDestino = list(request, response);
                break;
            case "LISTBESTRATING":
                pagDestino = listbestratingAction(request, response);
                break;
            case "LISTFILTER":
                pagDestino = listfilterAction(request, response);
                break;
            case "FICHADESCRIPTIVA":
                pagDestino = fichaDescriptivaAction(request, response);
                break;        }
        System.out.println(pagDestino);
        return pagDestino;
    }

    private String addAction(HttpServletRequest request,
                             HttpServletResponse response) {

        ObraDAO obraDAO = new ObraDAO();

        Mensaje mensaje = obraDAO.add(request.getParameter("TITULO"),request.getParameter("DESCRIPCION"), Integer.parseInt(request.getParameter("DURACION")), Float.parseFloat(request.getParameter("PRECIO")), (request.getParameter("ID_GENERO")), (request.getParameter("EDAD_RECOMENDADA")));

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Obra Añadida\"}";

        return jsonObra;
    }
    private String listmostsellAction(HttpServletRequest request,
                                      HttpServletResponse response) {

        ObraDAO obraDAO = new ObraDAO();

        ArrayList<Obra> lstObra = obraDAO.listmostsell();

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"obrasList\": [";
        for (Obra obra:lstObra) {
            jsonObra += gson.toJson(obra) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";
        return jsonObra;
    }
    private String list(HttpServletRequest request,
                        HttpServletResponse response) {

        ObraDAO obraDAO = new ObraDAO();

        ArrayList<Obra> lstObra = obraDAO.list(Integer.parseInt(request.getParameter("ID_SALA")));

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"obrasList\": [";
        for (Obra obra:lstObra) {
            jsonObra += gson.toJson(obra) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";

        return jsonObra;
    }
    private String listbestratingAction(HttpServletRequest request,
                                        HttpServletResponse response) {

        ObraDAO obraDAO = new ObraDAO();

        ArrayList<Obra> lstObra = obraDAO.listbestrating();

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"obrasList\": [";
        for (Obra obra:lstObra) {
            jsonObra += gson.toJson(obra) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";
        return jsonObra;
    }
    private String listfilterAction(HttpServletRequest request,
                                    HttpServletResponse response) {

        ObraDAO obraDAO = new ObraDAO();


        ArrayList<Obra> lstObra = obraDAO.listfilter(new String[]{request.getParameter("ID_GENERO")},new String[]{request.getParameter("EDAD_RECOMENDADA")});

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"obrasList\": [";
        for (Obra obra:lstObra) {
            jsonObra += gson.toJson(obra) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";
        return jsonObra;
    }

    private String fichaDescriptivaAction(HttpServletRequest request,
                                          HttpServletResponse response) {

        ObraDAO obraDAO = new ObraDAO();

        ArrayList<Obra> lstObra = obraDAO.fichaDescriptiva(Integer.parseInt(request.getParameter("ID_OBRA")));

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"obrasList\": [";
        for (Obra obra:lstObra) {
            jsonObra += gson.toJson(obra) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";
        return jsonObra;
    }
}