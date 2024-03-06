import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Car subclass
 */
public class Car extends Vehicle
{
    private GreenfootImage car;
    
    public Car(VehicleSpawner origin) {
        super(origin); // call the superclass' constructor
        maxSpeed = 4.5 + ((Math.random() * 30)/5);
        speed = maxSpeed;
        yOffset = 15;
        followingDistance = 15;

        if(Greenfoot.getRandomNumber(3)==1){
            setImage("suv.png");
            if (origin.facesRightward()){ // Right facing vehicles
            direction = 1;        
            } else { // left facing Vehicles
                direction = -1;
                // Reverse the image so it appears correct when moving the opposite direction
                getImage().mirrorHorizontally();
            }
        }
        else if(Greenfoot.getRandomNumber(3)==2){
            setImage("car1.png");
            yOffset = 8;
            if (origin.facesRightward()){ // Right facing vehicles
            direction = 1;        
            } else { // left facing Vehicles
                direction = -1;
                // Reverse the image so it appears correct when moving the opposite direction
                getImage().mirrorHorizontally();
            }
        }
        car = getImage();
        car.scale((int)(car.getWidth()*4.4), (int)(car.getHeight()*4.4));
    }

    public void act()
    {
        super.act();
    }

    /**
     * When a Car hit's a Pedestrian, it should knock it over
     */
    public boolean checkHitPedestrian () {
        Pedestrian p = (Pedestrian)getOneObjectAtOffset((int)speed + getImage().getWidth()/2, 0, Pedestrian.class);
        if (p != null)
        {
            p.knockDown();
            return true;
        }
        else if(p != null && !p.isAwake()){
            if(p.getEnergy()<=10){
                p.setEnergy(0);
            }
            else{
                p.setEnergy(p.getEnergy() - 10);
            }
        }
        return false;
    }
}
