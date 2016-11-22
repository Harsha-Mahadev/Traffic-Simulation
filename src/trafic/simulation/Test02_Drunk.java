/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package trafic.simulation;
import java.awt.Point;

public class Test02_Drunk {
    
    public static void main(String[] args) {
        DrunkenDriver drunk = new DrunkenDriver();
        
        int step = 0;
        boolean wrongDirection = false;
        boolean deviated = false;
        
        boolean stop = false;
        
        while (true) {
            
            Point before = new Point(drunk.getPosition());
            drunk.move();
            
            if (drunk.getPosition().y + drunk.getSize() < Simulation.TRACKWIDTH) {
                if (!stop) {
                    stop = true;
                    continue;
                }
                
                if (drunk.getPosition().equals(before)) {
                    System.out.println("ERROR: The drunken driver didn't move.");
                    System.exit(0);
                }
                
                if (drunk.getPosition().y != before.y) {
                    deviated = true;
                }
                if (drunk.getPosition().x < before.x) {
                    wrongDirection = true;
                }
            } else if (step > 800) {
                break;
            }
            step++;
        }
        if (!deviated || !wrongDirection) {
            System.out.println("ERROR: The drunken driver seems to be sober.");
            System.exit(0);
        }
        
        System.out.println("No violations detected.");
    }
}

