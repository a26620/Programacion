package action;

import com.google.gson.Gson;
import dao.CompraDAO;
import model.Compra;
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
        }
        System.out.println(pagDestino);
        return pagDestino;
    }

    private String addAction(HttpServletRequest request,
                             HttpServletResponse response) {

        CompraDAO compraDAO = new CompraDAO();

        Mensaje mensaje = compraDAO.add(Integer.parseInt(request.getParameter("ID_USER")),Integer.parseInt(request.getParameter("ID_ACTUACION")),Float.parseFloat(request.getParameter("IMPORTE")));


        String jsonObra = "";
        Gson gson = new Gson();
        jsonObra += "{\"message\": \"Obra Añadida\"}";

        return jsonObra;
    }
}