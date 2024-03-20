import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class People here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class People extends Pedestrian
{
    /**
     * Act - do whatever the People wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[]idleUp=new GreenfootImage[3];
    GreenfootImage[]idleDown=new GreenfootImage[3];
    SimpleTimer animationTimer = new SimpleTimer();
    private int imageIndex=0;
    private int num;
    private int actsLeft = 150;
    private int pickActs = 150;
    
    public void act()
    {
        // Add your action code here.
        super.act();
        if(this.getWorld() != null){
            animatePeople();
            dropThings();
            pickUp();
        }
    }
    
    public void dropThings(){
        if(actsLeft>0){
            actsLeft--;
        }
        
        if(actsLeft==0 && isAwake()){
            if(Greenfoot.getRandomNumber(3)==0){
                getWorld().addObject (new Items(), getX(), getY());
            }
            actsLeft=150;
        }
    }
    
    public void pickUp(){
        if(pickActs>0){
            pickActs--;
        }
        
        if (this.getWorld() != null && pickActs==0 && isAwake()){
            Items x = (Items) getOneIntersectingObject(Items.class);
            if(x!= null && Greenfoot.getRandomNumber(100) >  20){
                getWorld().removeObject(x);
            }
            pickActs=150;
        }
    }
    
    public People(int x){
        super(x);
        isPeople =true;
        
        if(getDirection()){
            if(Greenfoot.getRandomNumber(3)==0){
                num = 11;
                upImages();
            }
            else if(Greenfoot.getRandomNumber(3)==1){
                num = 14;
                upImages();
            }
            else{
                num = 17;
                upImages();
            }
            setImage(idleUp[0]);
        }
        else{
            if(Greenfoot.getRandomNumber(3)==0){
                num = 20;
                downImages();
            }
            else if(Greenfoot.getRandomNumber(3)==1){
                num = 23;
                downImages();
            }
            else{
                num = 26;
                downImages();
            }
            setImage(idleDown[0]);
        }
        
        animationTimer.mark();
    }
    
    
    public void upImages(){
        for(int i=0; i<idleUp.length;i++){
            idleUp[i]=new GreenfootImage("images/0"+num+".png");
            idleUp[i].scale(48, 72);
            num++;
        }
    }
    
    public void downImages(){
        for(int i=0; i<idleDown.length;i++){
            idleDown[i]=new GreenfootImage("images/0"+num+".png");
            idleDown[i].scale(48, 72);
            num++;
        }
    }

    public void animatePeople()
    {
        if(animationTimer.millisElapsed()<400)
        {
            return;
        }
        animationTimer.mark();
        
        if(isAwake()){
            if(getDirection()){
                setImage(idleUp[imageIndex]);
                imageIndex=(imageIndex + 1) % idleUp.length;
            }
            else{
                setImage(idleDown[imageIndex]);
                imageIndex=(imageIndex + 1) % idleDown.length;
            }
        }
        
    }
}
