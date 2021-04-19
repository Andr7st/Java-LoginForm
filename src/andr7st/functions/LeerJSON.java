package andr7st.functions;
/**
 * @author Andrés Segura
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LeerJSON {

    private String host ;
    private String usuario;
    private String contrasena;
    private String database;
    
    public String getHost() {
        return host;
    }


    public void setHost(String host) {
        this.host = host;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDatabaseName() {
        return database;
    }

    public void setDatabaseName(String database) {
        this.database = database;
    }



    public LeerJSON(String rutaJSON){

        File archivo = new File(rutaJSON);

        if (archivo.exists()) {
            
            try {    
                
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(rutaJSON));

                JSONObject archivoJSON  = (JSONObject) obj;
                JSONObject conexion     = (JSONObject) archivoJSON.get("dbconncect");
                JSONObject postgreSQL   = (JSONObject) conexion.get("postgresql");

                this.setHost(       postgreSQL.get("dbhost")       .toString());
                this.setUsuario(    postgreSQL.get("dbusername")       .toString());
                this.setContrasena( postgreSQL.get("dbpassword")       .toString());
                this.setDatabaseName(    postgreSQL.get("dbdatabase").toString());
                
            } 

            //catch(FileNotFoundException e){}
            catch(IOException e){

                System.err.println(e);
            }
            catch(ParseException e){

                System.err.println(e);
            } 
        }
        else {
            System.err.println(String.format("el archivo: %s\n no existe", rutaJSON));
        }
    }


}