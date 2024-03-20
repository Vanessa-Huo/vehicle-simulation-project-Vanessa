import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PoliceCar subclass
 */
public class PoliceCar extends Vehicle
{
    private GreenfootImage car;
    private GreenfootSound siren;
    
    public PoliceCar(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        followingDistance = 12;
        
        //Set up values for PoliceCar
        maxSpeed = 4.5 + ((Math.random() * 10)/5);
        speed = maxSpeed;
        
        // because the PoliceCar graphic is tall, offset it a up (this may result in some collision check issues)
        yOffset = 15;
        car = getImage();
        car.scale((int)(car.getWidth()*4.8), (int)(car.getHeight()*4.8));
        
        siren = new GreenfootSound("police.wav");
    }
    
    public void addedToWorld (World w){
        super.addedToWorld(w);
        siren.play();
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
    
    public void drive() 
    {
        // Ahead is a generic vehicle - we don't knockDownknow what type BUT
        // since every Vehicle "promises" to have a getSpeed() method,
        // we can call that on any vehicle to find out it's speed
        super.drive();
        
    }   
    
}
