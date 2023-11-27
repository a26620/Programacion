package dao;

import model.Mensaje;
import model.Sala;
import model.User;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ValoracionDAO{
    private static final String SQL_INSERT = "INSERT INTO VALORACION (id_user,id_obra,puntuacion,fechavaloracion) VALUES ";
    private static final String SQL_UPDATE = "UPDATE VALORACION SET ";
    private static final String SQL_DELETE = " DELETE FROM VALORACION WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM VALORACION WHERE 1=1 ";   

    private MotorSQL motorSql;

    public ValoracionDAO() {
        this.motorSql = new MotorSQL();
    }


    public Mensaje addValoracion(int id_user, int id_obra, float puntuacion) {

        Mensaje mensajes = new Mensaje();
        String sql = SQL_FIND_ALL;
        boolean coincidencia = false;

        try {
            motorSql.connect();

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                if (rs.getInt(2) == id_user && rs.getInt(3) == id_obra) {
                    coincidencia = true;
                }
            }
            if (!coincidencia) {
                sql = SQL_INSERT;
                sql += "("+id_user+","+id_obra+","+puntuacion+",NOW())";
                int resp = this.motorSql.execute(sql);
                mensajes.setMensaje("Valoracion Añadida");
            }
            if(coincidencia){
                sql = SQL_UPDATE;
                sql += "puntuacion ="+puntuacion+" WHERE id_obra ="+id_obra+" AND id_user =" +id_user;
                int resp = this.motorSql.execute(sql);
                mensajes.setMensaje("Valoracion Updateada");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return mensajes;

    }
}


