import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Smog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smog extends Effect
{
    /**
     * Act - do whatever the Smog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int actsLeft;
    private double speed;
    private boolean turnedAround;
    private GreenfootImage smog;
    private GreenfootSound sound;
    
    public Smog(){
        actsLeft=300;
        speed = 0.5;
        smog = getImage();
        smog.scale((int)(smog.getWidth()*2), (int)(smog.getHeight()*2));
        sound = new GreenfootSound("smog.wav");
    }
    
    public void addedToWorld (World w){
        sound.play();
    }
    
    public void act()
    {
        // Add your action code here.
        if(actsLeft>0){
            setLocation (getX(), getY() + speed);
            actsLeft--;
        }
        
        if(actsLeft == 0){
            getWorld().removeObject(this);
        }
    }
    
}
