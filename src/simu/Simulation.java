package simu;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author wwagner4
 */
public class Simulation implements Runnable {

    private SimulationPanel canvas;
    private Random ran = new Random();



    public void setCanvas(SimulationPanel canvas) {
        this.canvas = canvas;
    }
    
    
    int ranVal(int maxVal) {
        return ran.nextInt(maxVal - 600);
    }
    
    @Override
    public synchronized void run() {
        int maxw = canvas.getWidth();
        int maxh = canvas.getHeight();
        ArrayList<Obj> objects = new ArrayList<>();
        objects.add(new RoundObj(maxw / 2, maxh / 2));
        objects.add(new RoundObj(maxw / 2, maxh / 2));
        objects.add(new RoundObj(maxw / 2, maxh / 2));
        objects.add(new RoundObj(maxw / 2, maxh / 2));
        objects.add(new RoundObj(maxw / 2, maxh / 2));
        objects.add(new RoundObj(maxw / 2, maxh / 2));
        objects.add(new RoundObj(maxw / 2, maxh / 2));
        canvas.setObjects(objects);
        
        int cnt = 0;

        while (true) {
            try {
                if (cnt % 10 == 0) {
                    System.out.println("cnt: " + cnt);
                }
                moveObjects(objects);
                canvas.repaint();
                wait(100);
                cnt++;
            } catch (InterruptedException ex) {
                // Nothing to do
            }
        }
    }
    private void moveObjects(ArrayList<Obj> objects) {
        for (Obj object : objects) {
            move(object);
        }
    }

    private void move(Obj object) {
        int dx = ran.nextInt(11) - 5;
        int dy = ran.nextInt(11) - 5;
        object.setX(object.getX() + dx);
        object.setY(object.getY() + dy);
    }


}
