import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Desert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Desert extends World
{

    /**
     * Constructor for objects of class Desert.
     * 
     */
    public Desert()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 480, 1); 
        addObject(new Boat(), 270, 210);
        addObject(new Muffin(), (int)(10*Math.random())*60+30, (int)(8*Math.random())*60+30);
    }
}
