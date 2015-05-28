
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
    String[] name={"pajaro1","policia","abeja"};
    int n,r;
    JButton boton, botonr;
    
    public Graficos(){
        setLayout(new GridLayout(0,1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label=new JLabel[3];
        panel=new JPanel[3];
        for(n=0;n<3;n++){
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
        botonr=new JButton("regreso");
        botonr.addActionListener(this);
        add(botonr);
        setSize(1180,800);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton) {
        r=900;
        Ejercicoh tor =new Ejercicoh(name[0],r,label[0],"ida");
        Ejercicoh con =new Ejercicoh(name[1],r,label[1],"ida");
        Ejercicoh cam =new Ejercicoh(name[2],r,label[2],"ida");
        tor.start();
        con.start();
        cam.start();
        }else{
          r=900;
        Ejercicoh tor =new Ejercicoh(name[0],r,label[0],"reg");
        Ejercicoh con =new Ejercicoh(name[1],r,label[1],"reg");
        Ejercicoh cam =new Ejercicoh(name[2],r,label[2],"reg");
        tor.start();
        con.start();
        cam.start();
        }
        
    }
    
    
}
