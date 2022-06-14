package Daos;

import Beans.Cancion;
import Beans.Reproduccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

public class CancionDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";


    public ArrayList<Cancion> CancionesPorBanda(String textoBuscar) {
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        String user = "root";
        String pass = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "select * from cancion where banda='?' ";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1,textoBuscar.toLowerCase());

            try (ResultSet rs = preparedStatement.executeQuery();) {
                while (rs.next()) {
                    Cancion cancion = new Cancion();
                    cancion.setIdcancion(rs.getInt(1));
                    cancion.setCancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    listaCanciones.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCanciones;
    }

}
