package dao;

import model.Mensaje;
import model.Sala;
import model.User;
import motor.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO{
    private static final String SQL_INSERT = "INSERT INTO USR VALUES ";
    private static final String SQL_UPDATE = "UPDATE USR SET ";
    private static final String SQL_DELETE = " DELETE FROM USR WHERE ";
    private static final String SQL_FIND_ALL = "SELECT  *  FROM USR WHERE 1=1 ";   

    private MotorSQL motorSql;

    public UserDAO() {
        this.motorSql = new MotorSQL();
    }


    public ArrayList<User> login(String username, String pass) {

        ArrayList<User> lstUser = new ArrayList<>();


        String sql = SQL_FIND_ALL;
        boolean coincidencia = false;

        try {
            motorSql.connect();

            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString(2).equals(username) && rs.getString(4).equals(pass)) {
                    User user = new User();
                    user.setId_user(rs.getInt(1));
                    user.setUsername(rs.getString(2));
                    user.setEmail(rs.getString(3));
                    user.setPass(rs.getString(4));
                    user.setRol(rs.getString(5));
                    lstUser.add(user);
                    coincidencia = true;
                }
            }
            if (!coincidencia) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return lstUser;

    }
}


