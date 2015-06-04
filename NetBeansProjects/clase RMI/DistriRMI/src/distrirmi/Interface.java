
package distrirmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author anthonywainer
 */
public interface Interface  extends Remote{
    
    public String saludo(String salu, String msm)throws RemoteException;
    public Double suma(Double a, Double b)throws RemoteException;
    public Double resta(Double c, Double d)throws RemoteException;
    public Double multiplicacion(Double e, Double f)throws RemoteException;
    public Double division(Double g, Double h)throws RemoteException;
    
    
    
}
