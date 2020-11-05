package Daos;

import Beans.BBodegas;

import java.sql.*;
import java.util.ArrayList;

public class BodegasDao {
    //funcionalidades
    public ArrayList<BBodegas> listaBodegas() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String usuario = "root";
        String password = "root";

        String url = "jdbc:mysql://localhost:3306/grupo1_db?serverTimezone=America/Lima";

        String sql=
               "select b.nombreBodega, d.nombreDistrito, b.direccion, b.valoracion " +
                "from bodega b, distrito d where b.idDistrito =d.idDistrito order by d.nombreDistrito asc";

        ArrayList<BBodegas> listaBodegas=new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, usuario, password);){
            Statement stmt= connection.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while(rs.next()){
                //objeto
                BBodegas bodega=new BBodegas();
                bodega.setNombreBodega(rs.getString(1));
                bodega.setDistrito(rs.getString(2));
                bodega.setDireccion(rs.getString(3));
                bodega.setValoracion(rs.getInt(4));
                listaBodegas.add(bodega);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaBodegas;
    }
}
