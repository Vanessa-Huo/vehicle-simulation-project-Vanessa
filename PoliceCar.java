import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PoliceCar subclass
 */
public class PoliceCar extends Vehicle
{
    private GreenfootImage car;
    public PoliceCar(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        
        //Set up values for PoliceCar
        maxSpeed = 3.5 + ((Math.random() * 10)/5);
        speed = maxSpeed;
        // because the PoliceCar graphic is tall, offset it a up (this may result in some collision check issues)
        yOffset = 15;
        car = getImage();
        car.scale((int)(car.getWidth()*4.8), (int)(car.getHeight()*4.8));
    }

    /**
     * Act - do whatever the PoliceCar wants to do. This method is called whenever
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
