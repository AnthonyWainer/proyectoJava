package gradosrmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @author anthonywainer
 */
public class grados {

    public static void main(String[] args) throws RemoteException {
        try {
            Interface i = new Implementacion();
            Naming.rebind("//localhost:9051/servi1", i);
            System.out.println("servidor encontrado");

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

}
