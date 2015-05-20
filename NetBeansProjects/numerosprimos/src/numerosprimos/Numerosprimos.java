package numerosprimos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import static java.lang.Math.*; 

/**
 * @author anthony
 */
public class Numerosprimos extends JFrame implements ActionListener{

    JTextField tx1;
    JButton b1;
    JLabel l1;
    JTextArea j1;
    FileInputStream aa;
    FileOutputStream b;
    
    public Numerosprimos() throws IOException {

        l1 = new JLabel("Ingrese el Números de número primos:");
        tx1=new JTextField();
        b1 = new JButton("ok");
        j1 = new JTextArea();
        //(x,y,"largo","ancho")
        tx1.setBounds(10,50,150,20);
        b1.setBounds(10,70,70,20);
        l1.setBounds(10,30,170,20);
        j1.setBounds(10,100,300,200);
        b1.addActionListener(this);
        j1.setLineWrap(true);
        add(tx1);
        add(b1);
        add(l1);
        add(l1);
        add(j1);

        setLayout(null);
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws IOException {
        new Numerosprimos();
    }
    
    int a = 0, i ,n,c; 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            n= Integer.parseInt(tx1.getText());
                int i, j=0, div=0,raiz=0;
                String primo= "";

            try {
                File archivo=new File("archivo/primos.txt");
                //Escribimos en el archivo con el metodo write
                PrintWriter escribir =new PrintWriter(new FileWriter(archivo,true));
                escribir.println("Números primos: ");
                j1.setText(null);
                for (i=2;i<n+1;i++)    { //ciclo para recorrer los numeros hasta el num indicado
                    div=0; //variable para contar cuantas veces es el residuo de dividir es 0
                    raiz=(int)sqrt(i);//la raiz del número a buscarle los primos
                    for (j=1;j<=raiz;j++)    { //ciclo para recorrer los numeros hasta la raiz de i (estos seran los divisores)
                        if (i%j==0)//evalua la condicion de que el residuo de dividir i entre j es igual a cero
                        div++;// si la condicion anterior se cumple entonces entonces suma 1 a esta variable
                    }
                    if (div<=1)//Si existe más d eun divisor, entonces es primo
                        //primo += i + ", ";
                        
                        j1.append(i + ",");
                        //j1.append(System.getProperty("line.separator")); // Esto para el salto de línea 
                        escribir.println (i + ", "); //+ " es numero primo" );// imprime que cierto numero es primo
                       
                }
                
                //escribir.write(primo);
                //j1.setText(primo);
                escribir.close();
            } catch (Exception ex) {
                System.out.println("Error al escribir");
            }
        }
    }
}
