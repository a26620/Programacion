package action;

import action.IAction;
import dao.ObraDAO;
import model.Mensaje;

import java.util.ArrayList;
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
        }
        return pagDestino;
    }
    
    private String addAction(HttpServletRequest request,
            HttpServletResponse response) {
        
        ObraDAO obraDAO = new ObraDAO();
        
        Mensaje mensaje = obraDAO.add(request.getParameter("TITULO"),request.getParameter("DESCRIPCION"),request.getParameter("IMG"), Float.parseFloat(request.getParameter("PRECIO")));
                
        return Mensaje.convertMensajeToJSONString(mensaje);  
    }
}