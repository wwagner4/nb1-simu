package simu;

import java.awt.Graphics2D;

public class RectObj extends Obj {
    
    private static final int WIDTH = 3;

    public RectObj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(Graphics2D g) {
        g.drawRect(getX() - WIDTH, getY()- WIDTH, WIDTH * 2, WIDTH * 2);
    }

    
}
