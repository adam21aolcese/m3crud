package uf6.crud;

public class UF6CRUD {

    public static void main(String[] args) {

        ConnexioBD con = new ConnexioBD();

        con.connectar();

        System.out.println("---------------------------");
        System.out.println("Añadimos tres persona y tres instrumento");

        con.consultaIUD("INSERT INTO persones VALUES ('12345678C','Alex','78945',null)");
        con.consultaIUD("INSERT INTO persones VALUES('78945612B', 'Maria', 13545, null)");
        con.consultaIUD("INSERT INTO persones VALUES('12345678P', 'Pepe', 12315, null)");

        con.consultaIUD("INSERT INTO instruments VALUES ('101200AB','trompeta','amarilla','12345678P')");
        con.consultaIUD("INSERT INTO instruments VALUES ('101201AB','violin','marron','78945612B')");
        con.consultaIUD("INSERT INTO instruments VALUES ('101202AB','piano','negre','12345678C')");
        con.consultaIUD("INSERT INTO instruments VALUES ('101203AB','bajo','verde','78945612B')");

        System.out.println("---------------------------");
        con.consultaSelect("SELECT * FROM persones");
        con.consultaSelect2("SELECT * FROM instruments");
        System.out.println("---------------------------");
        System.out.println("Consulta donde se cambia el nombre de la persona con el dni especifico");

        con.consultaIUD("UPDATE persones SET nom = 'Fernando' WHERE dni = '12345678P'");
        con.consultaSelect("SELECT * FROM persones");
        System.out.println("---------------------------");

        System.out.println("Consulta donde se cambia el dni a una persona");
        con.consultaIUD("UPDATE persones SET dni = '12345678F' WHERE dni = '78945612B'");
        con.consultaSelect("SELECT * FROM persones");

        System.out.println("---------------------------");

        System.out.println("Eliminamos una persona y dos instrumentos");

        System.out.println("Se ha eliminado a esta persona junto a su instrumento");
        con.consultaIUD("DELETE FROM persones WHERE nom = 'Alex'");

        con.consultaSelect("SELECT * FROM persones");
        con.consultaSelect2("SELECT * FROM instruments");
        System.out.println("---------------------------");

        System.out.println("Se ha eliminado un instrumento con un n_serie");
        con.consultaIUD("DELETE FROM instruments WHERE n_serie = '101203AB'");

        con.consultaSelect2("SELECT * FROM instruments");
        System.out.println("---------------------------");

        System.out.println("Se ha eliminado un instrumento de color marron");
        con.consultaIUD("DELETE FROM instruments WHERE color = 'marron'");

        con.consultaSelect2("SELECT * FROM instruments");
        System.out.println("---------------------------");

        System.out.println("Seleccionamos una persona y un instrumento por su clave primaria");

        con.consultaSelect("SELECT * FROM persones WHERE dni = '12345678P'");

        con.consultaSelect2("SELECT * FROM instruments WHERE n_serie = '101200AB'");
        System.out.println("---------------------------");

        System.out.println("Mostrar el instrumento de una persona con sentencias preparadas");

        con.consultaSelectPS("SELECT * FROM instruments WHERE clau_persona = ? ", "12345678P");

        System.out.println("Mostrar el propietario de un instrumento con sentencias preparadas");

        con.consultaSelectPS2("SELECT * FROM instruments JOIN persones ON "
                + "(clau_persona = dni) WHERE n_serie = ? ", "101200AB");

        System.out.println("---------------------------");
        System.out.println("Inserccion de la banda");
        con.consultaIUD("INSERT INTO banda VALUES('1', 'Banda1')");
        con.consultaIUD("INSERT INTO banda VALUES('2', 'Banda2')");

        System.out.println("---------------------------");
        con.consultaIUD("INSERT INTO persones VALUES ('12345678D','Pedro','63928', 1)");
        con.consultaIUD("INSERT INTO persones VALUES ('12345678E','Xavi','99163', 2)");
        con.consultaIUD("INSERT INTO persones VALUES ('12345678T','Jorge','13428', 2)");
        con.consultaIUD("INSERT INTO persones VALUES ('12345678G','Manuel','56521', 2)");

        con.consultaIUD("INSERT INTO instruments VALUES ('4','piano','negro','12345678D')");
        con.consultaIUD("INSERT INTO instruments VALUES ('5','bateria','azul','12345678E')");
        con.consultaIUD("INSERT INTO instruments VALUES ('6','violin','marron','12345678T')");
        con.consultaIUD("INSERT INTO instruments VALUES ('7','flauta','amarilla','12345678G')");

        System.out.println("---------------------------");

        con.consultaSelect3("SELECT * FROM banda");

        System.out.println("---------------------------");
        System.out.println("Seleccionamos las personas participantes de la banda con su clave primaria");

        con.consultaSelect("SELECT * FROM persones WHERE id_banda = 1");
        
        System.out.println("---------------------------");
        System.out.println("Seleccionamos las bandas con un nombre especifico");
        con.consultaSelect3("SELECT * FROM banda WHERE nom_banda = 'Banda2'");

        System.out.println("---------------------------");
        System.out.println("Cambiamos el nombre a una banda");

        con.consultaIUD("UPDATE banda SET nom_banda = 'Segona banda' WHERE id_banda = 2");
        con.consultaSelect3("SELECT * FROM banda");
        System.out.println("---------------------------");

        System.out.println("Eliminamos una banda");

        con.consultaIUD("DELETE FROM banda WHERE id_banda = 1");
        con.consultaSelect3("SELECT * FROM banda");
        con.consultaSelect("SELECT * FROM persones");

        con.tancarConnexio();
    }

}
