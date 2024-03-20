import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Taxi subclass
 */

public class Taxi extends Vehicle
{
    private GreenfootImage taxi;
    private static final int stopDuration = 60;
    private int stopTime = 0;
    private int numP;
    private int maxNumP = 2;
    
    public Taxi(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        
        //Set up values for Taxi
        maxSpeed = 3.5 + ((Math.random() * 10)/5);
        speed = maxSpeed;
        followingDistance = 15;
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
        if (moving){
            super.act();
        }else{
            if (stopTime == 0){
                moving = true;
            }else{
                stopTime--;
            }
        }
    }

    public boolean checkHitPedestrian () {
        // currently empty
        Pedestrian p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, 0, Pedestrian.class);
        if(p == null){
            p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, getImage().getHeight()/3, Pedestrian.class);
        }
        if(p == null){
            p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, getImage().getHeight()*(2/3), Pedestrian.class);
        }
        if (p != null && p.isAwake())
        {
            // 2/3 chance of picking up a person 
            if(Greenfoot.getRandomNumber (3) == 0 || Greenfoot.getRandomNumber (3) == 2 && numP < maxNumP){
                stop();
                getWorld().removeObject(p);
                numP++;
            }
        }
        return false;
    }
    
    public void stop(){
        stopTime = stopDuration;
        moving = false;
    }
}
