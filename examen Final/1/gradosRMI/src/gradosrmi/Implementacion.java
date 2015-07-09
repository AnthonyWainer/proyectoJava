
package gradosrmi;

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
    public Integer grados(Integer g) throws RemoteException {
        double C;
        int z=0;

        while(g!=999){
            C = 5*(g-32)/9;
            System.out.print(C);
            return (int)C;
        }
        return null;
        
    }

    
}
