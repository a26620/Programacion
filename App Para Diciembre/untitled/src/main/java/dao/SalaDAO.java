package dao;

import model.Sala;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaDAO{
    private static final String SQL_INSERT = "INSERT INTO SALA VALUES ";
    private static final String SQL_UPDATE = "UPDATE SALA SET ";
    private static final String SQL_DELETE = " DELETE FROM SALA WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM SALA WHERE 1=1 ";   

    private MotorSQL motorSql;

    public SalaDAO() {
        this.motorSql = new MotorSQL();
    }


    public ArrayList<Sala> list() {

        ArrayList<Sala> salas = new ArrayList<>();

        String sql = SQL_FIND_ALL;

        boolean coincidencia = false;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
            
                Sala sala = new Sala();
                
                sala.setNombre(rs.getString(2));
                sala.setCapacidad(rs.getInt(3));
                sala.setId_sala(rs.getInt(1));
                salas.add(sala);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return salas;

    }
}