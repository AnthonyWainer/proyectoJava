
package servrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author anthonywainer
 */
public interface InterRMI extends Remote {
    public int [] suma(int[] a, int[] b) throws RemoteException;
    public int [] resta(int[] c, int[] d) throws RemoteException;
    public int [] multiplicacion(int[] e, int[] f) throws RemoteException;
    public int [] division(int[] g, int[] h) throws RemoteException;
    //public String saludo(String msm) throws RemoteException;
}
