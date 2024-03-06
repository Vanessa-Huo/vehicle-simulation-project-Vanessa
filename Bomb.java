import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends SuperSmoothMover
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean entering;
    private int destination;
    private int exitCountdown;
    private GreenfootImage explodeImage;
    
    public Bomb () {
        entering = true;
        explodeImage = new GreenfootImage(300, 300);
        explodeImage.setColor(Color.ORANGE);
        explodeImage.fillOval (0, 0, 299, 299);
        exitCountdown  = 60;
    }
    
    public void addedToWorld (World w){
        destination = w.getHeight()/2;
    }
    
    
    public void act()
    {
       if (entering){
           setLocation (getX(), getY() + 2);
           if (getY() >= destination){
               entering = false;
               setImage(explodeImage);
               damageTouching();
           }
       } else {
           damageTouching();
           exitCountdown--;
           if (exitCountdown <= 0){
               getWorld().removeObject(this);
           }
       }
    }
    
    private void damageTouching () {
        for (Vehicle v : getIntersectingObjects(Vehicle.class)){
            getWorld().removeObject (v);
        }
    }

}
