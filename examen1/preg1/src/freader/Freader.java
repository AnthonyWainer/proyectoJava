
package freader;

import java.io.IOException;
import javax.swing.JOptionPane;


public class Freader {

    public Freader() throws IOException{
    operaciones();
    
    }
    public static void main(String[] args) throws IOException {
        Freader freader = new Freader();
        
    }
    void operaciones() throws IOException{
        int F=0;
        double C;
        int z=0;

        while(F!=999){
            F=Integer.parseInt(JOptionPane.showInputDialog("ingresa en grados farenheit"));
            C = 5*(F-32)/9;
            JOptionPane.showMessageDialog(null,"centigrados= "+C);
            System.out.println("centigrados= "+C);
        }
 
    }

    
    
    
    
    
}
