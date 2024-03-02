import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Motorcycles subclass
 */
public class Motorcycles extends Vehicle
{
    private GreenfootImage car;
    
    public Motorcycles(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        
        //Set up values for Motorcycles
        maxSpeed = 4.5 + ((Math.random() * 10)/5);
        speed = maxSpeed;
        // because the Motorcycles graphic is tall, offset it a up (this may result in some collision check issues)
        yOffset = 12;
        
        car = getImage();
        car.scale((int)(car.getWidth()*5), (int)(car.getHeight()*5));
    }

    /**
     * Act - do whatever the Motorcycles wants to do. This method is called whenever
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
