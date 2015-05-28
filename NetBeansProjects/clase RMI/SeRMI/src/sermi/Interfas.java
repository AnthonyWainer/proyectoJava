package sermi;


import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author anthonywainer
 */
public interface Interfas extends Remote{
    public int suma(int a, int b) throws RemoteException;
    
    
}
