package Package01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MeuThread extends Thread{
    @Override
    public void run(){
        for(int i=0; i<=100; i++){
        	
        	if (i%2==0) {
        		System.out.println("Par: "+i);
        	}
        	
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(MeuThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
