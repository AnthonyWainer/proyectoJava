
package practicarmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author anthonywainer
 */
public class Implementacion extends UnicastRemoteObject implements Interface {
    
    public Implementacion() throws RemoteException{
        super();
    }
    @Override
    public Double pies(Integer m){
        double P;
        P = m * 3.28;
        System.out.print(P);
        return P;
    }


    
}
