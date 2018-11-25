package simu;

import java.awt.Graphics2D;
import java.util.Random;

public class RectObj extends Obj {
    
    private int offset;
    
    public RectObj(int x, int y, Direction direction, Random ran) {
        super(x, y, direction);
        this.offset = ran.nextInt(200);    }

    @Override
    public void paint(Graphics2D g, int time) {
        int w = (int)(5 + 3 * Math.sin(offset + (double)time / 50));
        g.drawRect(getX() - w, getY()- w, w * 2, w * 2);
    }

    
}
