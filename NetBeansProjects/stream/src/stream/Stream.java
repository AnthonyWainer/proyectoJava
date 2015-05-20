package stream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author anthony wainer
 */
public class Stream extends JFrame implements ActionListener {
    
    InputStreamReader entrada = null;
    BufferedReader memoria = null;
    String salida;
    
    public Stream() throws IOException {
        memoria = new BufferedReader(new InputStreamReader(System.in));
        salida = memoria.readLine();

        JTextField tx1;
        
        tx1=new JTextField();
        //(x,y,"largo","ancho")
        tx1.setBounds(10,50,150,20);
        add(tx1);

        setLayout(null);
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        tx1.setText(salida);
    }
    
    public static void main(String[] args) throws IOException {
        new Stream();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}

