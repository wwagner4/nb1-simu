package simu;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final MainFrame frame = new MainFrame();
                frame.setTitle("nb1 simu");
                frame.setLocation(100, 100);
                frame.setSize(1500, 1000);
                frame.setVisible(true);

                Simulation sim = new Simulation();
                sim.setCanvas(frame.getCanvas());
                
                new Thread(sim).start();
            }

        });
    }

}
