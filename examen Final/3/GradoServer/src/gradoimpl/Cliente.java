package gradoimpl;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import gradoApp.convGrad;
import gradoApp.convGradHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author anthonywainer
 */

public class Cliente extends JFrame implements ActionListener {
    
    static convGrad gradoImpl;
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
        
    public static void main(String[] args)  {

          
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] args = null;
        if (e.getSource()==btn) {
             try{
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "grados";
            gradoImpl = convGradHelper.narrow(ncRef.resolve_str(name));
            msgs.append(txtnick.getText() + " Grados Celcius = "+ Integer.toString((int)gradoImpl.grados(Integer.parseInt(txtnick.getText()))));
            gradoImpl.shutdown();
            }catch(Exception ex){
                System.out.print("error: "+ex.getMessage());
            }
        }        
        throw new UnsupportedOperationException("Not supported yet."); 
    }    

}
