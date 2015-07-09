
package clientermi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import serrmi.Interfas;

/**
 * @author anthonywainer
 */
public class ClienteRMI {
     public int leer(String num){
            Scanner sc = new Scanner(System.in);
            System.out.println(num);
            int p = sc.nextInt();
            return p;
        }
      public static void main(String[] args) throws RemoteException{
        try{
        Interfas i = (Interfas)Naming.lookup("//localhost:9050/sumita");
        //Interfas i = (Interfas)Naming.lookup("//192.168.4.53:9056/sumita");
        ClienteRMI cli= new ClienteRMI();
        int a = cli.leer("Escribir el primer numero: ");
        int b = cli.leer("Escribir el segundo numero: ");
        int s = i.suma(a,b);
        System.out.println("El resultado de la suma: "+s);

        }catch(Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }
    
}
