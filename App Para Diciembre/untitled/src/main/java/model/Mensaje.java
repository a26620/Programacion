package model;

public class Mensaje {
    String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public static String convertMensajeToJSONString(Mensaje mensaje) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
            jsonBuilder.append("{");
            jsonBuilder.append("\"mensaje\": \"").append(mensaje.getMensaje()).append("\"");
            jsonBuilder.append("}");
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}