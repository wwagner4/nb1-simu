package simu;

import java.awt.Graphics2D;
import java.util.Random;

public class RoundObj extends Obj {
    
    private static final int WIDTH = 10;
    
    private int offset;
    private int offsetDiff;

    public RoundObj(int x, int y, Direction direction, Random ran) {
        super(x, y, direction);
        offset = ran.nextInt(100);
        offsetDiff = ran.nextInt(100);
    }

    @Override
    public void paint(Graphics2D g, int time) {
        int w = (int)(15 + 14 * Math.sin(offset + (double)time / 150));
        int h = (int)(15 + 14 * Math.sin(offset + offsetDiff + (double)time / 150));
        g.drawOval(getX() - w, getY()- h, w * 2, h * 2);
    }

    
}
