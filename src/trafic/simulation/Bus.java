/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package trafic.simulation;

import java.awt.Color;
import java.awt.Point;

//inheritance 
public class Bus extends Vehicles{
    
    
    @Override
    public Color getColor(){
        return Color.RED;
    }
    
    @Override
    public int getSize() {
        size=2;
        return 2; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void move(){
        Point point=getPosition();
        if(DIRECTION==TOP){
            
            if(point.y>(.05*Simulation.TRACKSIZE+(Simulation.TRACKSIZE/2)+Simulation.INNERSIZE/2+Simulation.TRACKWIDTH/2)){
                DIRECTION=LEFT;
                move();
            }else{
                y+=randomSpeed();
                if(point.x>(3+.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-Simulation.TRACKWIDTH) && point.x<.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-3-size){
                    x=point.x;
                }
            }
        }else if(DIRECTION==RIGHT){
            if(point.x>(.05*Simulation.TRACKSIZE+(Simulation.TRACKSIZE)-Simulation.TRACKWIDTH/2)){
                DIRECTION=TOP;
                move();
            }else{
                x+=randomSpeed();
                if(point.y<.05*Simulation.TRACKSIZE+3 && point.y>3+.05*Simulation.TRACKSIZE+Simulation.TRACKWIDTH-3-size){
                    y=point.y;
                }
            }
        }else if(DIRECTION==BOTTOM){
            
            if(point.y<(.05*Simulation.TRACKSIZE+(Simulation.TRACKWIDTH/2))){
                DIRECTION=RIGHT;
                move();
            }else{
                y-=randomSpeed();
                if(point.x>3+.05*Simulation.TRACKSIZE && point.x<(.05*Simulation.TRACKSIZE+Simulation.TRACKWIDTH-3-size)){
                    x=point.x;
                }
            }
            
            
        }else if(DIRECTION==LEFT){
            
            
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
        return 2;
    }
    
    @Override
    public Point getPosition() {
    return (new Point((int)x,(int)y));
    }
}
