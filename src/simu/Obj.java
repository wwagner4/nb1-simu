package simu;

import java.awt.Graphics2D;

public abstract class Obj {

    private int x;
    private int y;

    public Obj(int x, int y) {
        this.x = x;
        this.y = y;
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

    public abstract void paint(Graphics2D g);

}
