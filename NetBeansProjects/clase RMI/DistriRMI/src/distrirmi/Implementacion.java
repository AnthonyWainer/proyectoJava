
package distrirmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author anthonywainer
 */
public class Implementacion extends UnicastRemoteObject implements Interface{
    public Implementacion() throws RemoteException{
        super();
    }

    @Override
    public String saludo(String salu, String msm) throws RemoteException {
          return "hola mozandero"+salu+" "+msm;
    }

    @Override
    public Double suma(Double a, Double b) throws RemoteException {
        return a+b; 
    }

    @Override
    public Double resta(Double c, Double d) throws RemoteException {
        return c-d; 
    }

    @Override
    public Double multiplicacion(Double e, Double f) throws RemoteException {
        return e*f; 
    }

    @Override
    public Double division(Double g, Double h) throws RemoteException {
        return g/h; 
    }
    
    
}
