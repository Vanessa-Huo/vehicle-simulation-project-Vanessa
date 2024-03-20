import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private boolean entering;
    private int destination;
  
    private GreenfootImage explodeImage;
    
    public Bomb () {
        entering = true;
        explodeImage = new GreenfootImage(300, 300);
        explodeImage.setColor(Color.ORANGE);
        explodeImage.fillOval (0, 0, 299, 299);
    }
    
    public void addedToWorld (World w){
        destination = 451;
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
               //getWorld().addObject(new Explosion(300, 10), getX(), getY());
               getWorld().removeObject(this);
       }
    }
    
    private void damageTouching () {
        for (Vehicle v : getIntersectingObjects(Vehicle.class)){
            getWorld().removeObject (v);
        }
    }
}
