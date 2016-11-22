/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package trafic.simulation;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Harsha
 */
public class FamilyCar extends Vehicles{
    
    @Override
    public Color getColor(){
        return Color.BLUE;
    }
    
    @Override
    public int getSize() {
        size=1;
        return size;//ody of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
    @Override
    public void move(){
        Point point=getPosition();
        if(DIRECTION==TOP){
            
            if(point.y>(.05*Simulation.TRACKSIZE+(Simulation.TRACKSIZE/2)+Simulation.INNERSIZE/2+Simulation.TRACKWIDTH/2)){
                DIRECTION=LEFT;
            }else{
                y+=randomSpeed();
                if(point.x>(3+.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-Simulation.TRACKWIDTH) && point.x<.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-3-size){
                    if (randomDir()%2==0) {
                        x-=.1;
                    }else{
                        x+=.1;
                    }
                }else if(point.x<(3+.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-Simulation.TRACKWIDTH) ){
                    x+=.1;
                }else{
                    x-=.1;
                }
            }
        }else if(DIRECTION==RIGHT){
            if(point.x>(.05*Simulation.TRACKSIZE+(Simulation.TRACKSIZE)-Simulation.TRACKWIDTH/2)){
                DIRECTION=TOP;
            }else{
                x+=randomSpeed();
                if(point.y<.05*Simulation.TRACKSIZE+3 && point.y>3+.05*Simulation.TRACKSIZE+Simulation.TRACKWIDTH-3-size){
                    if (randomDir()%2==0) {
                        y-=.1;
                    }else{
                        y+=.1;
                    }
                }else if(point.y>.05*Simulation.TRACKSIZE+3){
                    y-=.1;
                }else{
                    y+=.1;
                }
            }
        }else if(DIRECTION==BOTTOM){
            
            if(point.y<(.05*Simulation.TRACKSIZE+(Simulation.TRACKWIDTH/2))){
                DIRECTION=RIGHT;
            }else{
                y-=randomSpeed();
                if(point.x>3+.05*Simulation.TRACKSIZE && point.x<(.05*Simulation.TRACKSIZE+Simulation.TRACKWIDTH-3-size)){
                    
                    if (randomDir()%2==0) {
                        x-=.1;
                    }else{
                        x+=.1;
                    }
                }else if(point.x<3+.05*Simulation.TRACKSIZE){
                    x+=.1;
                }else{
                    x-=.1;
                }
            }
            
            
        }else if(DIRECTION==LEFT){
            
            
            if(point.x<.05*Simulation.TRACKWIDTH+Simulation.TRACKWIDTH/2){
                DIRECTION=BOTTOM;
            }else{
                x-=randomSpeed();
                
                if(point.y>.05*Simulation.TRACKSIZE+3+Simulation.TRACKSIZE/2+Simulation.INNERSIZE/2 && point.y<.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-size-3){
                    
                    if (randomDir()%2==0) {
                        y-=.1;
                    }else{
                        y+=.1;
                    }
                }else if(point.y<.05*Simulation.TRACKSIZE+3+Simulation.TRACKSIZE/2+Simulation.INNERSIZE/2){
                    y+=.1;
                }else{
                    y-=.1;
                }
            }
            
        }
    }
    
    @Override
    public Point getPosition() {
    return (new Point((int)x,(int)y));
    }
    
    private double randomSpeed(){
        return 3;
    }
    private int randomDir(){
        return (new Random()).nextInt(4)+1;
    }
    
}
