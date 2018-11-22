package simu;

import java.awt.Graphics2D;

public class RoundObj extends Obj {
    
    private static final int WIDTH = 10;

    public RoundObj(int x, int y) {
        super(x, y);
    }

    public void paint(Graphics2D g) {
        g.fillOval(getX() - WIDTH, getY()- WIDTH, WIDTH * 2, WIDTH * 2);
    }

    
}
