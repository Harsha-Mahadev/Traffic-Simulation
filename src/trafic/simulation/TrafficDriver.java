package trafic.simulation;

/**
 *
 * @author Paul Fischer
 *
 */
public class TrafficDriver {    
    /**
     * Driver class.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a simulation ...
        
        Simulation sim = new Simulation(10, 1000);
        // ... and run it.
        sim.run();
        
        
    }
}
