package andr7st.functions;
/**
 * @author Andrés Segura.
 */
import java.sql.*;

public class ConectarDB {

    private String ConexionDatabaseHost;
    private String conexionDatabaseUsuario;
    private String conexionDatabaseContrasena;
    private String conexionDatabaseNombreDatabase;

    // boolean esUsuario = false; // Si se encuentra el nombre de usuario en la bd = true. 

    String usuarioEvaluar;
    String contrasenaEvaluar;

    public String getUsuario() {
        return this.usuarioEvaluar;
    }
    public String getContrasena() {
        return this.contrasenaEvaluar;
    }

/*     public boolean getEsUsuario() {
        return this.esUsuario;
    } */

    private Connection conexionSQL = null;

    public ConectarDB(String usuarioForm) {

        this.obtenerConfig(); // Ontener la configuración de conexion guardada en el archivo 'config.dat'
          
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.err.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            
            String dbURL = "jdbc:postgresql://"
            .concat(ConexionDatabaseHost)
            .concat(":")
            .concat("5432")
            .concat("/")
            .concat(this.conexionDatabaseNombreDatabase);
            
            // Database connect
            // Conectamos con la base de datos
            this.conexionSQL = DriverManager.getConnection(dbURL, this.conexionDatabaseUsuario, this.conexionDatabaseContrasena);


            String comandoPostgreSQL = "SELECT * FROM usuarios WHERE usuario = '" + usuarioForm + "'";

            PreparedStatement pstm = this.conexionSQL.prepareStatement(comandoPostgreSQL);
            
            ResultSet resultset = pstm.executeQuery();

            while(resultset.next()) {

                this.usuarioEvaluar = resultset.getString("usuario");
                this.contrasenaEvaluar = resultset.getString("contrasena");
        
            }
            

       /*      else{
                
                Statement statement;
                statement = conexionSQL.createStatement();
                statement.executeUpdate(comandoPostgreSQL);

            } */

            boolean valid = this.conexionSQL.isValid(50000);
            
            System.out.println(valid ? "PostgreSQL conected OK" : "PostgreSQL conect FAIL");
        } 
        
        catch (java.sql.SQLException sqle) {
            System.err.println("Error:\n" + sqle);
        }
        
        finally {
            /// Cerrar para evitar consumo de recursos innecesarios
            if(this.conexionSQL != null) {
                
                try { 
                    this.conexionSQL.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
    }

    public void obtenerConfig() {
        
        LeerJSON postgreSQL = new LeerJSON("config.dat");

        this.conexionDatabaseUsuario    = postgreSQL.getUsuario();
        this.conexionDatabaseContrasena = postgreSQL.getContrasena();
        this.ConexionDatabaseHost       = postgreSQL.getHost();
        this.conexionDatabaseNombreDatabase = postgreSQL.getDatabaseName();

    }
}