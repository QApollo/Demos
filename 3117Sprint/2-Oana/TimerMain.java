import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String args[]){
        Runners runnerOne = new Runners("Marcel", 6);
		Runners runnerTwo = new Runners("John", 5);
        Timer timerOne = new Timer(true);
		Timer timerTwo = new Timer(true);
        timerOne.schedule(runnerOne, 1);
		timerTwo.schedule(runnerTwo, 2);
        System.out.println("Timer started");
		
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timerOne.cancel();
		timerTwo.cancel();
        System.out.println("Timer cancelled" + " " + new Date()); 
    }
}