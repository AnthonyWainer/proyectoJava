package frmcliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * @author anthonywainer
 */
public class FrmServidor extends JFrame implements Runnable, ActionListener  {
    
    Thread hilo;
    ServerSocket ser;
    Socket cli;
    //DataInputStream ini;
    ObjectInputStream ini;
    String entrada;
    JTextArea area;
    JButton boton;
    JTextField txtmsg;
    JLabel lab;
    String orde;
    
    
    public FrmServidor(){
        //panel = new JPanel();
        lab = new JLabel("SERVIDOR");
        lab.setBounds(10, 00, 280, 20);
        txtmsg = new JTextField();
        txtmsg.setBounds(10, 20, 280, 20);
        area = new JTextArea(8,40);
        area.setBounds(10, 70, 280, 170);
        area.setLineWrap(true);
        //JScrollPane paneltxt = new JScrollPane(area);
        boton = new JButton("enviar");
        boton.setBounds(10, 40, 80, 20);
        boton.addActionListener(this);
        //add(panel);
        
        setLayout(null);
        add(area);
        add(boton);
        add(txtmsg);
        add(lab);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        hilo = new Thread(this);
        hilo.start();
        
    }
    
    public static void main(String[] args){
        new FrmServidor();
    }

    @Override
    public void run() {
        try{
        ser=new ServerSocket(7890);
        cli=new Socket();
        
        while(!"fin".equals(entrada)){
            
            cli=ser.accept();
            System.out.println("alguien se conecto");
            orde = txtmsg.getText();
            ini =new ObjectInputStream(cli.getInputStream());
            entrada = (String)ini.readObject();
            //entrada = ini.readUTF();
            area.append("--> ip: "+ cli.getInetAddress() + " dice: \n"+ entrada+ "\n");
            System.out.println(entrada);
            
        }  

        ser.close();        
        
        }catch(Exception e){
        e.getMessage();
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
            area.append("\n"+"yo servidor: "+txtmsg.getText());
            try{
                //cli = new Socket("127.0.0.1",7890);
//                soc = new Socket("192.168.4.132",7890);
                //flujo = new ObjectOutputStream(cli.getOutputStream());
                String ord = (txtmsg.getText());
                //flujo.writeObject(ord);
                //soc.close();
                
            }catch(Exception ex){
                System.out.print("error: "+ex.getMessage());
            }
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
