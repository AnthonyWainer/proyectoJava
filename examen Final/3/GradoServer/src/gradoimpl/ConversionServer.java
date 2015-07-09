
package gradoimpl;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import gradoApp.convGrad;
import gradoApp.convGradHelper;

/**
 * @author anthonywainer
 */
public class ConversionServer {


    public static void main(String[] args) {
        try{
            //inicair el ORB
         ORB orb=ORB.init(args,null);
         
         //encontrar la raiz POA
         POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
         
         //Activar el POA   
         rootpoa.the_POAManager().activate();
         
         //crear el objeto de implementacion 
         gradoImpl gradoImpl = new gradoImpl();
         gradoImpl.setORB(orb);
         
         //Registrar el objeto 
         org.omg.CORBA.Object ref = rootpoa.servant_to_reference(gradoImpl);
         convGrad href= convGradHelper.narrow(ref);
         org.omg.CORBA.Object objRef= orb.resolve_initial_references("NameService");
         NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         
         //pŕoducir la direcc ion del objetio 
         String name = "grados";
         NameComponent path[]= ncRef.to_name(name);
         ncRef.rebind(path, objRef);
         System.out.println("Servidor de conversión listo y en espera");
         orb.run();
         
                 
         
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
          System.out.print("cerrando servidor");
    }
    
}
