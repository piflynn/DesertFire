import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boat extends Actor
{
    private int fuel;
    private int score;
    private int count;
   
    public Boat() {
        fuel = 30;
        score = 0;
        count = 0;
    }
    
    public Boat (int fuel, int score) {
        this.fuel = fuel;
        this.score = score;
        count = 0;
    }
    
    /**
     * Act - do whatever the Boat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
      {
        System.out.println(toString());
        getWorld().showText("Fuel: " + fuel,50,30);
        getWorld().showText("Heading: " + directionString(),70,60);
        getWorld().showText("Score: " + score,530,30);
        if(fuel > 0) {
            if(Greenfoot.isKeyDown("space")) {
                move(60);
                count++;
                fuel--;
            }
            if(Greenfoot.isKeyDown("right")) {
                turn(90);
            }
            if(Greenfoot.isKeyDown("left")) {
                turn(-90);
            }
            if(isAtEdge()) {
                turn(180);
                move(30);
            }
            if(isTouching(Muffin.class)) {
                removeTouching(Muffin.class);
                score += 13;
                getWorld().addObject(new Muffin(), (int)(10*Math.random())*60+30, (int)(7*Math.random())*60+30);
            }
            if(isTouching(Mushroom.class)) {
                removeTouching(Mushroom.class);
                fuel += 10;
            }
            if(isTouching(Grass.class)) {
                turn(180);
                move(60);
            }
        }
        if((int)(Math.random()*30) == 0) {
            getWorld().addObject(new Grass(), (int)(10*Math.random())*60+30, (int)(8*Math.random())*60+30);
        }
        if((int)(Math.random()*40) == 0) {
            getWorld().addObject(new Mushroom(), (int)(10*Math.random())*60+30, (int)(8*Math.random())*60+30);
        }
    }
    
    public String toString() {
        return "Fuel: " + fuel + "\t\t\tScore: " + score +
                "\nHeading: " + directionString();
               
    }
   
    private String directionString() {
        if(getRotation() == 0) {
            return "E";
        }
        else if(getRotation() > 0 && getRotation() < 90) {
            return "SE";
        }
        else if(getRotation() == 90) {
            return "S";
        }
        else if(getRotation() > 90 && getRotation() < 180) {
            return "SW";
        }
        else if(getRotation() == 180) {
            return "W";
        }
        else if(getRotation() > 180 && getRotation() < 270) {
            return "NW";
        }
        else if(getRotation() == 270) {
            return "N";
        }
        else if(getRotation() > 270 && getRotation() < 360) {
            return "NE";
        }
        else {
            return "...";
        }
    }
}
