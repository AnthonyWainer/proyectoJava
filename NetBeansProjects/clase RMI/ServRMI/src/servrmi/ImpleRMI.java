package servrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author anthonywainer
 */
public class ImpleRMI  extends UnicastRemoteObject implements InterRMI {
    
    public ImpleRMI() throws RemoteException{
        super();
    }

    @Override
    public int[] suma(int[] a, int[] b) throws RemoteException {
        int[] s=new int[4];
        for(int i = 0; i<4; i++){
            s[i] = a[i] + b[i];
        }
        return s;
    }

    @Override
    public int[] resta(int[] c, int[] d) throws RemoteException {
        int[] r=new int[4];
        for(int i = 0; i<4; i++){
            r[i] = c[i] - d[i];
        }
        return r;
    }

    @Override
    public int[] multiplicacion(int[] e, int[] f) throws RemoteException {
        int[] m=new int[4];
        for(int i = 0; i<4; i++){
            m[i] = e[i] * f[i];
        }
        return m;
    }

    @Override
    public int[] division(int[] g, int[] h) throws RemoteException {
        int[] d=new int[4];
        for(int i = 0; i<4; i++){
            d[i] = g[i] / h[i];
        }
        return d;
    }

 
    
}
