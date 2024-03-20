import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Effect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Effect extends SuperSmoothMover
{
    /**
     * Act - do whatever the Effect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected GreenfootImage image;
    
    public void act()
    {
        // Add your action code here.
    }
    
    protected void fade (int timeLeft, int totalFadeTime){
        double percent = timeLeft / (double)totalFadeTime;
        if(percent > 1.00) return;
        
    }
}
