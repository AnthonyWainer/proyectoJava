package servrmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @author anthonywainer
 */
public class ServRMI {

    public static void main(String[] args) throws RemoteException{
        try{
        InterRMI i = new ImpleRMI();
        Naming.rebind("//localhost:9050/servi1", i);
        System.out.println("servidor encontrado");

        }catch(Exception e){
         System.out.println("error: "+e.getMessage());
        }
    }
    
}
