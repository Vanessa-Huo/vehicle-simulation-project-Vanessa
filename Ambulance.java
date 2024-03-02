import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The Ambulance subclass
 */
public class Ambulance extends Vehicle
{
    private GreenfootImage ambulance;
    
    public Ambulance(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        maxSpeed = 3.5;
        speed = maxSpeed;
        ambulance = getImage();
        yOffset = 17;
        ambulance.scale((int)(ambulance.getWidth()*3.8), (int)(ambulance.getHeight()*3.8));
    }

    /**
     * Act - do whatever the Ambulance wants to do. This method is called whenever
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
