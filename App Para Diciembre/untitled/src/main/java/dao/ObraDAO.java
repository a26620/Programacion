package dao;

import model.Mensaje;
import model.Obra;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ObraDAO{
    private static final String SQL_INSERT = "INSERT INTO OBRA (titulo, descripcion, img, precio, id_sala, fechaActuacion) VALUES ";
    private static final String SQL_UPDATE = "UPDATE OBRA SET ";
    private static final String SQL_DELETE = " DELETE FROM OBRA WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM OBRA WHERE 1=1 ";   

    private MotorSQL motorSql;

    public ObraDAO() {
        this.motorSql = new MotorSQL();
    }


    public Mensaje add(String titulo, String descripcion, String img, float precio, int id_sala, String fechaActuacion) {

        String fechaInsert;

        try {
            SimpleDateFormat formatoFechaOriginal = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFechaOriginal.parse(fechaActuacion);
            SimpleDateFormat formatoFechaDeseada = new SimpleDateFormat("yyyy-MM-dd");
            fechaInsert = formatoFechaDeseada.format(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }



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
                sql += "('" + titulo + "', '" + descripcion + "', '" + img + "', " + precio + ", "+id_sala+", "+"'"+fechaInsert+"')";
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

    public ArrayList<Obra> listmostsell() {

        ArrayList<Obra> obras = new ArrayList<>();

        String sql = "SELECT OBRA.id_obra, OBRA.titulo, OBRA.img, COUNT(COMPRA.id_obra) as cantidad_vendida FROM OBRA \n" +
                "LEFT JOIN COMPRA ON OBRA.id_obra = COMPRA.id_obra \n" +
                "GROUP BY OBRA.id_obra \n" +
                "ORDER BY cantidad_vendida DESC LIMIT 10;";

        boolean coincidencia = false;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {

                Obra obra = new Obra();

                obra.setId_obra(rs.getInt(1));
                obra.setTitulo(rs.getString(2));
                obra.setImg(rs.getString(3));
                obras.add(obra);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return obras;

    }

    public ArrayList<Obra> list(int id_sala) {

        ArrayList<Obra> obras = new ArrayList<>();

        String sql = SQL_FIND_ALL ;

        if (id_sala != 0){
            sql +="AND id_sala ="+id_sala;
        }

        boolean coincidencia = false;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {

                Obra obra = new Obra();

                obra.setId_obra(rs.getInt(1));
                obra.setTitulo(rs.getString(2));
                obra.setDescripcion(rs.getString(3));
                obra.setImg(rs.getString(4));
                obra.setPrecio(Float.parseFloat(rs.getString(5)));
                obra.setId_sala(rs.getInt(6));
                obra.setFechaActuacion(rs.getString(7));

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