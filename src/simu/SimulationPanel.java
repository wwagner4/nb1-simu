package simu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class SimulationPanel extends JPanel{
    
    private List<Obj> objects = new ArrayList<>();

    public void setObjects(List<Obj> objects) {
        this.objects = objects;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Obj object : objects) {
            object.paint((Graphics2D) g);
        }
    }
    
}
