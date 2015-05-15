
package ejercicoh;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graficos extends JFrame implements ActionListener{
    
    JLabel[] label;
    JPanel[] panel;
    String[] name={"tortuga","conejo"};
    int n,r;
    JButton boton;
    
    public Graficos(){
        setLayout(new GridLayout(0,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label=new JLabel[2];
        panel=new JPanel[2];
        for(n=0;n<2;n++){
            label[n]=new JLabel();
            panel[n]=new JPanel();
            add(panel[n]);
            panel[n].add(label[n]);
            this.setLocation(0, 0);
            label[n].setIcon(new ImageIcon(getClass().getResource(name[n]+".gif")));
            
        }
        boton=new JButton("Inicio");
        boton.addActionListener(this);
        add(boton);
        setSize(1180,800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        r=950;
        Ejercicoh tor =new Ejercicoh(name[0],r,label[0]);
        Ejercicoh con =new Ejercicoh(name[1],r,label[1]);
        tor.start();
        con.start();
    }
    
    
}
