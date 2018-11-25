package simu;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        final MainFrame frame = new MainFrame();
        frame.setTitle("nb1 simu");
        frame.setLocation(100, 100);
        frame.setSize(1500, 1000);
        frame.setResizable(false); 
        frame.setVisible(true);

        Simulation sim = new Simulation();
        sim.setCanvas(frame.getCanvas());

        
        final ScheduledExecutorService sched = Executors.newScheduledThreadPool(20);
        sched.scheduleAtFixedRate(sim, 100, 50, TimeUnit.MILLISECONDS);
    }

}
