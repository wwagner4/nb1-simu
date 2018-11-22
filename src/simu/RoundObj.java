package simu;

import java.awt.Graphics2D;

public class RoundObj extends Obj {

    public RoundObj(int x, int y) {
        super(x, y);
    }

    public void paint(Graphics2D g) {
        g.fillOval(getX() - 50, getY()- 50, 100, 100);
    }

    
}
