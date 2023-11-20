package action;

import com.google.gson.Gson;
import dao.UserDAO;
import model.Mensaje;
import model.Sala;
import model.User;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAction implements IAction {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String pagDestino = "";
        String action = request.getParameter("ACTION");

        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "LOGIN":
                pagDestino = loginAction(request, response);
                break;
        }
        System.out.println(pagDestino);
        return pagDestino;
    }

    private String loginAction(HttpServletRequest request,
                               HttpServletResponse response) {

        UserDAO usuarioDAO = new UserDAO();

        ArrayList<User> lstUser = usuarioDAO.login(request.getParameter("USER"),request.getParameter("PASS"));

        String jsonUsuario = "";
        Gson gson = new Gson();
        jsonUsuario += "{\"message\": \"Esto es un mensaje de ejemplo\"," +
                "\"usersList\": [";
        if (lstUser.size()!=0){
            jsonUsuario += gson.toJson(lstUser.get(0));
        }
        jsonUsuario += "]}";

        return jsonUsuario;
    }
}
