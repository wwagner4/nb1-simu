package simu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class RectObj extends Obj {
    
    private final int offset;
    private final Color color;
    
    public RectObj(int x, int y, Direction direction, Random ran) {
        super(x, y, direction);
        this.offset = ran.nextInt(200);    
        this.color = color(ran);
    }

    @Override
    public void paint(Graphics2D g, int time) {
        g.setColor(this.color);
        int w = (int)(5 + 3 * Math.sin(offset + (double)time / 50));
        g.fillRect(getX() - w, getY()- w, w * 2, w * 2);
    }
    
    
}
