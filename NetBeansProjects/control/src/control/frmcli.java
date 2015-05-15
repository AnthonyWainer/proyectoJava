
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;

/**
 * @author anthonywainer
 */
public class frmcli extends JFrame implements ActionListener  {
    
    JTextField ord;
    JButton boton;
    Socket cli;
    Ord orde;
    ObjectOutputStream flujo;
    
    public frmcli(){
    
        //panel 
        ord = new JTextField();
        ord.setBounds(10, 10, 100, 20);
        boton = new JButton("enviar");
        boton.setBounds(10, 30, 100, 20);
        boton.addActionListener(this);
        
        //BorderLayout borde = new BorderLayout();
        //setLayout(borde);}
        setLayout(null);
        add(ord);
        add(boton);
        setSize(120,100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
     public static void main(String[] args){
        new frmcli();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== boton){

            try {              
                //cli = new Socket("192.168.4.151", 9060);
                cli = new Socket("127.0.0.1", 9064);
                orde = new Ord();
                orde.setOrden(ord.getText());
                flujo = new ObjectOutputStream(cli.getOutputStream());
                flujo.writeObject(orde);
                cli.close();
                
                
            } catch (IOException ex) {
                Logger.getLogger(frmcli.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        
        }
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
