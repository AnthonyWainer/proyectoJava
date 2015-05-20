
package scaner;
import java.util.Scanner;

public class Ejer {
   
    void ejer1(){
        
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        //Scanner c = new Scanner(System.in);
        int d = a.nextInt();
        
        if(b<=d){
            System.out.println("Valor de la multiplicacion "+b*d);
            
        }else{
        System.out.println("Valor de la division "+b/d);}
        
    }
    
     void ejer2(int z, int x){
         //int r;
         
        System.out.println("Valor de la division "+z/x);
     }
     void ejer3(){
      System.out.println("ingrese número a calcular: ");   
      Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        int c=1, r=1;
        do{
            r= r*c;
            c++;
        }while(c<=b);
             System.out.println("Valor de b: "+b+", El factorial es: " +r);   
         }
    }
    

