
package ejercicoh;


public class Ejercicoh extends Thread {
    Thread ir;
    int a,b,c;
    String x,y,z;
    
    public Ejercicoh (String x,int a){
        this.x=x;
        this.a=a;
        ir=new Thread(this);
    }
    
    public void run(){
        for(b=0;b<a;b++){
            System.out.println(x);
            yield();
        }
    }

    public static void main(String[] args) {
        Ejercicoh tor=new Ejercicoh("tortuga",5);
        Ejercicoh leo=new Ejercicoh("leon",5);
        Ejercicoh lie=new Ejercicoh("liebre",5);
        tor.start();
        leo.start();
        lie.start();
    }
    
}
