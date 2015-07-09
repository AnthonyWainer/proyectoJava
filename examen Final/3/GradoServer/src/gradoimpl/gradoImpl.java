
package gradoimpl;

import org.omg.CORBA.ORB;
import gradoApp.convGradPOA;

/**
 * @author anthonywainer
 */
public class gradoImpl extends convGradPOA {

    private ORB orb;
    public void setORB(ORB orb_val){
        orb= orb_val;
    }
    
    @Override
    public double grados(double g) {
        double C;
        int z=0;
        while(g!=999){
            C = 5*(g-32)/9;
            System.out.print(C);
            return C;
        }
        return 0;
        
    }

    @Override
    public void shutdown() {
        orb.shutdown(false);
    }


    
}
