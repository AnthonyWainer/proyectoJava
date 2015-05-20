
package calculadora.clase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Anthony Wainer
 */
public class CalculadoraClase extends JFrame implements ActionListener{
    
        JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bms,bmn,bpr,bdv,big,bpd,bc1;
        JTextField tx1,tx2, tx3;
        String num1="";
        int a = 0;
    public CalculadoraClase(){
     b1 = new JButton("1");
     b1.setBounds(200,200,50,20);
     b1.addActionListener(this);

     b2 = new JButton("2");
     b2.setBounds(250,200,50,20);
     b2.addActionListener(this);
     
     b3 = new JButton("3");
     b3.setBounds(300,200,50,20);
     b3.addActionListener(this);
     
     b4 = new JButton("4");
     b4.setBounds(200,220,50,20);
     b4.addActionListener(this);
     
     b5 = new JButton("5");
     b5.setBounds(250,220,50,20);
     b5.addActionListener(this);
     
     b6 = new JButton("6");
     b6.setBounds(300,220,50,20);
     b6.addActionListener(this);
     
     b7 = new JButton("7");
     b7.setBounds(200,240,50,20);
     b7.addActionListener(this);
     
     b8 = new JButton("8");
     b8.setBounds(250,240,50,20);
     b8.addActionListener(this);
     
     b9 = new JButton("9");
     b9.setBounds(300,240,50,20);
     b9.addActionListener(this);     
     
     bpd = new JButton(".");
     bpd.setBounds(360,200,50,20);
     bpd.addActionListener(this);   
     
     b0 = new JButton("0");
     b0.setBounds(360,220,50,20);
     b0.addActionListener(this);     
     
     bc1 = new JButton("C");
     bc1.setBounds(360,240,50,20);
     bc1.addActionListener(this);
     
     bpr = new JButton("*");
     bpr.setBounds(420,220,50,20);
     bpr.addActionListener(this);
     
     big = new JButton("=");
     big.setBounds(470,220,50,20);
     big.addActionListener(this);
     
     bdv = new JButton("÷");
     bdv.setBounds(520,220,50,20);
     bdv.addActionListener(this);     

     bdv = new JButton("÷");
     bdv.setBounds(520,220,50,20);
     bdv.addActionListener(this);  
     
     bms = new JButton("+");
     bms.setBounds(470,200,50,20);
     bms.addActionListener(this);

     bmn = new JButton("-");
     bmn.setBounds(470,240,50,20);
     bmn.addActionListener(this);     
     
     
     
     tx1=new JTextField();
     tx1.setBounds(200,150,200,20);
     add(b1);
     add(b2);
     add(b3);
     add(b4);
     add(b5);
     add(b6);
     add(b7);
     add(b8);
     add(b9);
     add(b0);
     add(bpd);
     add(bc1);
     add(bpr);
     add(big);
     add(bdv);
     add(bms);
     add(bmn);
          
     add(tx1);
     
     setLayout(null);
     setSize(700,500);
     setVisible(true);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new CalculadoraClase();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b0){
            num1 +="0";
            tx1.setText(num1);
        }
        if(e.getSource()==b1){
            num1 +="1";
            tx1.setText(num1);
        }
       if(e.getSource()==b2){
            num1 +="2";
            tx1.setText(num1);
        }
        if(e.getSource()==b3){
            num1 +="3";
            tx1.setText(num1);
        }                
        if(e.getSource()==b4){
            num1 +="4";
            tx1.setText(num1);
        }
        if(e.getSource()==b5){
            num1 +="5";
            tx1.setText(num1);
        }    
        if(e.getSource()==b6){
            num1 +="6";
            tx1.setText(num1);
        }        
        if(e.getSource()==b7){
            num1 +="7";
            tx1.setText(num1);
        }        
        if(e.getSource()==b8){
            num1 +="8";
            tx1.setText(num1);
        }
        if(e.getSource()==b9){
            num1 +="9";
            tx1.setText(num1);
        }     
        
        if(e.getSource()==bpd){
            a += 1;
            if (a==1) {
                num1 += ".";
                tx1.setText(num1);    
            }
            
            
        }   
        if(e.getSource()==bc1){
            num1 ="";
            tx1.setText(num1);
        }        
    }
    
}
