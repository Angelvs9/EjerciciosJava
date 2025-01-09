import ej3_2angel.gestorConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3_2Angel {
    List<String> nombresDeTablas = new ArrayList<>();

    public List<String> obtenerNombresDeTablas(Connection conexionRemota) {
        nombresDeTablas = new ArrayList<>();
        try {
            Statement stmtRemoto = conexionRemota.createStatement();
            String consulta="SHOW TABLES";
            ResultSet rs = stmtRemoto.executeQuery(consulta);
            while (rs.next()) {
                nombresDeTablas.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: al obtener los nombres de las tablas");
            ex.printStackTrace();
        }
        return nombresDeTablas;
    }

    public List<String> obtenerNombresDeColumnas(String tabla, Connection conexionRemota) {
        List<String> nombresDeColumnas = new ArrayList<>();
        try {
            Statement stmtRemoto = conexionRemota.createStatement();
            String consulta="SHOW COLUMNS FROM " + tabla;
            ResultSet rs = stmtRemoto.executeQuery(consulta);
            while (rs.next()) {
                nombresDeColumnas.add(rs.getString("Field"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: al obtener los nombres de las columnas");
            ex.printStackTrace();
        }
        return nombresDeColumnas;
    }

    public void copiarDatos(String tabla, List<String> columnas, Connection conexionRemota, Connection conexionLocal) {
        try {
            Statement stmtRemoto = conexionRemota.createStatement();
            ResultSet rs = stmtRemoto.executeQuery("SELECT * FROM " + tabla);
            Statement stmtLocal = conexionLocal.createStatement();
            while (rs.next()) {
                //EL IGNORE ES PARA QUE SI SE REPITEN DATOS PUES QUE NO INSERTE, QUE PASE DE EL
                String insert = "INSERT IGNORE INTO " + tabla + " (";
                for (int i = 0; i < columnas.size(); i++) {
                    insert += columnas.get(i);
                    if (i < columnas.size() - 1) insert += ", ";
                }
                insert += ") VALUES (";
                for (int i = 0; i < columnas.size(); i++) {
                    insert += "'" + rs.getString(columnas.get(i)) + "'";
                    if (i < columnas.size() - 1) insert += ", ";
                }
                insert += ")";
                stmtLocal.executeUpdate(insert);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: al copiar los datos");
            ex.printStackTrace();
        }
    }




    public static void main(String[] args) {
        String bdNombre = "addamagil0";
        String urlRemota = "jdbc:mysql://db4free.net:3306/";
        String userRemoto = "tgilito";
        String passwdRemoto = "qwerty22";

        String urlLocal = "jdbc:mysql://localhost:3306/";

        gestorConexion conexionRemota = new gestorConexion(bdNombre, urlRemota, userRemoto, passwdRemoto);
        gestorConexion conexionLocal = new gestorConexion(bdNombre, urlLocal, "root", "");

        Ejercicio3_2Angel copiador = new Ejercicio3_2Angel();

        List<String> tablas = copiador.obtenerNombresDeTablas(conexionRemota.getConexion());

        for (int i = 0; i < tablas.size(); i++) {
            List<String> columnas = copiador.obtenerNombresDeColumnas(tablas.get(i), conexionRemota.getConexion());
            copiador.copiarDatos(tablas.get(i), columnas, conexionRemota.getConexion(), conexionLocal.getConexion());
        }

        conexionRemota.cerrar_Conexion();
        conexionLocal.cerrar_Conexion();

    }
    
}
