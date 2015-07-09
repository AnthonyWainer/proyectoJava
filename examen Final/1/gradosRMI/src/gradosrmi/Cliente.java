
package gradosrmi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import gradosrmi.Interface;

/**
 * @author anthonywainer
 */
public class Cliente extends JFrame implements ActionListener {
        JTextField txtip, txtnick, txtmsg;
        JLabel lip, lnick, lmsg;
        JTextArea msgs;
        JButton btn; 
        JFrame frame;
        JScrollPane scroll;
        
    public Cliente(){
        
        frame = new JFrame("convertidor");
        txtnick = new JTextField();
        txtnick.setBounds(10,10,100,20);
        lnick = new JLabel("Celcius");
        lnick.setBounds(115,10,70,20);
        frame.add(txtnick);
        frame.add(lnick);
        
        msgs = new JTextArea();
        msgs.setBounds(10, 80,300,250);

        scroll = new JScrollPane (msgs);
        frame.add(msgs);
        frame.add(scroll);
        
        btn = new JButton("Convertir");
        btn.setBounds(210,10,100,20);
        btn.addActionListener(this);
        frame.add(btn);
        
        frame.setLayout(null);
        frame.setSize(320,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
        
      public static void main(String[] args) throws RemoteException{
          new Cliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn) {
            try{
             Interface i = (Interface)Naming.lookup("//localhost:9051/servi1");
             int s= i.grados(Integer.parseInt(txtnick.getText()));
             msgs.append(txtnick.getText() + " Grados Celcius = "+ s);
            }catch(Exception ex){
                System.out.print("error: "+ex.getMessage());
            }
            
        }        
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
