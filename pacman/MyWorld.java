import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    private void prepare(){
        addObject(new Wall(),265,79);
        addObject(new Wall(),265,108);
        addObject(new Wall(),265,137);
        addObject(new Wall(),265,166);
        addObject(new Wall(),168,79);
        addObject(new Wall(),190,79);
        addObject(new Wall(),210,79);
        addObject(new Wall(),225,79);
        addObject(new Wall(),225,320);
        addObject(new Wall(),225,300);
        addObject(new Wall(),225,280);
        addObject(new Wall(),225,260);
        addObject(new Wall(),195,320);
        addObject(new Wall(),175,320);
        Apple apple=new Apple();
        addObject(apple,438,71);
        Bigitem bigitem = new Bigitem();
        addObject(bigitem,104,115);
        Cherry cherry = new Cherry();
        addObject(cherry,532,152);
        Smallitem smallItem = new Smallitem();
        addObject(smallItem,196,241);
        Strawberry strowberry = new Strawberry();
        addObject(strowberry,439,313);
        Ghost ghost = new Ghost();
        addObject(ghost,339,313);
        addObject(new Pacman(),50,50);
    }
}
