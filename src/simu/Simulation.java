package simu;

import java.util.ArrayList;
import java.util.Random;

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
        for (int i = 0; i < 1500; i++) {
            if (ran.nextBoolean()) {
                objects.add(new RoundObj(maxw / 2, maxh / 2, Direction.EAST, ran));
            } else {
                objects.add(new RectObj(maxw / 2, maxh / 2, Direction.WEST, ran));
            }
        }
        canvas.setSim(this);
    }

    int ranVal(int maxVal) {
        return ran.nextInt(maxVal - 600);
    }

    @Override
    public void run() {
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

    private static final int DIST = 1;

    private void move(Obj object) {
        changeDirection(object);
        switch (object.getDirection()) {
            case NORTH: object.setY(object.getY() + DIST); break;
            case EAST: object.setX(object.getX() + DIST); break;
            case SOUTH: object.setY(object.getY() - DIST); break;
            case WEST: object.setX(object.getX() - DIST); break;
        }
    }

    private void changeDirection(Obj object) {
        if (ran.nextInt(10000) > 9920) {
           doChangeDirection(object);
        } 
    }

    private void doChangeDirection(Obj object) {
        if (ran.nextBoolean()) {
            turnRight(object);
        } else {
            turnLeft(object);
        }
    }

    private void turnRight(Obj object) {
        switch (object.getDirection()) {
            case NORTH: object.setDirection(Direction.EAST); break;
            case EAST: object.setDirection(Direction.SOUTH); break;
            case SOUTH: object.setDirection(Direction.WEST); break;
            case WEST: object.setDirection(Direction.NORTH); break;
        }
    }

    private void turnLeft(Obj object) {
        switch (object.getDirection()) {
            case NORTH: object.setDirection(Direction.WEST); break;
            case EAST: object.setDirection(Direction.NORTH); break;
            case SOUTH: object.setDirection(Direction.EAST); break;
            case WEST: object.setDirection(Direction.SOUTH); break;
        }
    }

}
