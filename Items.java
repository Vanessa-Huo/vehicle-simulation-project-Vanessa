import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Items here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Items extends Actor
{
    /**
     * Act - do whatever the Items wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[]list=new GreenfootImage[4];
    
    public void act()
    {
        // Add your action code here.
    }
    
    public Items(){
        for(int i=0; i<list.length;i++){
            list[i]=new GreenfootImage("images/0"+i+".png");
            list[i].scale(20, 20);
        }
        
        if(Greenfoot.getRandomNumber(4)==0){
            setImage(list[0]);
        }else if(Greenfoot.getRandomNumber(4)==1){
            setImage(list[1]);
        }else if(Greenfoot.getRandomNumber(4)==2){
            setImage(list[2]);
        }else{
            setImage(list[3]);
        }
        
    }
}
