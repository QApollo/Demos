import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Runners extends TimerTask {
	private String name;
	private int kilometers;
	
	public Runners(String name, int kilometers) {
		this.name = name;
		this.kilometers = kilometers;
	}

    @Override
    public void run() {
        System.out.println("Timer task started at:"+ new Date());
        completeTask();
		for (int i=0; i <= kilometers; i++) {
            System.out.print("\n" + name + " has run " + i + " kilometer" + (i != 1 ? "s" : ""));
		}   
        System.out.println("\nTimer task finished at:"+ new Date() + " for " + name);
    }

    private void completeTask() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}