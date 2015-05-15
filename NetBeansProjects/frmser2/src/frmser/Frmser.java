
package frmser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anthonywainer
 */
public class Frmser{

    ServerSocket ser;
    Socket soc;
    DataOutputStream sal;
    BufferedReader ini, tec;
    String entrada, teclado;
    int a,b;
    InputStreamReader in, tecla;
    
    public Frmser(){
        try {
            ser = new ServerSocket(18900);
            soc = new Socket();
            soc = ser.accept();
            
            System.out.println("gringuito moshaco se conecto");
            
            sal = new DataOutputStream(soc.getOutputStream());
            sal.writeUTF("bienvenido cual es su msm:");
            
            in  = new InputStreamReader(soc.getInputStream());
            ini = new BufferedReader(in);
            
            while(!"fin".equals(teclado)){
                entrada = ini.readLine();
                System.out.println(entrada);
                tecla = new InputStreamReader(System.in);
                tec = new  BufferedReader(tecla);
                teclado = tec.readLine();
                sal.writeUTF(" "+teclado); 
            }
                       
            ser.close();
            
            
            
            
            
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    
    public static void main(String[] args) {
        new Frmser();
    }
    
}
