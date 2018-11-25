package simu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SimulationPanel extends JPanel{
    
    private Simulation  sim;

    public void setSim(Simulation sim) {
        this.sim = sim;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.sim != null) {
        for (Obj object : sim.objects) {
            object.paint((Graphics2D) g, sim.cnt);
        }
        }
    }
    
}
