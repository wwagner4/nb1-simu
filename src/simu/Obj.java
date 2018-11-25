package simu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public abstract class Obj {

    private int x;
    private int y;
    private Direction direction;

    public Obj(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public abstract void paint(Graphics2D g, int time);

    Color color(Random ran) {
        return new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
    }

}
