import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Pedestrian that tries to walk across the street
 */
public abstract class Pedestrian extends SuperSmoothMover
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
    private boolean robbed;
    private int saveMeCount = 600;
    
    public boolean isPeople;
    
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
        money = Greenfoot.getRandomNumber (3001);
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
        if (awake && this.getWorld() != null){
            // Check in the direction I'm moving vertically for a Vehicle -- and only move if there is no Vehicle in front of me.
            if (getOneObjectAtOffset(0, (int)(direction * getImage().getHeight()/2 + (int)(direction * speed)), Vehicle.class) == null){
                setLocation (getX(), getY() + (int)(speed*direction));
            }
            if (direction == -1 && getY() < 180){
                getWorld().removeObject(this);
            }else if (direction == 1 && getY() > getWorld().getHeight() - 30){
                getWorld().removeObject(this);
            }
        }
        
        startCount();
    }
    
    public void startCount(){
        if(!isAwake() && this.getWorld() != null && energy==0 && saveMeCount>0){
            saveMeCount--;
        }
        if(energy==0 && saveMeCount==0 && this.getWorld() != null){
            getWorld().addObject (new DeadBody(), getX(), getY());
            getWorld().removeObject(this);
            saveMeCount = 600;
        }
    }

    /**
     * Method to cause this Pedestrian to become knocked down - stop moving, turn onto side
     */
    public void knockDown () {
        speed = 0;
        setRotation (direction * 90);
        energy = energy - Greenfoot.getRandomNumber(energy+1);
        energyBar.update(energy);
        awake = false;
    }
    
    public void addedToWorld (World w)
    {
        if (isPeople && VehicleWorld.SHOW_ENERGY_BARS) 
        {
            w.addObject (energyBar, getX(), getY());
            energyBar.update(energy);
        }
        if (isPeople && VehicleWorld.SHOW_MONEY_BARS) 
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
    
    public boolean isAlive(){
        boolean check = false;
        if(energy > 0){
            check = true;
        }
        return check;
    }
    
    public boolean canPay(){
        boolean check = false;
        if(money >= 500){
            check = true;
        }
        return check;
    }
    
    public void setEnergy(int x){
        energy = x;
    }
    
    public void setMoney(){
        money -= 500;
    }
    
    public int getEnergy(){
        return energy;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void steal(){
        money = money - Greenfoot.getRandomNumber(money+1);
        moneyBar.update(money);
    }
    
    public boolean getRobbed(){
        robbed = true;
        return robbed;
    }
    
    public boolean getDirection(){
        if(direction == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
