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

        String sql = "select idcancion, nombre_cancion, banda from cancion c, reproduccion r where c.idcancion=r.cancion_idcancion group by cancion_idcancion having count(*) >2 order by count(*) desc";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select * from jobs");) {

            while (rs.next()) {
                Banda banda = new Banda();
                banda.Banda(rs.getInt(1),rs.getString(2),rs.getString(3));
                listabandas.add(banda);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listabandas;
    }


}
