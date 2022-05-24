package uf6.crud;

public class UF6CRUD {

    public static void main(String[] args) {
        
        ConnexioBD con = new ConnexioBD();

        con.connectar();
        
        con.consultaSelect("SELECT * FROM persones");
        con.consultaSelect2("SELECT * FROM instruments");
        
        con.consultaIUD("INSERT INTO persones VALUES ('12345678C','Alex','78945')");
        con.consultaIUD("INSERT INTO instruments VALUES ('3','guitarra','roja','12345678C')");
        
       
        //con.consultaIUD("DELETE FROM persones WHERE nom = 'Alex'");
        
       // con.consultaIUD("DELETE FROM instruments WHERE n_serie= 1");
        
       //con.consultaIUD("DELETE FROM instruments WHERE color= 'marron'");
        
       con.consultaSelect("SELECT * FROM persones WHERE dni= '12345678C'");
       
       con.consultaSelect2("SELECT * FROM instruments WHERE n_serie = 1");
              
        con.consultaSelect("SELECT * FROM persones");
        con.consultaSelect2("SELECT * FROM instruments");
        
        
        
        con.tancarConnexio();
    }
    
}
