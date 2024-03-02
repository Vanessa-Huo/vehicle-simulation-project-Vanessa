import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Taxi subclass
 */

public class Taxi extends Vehicle
{
    private GreenfootImage taxi;
    
    public Taxi(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        
        //Set up values for Taxi
        maxSpeed = 3.5 + ((Math.random() * 10)/5);
        speed = maxSpeed;
        // because the Taxi graphic is tall, offset it a up (this may result in some collision check issues)
        yOffset = 11;
        
        taxi = getImage();
        taxi.scale((int)(taxi.getWidth()*4.5), (int)(taxi.getHeight()*4.5));
    }

    /**
     * Act - do whatever the Taxi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       super.act();
    }

    public boolean checkHitPedestrian () {
        // currently empty
        return false;
    }
}
