
package calculo;

import calc.calcula;
import calc.calculaHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 * @author anthonywainer
 */
public class Calculo {


    public static void main(String[] args) {
        try{
            //inicair el ORB
         ORB orb=ORB.init(args,null);
         
         //encontrar la raiz POA
         POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
         
         //Activar el POA   
         rootpoa.the_POAManager().activate();
         
         //crear el objeto de implementacion 
         CalculaImpl calcu = new CalculaImpl();
         calcu.setORB(orb);
         
         //Registrar el objeto 
         org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calcu);
         calcula href= calculaHelper.narrow(ref);
         org.omg.CORBA.Object objRef= orb.resolve_initial_references("NameService");
         NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         
         //pŕoducir la direcc ion del objetio 
         String name = "calcula";
         NameComponent path[]= ncRef.to_name(name);
         ncRef.rebind(path, objRef);
         System.out.println("Servidor de Calcula listo y en espera");
         orb.run();
         
                 
         
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
          System.out.print("cerrando servidor");
    }
    
}
