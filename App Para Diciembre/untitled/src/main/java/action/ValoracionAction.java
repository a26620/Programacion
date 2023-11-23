package action;

import com.google.gson.Gson;
import dao.UserDAO;
import dao.ValoracionDAO;
import model.Mensaje;
import model.Sala;
import model.User;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValoracionAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "ADD":
                pagDestino = addValoracionAction(request, response);
                break;
        }
        System.out.println(pagDestino);
        return pagDestino;
    }

    private String addValoracionAction(HttpServletRequest request,
                               HttpServletResponse response) {
        ValoracionDAO valoracionDAO = new ValoracionDAO();

        Mensaje mensaje = valoracionDAO.addValoracion(Integer.parseInt(request.getParameter("ID_USER")),Integer.parseInt(request.getParameter("ID_OBRA")),Integer.parseInt(request.getParameter("PUNTUACION")));

        String jsonValoracion = "";
        Gson gson = new Gson();
        jsonValoracion += "{\"message\": \"Valocion Success\"}";

        return jsonValoracion;
    }
}