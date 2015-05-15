package servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;
import ord.Orden;

/**
 * @author anthonywainer
 */
public class Servidor extends JFrame implements Runnable {

    JTextArea msgs;
    Thread ir;
    ServerSocket ser;
    Socket cli,cliser;
    ObjectInputStream flujo;
    ObjectOutputStream flu;
    Orden ord, dsal;
    String sip,snick,smgs;
    
    public Servidor(){
        
      
        msgs = new JTextArea();
        msgs.setBounds(10, 10,300,250);
        add(msgs);
        
        setLayout(null);
        setSize(320,310);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ir = new Thread(this);
        ir.start();
    
    }
    
    
    public static void main(String[] args) {
        new Servidor();
    }

    @Override
    public void run() {
        try{
            ser = new ServerSocket(7890);
            cli = new Socket();
            
            while(true){
                cli = ser.accept();
                flujo = new ObjectInputStream(cli.getInputStream());
                ord = new Orden();
                ord= (Orden)flujo.readObject();
                sip = ord.getIp();
                snick = ord.getNick();
                smgs = ord.getMsg();
                
                msgs.append("\n"+"el: "+ snick + " te dice "+smgs);
                
                
                cliser = new Socket(sip,7891);
                flu =  new ObjectOutputStream(cliser.getOutputStream());
                flu.writeObject(ord);
                
                if ("fin".equals(smgs)) {
                    ser.close();
                }
                
            }
            
            
            
        }catch(Exception ex){
        System.out.print("error: "+ex.getMessage());        
        }
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
