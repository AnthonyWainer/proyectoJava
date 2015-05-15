
package frmser;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;


public class Frmser  extends JFrame {

    ServerSocket ser;
    Socket soc;
    DataOutputStream sal;
    BufferedReader ini, tec;
    String entrada, teclado;
    int a,b;
    InputStreamReader in,tecla;
    JTextField txt;
    JTextArea area;
    JButton boton;
    
    public Frmser(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout(100,100));
    txt = new JTextField(" ",15);
    area = new JTextArea();
    boton = new JButton("enviar: ");
    area.setLineWrap(true);
    add(txt, BorderLayout.NORTH);
    add(txt, BorderLayout.NORTH);
    add(area, BorderLayout.CENTER);
    setSize(300,200);
    setVisible(true);
    
        try{
        ser=new ServerSocket(18900);
        soc=new Socket();
        soc=ser.accept();
        System.out.println("alguien se conecto");
        sal=new DataOutputStream(soc.getOutputStream());
        sal.writeUTF(" bienvenido cual es tu mensaje: \n");
        in=new InputStreamReader(soc.getInputStream());
        ini=new BufferedReader(in);
        tecla = new InputStreamReader(System.in); 
        tec=new BufferedReader(tecla);
        while(!"fin".equals(teclado)){
        entrada=ini.readLine();
        System.out.println(entrada);
        teclado=tec.readLine();
        sal.writeUTF("  \n "+teclado);
        }
        
        
        ser.close();
        
        
        
        
        
        }catch(Exception e){
        e.getMessage();
    }
        
    }
    
    public static void main(String[] args) {
        new Frmser();
    }
    
}
