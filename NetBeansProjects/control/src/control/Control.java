
package control;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author anthonywainer
 */
public class Control extends JFrame implements Runnable{
    
    Thread ir;
    ServerSocket ser;
    Socket cli;
    ObjectInputStream flujo;
    Ord orde;

    
//    JTextField ord;
//    JButton boton;
//    JTextArea area;
    
    
    
    public Control(){
    
        /*area = new JTextArea(8,40);
        area.setLineWrap(true);
        JScrollPane paneltxt = new JScrollPane(area);
        
        BorderLayout borde = new BorderLayout();
        setLayout(borde);
        add(paneltxt, BorderLayout.CENTER);
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/
        ir = new Thread(this);
        ir.start();
        
    
    }
    
    public static void main(String[] args) {
        new Control();
    }

    @Override
    public void run() {
        try{
            ser=new ServerSocket(9064);
            cli=new Socket();

            
            while(true){

                cli=ser.accept();
                System.out.println("alguien se conecto");
                flujo =new ObjectInputStream(cli.getInputStream());
                orde= (Ord)flujo.readObject();
                
                if(orde.getOrden().equals("cal")){
                    Runtime r = Runtime.getRuntime();
                    r.exec("/bin/bash -c  gnome-calculator");
                }else if(orde.getOrden().equals("apagar")){
                    Runtime r = Runtime.getRuntime();
                    r.exec("/bin/bash -c  halt");
                }else if(orde.getOrden().equals("fin")){
                    ser.close();
                }
                //orde = ini.readUTF();
                //area.append("--> ip: "+ cli.getInetAddress() + " dice: \n"+ orde+ "\n");
                //System.out.println(orde);

            }  

                    

            }catch(Exception e){
            e.getMessage();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
