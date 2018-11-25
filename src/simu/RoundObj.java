package simu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class RoundObj extends Obj {

    private final int offset;
    private final double offsetDiff;
    private final boolean filled;
    private final Color color;

    public RoundObj(int x, int y, Direction direction, Random ran) {
        super(x, y, direction);
        offset = ran.nextInt(100);
        offsetDiff = ran.nextDouble();
        filled = ran.nextInt(10000) >= 9900;
        color = color(ran);
    }

    @Override
    public void paint(Graphics2D g, int time) {
        if (filled) {
            int w = (int) (30 + 20 * Math.sin(offset + (double) time / (20 * (offsetDiff * 0.5 + 0.1))));
            int h = (int) (30 + 20 * Math.sin(offset + offsetDiff + (double) time / (20 * (offsetDiff * 0.5 + 0.1))));
            g.setColor(this.color);
            g.fillOval(getX() - w, getY() - h, w * 2, h * 2);
        } else {
            int w = (int) (5 + 4 * Math.sin(offset + (double) time / 95));
            int h = (int) (5 + 4 * Math.sin(offset + offsetDiff + (double) time / 90));
            g.setColor(Color.BLACK);
            g.drawOval(getX() - w, getY() - h, w * 2, h * 2);
        }
    }

}
