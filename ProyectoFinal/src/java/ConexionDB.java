

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexionDB {
    // Datos de conexion

    private final String driver = "com.mysql.jdbc.Driver";
    private final String name_dir = "jdbc:mysql://localhost:3306/db_cursos";
    private final String user_db = "root";
    private final String pass_db = "";
    private Connection con;
    private PreparedStatement pst;

    /**
     * Constructor que realiza la conexion cuando se instancia un objeto
     * Conexion
     */
    public ConexionDB() {
        try {
            // Driver de conexion, en este caso estoy utilizando el de postgresql
            Class.forName(driver);
            // Creo conexion con la base de datos a partir de los datos de conexion
            con = DriverManager.getConnection(name_dir, user_db, pass_db);
        } catch (Exception e) {
            //Si ocurre un error lo capturo
            System.out.println("Error en la Conexión ");
            System.out.println(e.getMessage());
        }
    }

    /**
     * A partir de una consulta SQL realizada por el usuario obtiene un
     * resultado
     *
     * @param sql
     * @return
     */
    public ArrayList<String[]> consulta(String sql) {
        
        ArrayList<String[]> datos = new ArrayList<String[]>();
        
        System.out.println("Consulta : " + sql + "\n"); // Declaracion en null del resultSet
        try {
            int registros = 0; //Variable para contar los registros
            pst = con.prepareStatement(sql); //Preparo la sentencia sql a ejecutar
            ResultSet rs = pst.executeQuery(); //Obtengo los datos de la consulta en un resultset
            //Guardo los datos del ResultSet en un ResultSetMetadata para jugar un poco mas
            ResultSetMetaData rsm = rs.getMetaData();
            //Obtengo los nombres de las columnas: D
            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                System.out.print("" + rsm.getColumnName(i) + " | ");
            }

            System.out.println("");
            while (rs.next()) {
                String[] fila = new String[rsm.getColumnCount()];
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    System.out.print(rs.getString(i) + " | ");
                    fila[i-1] = rs.getString(i);
                }
                registros++;
                System.out.println("");
                
                datos.add(fila);
            }
            System.out.println("\nCantidad de registros : " + registros);
            System.out.println("------------------------------------------------- \n");
            pst.close(); //Libero datos del PreparedStatement, tambien se libera el ResultSet
        } catch (SQLException e) {
            e.printStackTrace(); // Capturo la excepcion en caso de error
        }
        
        return datos;
    }

    /**
     * Se encarga de ejecutar sentencias DML del tipo: UPDATE, DELETE, INSERT...
     *
     * @param sql
     */
    public void sentencia(String sql) {
        System.out.println("Sentencia : " + sql + "\n"); // Declaracion en null del resultSet
        try {
            pst = con.prepareStatement(sql); //Preparo la sentencia sql a ejecutar
            int registros = pst.executeUpdate(); //Obtengo datos de consulta - Cuento los regs
            System.out.println("\nCantidad de registros afectados : " + registros);
            System.out.println("------------------------------------------------- \n");
            pst.close(); //Libero datos del PreparedStatement, tambien se libera ResultSet
        } catch (SQLException e) {
            e.printStackTrace(); // Capturo la excepcion en caso de error
        }
    }
}
