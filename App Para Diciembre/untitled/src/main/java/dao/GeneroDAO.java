package dao;

import model.Genero;
import model.Mensaje;
import model.Sala;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GeneroDAO {
    private static final String SQL_INSERT = "INSERT INTO GENERO (nombre) VALUES ";
    private static final String SQL_UPDATE = "UPDATE GENERO SET ";
    private static final String SQL_DELETE = " DELETE FROM GENERO WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM GENERO WHERE 1=1 ";

    private MotorSQL motorSql;

    public GeneroDAO() {
        this.motorSql = new MotorSQL();
    }


    public ArrayList<Genero> list() {
        ArrayList<Genero> generos = new ArrayList<>();

        String sql = SQL_FIND_ALL;

        try {
            motorSql.connect();
            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {

                Genero genero = new Genero();
                genero.setId_genero(rs.getInt(1));
                genero.setNombre(rs.getString(2));
                generos.add(genero);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return generos;

    }
}
