package dao;

import model.Genero;
import model.Mensaje;
import model.Compra;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

    public class CompraDAO{
        private static final String SQL_INSERT = "INSERT INTO COMPRA (id_user,id_actuacion,importe,fechaCompra,nEntradas) VALUES ";
        private static final String SQL_UPDATE = "UPDATE COMPRA SET ";
        private static final String SQL_DELETE = " DELETE FROM COMPRA WHERE ";
        private static final String SQL_FIND_ALL = "SELECT  *  FROM COMPRA WHERE 1=1 ";

        private MotorSQL motorSql;

        public CompraDAO() {
            this.motorSql = new MotorSQL();
        }

        public Mensaje add(int id_user, int id_actuacion, float importe, int nEntradas) {

            Mensaje mensajes = new Mensaje();
            String sql = "";
            boolean coincidencia = false;

            try {
                motorSql.connect();
                sql = SQL_INSERT;
                sql += "("+id_user+","+id_actuacion+","+importe+",NOW(),"+nEntradas+")";
                int resp = this.motorSql.execute(sql);
                mensajes.setMensaje("Compra Añadida");
            } finally {
                motorSql.disconnect();
            }

            return mensajes;

        }

        public ArrayList<Compra> list(int id_user) {
            ArrayList<Compra> compras = new ArrayList<>();

            String sql = "SELECT OBRA.titulo, COMPRA.* FROM COMPRA INNER JOIN OBRA_SALA ON COMPRA.id_actuacion = OBRA_SALA.id_actuacion INNER JOIN OBRA ON OBRA_SALA.id_obra = OBRA.id_obra WHERE COMPRA.id_user =" + id_user;

            try {
                motorSql.connect();
                System.out.println(sql);
                ResultSet rs = motorSql.executeQuery(sql);

                while (rs.next()) {

                    Compra compra = new Compra();
                    compra.setTituloObra(rs.getString(1));
                    compra.setFechaCompra(rs.getString(5));
                    compra.setnEntradas(rs.getInt(6));
                    compra.setImporte(rs.getFloat(7));
                    compras.add(compra);

                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                motorSql.disconnect();
            }
            return compras;

        }
    }
