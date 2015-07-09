
package practicarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author anthonywainer
 */
public interface Interface  extends Remote{
        public Integer grados(Integer g)throws RemoteException;
}
