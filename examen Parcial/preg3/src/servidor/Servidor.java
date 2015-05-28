
package servidor;

import java.awt.BorderLayout;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import ord.Orden;


public class Servidor extends JFrame implements Runnable {

    JTextArea msgs;
    Thread ir;
    ServerSocket ser;
    Socket cli,cliser;
    DataInputStream flujo;
    DataOutputStream flu;
    Orden den, dsal;
    String sip,snick,smsg , sipcli;
    JScrollPane panels;
    BorderLayout borde;
    InetAddress ipcli;
    public Servidor(){
        
        msgs = new JTextArea();
        
        //msgs.setBounds(10,10,350,350);
        panels=new JScrollPane(msgs);
        borde=new BorderLayout();
        setLayout(borde);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panels);
        ir=new Thread(this);
        ir.start();
        
    }
    
    
    public static void main(String[] args) {
        new Servidor();
    }

    @Override
    public void run() {
        
        try{
            ser=new ServerSocket(22500);
            cli=new Socket();
            while(true){
            cli=ser.accept();
            flujo= new DataInputStream(cli.getInputStream());
            den=new Orden();
            String de= flujo.readUTF();
            sip=den.getIp();
            snick=den.getNick();
            smsg=den.getMsg();
            
            
            sipcli=cli.getInetAddress().toString();
            den.setOtro(sipcli);
            
            msgs.append( "\n"+snick+" : "+smsg);
            cliser=new Socket(sip,22501);
            flu=new DataOutputStream(cliser.getOutputStream());
            flu.writeUTF(den.toString());
            
            
            if("fin".equals(smsg)){
            ser.close();
            break;
            }
            }
            
            
            
            
        }catch(Exception ex){
            System.out.println("error : "+ex.getMessage());
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
