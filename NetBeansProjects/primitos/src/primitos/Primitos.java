
package primitos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Primitos extends JFrame implements ActionListener{

    int a,b,c;
    boolean uno;
    JLabel ctd = new JLabel("asta el num");
    JPanel panel = new JPanel();
    JTextField txt = new JTextField(" ",10);
    JTextArea area =new JTextArea(8,40);
    JButton boton = new JButton("iniciar");
    
    
    public static void main(String[] args) throws IOException {
        new Primitos();
    }
 
    
    
 public Primitos() throws IOException{
     
     panel.add(ctd);
     panel.add(txt);
     panel.add(boton);
     BorderLayout borde = new BorderLayout();
     setLayout(borde);
     add(panel,BorderLayout.NORTH);
     area.setLineWrap(true);
     JScrollPane pane =  new JScrollPane(area);
     add(pane,BorderLayout.CENTER);
     setSize(400,500);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setVisible(true);
     
     PrintWriter msg= new PrintWriter(new BufferedWriter(new FileWriter("mozandero.txt")));
     
     c=Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad"));
     msg.println("estos son los primitos hasta "+c);
     for(int a=2;a<=c;a++){
     
     for(b=2;b<a;b++){
     
     uno=(a%b==0);
     if(uno==true){
         b=a+1;
     }
     }
     if(uno==false){
         System.out.println("el numero "+a+" es primo");
         msg.println("el numero "+a+" es primo");
     }
     }
     msg.close();
 }   

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
