
package sumaimpl;

import org.omg.CORBA.ORB;
import sumaApp.sumaPOA;

/**
 * @author anthonywainer
 */
public class sumaImpl extends sumaPOA {

    private ORB orb;
    public void setORB(ORB orb_val){
        orb= orb_val;
    }
    
    @Override
    public int sumar(int primernumero, int segundonumero) {
        return primernumero + segundonumero;
    }

    @Override
    public void shutdown() {
        orb.shutdown(false);
    }
    
}
