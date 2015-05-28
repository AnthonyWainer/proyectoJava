
package ejercicoh;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Ejercicoh extends Thread {
    Thread ir;
    int a,b,c,posi=0;
    String x,y,z,rr;
    JLabel label;
    
    public Ejercicoh (String x,int a,JLabel label, String rr){
        super(x);
        this.x=x;
        this.a=a;
        this.rr=rr;
        this.label=label;
        ir=new Thread(this);
    }
    
    public void run(){
        if ("ida".equals(rr)) {
            for(b=0;b<a;b++){
            try{
                Thread.sleep(5);
            }catch(Exception e){
                e.getMessage();
            }
            //System.out.println(x);
            label.setLocation(b,0);
            yield();
            posi++;
        }
        }else{
            for(b=a;b>0;b--){
                try{
                    Thread.sleep(5);
                }catch(Exception e){
                    e.getMessage();
                }
                //System.out.println(x);
                label.setLocation(b,0);
                yield();
        }
        }
        
        JOptionPane.showMessageDialog(null,x+" llego");
    }

    public static void main(String[] args) {
        new Graficos();
    }
    
}
