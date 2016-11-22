/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package trafic.simulation;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class Vehicles {//vehicle is chosen to be an Abstract class
    public int size; // size is used t store the dimension of the square which represents vehicle.
    int Xmax= (int) (0.05*Simulation.TRACKSIZE+Simulation.TRACKSIZE-Simulation.TRACKWIDTH/2);//the point till which an vehicle can move towards right side
    int Xmin=(int)Simulation.TRACKWIDTH/2;//the point till which an vehicle can move towards left side
    
    double x=(new Random()).nextInt((Xmax+1)-Xmin)+Xmin,y=.05*Simulation.TRACKSIZE+Simulation.TRACKWIDTH/3;//chosing an initial location for the vehicle to start at
    
    int TOP=1,LEFT=4,BOTTOM=3,RIGHT=2,DIRECTION=RIGHT;//defining the direction and assigning each direction an integer
    
    public abstract Color getColor();// abstract method to hold the colour of the vehicle
    public abstract Point getPosition();// abstract method to hold the position of the vehicle
    
    public abstract int getSize();//  abstract method to get the size of the vehicle
    public abstract void move();//  abstract method to move the vehicle
    
    
   
}
