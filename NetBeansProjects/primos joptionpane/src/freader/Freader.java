
package freader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Freader {

    public Freader() throws IOException{
    operaciones();
    
    }
    public static void main(String[] args) throws IOException {
        Freader freader = new Freader();
        
    }
    void operaciones() throws IOException{
        PrintWriter salida=null;
        int a;
        double b;
        int z=0;
        boolean uno=false;
        a=Integer.parseInt(JOptionPane.showInputDialog("ingresa el numero y descubramos cuantos numeros primos contiene"));
        System.out.println("los numeros primos hasta "+a+ " son");
        salida = new PrintWriter( new BufferedWriter(new FileWriter("prueba.txt")) );
        salida.println( "cantidad de numeros primos en "+a);
        //String num = String.valueOf(a);
        
        for(int i=2;i<=a;i++){
            
            //b=Math.sqrt(i);
           for(int x=2;x<i;x++){
               
                uno=(i%x==0);
               if(uno==true){
                  x=i+1; 
               }
               
            }if(uno ==false){z++;
                
                System.out.println("el numero =  " +i+ "  es primo "+z);
                
                
                //salida = new PrintWriter( new BufferedWriter(new FileWriter("prueba.txt")) );
                salida.println( "numero primo "+i+" esta en la posicion "+z );
               // salida.println("en un fichero."+"\n");
                
                
                
                
                
            }
          //salida.close();  
        }
       salida.close(); 
    }

    
    
    
    
    
}
