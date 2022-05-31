package uf6.crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexioBD {

    private Connection con = null;
    private String driver = "com.mysql.cj.jdbc.Driver";//Classe Driver
    private String cadenaConnexio = "jdbc:mysql://localhost:3306/CRUD";
    private String usuari = "root";
    private String contrasenya = "1234";

    public ConnexioBD() {
    }

    public ConnexioBD(String driver, String cadenaConnexio, String usuari, String contrasenya) {
        this.driver = driver;
        this.cadenaConnexio = cadenaConnexio;
        this.usuari = usuari;
        this.contrasenya = contrasenya;
    }

    /**
     * Carrega la classe Driver de la llibreria jdbc per a mysql, obté una
     * instància de la classe Connection, amb la connexió oberta amb el SGBD a
     * la BD indicada a la cadena de connexió.
     *
     * @return torna true si s'estableix la connexió i false en cas contrari.
     */
    public boolean connectar() {
        boolean comprova = false;

        try {
            Class.forName(driver); //es carrega el la classe Driver
            con = DriverManager.getConnection(cadenaConnexio, usuari, contrasenya);
            comprova = true;
            System.out.println("Connexió establerta");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Problemes amb la connexió: \n" + e.getMessage());
        } finally {
            return comprova;
        }
    }

    /**
     * Comprova si l'objecte Connection s'ha creat i es troba oberta, en aquest
     * cas tanca la connexió.
     *
     * @return true si la connexió estava oberta i es tanca, false en cas de no
     * estar creat l'objecte Connection o que ja estava tancada.
     */
    public boolean tancarConnexio() {
        boolean comprova = false;
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                comprova = true;
                System.out.println("Connexió tancada.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return comprova;
    }

    /**
     * Torna l'objecte Connection si s'ha creat abans amb el mètode connectar()
     *
     * @return la instància creada de Connection si ha esta creada i null en cas
     * contrari.
     */
    public Connection getCon() {
        return con;
    }

    public void consultaSelect(String sql) {

        Statement miConsulta;
        ResultSet registres;

        try {
            //Creamos un objeto Consulta
            miConsulta = con.createStatement();
            //Ejectutamos la consulta y obtenemos el resultado
            registres = miConsulta.executeQuery(sql);

            System.out.println("dni : nom : telefon : id_banda");
            while (registres.next()) {
                System.out.println(registres.getString("dni")
                        + "  : " + registres.getString("nom")
                + "  : " + registres.getString("telefon")+ " : "
                +registres.getString("id_banda"));

            }
            System.out.println("Consulta realitzada correctament\n");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void consultaSelect2(String sql) {

        Statement miConsulta;
        ResultSet registres;

        try {
            //Creamos un objeto Consulta
            miConsulta = con.createStatement();
            //Ejectutamos la consulta y obtenemos el resultado
            registres = miConsulta.executeQuery(sql);

            System.out.println("n_serie : tipus_instrument : color : clau_persona");
            while (registres.next()) {
                System.out.println(registres.getString("n_serie")
                        + "  : " + registres.getString("tipus_instrument")
                + "  : " + registres.getString("color")
                + "  : " + registres.getString("clau_persona"));

            }
            System.out.println("Consulta realitzada correctament\n");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void consultaIUD(String sql) {

        Statement miConsulta;

        try {
            miConsulta = con.createStatement();
            miConsulta.executeUpdate(sql);
            System.out.println("Instrucció executada correctament\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void consultaSelect3(String sql) {

        Statement miConsulta;
        ResultSet registres;

        try {
            //Creamos un objeto Consulta
            miConsulta = con.createStatement();
            //Ejectutamos la consulta y obtenemos el resultado
            registres = miConsulta.executeQuery(sql);

            System.out.println("id_banda : nom_banda");
            while (registres.next()) {
                System.out.println(registres.getString("id_banda")
                        + "  : " + registres.getString("nom_banda"));

            }
            System.out.println("Consulta realitzada correctament\n");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    

    public void consultaSelectPS(String sql, String dni ) {

        PreparedStatement miConsulta;
        ResultSet registres;

        try {
            miConsulta = con.prepareStatement(sql);
           
            miConsulta.setString(1, dni);
            registres = miConsulta.executeQuery();
            while (registres.next()) {
                System.out.println(registres.getString("n_serie")
                        + "  : " + registres.getString("tipus_instrument")+" : " + 
                        registres.getString("color")+ " : "+
                        registres.getString("clau_persona"));

            }
            System.out.println("Consulta realitzada correctament\n");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void consultaSelectPS2(String sql, String n_serie ) {

        PreparedStatement miConsulta;
        ResultSet registres;

        try {
            miConsulta = con.prepareStatement(sql);
           
            miConsulta.setString(1, n_serie);
            registres = miConsulta.executeQuery();
            while (registres.next()) {
                System.out.println(registres.getString("dni")
                        + "  : " + registres.getString("nom")+" : " + 
                        registres.getString("telefon")+ " : "+
                        registres.getString("id_banda"));

            }
            System.out.println("Consulta realitzada correctament\n");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
