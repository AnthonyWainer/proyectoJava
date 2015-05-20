
package stream2;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JTextArea;



/**
 *
 * @author anthony wainer
 */
public class Stream2 extends JFrame implements ActionListener {

    FileInputStream a;
    FileOutputStream b;
    JTextArea tx1;
    int c;
    
    
    public Stream2() throws FileNotFoundException, IOException{
            
        
            tx1=new JTextArea();
            //(x,y,"largo","ancho")
            tx1.setBounds(10,50,150,20);
            add(tx1);

            setLayout(null);
            setSize(200,200);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);  
            
        try {

            
            //a = new FileInputStream(tx1.getText());
            //a = new FileInputStream("archivo/holis.txt");
            
            InputStreamReader d= new InputStreamReader(System.in);
            b = new FileOutputStream("archivo/mozandero.txt");
            
            c = a.read();
            //while( c != -1  ){
            for (int i = 0; i < 50; i++) {
                c = d.read();
                b.write(c);                
            }
                
            
        } finally {
            if (a!=null) {
                a.close();
            }
            if (b!=null) {
                b.close();
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        new Stream2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    
}
