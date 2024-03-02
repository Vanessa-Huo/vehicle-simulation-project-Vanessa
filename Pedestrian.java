import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Pedestrian that tries to walk across the street
 */
public class Pedestrian extends SuperSmoothMover
{
    private double speed;
    private double maxSpeed;
    private int direction; // direction is always -1 or 1, for moving down or up, respectively
    private boolean awake, gettingUp;
    
    private SuperStatBar energyBar;
    private int energy;
    private int maxEnergy;
    private SuperStatBar moneyBar;
    private int money; 
    
    public Pedestrian(int direction) {
        // choose a random speed
        maxSpeed = Math.random() * 2 + 1;
        speed = maxSpeed;
        // start as awake 
        awake = true;
        gettingUp = false;
        this.direction = direction;
        maxEnergy = VehicleWorld.P_Max_HP;
        energy = maxEnergy;
        money = Greenfoot.getRandomNumber (2500)+500;
        if(VehicleWorld.SHOW_ENERGY_BARS){
            energyBar = new SuperStatBar(maxEnergy, energy, this, 40, 8, -32, Color.GREEN, Color.GRAY, false, Color.GRAY, 1);
        }
        if(VehicleWorld.SHOW_MONEY_BARS){
            moneyBar = new SuperStatBar(3000, money, this, 40, 8, -40, Color.YELLOW, Color.GRAY, false, Color.GRAY, 1);
        }
    }
    
    public Pedestrian(){
        maxSpeed = Math.random() * 2 + 1;
        speed = maxSpeed;
        // start as awake 
        awake = true;
        gettingUp = false;
        this.direction = direction;
        maxEnergy = VehicleWorld.P_Max_HP;
        energy = maxEnergy;
        if(VehicleWorld.SHOW_ENERGY_BARS){
            energyBar = new SuperStatBar(maxEnergy, energy, this, 40, 8, -32, Color.GREEN, Color.GRAY, false, Color.GRAY, 1);
        }
        if(VehicleWorld.SHOW_MONEY_BARS){
            moneyBar = new SuperStatBar(3000, money, this, 40, 8, -40, Color.YELLOW, Color.GRAY, false, Color.GRAY, 1);
        }
    }

    /**
     * Act - do whatever the Pedestrian wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Awake is false if the Pedestrian is "knocked down"
        if (awake){
            // Check in the direction I'm moving vertically for a Vehicle -- and only move if there is no Vehicle in front of me.
            if (getOneObjectAtOffset(0, (int)(direction * getImage().getHeight()/2 + (int)(direction * speed)), Vehicle.class) == null){
                setLocation (getX(), getY() + (int)(speed*direction));
            }
            if (direction == -1 && getY() < 180){
                getWorld().removeObject(this);
            } else if (direction == 1 && getY() > getWorld().getHeight() - 30){
                getWorld().removeObject(this);
            }

        }
    
    }

    /**
     * Method to cause this Pedestrian to become knocked down - stop moving, turn onto side
     */
    public void knockDown () {
        speed = 0;
        setRotation (direction * 90);
        awake = false;
    }
    
    public void addedToWorld (World w)
    {
        if (VehicleWorld.SHOW_ENERGY_BARS) 
        {
            w.addObject (energyBar, getX(), getY());
            energyBar.update(energy);
        }
        if (VehicleWorld.SHOW_MONEY_BARS) 
        {
            w.addObject (moneyBar, getX(), getY());
            moneyBar.update(money);
        }
    }

    /**
     * Method to allow a downed Pedestrian to be healed
     */
    public void healMe () {
        speed = maxSpeed;
        setRotation (0);
        awake = true;
    }

    public boolean isAwake () {
        return awake;
    }
}
