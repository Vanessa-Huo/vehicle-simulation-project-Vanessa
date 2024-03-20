import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Effect
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[]idleX = new GreenfootImage[49];
    SimpleTimer timer = new SimpleTimer();
    private int imageIndex=0;
    private GreenfootSound crash;
    
    public void act()
    {
        // Add your action code here.
        if(imageIndex < 35){
            animateE();
        }

        if(imageIndex>=35){
            ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>)getIntersectingObjects(Vehicle.class);
            for (Vehicle v : vehicles){
                if ((v instanceof Vehicle)){
                    getWorld().removeObject(v);
                }
            }
            ArrayList<Pedestrian> peds = (ArrayList<Pedestrian>)getObjectsInRange (150, Pedestrian.class);
            for (Pedestrian p : peds){
                p.knockDown();
            }
            getWorld().removeObject(this);
        }
    }
    
    public Explosion(){
        for(int i=0; i<idleX.length;i++){
            idleX[i]=new GreenfootImage("images/explo/1_"+i+".png");
            idleX[i].scale(300, 300);
        }
        
        timer.mark();
        
        setImage(idleX[0]);
        
        crash = new GreenfootSound("crash.wav");
    }
    
    public void addedToWorld (World w){
        crash.play();
    }
    
    public void animateE()
    {
        if(timer.millisElapsed()<35)
        {
            return;
        }
        timer.mark();
        
        setImage(idleX[imageIndex]);
        imageIndex=(imageIndex + 1) % idleX.length;
    }
}
