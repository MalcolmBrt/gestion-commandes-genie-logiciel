package abstractfactory;

import java.sql.*;
import java.util.HashMap;

public class ConnexionBDD {
    private String URL = "jdbc:mysql://localhost:3306/resto_bdd";
    private String DB_USER = "root";
    private String DB_PASSWORD = "";

    public HashMap<Integer, Plat> getMenu() {
        HashMap<Integer, Plat> menu = new HashMap<Integer, Plat>();
        String sql = "SELECT * FROM menu";
        try (Connection connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                menu.put(resultSet.getInt("numero"), new Plat(resultSet.getString("nom"), resultSet.getInt("prix")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }

}
