package dao;

import model.Genero;
import model.Mensaje;
import model.Obra;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActuacionDAO {

    private static final String SQL_INSERT = "INSERT INTO OBRA_SALA (id_obra, id_sala, fechaActuacion, horaActuacion) VALUES ";
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

    public Mensaje add(int id_obra, int id_sala , String Fecha, String Hora) {



        Mensaje mensajes = new Mensaje();
        String sql = SQL_FIND_ALL;
        boolean coincidencia = false;

        try {
            motorSql.connect();

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                if (rs.getInt(2) == id_sala && rs.getString(3).equals(Fecha) && rs.getString(4).equals(Hora)) {
                    coincidencia = true;
                    mensajes.setMensaje("Ya Existe esta Obra");
                }
            }

            if (!coincidencia) {
                SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = inputFormat.parse(Fecha);
                String formattedFecha = outputFormat.format(date);
                sql = SQL_INSERT;
                sql += "(" + id_obra + "," + id_sala + ",'" + formattedFecha + "', '" + Hora + "')";
                int resp = this.motorSql.execute(sql);
                mensajes.setMensaje("Obra Añadida");
            }
        } catch (SQLException e) {
            System.out.println(e);
            mensajes.setMensaje("Añadir obra fallido");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            motorSql.disconnect();
        }
        return mensajes;
    }

}

