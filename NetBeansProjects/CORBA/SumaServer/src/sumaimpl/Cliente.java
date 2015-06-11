package sumaimpl;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import sumaApp.suma;
import sumaApp.sumaHelper;

/**
 * @author anthonywainer
 */

public class Cliente {
    
    static suma sumaImpl;
    public static void main(String[] args) {
    try{
       
        ORB orb = ORB.init(args, null);
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        
        String name = "Suma";
        sumaImpl = sumaHelper.narrow(ncRef.resolve_str(name));
        System.out.print("Suma es : "+Integer.toString(sumaImpl.sumar(22, 50)));
        sumaImpl.shutdown();
            
    }catch(InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e){
            System.out.print("Error : "+e);
            e.printStackTrace(System.out);
        }
          
    }
}
