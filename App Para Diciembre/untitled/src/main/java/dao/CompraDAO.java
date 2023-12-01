package dao;

import model.Mensaje;
import model.Compra;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

    public class CompraDAO{
        private static final String SQL_INSERT = "INSERT INTO COMPRA (id_user,id_actuacion,importe,fechaCompra) VALUES ";
        private static final String SQL_UPDATE = "UPDATE COMPRA SET ";
        private static final String SQL_DELETE = " DELETE FROM COMPRA WHERE ";
        private static final String SQL_FIND_ALL = "SELECT  *  FROM COMPRA WHERE 1=1 ";

        private MotorSQL motorSql;

        public CompraDAO() {
            this.motorSql = new MotorSQL();
        }

        public Mensaje add(int id_user, int id_actuacion, float importe) {

            Mensaje mensajes = new Mensaje();
            String sql = "";
            boolean coincidencia = false;

            try {
                motorSql.connect();
                sql = SQL_INSERT;
                sql += "("+id_user+","+id_actuacion+","+importe+",NOW())";
                int resp = this.motorSql.execute(sql);
                mensajes.setMensaje("Compra Añadida");
            } finally {
                motorSql.disconnect();
            }

            return mensajes;

        }
    }
}
