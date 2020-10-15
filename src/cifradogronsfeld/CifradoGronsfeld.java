
package cifradogronsfeld;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
//NESTOR CASTELLANOS - YERNEY WINTACO

public class CifradoGronsfeld {

    public static void main(String[] args) {

        Conexion con = new Conexion();
        con.conectar();
        Connection connection = con.getConnetion();
        //con.desconectar();
        System.out.println("Ingrese el mensaje a cifrar");
        Scanner msg = new Scanner (System.in);
        String mensaje = msg.nextLine();
        mensaje=mensaje.toUpperCase();
        System.out.println("Ingrese la clave para cifrar");
        Scanner llave = new Scanner (System.in);
        int clave = llave.nextInt();
                       
        Cifrar c;
        c= new Cifrar (mensaje,clave);
    }
    
}
