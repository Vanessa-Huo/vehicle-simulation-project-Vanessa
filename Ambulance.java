import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The Ambulance subclass
 */
public class Ambulance extends Vehicle
{
    private GreenfootImage ambulance;
    private static final int stopDuration = 60;
    private int stopTime = 0;
    private int numP;
    
    public Ambulance(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        maxSpeed = 3.0;
        followingDistance = 15;
        speed = maxSpeed;
        ambulance = getImage();
        yOffset = 15;
        ambulance.scale((int)(ambulance.getWidth()*3.8), (int)(ambulance.getHeight()*3.8));
    }

    /**
     * Act - do whatever the Ambulance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (moving){
            super.act();
            speed = maxSpeed;
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
            p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, -getImage().getHeight(), Pedestrian.class);
        }
        if(p == null){
            p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, getImage().getHeight(), Pedestrian.class);
        }
        if(p == null){
            p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, getImage().getHeight()/3, Pedestrian.class);
        }
        if(p == null){
            p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, getImage().getHeight()*(2/3), Pedestrian.class);
        }
        if(p != null && !p.isAwake() && p.isAlive() && p.canPay()){
            stop();
            p.healMe();
            p.setEnergy(3000);
            return true;
        }
        else if(p != null && !p.isAwake() && !p.isAlive() && numP < 2){
            stop();
            getWorld().removeObject(p);
            numP++;
            return true;
        }
        return false;
    }
    
    public void stop(){
        stopTime = stopDuration;
        speed = 0;
        moving = false;
    }
    
}
