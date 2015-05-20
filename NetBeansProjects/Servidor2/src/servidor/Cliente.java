
package servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ord.Orden;


public class Cliente extends JFrame implements ActionListener, Runnable {
    
    Thread ir;
    JTextField txtip,txtnick,txtmsg;
    JLabel lip,lnick,lmsg;
    JTextArea msgs;
    JButton btn;
    ServerSocket serv;
    Socket cli,cliser;
    ObjectOutputStream flujo;
    ObjectInputStream flu;
    Orden ord,osali;
    String sip,snick,smsg, oipp,oinick,oimsg,otroip;
    
    public Cliente(){
        
        txtip=new JTextField();
        txtip.setBounds(10,10,100, 20);
        lip=new JLabel();
        lip.setText("IP");
        lip.setBounds(115,10,70,20);
        add(txtip);
        add(lip);
        
        txtnick=new JTextField();
        txtnick.setBounds(10,35,100, 20);
        lnick=new JLabel();
        lnick.setText("NICK");
        lnick.setBounds(115,35,70,20);
        add(txtnick);
        add(lnick);
        
        txtmsg=new JTextField();
        txtmsg.setBounds(10,60,300, 20);
        lmsg=new JLabel();
        lmsg.setText("MENSAJE");
        lmsg.setBounds(315,60,100,20);
        add(txtmsg);
        add(lmsg);
        
        msgs= new JTextArea();
        msgs.setBounds(10,85,365,350);
        add(msgs);
        
        btn=new JButton("enviar");
        btn.setBounds(150,10,100,20);
        btn.addActionListener(this);
        add(btn);
        setLayout(null);
        setSize(400,480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ir=new Thread(this);
        ir.start();
        
        
        
    }
    
    
  public static void main(String[] args) {
        new Cliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn){
            msgs.append("\n"+"yo: "+txtmsg.getText());
            
            try{
                cli=new Socket("127.0.0.1",7890);
                flujo=new ObjectOutputStream(cli.getOutputStream());
                ord=new Orden();
                ord.setIp(txtip.getText());
                ord.setNick(txtnick.getText());
                ord.setMsg(txtmsg.getText());
                flujo.writeObject(ord);
                cli.close();
                
                
                
            }catch(Exception ex){
                System.out.println("error : "+ex.getMessage());
            }
            
            
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void run() {
            
        try{
            serv=new ServerSocket(7891);
            cliser=new Socket();
            while(true){
            cliser=serv.accept();
            flu=new ObjectInputStream(cliser.getInputStream());
            osali=new Orden();
            osali=(Orden)flu.readObject();
            oipp=osali.getIp();
            oinick=osali.getNick();
            oimsg=osali.getMsg();
            otroip=osali.getOtro();
            
            msgs.append("\n"+oinick+" : "+oimsg+" "+otroip );
            if(oimsg.equals("fin")){
                serv.close();
                break;
            }
            }
            
        }catch(Exception exe){
            System.out.println("error : "+exe.getMessage());
        }
        
        
        
        
        
       // throw new UnsupportedOperationException("Not supported yet."); 
    }
        
}
