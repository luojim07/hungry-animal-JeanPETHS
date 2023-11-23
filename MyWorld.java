import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class MyWorld here.
 * 
 * @author Jean 
 * @version Nov 2023
 */
public class MyWorld extends World
{
    GreenfootSound gameOverSound = new GreenfootSound("gameOverTrombone.wav");
    
    Apple apple;
    Knife knife;
    Bomb bomb;
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        //Create a label
        scoreLabel = new Label(score, 80);
        addObject(scoreLabel,50,50);
        
        createApple();
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        gameOverSound.play();
        removeObject(apple);
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    /**
     * Increase score
     */
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        
        if(score%5==0)
        {
            level++;
        }
    }
    
    /**
     * Decrease score
     */
    public void decreaseScore()
    {
        score--;
        scoreLabel.setValue(score);
    }
    
    /**
     * Create a new apple at random location at top of screen
     */
    public void createApple()
    {
        apple = new Apple();
        apple.setSpeed(level);
        addObject(apple, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Create a new knife at random location at top of screen
     */
    public void createKnife()
    {
        knife = new Knife();
        knife.setSpeed(level);
        addObject(knife, Greenfoot.getRandomNumber(600), 0);
    }
    
    /**
     * Create a new bomb at random time at top of screen
     */
    public void createBomb()
    {
        bomb = new Bomb();
        bomb.setSpeed(level);
        addObject(bomb, Greenfoot.getRandomNumber(600), 0);
    }
}
