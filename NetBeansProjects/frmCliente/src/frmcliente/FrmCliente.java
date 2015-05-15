package frmcliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author anthonywainer
 */
public class FrmCliente extends JFrame implements  ActionListener {

    Socket soc;
    DataOutputStream sal;
    BufferedReader mem;
    InputStreamReader tec,in;
    String salida, sali;
    JTextArea area;
    JButton boton;
    JTextField txtmsg;
    JLabel lab;
    ObjectOutputStream flujo;
   
    
    public FrmCliente(){
    try{
        lab = new JLabel("CLIENTE");
        lab.setBounds(10, 00, 280, 20);
        txtmsg = new JTextField();
        txtmsg.setBounds(10, 20, 280, 20);
        area = new JTextArea(8,40);
        area.setBounds(10, 70, 280, 170);
        area.setLineWrap(true);
        boton = new JButton("enviar");
        boton.setBounds(10, 40, 80, 20);
        boton.addActionListener(this);
        setLayout(null);
        add(area);
        add(boton);
        add(txtmsg);
        add(lab);
        
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        
        /*soc = new Socket("127.0.0.1", 7890);              
        tec = new InputStreamReader(System.in); 
        mem = new BufferedReader(tec);
        salida=mem.readLine();
        sal = new DataOutputStream(soc.getOutputStream());
        sal.writeUTF(salida+": \n");
        soc.close();*/
          
          
    }catch(Exception e){
        e.getMessage();
    }
    }

    public static void main(String[] args){
        new FrmCliente();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==boton) {
            area.append("\n"+"yo: "+txtmsg.getText());
            try{
                soc = new Socket("127.0.0.1",7890);
//                soc = new Socket("192.168.4.132",7890);
                flujo = new ObjectOutputStream(soc.getOutputStream());
                String ord = (txtmsg.getText());
                flujo.writeObject(ord);
                soc.close();
                
            }catch(Exception ex){
                System.out.print("error: "+ex.getMessage());
            }
            
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
