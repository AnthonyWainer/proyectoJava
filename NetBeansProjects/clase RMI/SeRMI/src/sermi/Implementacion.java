
package sermi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author anthonywainer
 */
public class Implementacion extends UnicastRemoteObject implements Interfas {
    
    public Implementacion() throws RemoteException{
        super();
    }

    @Override
    public int suma(int a, int b) throws RemoteException {
        return a+b;
        //throw new UnsupportedOperationException("Not supported yet."); 
    }
}
