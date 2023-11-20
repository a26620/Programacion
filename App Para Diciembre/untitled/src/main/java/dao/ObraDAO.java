package dao;

import model.Mensaje;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObraDAO{
    private static final String SQL_INSERT = "INSERT INTO OBRA (titulo, descripcion, img, precio) VALUES ";
    private static final String SQL_UPDATE = "UPDATE OBRA SET ";
    private static final String SQL_DELETE = " DELETE FROM OBRA WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM OBRA WHERE 1=1 ";   

    private MotorSQL motorSql;

    public ObraDAO() {
        this.motorSql = new MotorSQL();
    }


    public Mensaje add(String titulo, String descripcion, String img, float precio) {

        Mensaje mensajes = new Mensaje();
        String sql = SQL_FIND_ALL;
        boolean coincidencia = false;

        try {
            motorSql.connect();

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString(2).equals(titulo)) {
                    coincidencia = true;
                    mensajes.setMensaje("Ya Existe esta Obra");
                }
            }

            if (!coincidencia) {
                sql = SQL_INSERT;
                sql += "('" + titulo + "', '" + descripcion + "', '" + img + "', " + precio + ")";
                int resp = this.motorSql.execute(sql);
                mensajes.setMensaje("Obra Añadida");
            }
        } catch (SQLException e) {
            System.out.println(e);
            mensajes.setMensaje("Añadir obra fallido");
        } finally {
            motorSql.disconnect();
        }
        return mensajes;

    }
}