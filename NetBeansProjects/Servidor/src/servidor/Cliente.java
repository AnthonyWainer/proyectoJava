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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import ord.Orden;

/**
 * @author anthonywainer
 */

public class Cliente extends JFrame implements ActionListener, Runnable{
    
    JTextField txtip, txtnick, txtmsg;
    JLabel lip, lnick, lmsg;
    JTextArea msgs;
    JButton btn; 
    JFrame frame;
    JScrollPane scroll;
            
    Socket cli,cliser;
    ObjectOutputStream flujo;
    Orden ord,odsal;
    
    Thread ir;
    ServerSocket serv;
    ObjectInputStream flu;
    String sip,snick,smgs;       
    
    
    public Cliente(){
        
        frame = new JFrame("cliente");
        txtnick = new JTextField();
        txtnick.setBounds(10,10,100,20);
        lnick = new JLabel("nick");
        lnick.setBounds(115,10,70,20);
        frame.add(txtnick);
        frame.add(lnick);
        
        
        txtip = new JTextField();
        txtip.setBounds(10,30,100,20);
        lip = new JLabel("ip");
        lip.setBounds(115,30,70,20);
        frame.add(txtip);
        frame.add(lip);
        
        txtmsg = new JTextField();
        txtmsg.setBounds(10,50,250,20);
        lmsg = new JLabel("msg");
        lmsg.setBounds(270,50,70,20);
        frame.add(txtmsg);
        frame.add(lmsg);
        
        msgs = new JTextArea();
        msgs.setBounds(10, 80,300,250);

        scroll = new JScrollPane (msgs);
        frame.add(msgs);
        frame.add(scroll);
        
        btn = new JButton("enviar");
        btn.setBounds(210,10,100,20);
        btn.addActionListener(this);
        frame.add(btn);
        
        frame.setLayout(null);
        frame.setSize(320,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ir = new Thread(this);
        ir.start();
        
    }
    
    
    
    public static void main(String[] args) {
        new Cliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==btn) {
            msgs.append("\n"+"yo: "+txtmsg.getText());
            try{
                //cli = new Socket("127.0.0.1",7890);
                cli = new Socket("192.168.4.53",7890);
                flujo = new ObjectOutputStream(cli.getOutputStream());
                ord= new Orden();
                ord.setIp(txtip.getText());
                ord.setNick(txtnick.getText());
                ord.setMsg(txtmsg.getText());
                flujo.writeObject(ord);
                cli.close();
                
            }catch(Exception ex){
                System.out.print("error: "+ex.getMessage());
            }
            
        }
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run() {
        try{
            serv = new ServerSocket(7891);
            cli = new Socket();
            
            while(true){
                cli = serv.accept();
                flu = new ObjectInputStream(cli.getInputStream());
                odsal = new Orden();
                odsal= (Orden)flu.readObject();
                
                sip = odsal.getIp();
                snick = odsal.getNick();
                smgs = odsal.getMsg();
                msgs.append("\n"+"el: "+ snick + " te dice "+smgs +" con el ip: "+sip);                              

                
                if ("fin".equals(smgs)) {
                    serv.close();
                }
                
        }
            
            
            
        }catch(Exception ex){
        System.out.print("error: "+ex.getMessage());        
        }       
        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
