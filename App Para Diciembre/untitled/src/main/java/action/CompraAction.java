package action;

import com.google.gson.Gson;
import dao.CompraDAO;
import dao.GeneroDAO;
import model.Compra;
import model.Genero;
import model.Mensaje;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CompraAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "ADD":
                pagDestino = addAction(request, response);
                break;
            case "LIST":
                pagDestino = listAction(request, response);
                break;
        }
        System.out.println(pagDestino);
        return pagDestino;
    }

    private String addAction(HttpServletRequest request,
                             HttpServletResponse response) {

        CompraDAO compraDAO = new CompraDAO();

        Mensaje mensaje = compraDAO.add(Integer.parseInt(request.getParameter("ID_USER")),Integer.parseInt(request.getParameter("ID_ACTUACION")),Float.parseFloat(request.getParameter("IMPORTE")), Integer.parseInt(request.getParameter("N_ENTRADAS")));


        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Obra Añadida\"}";

        return jsonObra;
    }
    private String listAction(HttpServletRequest request,
                              HttpServletResponse response) {

        CompraDAO compraDAO = new CompraDAO();

        ArrayList<Compra> lstCompra = compraDAO.list(Integer.parseInt(request.getParameter("ID_USER")));

        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"comprasList\": [";
        for (Compra compra:lstCompra) {
            jsonObra += gson.toJson(compra) + ", ";
        }
        jsonObra = jsonObra.substring(0, jsonObra.length()-2);
        jsonObra += "]}";

        return jsonObra;
    }
}