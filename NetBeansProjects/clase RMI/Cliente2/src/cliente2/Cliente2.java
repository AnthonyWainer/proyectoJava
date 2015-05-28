
package cliente2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import servirmi.InterRMI;

/**
 * @author anthonywainer
 */
public class Cliente2 {
     public int[] leer(String msj){
            System.out.println(msj);
            int[] p = new int[4];
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 4; i++) {
                p[i] = sc.nextInt();
             }
            return p;
        }
     public void imprimir(int[] p){
         for (int i = 0; i < 4; i++) {
            System.out.println(" "+p); 
         }
     }

      public static void main(String[] args) throws RemoteException{
          int op;
          BufferedReader te = new BufferedReader(new InputStreamReader(System.in));
          
        try{
            do {
                 System.out.println("ELija: \n 1-suma \n 2-resta \n 3-multiplicacion \n 4-division \n>>");
                 op = Integer.parseInt(te.readLine());
                 switch(op){
                     case 1:{
                         InterRMI i = (InterRMI)Naming.lookup("//192.168.4.53:9191/suma");
                         int[] a = new int[4];
                         int[] b = new int[4];
                         int[] s = new int[4];
                         Cliente2 cli= new Cliente2();
                         a = cli.leer("Escribir los primeros 4 numeros: ");
                         b = cli.leer("Escribir los sgts 4 numeros: ");
                         s = i.suma(a, b);
                         System.out.println("El resultado de la suma: "+s);
                         cli.imprimir(s);
                     }break;
                     case 2:{
                         InterRMI i = (InterRMI)Naming.lookup("//192.168.4.53:9191/servi1");
                         int[] c = new int[4];
                         int[] d = new int[4];
                         int[] r = new int[4];
                         Cliente2 cli= new Cliente2();
                         c = cli.leer("Escribir los primeros 4 numeros: ");
                         d = cli.leer("Escribir los sgts 4 numeros: ");
                         r = i.resta(c, d);
                         System.out.println("El resultado de la resta: "+r);
                         cli.imprimir(r);
                     }break;
                    case 3:{
                         InterRMI i = (InterRMI)Naming.lookup("//192.168.4.53:9191/multi");
                         int[] e = new int[4];
                         int[] f = new int[4];
                         int[] m = new int[4];
                         Cliente2 cli= new Cliente2();
                         e = cli.leer("Escribir los primeros 4 numeros: ");
                         f = cli.leer("Escribir los sgts 4 numeros: ");
                         m = i.multiplicacion(e, f);
                         System.out.println("El resultado de la multiplicacion: "+m);
                         cli.imprimir(m);
                     }break;
                     case 4:{
                         InterRMI i = (InterRMI)Naming.lookup("//192.168.4.53:9191/divi");
                         int[] g = new int[4];
                         int[] h = new int[4];
                         int[] n = new int[4];
                         Cliente2 cli= new Cliente2();
                         g = cli.leer("Escribir los primeros 4 numeros: ");
                         h = cli.leer("Escribir los sgts 4 numeros: ");
                         n = i.divicion(g, h);
                         System.out.println("El resultado de la division: "+n);
                         cli.imprimir(n);
                     }break;                         
                 
                 case 5:{
                    System.out.println("gracias por participar");
                    System.exit(0);
                 }
                 }
            } while (op != 5);

            

        }catch(Exception e){
            System.out.println("error: "+e.getMessage());
        }
    }
    
}

