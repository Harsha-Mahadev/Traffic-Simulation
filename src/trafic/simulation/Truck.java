/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package trafic.simulation;

import java.awt.Color;
import java.awt.Point;


public class Truck extends Vehicles {    
    
    @Override
    public Color getColor(){
        return Color.BLACK;//assigning black color to truck
    }
    
    @Override
    public int getSize() {
        size=3;//assigning size of Truck
        return size;
    }
    
    
    @Override
    public Point getPosition() {
        return (new Point((int)x,(int)y));//get the current position of Truck
    }
    
    
    
//    @Override
//    public double getSize() {
//        return 3;
//    }
//
    @Override
    public void move(){//below code is to move vehicle
        Point point=getPosition();
        
        /*
        If Direction is Top:
        If the extreme position in the current direction of motion is reached, then change the direction;
        else proceed in the same direction
        */
        if(DIRECTION==TOP){//Logic to move the vehicle Up/Top
            if(point.y>(.05*Simulation.TRACKSIZE+(Simulation.TRACKSIZE/2)+Simulation.INNERSIZE/2+Simulation.TRACKWIDTH/2)){
                DIRECTION=LEFT;
                move();
            }else{
                y+=randomSpeed();
                if(point.x>(3+.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-Simulation.TRACKWIDTH) && point.x<.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-3-size){
                    x=point.x;
                }
            }
        }
        
        /*
        If Direction is Right:
        If the extreme position in the current direction of motion is reached, then change the direction;
        else proceed in the same direction
        */
        else if(DIRECTION==RIGHT){//Logic to move the vehicle towards Right
            if(point.x>(.05*Simulation.TRACKSIZE+(Simulation.TRACKSIZE)-Simulation.TRACKWIDTH/2)){
                DIRECTION=TOP;
                move();
            }else{
                x+=randomSpeed();
                if(point.y<.05*Simulation.TRACKSIZE+3 && point.y>3+.05*Simulation.TRACKSIZE+Simulation.TRACKWIDTH-3-size){
                    y=point.y;
                }
            }
        }
        
        /*
        If Direction is Bottom:
        If the extreme position in the current direction of motion is reached, then change the direction;
        else proceed in the same direction
        */
        else if(DIRECTION==BOTTOM){//Logic to move the vehicle Bottom/down
            
            if(point.y<(.05*Simulation.TRACKSIZE+(Simulation.TRACKWIDTH/2))){
                DIRECTION=RIGHT;
                move();
            }else{
                y-=randomSpeed();
                if(point.x>3+.05*Simulation.TRACKSIZE && point.x<(.05*Simulation.TRACKSIZE+Simulation.TRACKWIDTH-3-size)){
                    x=point.x;
                }
            }
            
            
        }
        
        /*
        If Direction is Left:
        If the extreme position in the current direction of motion is reached, then change the direction;
        else proceed in the same direction
        */
        else if(DIRECTION==LEFT){//Logic to move the vehicle towards Left
            
            
            if(point.x<.05*Simulation.TRACKWIDTH+Simulation.TRACKWIDTH/2){
                DIRECTION=BOTTOM;
                move();
            }else{
                x-=randomSpeed();
                if(point.y>.05*Simulation.TRACKSIZE+3+Simulation.TRACKSIZE/2+Simulation.INNERSIZE/2 && point.y<.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-size-3){
                    y=point.y;
                }
            }
            
        }
    }
    
    private double randomSpeed(){
        return 1;
    }
    
}
