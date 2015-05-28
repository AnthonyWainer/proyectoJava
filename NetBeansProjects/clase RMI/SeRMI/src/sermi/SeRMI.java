
package sermi;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @author anthonywainer
 */
public class SeRMI {

    public static void main(String[] args) throws RemoteException{
        try{
        Interfas i = new Implementacion();
        Naming.rebind("//localhost:9050/sumita", i);
        System.out.println("servidor encontrado");

        }catch(Exception e){
         System.out.println("error: "+e.getMessage());
        }
    }
    
}
