package Daos;

import Beans.Banda;

import java.util.ArrayList;
import java.sql.*;

public class BandaDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";


    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }

    //En este caso se usa preparedStatement
    public ArrayList<Banda> obtenerListaBandas(String filter) {
        ArrayList<Banda> listabandas = new ArrayList<>();

        return listabandas;
    }


}
