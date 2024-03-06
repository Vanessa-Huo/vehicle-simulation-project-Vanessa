import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DeadBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DeadBody extends Pedestrian
{
    /**
     * Act - do whatever the DeadBody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public DeadBody ()
    {
        this.getImage().setTransparency(250);
    }
    
    public void act()
    {
        this.getImage().setTransparency(getImage().getTransparency() - 1);
        if (this.getImage().getTransparency() < 5)
        {
            getWorld().removeObject(this);
        }
    }
}
