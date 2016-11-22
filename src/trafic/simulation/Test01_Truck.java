/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package trafic.simulation;

/**
 *
 * @author Harsha
 */

import java.awt.Point;

public class Test01_Truck {
    
    public static void main(String[] args) {
        Truck truck = new Truck();
        
        if (truck.getSize() <= (new FamilyCar()).getSize() || truck.getSize() <= (new Bus()).getSize()
                || truck.getSize() <= (new DrunkenDriver().getSize())) {
            System.out.println("ERROR: The truck " + truck + " is not the biggest vehicle.");
            System.exit(0);
        }
        
        boolean stop = false;
        
        int step = 0;
        System.out.println(truck.getPosition().toString());
        
        while (true) {
            
            Point before = new Point(truck.getPosition());
            truck.move();
            System.out.println(truck.getPosition().toString());
            
            if (truck.getPosition().y + truck.getSize() < Simulation.TRACKWIDTH) {
                if (!stop) {
                    stop = true;
                    continue;
                }
                
                if (truck.getPosition().equals(before)) {
                    System.out.println("ERROR: The truck " + truck + " didn't move.");
                    System.exit(0);
                }
                
                if (step > 2 && truck.getPosition().x < before.x) {
                    System.out.println("ERROR: The truck " + truck + " moved in the wrong direction.");
                    System.exit(0);
                    
                    if (truck.getPosition().y != before.y) {
                        System.out.println("ERROR: The truck " + truck
                                + " should move straight ahead on this part of the track, but it deviated to the right or left.");
                        System.exit(0);
                    }
                }
                step++;
                
            } else if (stop) {
                break;
            }
            
        }
        
        System.out.println("No violations detected.");
    }
}
