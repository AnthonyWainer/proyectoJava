/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryc;

import javax.swing.JOptionPane;

/**
 *
 * @author anthony
 */
public class Tryc {
    int a = 0, b= 0;
    public  Tryc(){
        try{
        a =Integer.parseInt(JOptionPane.showInputDialog("Ingrese un Número"));
        b =Integer.parseInt(JOptionPane.showInputDialog("Ingrese otro numero a dividir"));
        JOptionPane.showMessageDialog(null,"la diviison es= "+a/b);
        }catch(ArithmeticException dicero){
            JOptionPane.showMessageDialog(null,"no es posible la division con cero, resultado infinito ");
        }catch(NumberFormatException letras){
            JOptionPane.showMessageDialog(null,"ingrese numero no letras chistoso");
        }catch(Exception e){
            e.getMessage();
        }
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Tryc();
    }
    
}
