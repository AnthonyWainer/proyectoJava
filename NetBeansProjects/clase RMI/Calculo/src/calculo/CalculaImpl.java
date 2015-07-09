
package calculo;

import calc.calculaPOA;
import org.omg.CORBA.ORB;

/**
 * @author anthonywainer
 */

public class CalculaImpl extends calculaPOA {

    private ORB orb;
    public void setORB(ORB orb_val){
        orb = orb_val;
    }
    
    
    @Override
    public double suma(double a, double b) {
        return a+b;
    }

    @Override
    public double resta(double c, double d) {
        return c-d;
    }

    @Override
    public double multi(double r, double f) {
        return r*f;
    }

    @Override
    public double divi(double g, double h) {
        double r = 0;
        try{
            r = g/h;
        }catch(Exception e){
        }
         return r;
    }

    @Override
    public void shutdown() {
        orb.shutdown(false);
    }
    
}
