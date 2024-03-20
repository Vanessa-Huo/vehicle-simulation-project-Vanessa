import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Motorcycles subclass
 */
public class Motorcycles extends Vehicle
{
    private GreenfootImage car;
    private boolean rob;
    
    
    public Motorcycles(VehicleSpawner origin){
        super (origin); // call the superclass' constructor first
        followingDistance = 10;
        
        //Set up values for Motorcycles
        maxSpeed = 4.0 + ((Math.random() * 10)/5);
        speed = maxSpeed;
        // because the Motorcycles graphic is tall, offset it a up (this may result in some collision check issues)
        car = getImage();
        car.scale((int)(car.getWidth()*5), (int)(car.getHeight()*5));
        
        yOffset = 12;
    }

    /**
     * Act - do whatever the Motorcycles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        if(this.getWorld() != null){
            checkItemsOnRoad();
        }
    }

    public boolean checkHitPedestrian () {
        // currently empty
        Pedestrian p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, 0, Pedestrian.class);
        if(p != null && p.isAwake() && p.isAlive() && p.getMoney()>0){
            if(Greenfoot.getRandomNumber (2)==0){
                p.steal();
                rob = true;
                p.getRobbed();
            }
            else if(Greenfoot.getRandomNumber (2)==1){
                p.knockDown();
                p.steal();
                rob = true;
                p.getRobbed();
                return true;
            }
        }
        else if(p != null && !p.isAwake()){
            p.steal();
            rob = true;
        }
        return false;
    }
    
    public void checkItemsOnRoad(){
        Items x = (Items) getOneIntersectingObject(Items.class);
        if(x != null){
            rob = true;
            getWorld().removeObject(x);
        }
    }
    
    public boolean robbed(){
        return rob;
    }

}
