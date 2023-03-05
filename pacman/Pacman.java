import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final int COUNT_DOWN_MOUTH_STAR_VALUE=10;
    private static final int DIRECTION_RIGHT=0;
    private static final int DIRECTION_LEFT=1;
    private static final int DIRECTION_UP=2;
    private static final int DIRECTION_DOWN=3;
    private static final int OFFSET=5;
    private int mouthDelay=COUNT_DOWN_MOUTH_STAR_VALUE;
    private String [][]images;
    private int imagesIndex;
    private int direction=DIRECTION_RIGHT;
    private int score=0;
    public Pacman(){
        prepareImagesCollection();
        setImage(images[DIRECTION_RIGHT][0]);
    }
    public void act()
    {
        movePacMan();
        handleKeys();
        handleImageSelector();
        checkCollisions();
        updateHud();
        checkWall();
    }
    private void checkWall(){
        Boolean touch = isTouching(Wall.class);
        while(touch){
                if(Greenfoot.isKeyDown("left")){
                setLocation(getX()-3,getY()-1);//x
            }
            if(Greenfoot.isKeyDown("right")){
                setLocation(getX()+3,getY()+1);
            }
            if(Greenfoot.isKeyDown("up")){
                setLocation(getX()-1,getY()-3);
            }
            if(Greenfoot.isKeyDown("down")){
                setLocation(getX()+1,getY()+3);
            }
            touch = isTouching(Wall.class);
        }
        //getInteractionObject
        //getOneIntersectingObject
        //getNeighbours
        //getObjectatobset
        //getObjectatraid?
    }
    private void checkCollisions(){
        Item item=(Item)this.getOneIntersectingObject(Item.class);
        if(item!=null){
            score += item.getPoints();
            this.getWorld().removeObject(item);
        }
       /* Apple apple = (Apple)this.getOneIntersectingObject(Apple.class);
        if(apple!=null){
            score += 20;
            this.getWorld().removeObject(apple);
        }
        Cherry cherry = (Cherry)this.getOneIntersectingObject(Cherry.class);
        if(cherry!=null){
            score += 25;
            this.getWorld().removeObject(cherry);
        }
        Bigitem bigitem = (Bigitem)this.getOneIntersectingObject(Bigitem.class);
        if(bigitem!=null){
            score += 10;
            this.getWorld().removeObject(bigitem);
        }
        Smallitem smallitem = (Smallitem)this.getOneIntersectingObject(Smallitem.class);
        if(smallitem!=null){
            score += 5;
            this.getWorld().removeObject(smallitem);
        }
        Strawberry strawberry = (Strawberry)this.getOneIntersectingObject(Strawberry.class);
        if(strawberry!=null){
            score += 30;
            this.getWorld().removeObject(strawberry);
        }*/
    }
    private void updateHud(){
        World world = getWorld();
        world.showText("Score:"+score,world.getWidth()-100,20);
    }
    private void prepareImagesCollection(){
        images=new String[4][2];
        images[DIRECTION_RIGHT]= new String[]{
            "images/pacman-close.png",
            "images/pacman-open.png"
        };
        images[DIRECTION_DOWN]= new String[]{
            "images/pacman-close-down.png",
            "images/pacman-open-down.png"
        };
        images[DIRECTION_UP]= new String[]{
            "images/pacman-open-up.png",
            "images/pacman-close-up.png"
        };
        images[DIRECTION_LEFT]= new String[]{
            "images/pacman-close-left.png",
            "images/pacman-open-left.png"
        };
    }
    private void handleKeys(){
        if(Greenfoot.isKeyDown("left")){
            direction=DIRECTION_LEFT;
        }else if(Greenfoot.isKeyDown("right")){
            direction=DIRECTION_RIGHT;
        }else if(Greenfoot.isKeyDown("up")){
            direction=DIRECTION_UP;
        }else if(Greenfoot.isKeyDown("down")){
            direction=DIRECTION_DOWN;
        }
    }
    private void handleImageSelector(){
        mouthDelay--;
        if(mouthDelay==0){
            imagesIndex=(imagesIndex+1)%images[direction].length;
            setImage(images[direction][imagesIndex]);
            mouthDelay=COUNT_DOWN_MOUTH_STAR_VALUE;
        }
    }
    private void movePacMan(){
        switch(direction){
            case DIRECTION_RIGHT:
                setLocation(getX()+OFFSET,getY());
            break; 
            case DIRECTION_LEFT:
                setLocation(getX()-OFFSET,getY());
            break; 
            case DIRECTION_UP:
                setLocation(getX(),getY()-OFFSET);
            break; 
            case DIRECTION_DOWN:
                setLocation(getX(),getY()+OFFSET);
            break; 
        }
    }
}
