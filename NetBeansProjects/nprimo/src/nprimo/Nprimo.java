/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nprimo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author D3N7Z
 */
public class Nprimo extends JFrame implements ActionListener {
    
    FileOutputStream fileout;
    JTextField textarea;
    JButton enviar;
    JTextArea resultado;
    String primod,conversion;
    int num, a = 0,c,cantidad,j,d;

    public Nprimo() throws FileNotFoundException, IOException {
        textarea = new JTextField();
        textarea.setBounds(50, 30, 200, 20);

        enviar = new JButton("Enviar");
        enviar.setBounds(110, 60, 80, 20);

        resultado = new JTextArea();
        resultado.setBounds(50, 90, 200, 40);
        add(textarea);
        add(enviar);
        add(resultado,BorderLayout.SOUTH);
        BorderLayout borde = new BorderLayout();
        setLayout(borde);
        setSize(300, 300);
        setVisible(true);
        enviar.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         resultado.setLineWrap(true);
        
        
           
    }

    public static void main(String[] args) throws IOException {
        new Nprimo();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        num = Integer.parseInt(textarea.getText()) + 1;
       // System.out.println(num);
        if (e.getSource() == enviar) {

         
                for (int i = 1; i < num; i++) {
                    d=0;
                    
                    for(j=1;j<(i+1);j++){
                        if(i%j==0){
                            d++;
                        }
                        
                    }
                    if(d==2){
                        conversion=Integer.toString(i);
                        resultado.setText(resultado.getText()+","+conversion);
                      
                    }
                }
                
               
               
          
           

        }
        try {
            enviartext();
        } catch (IOException ex) {
            Logger.getLogger(Nprimo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void enviartext() throws IOException {
     
   //     fileinput=new FileInputStream(textarea.getText());
  
   // InputStreamReader d= new InputStreamReader(resultado.getToolTipText());
           //fileout=new FileOutputStream("C:/Users/D3N7Z/Documents/mensaje1.txt");
            File archivo= new File("C:/Users/Alumno.Usuario-PC/Documents/mensaje1.txt"); 
                    BufferedWriter bw = new BufferedWriter (new FileWriter(archivo));
                    bw.write(resultado.getText());
                    bw.close();               
    }
}
