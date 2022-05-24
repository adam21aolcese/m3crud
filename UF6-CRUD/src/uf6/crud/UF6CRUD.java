package uf6.crud;

public class UF6CRUD {

    public static void main(String[] args) {
        
        ConnexioBD con = new ConnexioBD();

        con.connectar();
        
        con.consultaSelect("SELECT * FROM persones");
        con.consultaSelect2("SELECT * FROM instruments");
        
        con.tancarConnexio();
    }
    
}
