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
    private static final String SQL_INSERT = "INSERT INTO OBRA (titulo, descripcion, duracion, precio, id_genero, edadRecomendada) VALUES ";
    private static final String SQL_UPDATE = "UPDATE OBRA SET ";
    private static final String SQL_DELETE = " DELETE FROM OBRA WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM OBRA WHERE 1=1 ";

    private MotorSQL motorSql;

    public ObraDAO() {
        this.motorSql = new MotorSQL();
    }

    public Mensaje add(String titulo, String descripcion, int duracion, float precio, String id_genero, String edadRecomendada) {





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
                sql += "('" + titulo + "', '" + descripcion + "', '" + duracion + "', " + precio + ", "+id_genero+", "+"'"+edadRecomendada+"')";
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

        String sql = "SELECT o.id_obra, o.titulo, COUNT(c.id_compra) AS cantidad_vendida " +
                "FROM OBRA o " +
                "LEFT JOIN COMPRA c ON o.id_obra = c.id_actuacion " +
                "GROUP BY o.id_obra, o.titulo " +
                "ORDER BY cantidad_vendida DESC LIMIT 10";


        System.out.println(sql);

        boolean coincidencia = false;

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {

                Obra obra = new Obra();

                obra.setId_obra(rs.getInt(1));
                obra.setTitulo(rs.getString(2));
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

    public ArrayList<Obra> listbestrating() {

        ArrayList<Obra> obras = new ArrayList<>();

        String sql = "SELECT o.id_obra, o.titulo, CASE " +
                "WHEN AVG(v.puntuacion) IS NULL THEN 0 " +
                "ELSE ROUND(AVG(v.puntuacion), 2) " +
                "END AS puntuacion_media " +
                "FROM OBRA o " +
                "LEFT JOIN VALORACION v ON o.id_obra = v.id_obra " +
                "GROUP BY o.id_obra, o.titulo " +
                "ORDER BY puntuacion_media DESC LIMIT 10";;


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

    public ArrayList<Obra> fichaDescriptiva(int id_obra) {

        ArrayList<Obra> obras = new ArrayList<>();

        String sql = "SELECT o.id_obra, o.titulo, o.descripcion, o.precio, " +
                "COALESCE(ROUND(AVG(v.puntuacion), 2), 0) AS valoracion_media, " +
                "g.nombre AS nombre_genero, o.edadRecomendada, o.duracion " +
                "FROM OBRA o " +
                "LEFT JOIN VALORACION v ON o.id_obra = v.id_obra " +
                "LEFT JOIN GENERO g ON o.id_genero = g.id_genero " +
                "WHERE o.id_obra = "+id_obra;


        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {

                Obra obra = new Obra();

                obra.setId_obra(rs.getInt(1));
                obra.setTitulo(rs.getString(2));
                obra.setDescripcion(rs.getString(3));
                obra.setPrecio(rs.getFloat(4));
                obra.setValoracionMedia(rs.getFloat(5));
                obra.setGenero(rs.getString(6));
                obra.setEdadRecomendada(rs.getInt(7));
                obra.setDuracion(rs.getInt(8));
                obras.add(obra);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return obras;

    }

    public ArrayList<Obra> listfilter(String[] id_generos, String[] edadRecomendada) {


        ArrayList<Obra> obras = new ArrayList<>();

        String sql = SQL_FIND_ALL;

        if (id_generos[0] != "") {
            sql += " AND id_genero IN(";

            for(int i = 0;i < id_generos.length; i++){
                sql+= id_generos[i]+", ";
            }
            sql = sql.substring(0, sql.length()-2);
            sql += ")";
        }
        if (edadRecomendada[0] != "") {
            sql += " AND edadRecomendada IN(";
            for(int i = 0;i < edadRecomendada.length; i++){
                sql+= edadRecomendada[i]+", ";
            }
            sql = sql.substring(0, sql.length()-2);
            sql += ")";
        }

        try {
            motorSql.connect();
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {

                Obra obra = new Obra();

                obra.setId_obra(rs.getInt(1));
                obra.setTitulo(rs.getString(2));
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