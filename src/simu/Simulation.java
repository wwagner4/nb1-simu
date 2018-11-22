package simu;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author wwagner4
 */
public class Simulation implements Runnable {

    private SimulationPanel canvas;
    private final Random ran = new Random();
    int cnt = 0;
    ArrayList<Obj> objects = new ArrayList<>();

    public void setCanvas(SimulationPanel canvas) {
        this.canvas = canvas;
        int maxw = canvas.getWidth();
        int maxh = canvas.getHeight();
        for (int i = 0; i < 100000; i++) {
            //objects.add(new RoundObj(maxw / 2, maxh / 2));
            objects.add(new RectObj(maxw / 2, maxh / 2));
        }
        canvas.setObjects(objects);
    }

    int ranVal(int maxVal) {
        return ran.nextInt(maxVal - 600);
    }

    @Override
    public void run() {
        takeStep();
    }

    public void takeStep() {
        if (cnt % 1000 == 0) {
            System.out.println("step " + cnt);
        }
        moveObjects(objects);
        canvas.repaint();
        cnt++;
    }

    private void moveObjects(ArrayList<Obj> objects) {
        for (Obj object : objects) {
            move(object);
        }
    }

    private static final int DIST = 2;

    private void move(Obj object) {
        int dx = ran.nextInt(2 * DIST + 1) - DIST;
        int dy = ran.nextInt(2 * DIST + 1) - DIST;
        object.setX(object.getX() + dx);
        object.setY(object.getY() + dy);
    }

}
