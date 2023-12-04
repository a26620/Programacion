package dao;

import model.Genero;
import model.Obra;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActuacionDAO {

    private static final String SQL_INSERT = "INSERT INTO OBRA_SALA (nombre) VALUES ";
    private static final String SQL_UPDATE = "UPDATE OBRA_SALA SET ";
    private static final String SQL_DELETE = " DELETE FROM OBRA_SALA WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM OBRA_SALA WHERE 1=1 ";

    private MotorSQL motorSql;

    public ActuacionDAO() {
        this.motorSql = new MotorSQL();
    }


    public ArrayList<Obra> list(int id_obra) {
        ArrayList<Obra> obras = new ArrayList<>();

        String sql = "SELECT ob.*, o.precio FROM OBRA_SALA ob INNER JOIN obra o on o.id_obra = ob.id_obra WHERE 1=1\n";
        sql += "AND ob.id_obra = "+id_obra;
        try {
            motorSql.connect();
            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {

                Obra obra = new Obra();
                obra.setId_actuacion(rs.getInt(1));
                obra.setId_obra(rs.getInt(2));
                obra.setId_sala(rs.getInt(3));
                obra.setFechaActuacion(rs.getString(4));
                obra.setHoraActuacion(rs.getString(5));
                obra.setPrecio(rs.getFloat(6));
                obras.add(obra);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return obras;
    }
}

